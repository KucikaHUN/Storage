/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.statistics;

import oop.types.StatisticType;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author kucik
 */
public class StatisticHandlerFactory {
    
    private final static Map<StatisticType, StatisticHandler> handlers;
    
    static{
        handlers = new HashMap<>();
        handlers.put(StatisticType.TAX, new StatisticTaxHandler());
    }

    private StatisticHandlerFactory() {
    }
    
    public static StatisticHandler createStatisticHandler(StatisticType type){
        return handlers.get(type);
    }
}
