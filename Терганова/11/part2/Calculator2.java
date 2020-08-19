package com.mera.11.part2;

public class Calculator2 {
    public final static String MULTIPLY = "умножение";
    public final static String DIVIDE = "деление";
    public final static String ADD = "сложение";
    public final static String SUBTRACT = "вычитание";
    public final static String POW = "возведение в степень";
    public final static String ROOT = "извлечение корня степени n";

    public static void main(String[] args) {
        Calculator2 calc = new Calculator();

        Operation multiplication = (x, y) -> x * y;
        Operation division = (x, y) -> x / y;
        Operation addition = (x, y) -> x + y;
        Operation subtraction = (x, y) -> x - y;
        Operation pow = (x, y) -> Math.pow(x, y);
        Operation rootFunction = (x, y)-> Math.pow(x, 1.0 / y);

        calc.addOperation(MULTIPLY, multiplication);
        calc.addOperation(DIVIDE, division);
        calc.addOperation(ADD, addition);
        calc.addOperation(SUBTRACT, subtraction);
        calc.addOperation(POW, pow);
        calc.addOperation(ROOT, rootFunction);

        double x = 8.0;
        double y = 4.0;
        calc.calculate(ADD,x, y );
        calc.calculate(SUBTRACT, x, y);
        calc.calculate(MULTIPLY, x, y);
        calc.calculate(POW, x, y);
        calc.calculate(DIVIDE, x, y);
        calc.calculate(ROOT, x, y);

        calc.calculate(ROOT, 8.0,2.0);
        calc.calculate(ADD, 27.0,3.0);
    }
}