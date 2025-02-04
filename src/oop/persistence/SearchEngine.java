/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.persistence;

import java.util.List;
import oop.entities.Entity;
import oop.types.EntityHandlerType;

/**
 *
 * @author kucik
 */
public class SearchEngine {
    
    private final static Search search;
    
    static{
        search = new Search();
    }
    
    private SearchEngine() {
    }
    
    public static List<? extends Entity> selectAll(EntityHandlerType type, String command) {
        return search.selectAll(type, command);
    }
}
