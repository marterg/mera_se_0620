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

        public static final String MATH = "матанализ";
        public static final String PHILOSOPHY = "философия";
        public static final String ENGLISH = "английский язык";
        public static final String HISTORY = "история";
        public static final String SPORT = "физкультура";

        List<Student> students = new ArrayList<>();
        Student student1 = new Student("Студент1");
        Student student2 = new Student("Студент2");
        Student student3 = new Student("Студент3");
        Student student4 = new Student("Студент4");
        Student student5 = new Student("Студент5");
        Student student6 = new Student("Студент6");
        Student student7 = new Student("Студент7");
        Student student8 = new Student("Студент8");
        Student student9 = new Student("Студент9");
        Student student10= new Student("Студент10");

        for (int i = 1; i <= 10; i++) {
            students.add(new Student(studentName));
        }
        System.out.println("Расписание каждого студента");
        Set<Lection> finalMySchedule = mySchedule;
        students.forEach(student -> {
            student.fillPersonalSchedule(finalMySchedule);
            System.out.println(student);
        });

        VisitStatistics statistics = new VisitStatistics(mySchedule, students);

        System.out.println("Список студентов, которые хоть раз посещали матанализ:\n");
        students.stream()
                .filter(student -> student.getSchedule().stream()
                        .anyMatch(lecture -> lecture.getName().equals(MATH)))
                .forEach(student -> System.out.println(student.getStudentName()));

        System.out.println("Статистика посещений в формате: Имя - количество посещенных лекций");
        students.forEach(student ->
                System.out.println(student.getStudentName() + " посетил лекций " + student.getSchedule().size()));

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
