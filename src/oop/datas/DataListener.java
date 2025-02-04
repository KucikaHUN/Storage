/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.datas;

import oop.entities.Entity;

/**
 *
 * @author kucik
 */
public interface DataListener {
    
    public void notifyListeners();

    public void addListener(DataEventListener l);

    public void removeListener(DataEventListener l);

}
