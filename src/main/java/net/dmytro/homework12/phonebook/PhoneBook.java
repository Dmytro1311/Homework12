package net.dmytro.homework12.phonebook;


import java.util.ArrayList;
import java.util.List;


public class PhoneBook {
    static List<Record> records = new ArrayList<>();

   


    public void add(Record record){
        records.add(record);
    }
    public Record find(String name){
        for(Record record : records){
            if(record.getName().equals(name)){
                return record;
            }
        }
        return null;
    }
    public List<Record> findAll(String name ){
        List<Record> recordsList = new ArrayList<>();
        for (Record record : records){
            if (record.getName().equals(name)){
                recordsList.add(record);
            }
        }
        if (recordsList.isEmpty()){
            return null;
        }else {
            return recordsList;
        }
    }
    public static List<Record> getRecords() {
        return records;
    }


}
