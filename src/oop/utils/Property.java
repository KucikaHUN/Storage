/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.utils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import oop.entities.Durable;
import oop.entities.Entity;
import oop.entities.Perishable;
import oop.entities.Product;
import oop.entities.Tax;
import oop.exceptions.DataManagerException;
import oop.logs.Logger;
import oop.types.PropertyType;

/**
 *
 * @author kucik
 */
class Property {

    private static final Map<PropertyType, Function<Entity, String>> properties;

    static {
        properties = fillProperties();

    }

    private Property() {
    }

    public static String getPropertyInString(PropertyType type, Entity entity) {
        return properties.get(type).apply(entity);
    }

    private static Map<PropertyType, Function<Entity, String>> fillProperties() {
        Map<PropertyType, Function<Entity, String>> result = new HashMap<>();

        result.put(PropertyType.ARTICLE_NUMBER, (entity) -> entity.getId());
        result.put(PropertyType.NAME, (entity) -> getNameProperty(entity));
        result.put(PropertyType.BRAND, (entity) -> getBrandProperty(entity));
        result.put(PropertyType.FAMILY, (entity) -> getFamilyProperty(entity));
        result.put(PropertyType.NETTO_PRICE, (entity) -> getNettoPriceProperty(entity));
        result.put(PropertyType.TAX_ID, (entity) -> getTaxIdProperty(entity));
        result.put(PropertyType.QUANTITY, (entity) -> getQuantityProperty(entity));
        result.put(PropertyType.CRITICAL_QUANTITY, (entity) -> getCriticalQuantityProperty(entity));
        result.put(PropertyType.AMOUNT_UNITS, (entity) -> getAmountUnitsProperty(entity));
        result.put(PropertyType.EXPIRATION_DATE, (entity) -> getExpirationDateProperty(entity));
        result.put(PropertyType.PRODUCTION_DATE, (entity) -> getProductionDateProperty(entity));
        result.put(PropertyType.WARANTY_PERIOD, (entity) -> getWarantyPeriodProperty(entity));
        result.put(PropertyType.GROSS_WEIGHT, (entity) -> getGrossWeightProperty(entity));
        result.put(PropertyType.TAX_KEY, (entity) -> getTaxKeyProperty(entity));

        return result;
    }

    private static Product castProduct(Entity entity) {
        Product result = null;
        try {
            result = (Product) entity;
        } catch (ClassCastException e) {
            Logger.createLogError("Entity not contains this property: Property.castProduct");
            throw new DataManagerException("Call the developer. (Contains error)");
        }

        return result;
    }

    private static Durable castDurable(Entity entity) {
        Durable result = null;
        try {
            result = (Durable) entity;
        } catch (ClassCastException e) {
            Logger.createLogError("Entity not contains this property: Property.castDurable");
            throw new DataManagerException("Call the developer. (Contains error)");
        }

        return result;
    }

    private static Perishable castPerishable(Entity entity) {
        Perishable result = null;
        try {
            result = (Perishable) entity;
        } catch (ClassCastException e) {
            Logger.createLogError("Entity not contains this property: Property.castPerishable");
            throw new DataManagerException("Call the developer. (Contains error)");
        }

        return result;
    }

    private static Tax castTax(Entity entity) {
        Tax result = null;
        try {
            result = (Tax) entity;
        } catch (ClassCastException e) {
            Logger.createLogError("Entity not contains this property: Property.castTax");
            throw new DataManagerException("Call the developer. (Contains error)");
        }

        return result;
    }

    private static String getNameProperty(Entity entity) {
        Product p = castProduct(entity);
        return p.getName();
    }

    private static String getBrandProperty(Entity entity) {
        Product p = castProduct(entity);
        return p.getBrand();
    }

    private static String getFamilyProperty(Entity entity) {
        Product p = castProduct(entity);
        return p.getFamily();
    }

    private static String getNettoPriceProperty(Entity entity) {
        Product p = castProduct(entity);
        int nettoPrice = p.getNettoPrice();
        return String.valueOf(nettoPrice);
    }

    private static String getTaxIdProperty(Entity entity) {
        Product p = castProduct(entity);
        int taxId = p.getTaxId();
        return String.valueOf(taxId);
    }

    private static String getQuantityProperty(Entity entity) {
        Product p = castProduct(entity);
        int quantity = p.getQuantity();
        return String.valueOf(quantity);
    }

    private static String getCriticalQuantityProperty(Entity entity) {
        Product p = castProduct(entity);
        int criticalQuantity = p.getCriticalQuantity();
        return String.valueOf(criticalQuantity);
    }

    private static String getAmountUnitsProperty(Entity entity) {
        Product p = castProduct(entity);
        return p.getAmountUnits();
    }

    private static String getExpirationDateProperty(Entity entity) {
        Perishable p = castPerishable(entity);
        LocalDate expirationDate = p.getExpirationDate();
        return String.valueOf(expirationDate);
    }

    private static String getProductionDateProperty(Entity entity) {
        Perishable p = castPerishable(entity);
        LocalDate productionDate = p.getProductionDate();
        return String.valueOf(productionDate);
    }

    private static String getWarantyPeriodProperty(Entity entity) {
        Durable d = castDurable(entity);
        int warantyPeriod = d.getWarantyPeriod();
        return String.valueOf(warantyPeriod);
    }

    private static String getGrossWeightProperty(Entity entity) {
        Durable d = castDurable(entity);
        BigDecimal grossWeight = d.getGrossWeight();
        return String.valueOf(grossWeight);
    }

    private static String getTaxKeyProperty(Entity entity) {
        Tax t = castTax(entity);
        return t.getId();
    }

}
