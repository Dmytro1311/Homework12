package net.dmytro.homework15;


import lombok.Data;

import java.util.*;

@Data
public class FileNavigator  {
    private final Map<String,Set<FileData>> map;


    public FileNavigator() {
        this.map = new HashMap<>();
    }

    public void add(String filePath, FileData file){
        if (!file.getFilePath().equals(filePath)){
            throw new IllegalArgumentException("Can't add file with this path" + file.getFilePath() + "to the directory " + filePath);
        }
        map.computeIfAbsent(filePath, s -> new HashSet<>()).add(file);

    }
    public Set<FileData> find(String filePath){
        return map.getOrDefault(filePath, new HashSet<>());
    }
    public Set<FileData> filterBySize(String filePath, int size){
        if (!map.containsKey(filePath)){
            return new HashSet<>();
        }
        Set<FileData> filterMap = new HashSet<>();
        for (FileData data : map.get(filePath)){
            if (data.getSize() <= size){
                filterMap.add(data);
            }
        }
        return filterMap;
    }
    public void remove(String path){
        map.remove(path);
    }
    public Set<FileData> sortBySize(String filePath){
        if (!map.containsKey(filePath)){
            return new HashSet<>();
        }
        Set<FileData> filter = new TreeSet<>(Comparator.comparingLong(FileData::getSize));
        filter.addAll(map.get(filePath));
        return filter;
    }
}
