/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.statistics;

import java.util.List;
import oop.entities.Product;

/**
 *
 * @author kucik
 */
public interface StatisticHandler {

    public List<? extends Statistic> getStatistics(List<? extends Product> list);

}
