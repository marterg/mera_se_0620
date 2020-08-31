package com.mera.11.part3;

import java.time.LocalDate;
import java.util.Objects;

public class Lection {

    public static final String MATH = "матанализ";
    public static final String PHILOSOPHY = "философия";
    public static final String ENGLISH = "английский язык";
    public static final String HISTORY = "история";
    public static final String SPORT = "физкультура";

    private String name;
    private LocalDate date;

    public Lection(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Lection{" +
                "name='" + name + '\'' +
                ", date=" + date +
                '}' + "\n";
    }
}