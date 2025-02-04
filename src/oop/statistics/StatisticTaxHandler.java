/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.statistics;

import java.util.ArrayList;
import java.util.List;
import oop.entities.Product;

/**
 *
 * @author kucik
 */
class StatisticTaxHandler implements StatisticHandler {

    private List<Statistic> statisticTaxes;
    private List<Integer> taxes;

    public StatisticTaxHandler() {
        taxes = new ArrayList<>();
        statisticTaxes = new ArrayList<>();
    }

    @Override
    public final List<? extends Statistic> getStatistics(List<? extends Product> list) {
        taxes = getTaxesOneOfEachValue(list);
        statisticTaxes = fillStatisticTaxes(list);
        return statisticTaxes;
    }

    private List<Integer> getTaxesOneOfEachValue(List<? extends Product> list) {
        List<Integer> result = new ArrayList<>();
        int taxId;
        for (Product product : list) {
            taxId = product.getTaxId();
            if (!haveValueInList(result, taxId)) {
                result.add(taxId);
            }
        }
        return result;
    }

    private boolean haveValueInList(List<Integer> list, int taxId) {
        boolean result = false;
        int number;
        for (int i = 0; i < list.size(); i++) {
            number = list.get(i);
            if (number == taxId) {
                result = true;
                i = list.size();
            }
        }
        return result;
    }

    private List<Statistic> fillStatisticTaxes(List<? extends Product> list) {
        List<Statistic> result = new ArrayList<>();
        StatisticTax statTax;
        for (Integer tax : taxes) {
            statTax = new StatisticTax();
            statTax.makeStatistics(list, tax);
            result.add(statTax);
        }
        return result;
    }

}
