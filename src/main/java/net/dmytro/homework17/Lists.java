package net.dmytro.homework17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lists {

    public static List<String> toList(String[] str){
        List<String> list = new ArrayList<>();
        Collections.addAll(list,str);
        return list;
    }
}
