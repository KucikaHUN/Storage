/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.datas;

import java.util.ArrayList;
import java.util.List;
import oop.entities.Durable;
import oop.entities.Entity;
import oop.entities.Product;
import oop.entities.Select;
import oop.exceptions.DataManagerException;
import oop.exceptions.EntityException;
import oop.logs.Logger;
import oop.persistence.EntityHandlerFactory;
import oop.types.EntityHandlerType;
import oop.types.LogType;


/**
 *
 * @author kucik
 */
class DataManagerDurable<T extends Entity> extends DataManager<T> {

    public DataManagerDurable() {
        refreshData();
        handler = EntityHandlerFactory.createEntityHandler(EntityHandlerType.DURABLE_HANDLER);
    }

    @Override
    public final void refreshData() {
        entities = (List<T>) Select.getAllProduct(EntityHandlerType.DURABLE_HANDLER);

    }

    @Override
    public List<Product> getProductsBelowCriticalQuantity(List<? extends Product> list) {
        List<Product> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Durable d = (Durable) list.get(i);
            if (d.haveLowCriticalQuantity()) {
                result.add(d);
            }
        }
        return result;
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

    @Override
    public boolean decreaseProductQuantity(Product p, int quantity) {
        Durable product = (Durable) getEntityIfHaveWithId(p);
        boolean result = false;
        if (product != null) {
            int actualQuantity = product.getQuantity();
            product.setQuantity(actualQuantity - quantity);

            if ((result = updateEntityToDatabase((T) product))) {
                updateEntityInDataManager((T) product);
                Logger.createLog(product, LogType.DECREASE_QUANTITY);
                notifyListeners();
                result = true;
            } else {
                Logger.createLogError("Product not exist in Database: DataManagerDurable.decreaseProductQuantity");
                throw new DataManagerException("Call the developer. (Database Error)");
            }
        } else {
            throw new EntityException("Cant find product");
        }
        return result;
    }

    @Override
    public boolean increaseProductQuantity(Product p, int quantity) {
        boolean result = false;
        Durable product = (Durable) getEntityIfHaveWithId(p);
        if (product != null) {
            int actualQuantity = product.getQuantity();
            product.setQuantity(actualQuantity + quantity);

            if ((result = updateEntityToDatabase((T) product))) {
                updateEntityInDataManager((T) product);
                Logger.createLog(product, LogType.INCREASE_QUANTITY);
                notifyListeners();
                result = true;
            } else {
                Logger.createLogError("Product not exist in Database: DataManagerDurable.increaseProductQuantity");
                throw new DataManagerException("Call the developer. (Database error)");
            }
        } else {
            throw new EntityException("Cant find product");
        }
        return result;
    }

}
