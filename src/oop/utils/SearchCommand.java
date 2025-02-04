/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.utils;

import java.util.HashMap;
import java.util.Map;
import oop.entities.Durable;
import oop.entities.Entity;
import oop.entities.Perishable;
import oop.entities.Tax;
import oop.types.PropertyType;

/**
 *
 * @author kucik
 */
class SearchCommand {

    private static final Map<Class<? extends Entity>, Map<PropertyType, String>> commands;

    static {
        commands = new HashMap<>();
        Map<PropertyType, String> durableCommands = fillDurableCommands();
        Map<PropertyType, String> perishableCommands = fillPerishableCommands();
        Map<PropertyType, String> taxCommands = fillTaxCommands();
        commands.put(Durable.class, durableCommands);
        commands.put(Perishable.class, perishableCommands);
        commands.put(Tax.class, taxCommands);

    }

    private SearchCommand() {
    }

    public static String findCommand(PropertyType type, Class<? extends Entity> entityClass) {
        return commands.get(entityClass).get(type);
    }

    private static Map<PropertyType, String> fillDurableCommands() {
        Map<PropertyType, String> result = new HashMap<>();

        String defaultCommand = "select * from durable_product where ";
        result.put(PropertyType.ARTICLE_NUMBER, defaultCommand + "article_number like ");
        result.put(PropertyType.NAME, defaultCommand + "`name` like ");
        result.put(PropertyType.BRAND, defaultCommand + "brand like ");
        result.put(PropertyType.FAMILY, defaultCommand + "family like ");
        result.put(PropertyType.NETTO_PRICE, defaultCommand + "netto_price like ");
        result.put(PropertyType.TAX_ID, defaultCommand + "tax_id like ");
        result.put(PropertyType.QUANTITY, defaultCommand + "quantity like ");
        result.put(PropertyType.CRITICAL_QUANTITY, defaultCommand + "critical_quantity like ");
        result.put(PropertyType.AMOUNT_UNITS, defaultCommand + "amount_units like ");
        result.put(PropertyType.WARANTY_PERIOD, defaultCommand + "waranty_period like ");
        result.put(PropertyType.GROSS_WEIGHT, defaultCommand + "gross_weight like ");

        return result;
    }

    private static Map<PropertyType, String> fillPerishableCommands() {
        Map<PropertyType, String> result = new HashMap<>();

        String defaultCommand = "select * from perishable_product where ";
        result.put(PropertyType.ARTICLE_NUMBER, defaultCommand + "article_number like ");
        result.put(PropertyType.NAME, defaultCommand + "`name` like ");
        result.put(PropertyType.BRAND, defaultCommand + "brand like ");
        result.put(PropertyType.FAMILY, defaultCommand + "family like ");
        result.put(PropertyType.NETTO_PRICE, defaultCommand + "netto_price like ");
        result.put(PropertyType.TAX_ID, defaultCommand + "tax_id like ");
        result.put(PropertyType.QUANTITY, defaultCommand + "quantity like ");
        result.put(PropertyType.CRITICAL_QUANTITY, defaultCommand + "critical_quantity like ");
        result.put(PropertyType.AMOUNT_UNITS, defaultCommand + "amount_units like ");
        result.put(PropertyType.EXPIRATION_DATE, defaultCommand + "expiration_date like ");
        result.put(PropertyType.PRODUCTION_DATE, defaultCommand + "production_date like ");

        return result;
    }

    private static Map<PropertyType, String> fillTaxCommands() {
        Map<PropertyType, String> result = new HashMap<>();

        String defaultCommand = "select * from state_sales_tax where ";
        result.put(PropertyType.TAX_KEY, defaultCommand + "tax_key like ");

        return result;
    }
}
