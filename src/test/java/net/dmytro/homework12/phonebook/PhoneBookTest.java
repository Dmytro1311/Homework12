package net.dmytro.homework12.phonebook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PhoneBookTest {
    @Test
    public void addToPhoneBookTest(){
        PhoneBook phoneBook = new PhoneBook();
        Record record = new Record("Dmytro", "3213123");
        Record record1 = new Record("Sashko", "1231231231");
        phoneBook.add(record1);
        phoneBook.add(record);

        Assertions.assertEquals(record1.getName(),PhoneBook.getRecords().get(0).getName());
        Assertions.assertEquals(record.getName(),PhoneBook.getRecords().get(1).getName());


    }
    @Test
    public void findNameTes(){
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(new Record("Dmytro", "13123"));
        phoneBook.add(new Record("Sashko","31231231"));
        phoneBook.add(new Record("Mukola","325234234"));
        phoneBook.add(new Record("Vitaliy","34534534"));

        Object expected1 =phoneBook.getRecords().get(1);
        Object expected2 = phoneBook.getRecords().get(0);
        Object actual =phoneBook.find(phoneBook.getRecords().get(1).getName());
        Object actual1 = phoneBook.find(phoneBook.getRecords().get(0).getName());
        Assertions.assertEquals(expected1,actual);
        Assertions.assertEquals(expected2,actual1);

    }
    @Test
    public void findAllTest(){
        Record record = new Record("Dmytro", "3213123");
        Record record1 = new Record("Sashko", "1231231231");
        Record record2 = new Record("Dmytro","325234234");
        Record record3 = new Record("Vitaliy","34534534");
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(record);
        phoneBook.add(record1);
        phoneBook.add(record2);
        phoneBook.add(record3);

        List<Record> actual = phoneBook.findAll("Dmytro");
        List<Record> expected = new ArrayList<>();
        expected.add(record);
        expected.add(record2);
        Assertions.assertEquals(expected,actual);

    }
}
