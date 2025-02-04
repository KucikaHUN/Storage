/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.entities;

import java.util.List;
import oop.persistence.EntityHandler;
import oop.persistence.EntityHandlerFactory;
import oop.types.EntityHandlerType;

/**
 *
 * @author kucik
 */
public class Select {

    private static EntityHandler handler;

    private Select() {
    }

    public static List<Entity> getAllProduct(EntityHandlerType t) {
        handler = EntityHandlerFactory.createEntityHandler(t);
        return (List<Entity>) handler.selectAll();
    }
}
