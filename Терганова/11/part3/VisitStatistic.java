package com.mera.11.part3;

import com.mera.11.part2.Calculator;

import java.security.cert.CollectionCertStoreParameters;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class VisitStatistics {
    public Set<Lection> generalSchedule = new HashSet<>();
    public List<Student> students = new ArrayList<>();

    public VisitStatistics(Set<Lection> generalSchedule) {
        this.generalSchedule = generalSchedule;
    }

    public VisitStatistics(Set<Lection> generalSchedule, List<Student> students) {
        this.generalSchedule = generalSchedule;
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void createGeneralScheduleFromTemplate(Set<Lection> template ) {
        generalSchedule = template;
    }

    public Set<Lection> getGeneralSchedule() {
        return generalSchedule;
    }

    public void setGeneralSchedule(Set<Lection> generalSchedule) {
        this.generalSchedule = generalSchedule;
    }

    @Override
    public String toString() {
        return "VisitStatistics{" +
                "generalSchedule=" + generalSchedule +
                ", students=" + students +
                '}';
    }

    public List<Student> atLeastOnceVisited(String lectionNаme) {
        return students.stream()
                .filter(student -> student.getSchedule().stream()
                        .anyMatch(lection -> lection.getName().equals(lectionNаme)))
                .collect(Collectors.toList());
    }


    public Map<String,Integer> createMapWithNumberOfVisitedLections() {
        Map<String, Integer> map = new HashMap<>();
        students.stream().peek(student->map.put(student.getName(), student.getSchedule().size())).collect(Collectors.toList());
        return map;
    }

    public List<String> findTheMostPopularCourses() {
        Map<String, Long> map =students.stream()
                .flatMap(student -> student.getSchedule().stream()).collect(Collectors.toList())
                .stream()
                .collect(Collectors.groupingBy(Lection::getName, Collectors.counting()));

        long max = map.entrySet().stream().max((o1, o2) -> (int) (o1.getValue() - o2.getValue())).get().getValue();

        List<String> maxes = map.entrySet().stream()
                .filter(e -> e.getValue() == max)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        return  maxes;
    }


    public List<Map.Entry<String, Map.Entry<LocalDate, Long>>> getMostActiveStudents() {

        Map<String, Map<LocalDate, Long>> studentsMap = students.stream()
                .collect(Collectors.toMap(student -> student.getName(), student -> student.getSchedule()
                        .stream()
                        .collect(Collectors
                                .groupingBy(Lection::getDate, Collectors.counting()))));

        Map<String, Map.Entry<LocalDate, Long>> maxMap = studentsMap.entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey(),
                        e -> e.getValue()
                                .entrySet()
                                .stream()
                                .max(Map.Entry.comparingByValue())
                                .get()));

        Long maxEntry = maxMap.entrySet().stream()
                .max((o1, o2) -> (int) (o1.getValue().getValue() - o2.getValue().getValue()))
                .get().getValue().getValue();

        List<Map.Entry<String, Map.Entry<LocalDate, Long>>> mostActive = maxMap
                .entrySet()
                .stream().filter(e->e.getValue().getValue() == maxEntry)
                .collect(toList());

        return mostActive;
    }

    public Map<String, Set<String>> createGroupListForEveryCourse() {
        //get the set of courses
        Set<String> courses = students.stream()
                .flatMap(student -> student.getSchedule().stream()).collect(toList())
                .stream()
                .map(lection -> lection.getName())
                .collect(toSet());

        Map<String, Set<String>> nameCourses = students.stream()
                .collect(Collectors
                        .toMap(Student::getName, student -> student.getSchedule()
                                .stream()
                                .map(lection -> lection.getName()).collect(Collectors.toSet())));

        Map<String, Set<String>> courseNames = courses.stream()
                .collect(Collectors
                        .toMap(String::toString, t -> {
                            return nameCourses.entrySet()
                                    .stream()
                                    .filter(e->e.getValue().contains(t))
                                    .map(Map.Entry::getKey)
                                    .collect(Collectors.toSet());
                        } ));

        return courseNames;
    }
}