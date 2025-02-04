/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.datas;

import java.util.List;
import oop.entities.Entity;
import oop.entities.Select;
import oop.persistence.EntityHandlerFactory;
import oop.types.EntityHandlerType;

/**
 *
 * @author kucik
 */
class DataManagerTax<T extends Entity> extends DataManager<T> {

    public DataManagerTax() {
        refreshData();
        handler = EntityHandlerFactory.createEntityHandler(EntityHandlerType.TAX_HANDLER);
    }

    @Override
    public final void refreshData() {
        entities = (List<T>)Select.getAllProduct(EntityHandlerType.TAX_HANDLER);
    }

    @Override
    protected synchronized boolean addEntityToDatabase(T e) {
        return handler.insert(e);
    }

    @Override
    protected synchronized boolean updateEntityToDatabase(T e) {
        return handler.update(e);
    }

    @Override
    protected synchronized boolean deleteEntityInDatabase(T e) {
        return handler.delete(e);
    }
}
