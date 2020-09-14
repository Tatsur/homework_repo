package ru.geekbrains.java_one.homework.homework8a;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

public class Map extends JPanel {
    public static final int MODE_VS_HUMAN = 0;
    public static final int MODE_VS_AI = 1;
    public static JPanel[][] gridElements;
    private static int fieldSize = 3;
    private static int winLength = 3;
    private static char[][] map;
    public static final String PLAYER_WIN_MESSAGE = "Пользователь победил!";
    public static final String AI_WIN_MESSAGE = "Победил Искуственный Интеллект!";
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final char DOT_EMPTY = '•';
    private static final Random random = new Random();
    private static int buttonWidth;
    private static int buttonHeight;

    Map() {
        setBackground(Color.lightGray);
        setBorder(BorderFactory.createLineBorder(Color.red, 10));
    }

    void startNewGame(int gameMode, int fieldSize, int winLength) {
        Map.fieldSize = fieldSize;
        Map.winLength = winLength;
        map = new char[fieldSize][fieldSize];
        System.out.printf("mode: %d, size: %d, len: %d\n", gameMode, fieldSize, winLength);
        resetBoard();
        addGameFieldGrid(fieldSize);
        initMap();
        printMap();
    }

    public void resetBoard() {
        removeAll();
        revalidate();
        repaint();
    }

    private void addGameFieldGrid(int fieldSize) {
        setLayout(new GridLayout(fieldSize, fieldSize));
        gridElements = new JPanel[fieldSize][fieldSize];
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                JPanel panel = new JPanel();
                gridElements[i][j] = panel;
                add(panel);
                panel.setLayout(new GridLayout(1, 2));
                panel.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                JButton button = new JButton();
                panel.add(button);
                int finalJ = j;
                int finalI = i;
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        buttonWidth = button.getWidth();
                        buttonHeight = button.getHeight();
                        setCell(finalI, finalJ, 'X');
                        printMap();
                        if (!checkEnd(DOT_X, PLAYER_WIN_MESSAGE)) {
                            aiTurn();
                            printMap();
                            if (checkEnd(DOT_O, AI_WIN_MESSAGE)) ;
                        }
                    }
                });
            }
        }
        setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

    }

    private static void setCell(int rowIndex, int colIndex, char symbol) {
        map[rowIndex][colIndex] = symbol;
        JPanel panel = gridElements[rowIndex][colIndex];
        panel.remove(0);
        panel.add(new Token(0, 0, buttonWidth, buttonHeight, symbol));
        panel.revalidate();
        panel.repaint();
    }

    private static void checkCell(int rowIndex, int colIndex, char symbol) {
        map[rowIndex][colIndex] = symbol;
    }

    private static void aiTurn() {
        int[] cell = getCellToBlockOpponent(DOT_O);
        if (cell == null) {
            cell = getCellToBlockOpponent(DOT_X);
            if (cell == null) {
                cell = getRandomEmptyCell();
            }
        }
        int rowIndex = cell[0];
        int colIndex = cell[1];
        setCell(rowIndex, colIndex, DOT_O);
    }

    private static int[] getRandomEmptyCell() {
        int rowIndex, colIndex;
        do {
            rowIndex = random.nextInt(fieldSize);
            colIndex = random.nextInt(fieldSize);
        } while (!isCellValid(rowIndex, colIndex));
        return new int[]{rowIndex, colIndex};
    }

    private static boolean isCellValid(int rowIndex, int colIndex) {
        if (rowIndex < 0 || rowIndex >= fieldSize || colIndex < 0 || colIndex >= fieldSize) {
            return false;
        }

        return map[rowIndex][colIndex] == DOT_EMPTY;
    }

    @SuppressWarnings("SameParameterValue")
    private static int[] getCellToBlockOpponent(char opponentSymbol) {
        for (int rowIndex = 0; rowIndex < map.length; rowIndex++) {
            for (int colIndex = 0; colIndex < map[rowIndex].length; colIndex++) {
                if (map[rowIndex][colIndex] == DOT_EMPTY && isGameMoveWinning(rowIndex, colIndex, opponentSymbol)) {
                    return new int[]{rowIndex, colIndex};
                }
            }
        }

        return null;
    }

    private static boolean isGameMoveWinning(int rowIndex, int colIndex, char opponentSymbol) {
        checkCell(rowIndex, colIndex, opponentSymbol);
        boolean result = checkWin(opponentSymbol);
        checkCell(rowIndex, colIndex, DOT_EMPTY);
        return result;
    }

    private boolean checkEnd(char symbol, String winMessage) {
        if (checkWin(symbol)) {
            System.out.println(winMessage);
            resetBoard();
            add(new JLabel(winMessage, SwingConstants.CENTER));
            return true;
        }
        if (isMapFull()) {
            String draw = "Ничья!";
            System.out.println(draw);
            resetBoard();
            add(new JLabel(draw, SwingConstants.CENTER));
            return true;
        }
        return false;
    }

    private static boolean isMapFull() {
        for (char[] row : map) {
            for (char cell : row) {
                if (cell == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkWin(char symbol) {
        if (checkRowsAndCols(symbol)) return true;
        return checkDiagonals(symbol);
    }

    private static boolean checkDiagonals(char symbol) {
        int mainDiagCounter = 0;
        int sideDiagCounter = 0;
        for (int k = 0; k <= fieldSize - winLength; k++) {

            for (int i = 0; i < fieldSize; i++) {
                if (i + k < fieldSize) {
                    mainDiagCounter = (map[i + k][i] == symbol) ? mainDiagCounter + 1 : 0;
                    sideDiagCounter = (map[i + k][map.length - 1 - i] == symbol) ? sideDiagCounter + 1 : 0;
                }
                if (mainDiagCounter == winLength || sideDiagCounter == winLength) {
                    return true;
                }
            }
            for (int i = 0; i < fieldSize; i++) {
                if (i + k < fieldSize) {
                    mainDiagCounter = (map[i][i + k] == symbol) ? mainDiagCounter + 1 : 0;
                }
                if (i < fieldSize - k) {
                    sideDiagCounter = (map[i][map.length - 1 - i - k] == symbol) ? sideDiagCounter + 1 : 0;
                }
                if (mainDiagCounter == winLength || sideDiagCounter == winLength) {
                    return true;
                }
            }

        }
        return false;
    }

    private static boolean checkRowsAndCols(char symbol) {
        for (int i = 0; i < fieldSize; i++) {
            int rowCounter = 0;
            int colCounter = 0;
            for (int j = 0; j < fieldSize; j++) {
                rowCounter = (map[i][j] == symbol) ? rowCounter + 1 : 0;
                colCounter = (map[j][i] == symbol) ? colCounter + 1 : 0;
                if (rowCounter == winLength || colCounter == winLength) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void printRows() {
        for (int i = 0; i < map.length; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void printColumnNumbers() {
        for (int i = 0; i <= fieldSize; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void initMap() {
        for (char[] row : map) {
            Arrays.fill(row, DOT_EMPTY);
        }
    }

    private static void printMap() {
        printColumnNumbers();
        printRows();
        System.out.println();
    }
}
