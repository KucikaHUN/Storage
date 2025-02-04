/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.statistics;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import oop.entities.Product;

/**
 *
 * @author kucik
 */
public class StatisticTax implements Statistic {

    private int taxid;
    private long nettoPriceAll;
    private long bruttoPriceAll;
    private BigDecimal nettoPriceAverage;
    private int quantity;
    private List<? extends Product> list;

    public StatisticTax() {
        list = new ArrayList<>();
    }

    protected void makeStatistics(List<? extends Product> list, int taxId) {
        this.taxid = taxId;
        this.list = fillList(list);
        nettoPriceAll = calculateNettoPriceAll();
        bruttoPriceAll = calculateBruttoPriceAll();
        quantity = calculateQuantity();
        nettoPriceAverage = calculateNettoPriceAverage();
    }

    public int getTaxid() {
        return taxid;
    }

    public long getNettoPriceAll() {
        return nettoPriceAll;
    }

    private long calculateNettoPriceAll() {
        long result = 0;
        for (Product product : list) {
            result += product.getNettoPrice();
        }
        return result;
    }

    public long getBruttoPriceAll() {
        return bruttoPriceAll;
    }

    private long calculateBruttoPriceAll() {
        long result = 0;
        for (Product product : list) {
            result += product.getBruttoPrice();
        }
        return result;
    }

    public BigDecimal getNettoPriceAverage() {
        return nettoPriceAverage;
    }

    private BigDecimal calculateNettoPriceAverage() {
        BigDecimal a = BigDecimal.valueOf(nettoPriceAll);
        BigDecimal b = BigDecimal.valueOf(quantity);
        return a.divide(b,2,RoundingMode.DOWN);
    }

    public long getQuantity() {
        return quantity;
    }

    public List<? extends Product> getProductsInStatistic() {
        return list;
    }

    private int calculateQuantity() {
        return list.size();
    }

    private List<? extends Product> fillList(List<? extends Product> list) {
        List<Product> result = new ArrayList<>();
        for (Product product : list) {
            if (product.getTaxId() == taxid) {
                result.add(product);
            }
        }
        return result;
    }

}
