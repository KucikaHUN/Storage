/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.persistence;

import java.util.List;
import oop.entities.Entity;

/**
 *
 * @author kucik
 */
public interface EntityHandler {

    boolean insert(Entity entity);

    boolean update(Entity entity);

    boolean delete(Entity entity);

    List<? extends Entity> selectAll();
}
