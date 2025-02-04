/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import oop.types.SearchType;

/**
 *
 * @author kucik
 */
class SearchWordFormatter {

    private final static Map<SearchType, Function<String, String>> searchWordFormat;

    static {
        searchWordFormat = new HashMap<>();
        searchWordFormat.put(SearchType.ALL, (string) -> "'%" + string + "%'");
        searchWordFormat.put(SearchType.CONCRETE, (string) -> "'" + string + "'");
        searchWordFormat.put(SearchType.FORWARD, (string) -> "'" + string + "%'");
        searchWordFormat.put(SearchType.BACKWARD, (string) -> "'%" + string + "'");
    }

    private SearchWordFormatter() {
    }

    protected static String format(SearchType type, String word) {
        return searchWordFormat.get(type).apply(word);
    }

}
