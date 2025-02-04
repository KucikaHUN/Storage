/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.utils;

import java.math.BigDecimal;
import java.time.LocalDate;
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
import oop.exceptions.DataManagerException;
import oop.types.PropertyType;
import oop.types.SearchType;

/**
 *
 * @author kucik
 */
class Searcher {

    private Searcher() {
    }

    public static List<? extends Entity> search(List<? extends Entity> list, PropertyType propertyType, String word, SearchType searchType) {
        List<Entity> result = new ArrayList<>();

        for (Entity entity : list) {
            String property = Property.getPropertyInString(propertyType, entity);
            switch (searchType) {
                case ALL:
                    if (property.contains(word)) {
                        result.add(entity);
                    }
                    break;
                case CONCRETE:
                    if (property.equals(word)) {
                        result.add(entity);
                    }
                    break;
                case FORWARD:
                    if (property.startsWith(word)) {
                        result.add(entity);
                    }
                    break;
                case BACKWARD:
                    if (property.endsWith(word)) {
                        result.add(entity);
                    }
                    break;
            }
        }
        return result;
    }

}
