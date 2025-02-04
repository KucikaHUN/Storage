/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.entities;

import java.math.BigDecimal;
import java.math.RoundingMode;
import oop.exceptions.EntityException;

/**
 *
 * @author kucik
 */
public class Durable extends Product {

    private int warantyPeriod;
    private BigDecimal grossWeight;

    public Durable(String articleNumber, String name, String brand, String family,
            int nettoPrice, int taxId, int quantity, int criticalQuantity, String amountUnits,
            int warantyPeriod, BigDecimal grossWeight) {
        super(articleNumber, name, brand, family, nettoPrice, taxId, quantity, criticalQuantity, amountUnits);
        setWarantyPeriod(warantyPeriod);
        setGrossWeight(grossWeight);
    }

    @Override
    protected String getFirstTwoRightCharacter() {
        return "DP";
    }

    public int getWarantyPeriod() {
        return warantyPeriod;
    }

    public final void setWarantyPeriod(int warantyPeriod) {
        if (warantyPeriod < 0) {
            throw new EntityException("WarantyPeriod cant below zero");
        }
        this.warantyPeriod = warantyPeriod;
    }

    public BigDecimal getGrossWeight() {
        return grossWeight;
    }

    public final void setGrossWeight(BigDecimal grossWeight) {
        if (grossWeight == null) {
            throw new EntityException("GrossWeight cant empty");
        } else {
            grossWeight = grossWeight.setScale(1, RoundingMode.FLOOR);
            if (grossWeight.doubleValue() < 0.0 || grossWeight.doubleValue() >= 1000.0) {
                throw new EntityException("GrossWeight cant below zero and more than 1000");
            }
            this.grossWeight = grossWeight;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Durable{" + "warantyPeriod=" + warantyPeriod + ", grossWeight=" + grossWeight + '}';
    }

}
