package net.dmytro.homework15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class FileNavigatorTest {

    @Test
    void exceptionInMethodAddTest(){
        FileNavigator fileNavigator = new FileNavigator();
        Assertions.assertThrows(IllegalArgumentException.class, () ->fileNavigator.add("path to file", new FileData("test path","TestFile.txt", 500)));
    }
    @Test
    void addTest(){
        FileData fileData1 = new FileData("file1","homework15/file1",300);
        FileData fileData2 = new FileData("file2","homework15/file2",400);
        FileData fileData3 = new FileData("file3","homework15/file3",500);
        FileNavigator fileNavigator = new FileNavigator();
        fileNavigator.add(fileData2.getFilePath(),fileData2);
        fileNavigator.add(fileData1.getFilePath(),fileData1);
        fileNavigator.add(fileData3.getFilePath(),fileData3);
        Assertions.assertEquals(3,fileNavigator.getMap().size());
        Assertions.assertTrue(fileNavigator.getMap().containsKey(fileData1.getFilePath()));


    }
    @Test
    void findPathTest(){
        FileData fileData1 = new FileData("file1","homework15",300);
        FileData fileData2 = new FileData("file2","homework15",400);
        FileData fileData3 = new FileData("file3","homework15",500);
        FileNavigator fileNavigator = new FileNavigator();
        fileNavigator.add(fileData2.getFilePath(),fileData2);
        fileNavigator.add(fileData1.getFilePath(),fileData1);
        fileNavigator.add(fileData3.getFilePath(),fileData3);

        Assertions.assertTrue(fileNavigator.find("homework15").contains(fileData1));
        Assertions.assertTrue(fileNavigator.find("homework15").contains(fileData3));
        Assertions.assertFalse(fileNavigator.find("homework14").contains(fileData2));
        Assertions.assertFalse(fileNavigator.find("homework15/file2").contains(fileData3));
    }
    @Test
    void filterTest(){
        FileData fileData1 = new FileData("file1","homework15",300);
        FileData fileData2 = new FileData("file2","homework15",400);
        FileData fileData3 = new FileData("file3","homework15",500);
        FileNavigator fileNavigator = new FileNavigator();
        fileNavigator.add(fileData2.getFilePath(),fileData2);
        fileNavigator.add(fileData1.getFilePath(),fileData1);
        fileNavigator.add(fileData3.getFilePath(),fileData3);

        Assertions.assertTrue(fileNavigator.filterBySize("homework15",300).contains(fileData1));
        Assertions.assertTrue(fileNavigator.filterBySize("homework15",500).contains(fileData3));
        Assertions.assertFalse(fileNavigator.filterBySize("homework15",300).contains(fileData3));

    }
    @Test
    void removeTest(){
        FileData fileData1 = new FileData("file1","homework15/file1",300);
        FileNavigator fileNavigator = new FileNavigator();
        fileNavigator.add(fileData1.getFilePath(),fileData1);
        fileNavigator.remove("homework15/file1");
        Assertions.assertTrue(fileNavigator.getMap().isEmpty());


    }
    @Test
    void sortBySizeTest(){
        FileData fileData1 = new FileData("file1","homework15",400);
        FileData fileData2 = new FileData("file2","homework15",500);
        FileData fileData3 = new FileData("file3","homework15",250);
        FileNavigator fileNavigator = new FileNavigator();
        fileNavigator.add(fileData2.getFilePath(),fileData2);
        fileNavigator.add(fileData1.getFilePath(),fileData1);
        fileNavigator.add(fileData3.getFilePath(),fileData3);

        Set<FileData> actual = fileNavigator.sortBySize("homework15");
        Set<FileData> expected = new TreeSet<>(Comparator.comparingLong(FileData::getSize));
        expected.add(fileData1);
        expected.add(fileData2);
        expected.add(fileData3);

        Assertions.assertEquals(expected,actual);
    }


}
