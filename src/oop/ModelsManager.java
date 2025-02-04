/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop;

import javax.swing.table.DefaultTableModel;
import oop.datas.DataManager;
import oop.entities.Entity;

/**
 *
 * @author kucik
 */
public class ModelsManager {

    private DefaultTableModel model;

    public ModelsManager(DefaultTableModel model) {
        this.model = model;

    }

    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

}
