/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.entities;

import oop.exceptions.EntityException;

/**
 *
 * @author kucik
 */
public abstract class Product implements Entity {

    private final String articleNumber;
    private String name;
    private String brand;
    private String family;
    private int nettoPrice;
    private int taxId;
    private int quantity;
    private int criticalQuantity;
    private String amountUnits;

    public Product(String articleNumber, String name, String brand, String family, int nettoPrice, int taxId, int quantity, int criticalQuantity, String amountUnits) {
        checkArticleNumber(articleNumber);
        this.articleNumber = articleNumber;
        setName(name);
        setBrand(brand);
        setFamily(family);
        setNettoPrice(nettoPrice);
        setTaxId(taxId);
        setQuantity(quantity);
        setCriticalQuantity(criticalQuantity);
        setAmountUnits(amountUnits);
    }

    public String getName() {
        return name;
    }

    public final void setName(String name) {
        if (name == null || name.length() > 150) {
            throw new EntityException("Name cant null and max length 150");
        }
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public final void setBrand(String brand) {
        if (brand == null || brand.length() > 50) {
            throw new EntityException("Brand cant null and max length 50 character");
        }
        this.brand = brand;
    }

    public String getFamily() {
        return family;
    }

    public final void setFamily(String family) {
        if (family == null || family.length() > 50) {
            throw new EntityException("Family cant null and max length 50 character");
        }
        this.family = family;
    }

    public int getNettoPrice() {
        return nettoPrice;
    }

    public final void setNettoPrice(int nettoPrice) {
        if (nettoPrice < 0) {
            throw new EntityException("NettiPrice cant below zero");
        }
        this.nettoPrice = nettoPrice;
    }

    public int getTaxId() {
        return taxId;
    }

    public final void setTaxId(int taxId) {
        if (taxId < 0 || taxId > 100) {
            throw new EntityException("TaxId need range 0 to 100");
        }
        this.taxId = taxId;
    }

    public int getQuantity() {
        return quantity;
    }

    public final void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new EntityException("Quantity cant below zero");
        }
        this.quantity = quantity;
    }

    public int getCriticalQuantity() {
        return criticalQuantity;
    }

    public final void setCriticalQuantity(int criticalQuantity) {
        if (criticalQuantity < 0) {
            throw new EntityException("CriticalQuantity cant below zero");
        }
        this.criticalQuantity = criticalQuantity;
    }

    public String getAmountUnits() {
        return amountUnits;
    }

    public final void setAmountUnits(String amountUnits) {
        if (amountUnits == null || amountUnits.length() > 10) {
            throw new EntityException("AmountUnits cant null and max length 10 character");
        }
        this.amountUnits = amountUnits;
    }

    @Override
    public String getId() {
        return articleNumber;
    }

    public int getBruttoPrice() {
        double multiplier = 1.0 + (taxId / 100.0);
        double result = nettoPrice * multiplier;
        return (int)result;
    }

    public boolean haveLowCriticalQuantity() {
        return quantity <= criticalQuantity;
    }

    private boolean checkArticleFirstTwoCharactersRight(String articleNumber) {
        String firstTwoCharacter = getFirstTwoRightCharacter();

        return articleNumber.substring(0, 2).equals(firstTwoCharacter);
    }

    private boolean checkArticleNumbersRight(String articleNumber) {
        String regex = "[0-9]+";
        String data = articleNumber.substring(2, 10);
        return data.matches(regex);
    }

    protected abstract String getFirstTwoRightCharacter();

    private boolean checkArticleLengthRight(String articleNumber) {
        return articleNumber.length() == 10;
    }

    @Override
    public String toString() {
        return "Product{" + "articleNumber=" + articleNumber + ", name=" + name + ", brand=" + brand + ", family=" + family + ", nettoPrice=" + nettoPrice + ", taxId=" + taxId + ", quantity=" + quantity + ", criticalQuantity=" + criticalQuantity + ", amountUnits=" + amountUnits + '}';
    }

    private void checkArticleNumber(String articleNumber) {
        if (articleNumber == null || !checkArticleLengthRight(articleNumber)
                || !checkArticleFirstTwoCharactersRight(articleNumber)
                || !checkArticleNumbersRight(articleNumber)) {
            throw new EntityException("ArticleNumber not correct");
        }
    }

}
