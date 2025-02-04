/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.utils;

import java.util.ArrayList;
import java.util.List;
import oop.entities.Entity;
import oop.types.PropertyType;
import oop.utils.HigherHelper.UtilHigherHelper;

/**
 *
 * @author kucik
 */
class Sort {

    private Sort() {
    }

    private static class UtilElement {

        String id;
        String property;
    }

    protected static List<? extends Entity> sortByProperty(PropertyType type, List<? extends Entity> list) {
        List<UtilElement> utilList = new ArrayList<>();
        UtilElement e;
        for (Entity entity : list) {
            e = new UtilElement();
            e.id = entity.getId();
            e.property = Property.getPropertyInString(type, entity);
            utilList.add(e);
        }

        utilList = sort(utilList, type);
        List<Entity> result = formatUtilElementListToEntity(utilList, list);

        return result;
    }

    private static List<UtilElement> sort(List<UtilElement> list, PropertyType type) {
        UtilElement actual;
        UtilElement next;
        String actualProperty;
        String nextProperty;
        boolean swapped;

        for (int i = 0; i < list.size(); i++) {
            swapped = false;

            for (int j = 0; j < list.size() - 1; j++) {
                actual = list.get(j);
                next = list.get(j + 1);
                actualProperty = actual.property;
                nextProperty = next.property;
                UtilHigherHelper helper = new UtilHigherHelper(actualProperty, nextProperty);
                if (HigherHelper.isActualUpper(type, helper)) {
                    list.set(j, next);
                    list.set(j + 1, actual);
                    swapped = true;
                }
            }
            if (!swapped) {
                i = list.size();
            }
        }
        return list;
    }

    private static List<Entity> formatUtilElementListToEntity(List<UtilElement> utilList, List<? extends Entity> list) {
        List<Entity> result = new ArrayList<>();
        String elementId;
        String entityId;
        for (int i = 0; i < utilList.size(); i++) {
            elementId = utilList.get(i).id;
            for (int j = 0; j < list.size(); j++) {
                entityId = list.get(j).getId();
                if (entityId.equals(elementId)) {
                    result.add(list.get(j));
                    j = list.size();
                }
            }
        }
        return result;
    }
}
