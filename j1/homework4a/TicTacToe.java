package ru.geekbrains.java.homework.j1.homework4a;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static final char aiMarker = '0';
    private static final char playerMarker = 'X';
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static final int fieldSize = 3;
    private static final int winStrike = 3;
    private static final char[][] values = new char[fieldSize][fieldSize];
    private static final char placeholder = '_';
    private static char lastMarker;
    private static int turnsCount = 1;
    private static int playerX;
    private static int playerY;
    private static int offset = 1;

    public static void main(String[] args) {

        boolean tryAgain = true;
        while (tryAgain) {
            fieldInit();
            printField();
            game();
            endGame();
            tryAgain = isTryAgain();
        }
    }

    private static boolean isTryAgain() {
        String answer;
        do {
            System.out.println("Do you want to play again? y/n?:");
            answer = scanner.nextLine();
            System.out.println(answer);
            if (answer.equals("n")) {
                return false;
            } else if (answer.equals("y")) return true;
        }
        while (isInvalidAnswer(answer));
        return true;
    }

    private static boolean isInvalidAnswer(String answer) {
        if (answer.equals("n") || answer.equals("y")) {
            return false;
        }
        System.out.println("incorrect answer, write y or n");
        return true;
    }

    private static void game() {
        while (true) {
            if (isFieldFilled()) break;
            playerTurn();
            printField();
            if (isWon(playerMarker)) break;
            if (isFieldFilled()) break;
            if (isWon(aiMarker)) break;
            aiTurn();
            printField();
            if (isWon(aiMarker)) break;
            if (isFieldFilled()) break;
            turnsCount++;
        }
    }

    private static boolean isFieldFilled() {
        for (char[] outer :
                values) {
            for (char in :
                    outer) {
                if (in == placeholder) {
                    return false;
                }
            }

        }
        lastMarker = placeholder;
        return true;
    }

    private static void fieldInit() {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                values[i][j] = placeholder;
            }
        }
    }

    private static boolean isWon(char marker) {
            lastMarker = marker;
            int mainDiaWinStrike = 0;
            int sideDiaWinStrike = 0;
            int horWinStrike;
            int verWinStrike;
            for (int y = 0; y < fieldSize; y++) {
                //main dia
                if (values[y][y] == marker) {
                    mainDiaWinStrike++;
                    aiPredict(mainDiaWinStrike, y + 1, y + 1, y - (winStrike - 1), y - (winStrike - 1), marker);
                    if (checkWin(mainDiaWinStrike)) return true;
                } else mainDiaWinStrike = 0;
                //side dia
                if (values[y][fieldSize - 1 - y] == marker) {
                    sideDiaWinStrike++;
                    aiPredict(sideDiaWinStrike, y + 1, fieldSize - 1 - y - 1, y - (winStrike - 1), fieldSize - 1 - y + (winStrike - 1), marker);
                    if (checkWin(sideDiaWinStrike)) return true;
                } else sideDiaWinStrike = 0;


                //horizon
                horWinStrike = 0;
                for (int x = 0; x < fieldSize; x++) {
                    int value = values[x][y];
                    if (value == marker) {
                        horWinStrike++;
                        aiPredict(horWinStrike, x + 1, y, x - (winStrike - 1), y, marker);
                        if (checkWin(horWinStrike)) return true;
                    } else horWinStrike = 0;
                }

            }
            //vertical
            for (int x = 0; x < fieldSize; x++) {
                verWinStrike = 0;
                for (int y = 0; y < fieldSize; y++) {
                    if (values[x][y] == marker) {
                        verWinStrike++;
                        aiPredict(verWinStrike, x, y + 1, x, y - (winStrike - 1), marker);
                        if (checkWin(verWinStrike)) return true;
                    } else verWinStrike = 0;
                }
            }
        return false;
    }

    private static void aiPredict(int localWinStrike, int x, int y, int x2, int y2, char marker) {
        if (localWinStrike == winStrike - offset ) {
            if (x < fieldSize && x >= 0 && y < fieldSize && y >= 0) {
                if (values[x][y] == placeholder) {
                    playerX = x;
                    playerY = y;
                }
            } else if (x2 < fieldSize && x2 >= 0 && y2 < fieldSize && y2 >= 0) {
                if (values[x2][y2] == placeholder) {
                    playerX = x2;
                    playerY = y2;
                }
            }
        }
    }

    private static boolean checkWin(int currentWinStrike) {
        return currentWinStrike == winStrike;
    }

    private static void endGame() {
        if (lastMarker == playerMarker)
            System.out.println("Congratulations! You won!");
        else if (lastMarker == aiMarker) System.out.println("You lost!");
        else System.out.println("This's a draw.");
        turnsCount = 1;
    }

    private static void aiTurn() {
        int x;
        int y;
        boolean checkAiIf = false;
        do {
            x = random.nextInt(fieldSize);
            y = random.nextInt(fieldSize);
            if (turnsCount >= winStrike - 1 && !checkAiIf) {
                x = playerX;
                y = playerY;
                checkAiIf = true;
            }
        } while (isValidInput(x, y, aiMarker));
    }


    private static void playerTurn() {
        int x = -1;
        int y = -1;
        do {
            System.out.println("write coordinates x and y: ");
            String[] strings = scanner.nextLine().split(" ");
            if (strings.length != 2) {
                System.out.println("enter integer values separated by a space");
                continue;
            }
            try {
                x = Integer.parseInt(strings[0]);
                y = Integer.parseInt(strings[1]);
                playerX = x;
                playerY = y;
            } catch (NumberFormatException e) {
                System.out.println("Invalid coordinates, write integer values, please");
            }
        } while (isValidInput(x, y, playerMarker));
    }

    private static boolean isValidInput(int x, int y, char marker) {
        if (x < 0 || x >= fieldSize || y < 0 || y >= fieldSize) {
            return true;
        }
        if (values[x][y] == placeholder) {
            values[x][y] = marker;
            return false;
        } else {
            System.out.println("The field is already held");
            return true;
        }
    }

    private static void printField() {
        System.out.print("\nx->__");
        for (int i = 0; i < fieldSize; i++) {
            System.out.print(i + "_");
        }
        System.out.println();
        for (int i = 0; i < fieldSize; i++) {
            System.out.print("y->" + i + "|");
            for (int j = 0; j < fieldSize; j++) {
                System.out.printf("%c", values[j][i]);
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println();
    }
}
