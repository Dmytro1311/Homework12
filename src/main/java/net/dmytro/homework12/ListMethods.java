package net.dmytro.homework12;


import lombok.Value;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.Arrays;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;


public class ListMethods {

  public static int countOccurance(List<String> list, String str){
    int count = 0;
    for(String word : list){
      if (word.equals(str)){

        count++;
      }
    }
    return count;
  }
  public static List<int[]> toList(int[]arr){
    List<int[]> list = Arrays.asList(arr);
    return list;
  }
  public static List<Integer> findUnique(List<Integer>list){
    Set<Integer> newList = new HashSet<>(list);
    return new ArrayList<>(newList);

  }
  public static Map<String,Integer> calcOccurance(List<String>list){
    Map<String,Integer> wordsCount = new HashMap<>();
    for (String word : list){
      if (wordsCount.containsKey(word)){
        wordsCount.put(word, wordsCount.get(word) + 1);
      }else {
        wordsCount.put(word,1);
      }
    }
    return wordsCount;
  }
@Value
  public static class FindOccuran implements Comparable<FindOccuran>{
    String words;
    int count;

    @Override
    public int compareTo(FindOccuran o) {
      return this.words.compareTo(o.words);
    }
  }
public static List<FindOccuran> findOccurans(List<String>list){
  List<FindOccuran> listToReturn = new ArrayList<>();
  Map<String,Integer> wordsCount = new HashMap<>();
  for (String s:list){
    if (!wordsCount.containsKey(s)){
      wordsCount.put(s,1);
    }else {
      int i = wordsCount.get(s);
      wordsCount.put(s,i+1);
    }
  }
  for (Map.Entry<String,Integer> mapEntry: wordsCount.entrySet()){
    listToReturn.add(new FindOccuran(mapEntry.getKey(), mapEntry.getValue()));
  }
  return listToReturn;


}
}
