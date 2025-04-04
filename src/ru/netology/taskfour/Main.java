package ru.netology.taskfour;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        long minorsCount = persons.stream().filter(x -> x.getAge() < 18).count();
        System.out.printf("Minorscount %d", minorsCount);
        List<String> conscriptList = persons.stream().filter(x -> x.getSex().equals(Sex.MAN))
                .filter(person -> person.getSex() == Sex.MAN && person.getAge() >= 18 && person.getAge() <= 27)
                .map(Person::getFamily)
                .collect(Collectors.toList());
        System.out.println("\nconscriptList:");
        System.out.println(conscriptList.size());
        System.out.println(conscriptList.get(0));

        List<Person> potentialWorkersList = persons.stream()
                .filter(person -> (person.getSex() == Sex.WOMAN && person.getAge() >= 18 && person.getAge() <= 60) ||
                        (person.getSex() == Sex.MAN && person.getAge() >= 18 && person.getAge() <= 65))
                .filter(person -> person.getEducation() == Education.HIGHER)
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
        System.out.println("\npotentialWorkersList:");
        System.out.println(potentialWorkersList.size());
        System.out.println(potentialWorkersList.get(0));
        System.out.println(potentialWorkersList.get(potentialWorkersList.size()-1));
    }
}
