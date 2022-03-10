package com.trello.services;

import java.util.HashMap;
import java.util.Map;

public class IDGenerator {
    private static Map<String, Integer> idMap = new HashMap<>();
    public static Integer getId(String code){
        Integer id = idMap.getOrDefault(code,0);
        idMap.put(code, id+1);
        return id;
    }
}
