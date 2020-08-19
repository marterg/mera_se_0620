package com.mera.11.part3;

import com.mera.11.part3.VisitStatistics;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Lection> mySchedule = new HashSet<>();
        LocalDate date = LocalDate.of(2020, 8, 10);
        mySchedule = fillWeekSchedule(date);
        mySchedule.addAll(fillWeekSchedule(date.plusDays(7)));

        List<Student> students = new ArrayList<>();
        Student Tom = new Student("Студент1");
        Student Fedor = new Student("Студент2");
        Student Denis = new Student("Студент3");
        Student Electronic = new Student("Студент4");
        Student Vasechkin = new Student("Студент5");
        Student Peppy = new Student("Студент6");
        Student Alice = new Student("Студент7");
        Student Vasya = new Student("Студент8");
        Student Vitya = new Student("Студент9");
        Student Lusya= new Student("Студент10");

        students = Arrays.asList(Студент1, Студент2, Студент3, Студент4, Студент5, Студент6, Студент7, Студент8, Студент9, Студент10);

        System.out.println("Расписание каждого студента");
        Set<Lection> finalMySchedule = mySchedule;
        students.forEach(student -> {
            student.fillPersonalSchedule(finalMySchedule);
            System.out.println(student);
        });

        VisitStatistics statistics = new VisitStatistics(mySchedule, students);

        List<Student> tempList = statistics.atLeastOnceVisited(Lection.MATH);
        tempList.forEach(student->System.out.println("Список студентов, которые хоть раз посещали матанализ:\n" + student.getName()));

        System.out.println("Статистика посещений в формате \"Имя - количество посещенных лекций\"");
        Map<String, Integer> tempMap = statistics.createMapWithNumberOfVisitedLections();
        tempMap.entrySet().forEach(System.out::println);

        System.out.println("Название дисциплин, имеющих наибольшее количество посещений:\n");
        List<String> popularCourses = statistics.findTheMostPopularCourses();
        popularCourses.forEach(System.out::println);

        System.out.println("Список студентов, которые посетили наибольшее количество лекций в день:\n");
        List<Map.Entry<String, Map.Entry<LocalDate, Long>>> mostActive = statistics.getMostActiveStudents();
        mostActive.forEach(System.out::println);

        System.out.println("Список студентов по каждой дисциплине:\n");
        Map<String, Set<String>> visitMap = statistics.createGroupListForEveryCourse();
        visitMap.entrySet().forEach(System.out::println);
    }

    public static Set<Lection> fillWeekSchedule(LocalDate dateStart) {
        //Monday
        LocalDate date = dateStart;
        Set<Lection> schedule = new HashSet<>();
        schedule.add(new Lection(Lection.MATH, date));
        date = date.plusDays(1);
        //Tuesday
        schedule.add(new Lection(Lection.ENGLISH, date));
        schedule.add(new Lection(Lection.PHILOSOPHY, date));
        date = date.plusDays(1);
        //Wednesday
        schedule.add(new Lection(Lection.HISTORY, date));
        schedule.add(new Lection(Lection.SPORT, date));
        schedule.add(new Lection(Lection.MATH, date));
        date = date.plusDays(1);
        //Thursday
        schedule.add(new Lection(Lection.PHILOSOPHY, date));
        schedule.add(new Lection(Lection.SPORT, date));
        schedule.add(new Lection(Lection.ENGLISH, date));
        schedule.add(new Lection(Lection.MATH, date));
        date = date.plusDays(1);
        //Friday
        schedule.add(new Lection(Lection.MATH, date));
        schedule.add(new Lection(Lection.ENGLISH, date));
        schedule.add(new Lection(Lection.SPORT, date));
        schedule.add(new Lection(Lection.PHILOSOPHY, date));
        schedule.add(new Lection(Lection.HISTORY, date));
        return schedule;
    }
}
