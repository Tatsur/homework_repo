package ru.geekbrains.java_one.homework.homework1a;

public class Main {
    public static void main(String[] args) {
        variables();
        Calculator calc = new Calculator(2,4,6,3);
        System.out.println("3. "+ calc.calcExpression());
        System.out.println("4. "+ calc.calcSumInLimits(5,19));
        System.out.print("5. ");
        calc.checkValueSign(-5);
        System.out.println("6. "+ calc.isValueNegative(-8));
        System.out.print("7. ");
        calc.welcomeMessage("Drake");
        System.out.print("8. ");
        calc.checkLeapYear(2005);
    }

    private static void variables() {
        byte b = 127;
        short sh = -35;
        int i = 12125125;
        long l = 5_000_000_000L;
        float f = 148.35f;
        double d = 1046.290;
        char ch = 'a';
        boolean bl = true;
    }

}
