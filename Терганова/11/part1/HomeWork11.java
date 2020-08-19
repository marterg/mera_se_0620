package com.mera.11.part1;

import com.mera.11.part3.VisitStatistics;

import java.util.*;

public class HomeWork11 {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        Person person1 = new Person("Студент1", 25);
        Person person2 = new Person("Студент2", 26);
        Person person3 = new Person("Студент3", 27);
        Person person4 = new Person("Студент4", 28);
        Person person5 = new Person("Студент5", 29);
        people = Arrays.asList(person1, person2, person3, person4, person5);
        System.out.println("Список студентов:\n" + people.forEach(System.out::println));

        Collections.sort(people, (person1, person2) -> person1.getName().compareTo(person2.getName()));
        System.out.println("Сортировка по именам:\n" + people.forEach(System.out::println));

        Collections.sort(people, ( person1,  person2) -> person1.getAge().compareTo(person2.getAge()));
        System.out.println("Сортировка по возрасту:\n" + people.forEach(System.out::println));
    }
}