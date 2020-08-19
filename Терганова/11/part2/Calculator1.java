package com.mera.11.part2;

import java.util.HashMap;
import java.util.Map;

public class Calculator1 {
    Map<String, Operation> operations = new HashMap<>();

    public void addOperation(String name, Operation operation) {
        operations.put(name, operation);
    }

    public double calculate(String operationName, Double number1, Double number2) {
        System.out.printf("Операция %s\nЧисло 1 [%.3f] число 2[%.3f]\n", operationName, number1, number2);
        double result = operations.get(operationName).doOperation(number1, number2);
        System.out.printf("Результат [%.3f]\n", result);
        return result;
    }

}