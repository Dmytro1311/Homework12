package net.dmytro.homework12;


import lombok.Value;

import java.util.*;


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
  public static List<Integer> toList(int[]arr){
    List<Integer> list = new ArrayList<>();
    for (int i : arr){
      list.add(i);
    }
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
    Set<String> words = new HashSet<>(list);
    List<FindOccuran> listToReturn = new ArrayList<>();

  for (String s:words){
     FindOccuran findOccuran = new FindOccuran(s, Collections.frequency(list,s));
     listToReturn.add(findOccuran);
  }
  Collections.sort(listToReturn);
  return listToReturn;


}
}
