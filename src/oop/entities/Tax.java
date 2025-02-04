/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.entities;

import java.math.BigDecimal;
import oop.exceptions.EntityException;
import oop.persistence.EntityHandler;
import oop.persistence.EntityHandlerFactory;
import oop.types.EntityHandlerType;

/**
 *
 * @author kucik
 */
public class Tax implements Entity {

    private int taxKey;
    private String description;
    private double multiplier;

    public Tax(int taxKey, String description) {
        setTaxKey(taxKey);
        setDescription(description);
        setMultiplier();
    }

    public String getDescription() {
        return description;
    }

    public double getMultiplier() {
        return multiplier;
    }

    @Override
    public String getId() {
        return String.valueOf(taxKey);
    }

    private void setMultiplier() {
        BigDecimal a = new BigDecimal("1.0");
        String bString = String.valueOf(taxKey / 100.0);
        BigDecimal b = new BigDecimal(bString);
        BigDecimal result = a.add(b);
        this.multiplier = result.doubleValue();
    }

    private void setTaxKey(int taxKey) {
        if (taxKey > 100 || taxKey < 0) {
            throw new EntityException("Tax range: 0-100");
        }
        this.taxKey = taxKey;
    }

    private void setDescription(String description) {
        if (description == null || description.length() > 20) {
            throw new EntityException("Description cant null and max 20 character");
        }
        this.description = description;
    }

    @Override
    public String toString() {
        return "Tax{" + "taxKey=" + taxKey + ", description=" + description + ", multiplier=" + multiplier + '}';
    }

}
