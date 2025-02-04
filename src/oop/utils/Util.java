/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import oop.entities.Durable;
import oop.entities.Entity;
import oop.entities.Perishable;
import oop.entities.Product;
import oop.entities.Tax;
import oop.types.PropertyType;
import oop.types.SearchType;

/**
 *
 * @author kucik
 */
public class Util {

    private Util() {
    }

    public static String dateToString(LocalDate date) {
        return DateFormatter.dateToString(date);
    }

    public static LocalDate textToDate(String dateText) {
        return DateFormatter.textToDate(dateText);
    }

    public static String formatSearchWord(SearchType type, String word) {
        return SearchWordFormatter.format(type, word);
    }
    
    public static List<? extends Entity> search(List<? extends Entity> list, 
            PropertyType propertyType, String word, SearchType searchType){
        return Searcher.search(list, propertyType, word, searchType);
    }
    
    public static List<? extends Entity> sortByProperty(PropertyType type, List<? extends Entity> list) {
        return Sort.sortByProperty(type, list);
    }
    
    public static String searchCommand(PropertyType type, Class<? extends Entity> entityClass){
        return SearchCommand.findCommand(type, entityClass);
    }
    
    public static List<? extends Entity> reverseList(List<? extends Entity> list){
        List<Entity> result = new ArrayList<>();
        for (int i = list.size()-1; i >= 0; i--) {
            result.add(list.get(i));
        }
        return result;
    }
    
    public static String createCurrentTime(){
        return DateFormatter.createCurrentTime();
    }
}
