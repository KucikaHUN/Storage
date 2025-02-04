/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.persistence;

import oop.types.EntityHandlerType;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author kucik
 */
public class EntityHandlerFactory {

    private final static Map<EntityHandlerType, EntityHandler> handlerSelection;

    static {
        handlerSelection = new HashMap<>();
        handlerSelection.put(EntityHandlerType.DURABLE_HANDLER,
                new DurableHandler());
        handlerSelection.put(EntityHandlerType.PERISHABLE_HANDLER,
                new PerishableHandler());
        handlerSelection.put(EntityHandlerType.TAX_HANDLER, new TaxHandler());
    }

    private EntityHandlerFactory() {
    }

    public static EntityHandler createEntityHandler(EntityHandlerType type) {
        return handlerSelection.get(type);
    }
}
