package ru.geekbrains.java.homework.j2.lesson3;

import java.util.ArrayList;
import java.util.HashMap;

public class Phonebook extends HashMap<String, ArrayList<Long>> {

    public void add(String surname, long phoneNumber) {
        if (!containsKey(surname)) {
            ArrayList<Long> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            put(surname, phoneNumbers);
        } else
            super.get(surname).add(phoneNumber);
    }

    public void get(String surname) {
        if (containsKey(surname)) {
            System.out.println(surname + ": " + super.get(surname));
        } else System.out.printf("\"%s\" not found", surname);
    }
}
