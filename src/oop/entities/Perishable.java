/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.entities;

import java.time.LocalDate;
import oop.exceptions.EntityException;

/**
 *
 * @author kucik
 */
public class Perishable extends Product {

    private LocalDate expirationDate;
    private LocalDate productionDate;

    public Perishable(String articleNumber, String name, String brand, String family,
            int nettoPrice, int taxId, int quantity, int criticalQuantity, String amountUnits,
            LocalDate expirationDate, LocalDate productionDate) {
        super(articleNumber, name, brand, family, nettoPrice, taxId, quantity, criticalQuantity, amountUnits);
        setExpirationDate(expirationDate);
        setProductionDate(productionDate);
    }

    @Override
    protected String getFirstTwoRightCharacter() {
        return "PP";
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public final void setExpirationDate(LocalDate expirationDate) {
        if (expirationDate == null) {
            throw new EntityException("ExpirationDate cant null");
        }
        this.expirationDate = expirationDate;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public final void setProductionDate(LocalDate productionDate) {
        if (productionDate == null || productionDate.isAfter(expirationDate)) {
            throw new EntityException("ProductionDate cant null and after expiration");
        }
        this.productionDate = productionDate;
    }

    public int getExpirationDaysUntilNow() {
        LocalDate now = LocalDate.now();
        int days = 0;
        try {
            days = (int) now.datesUntil(expirationDate).count();
        } catch (IllegalArgumentException e) {
        }
        return days;
    }

    @Override
    public String toString() {
        return super.toString() + "Perishable{" + "expirationDate=" + expirationDate + ", productionDate=" + productionDate + '}';
    }

}
