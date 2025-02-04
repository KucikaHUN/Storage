/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.datas;

import java.util.ArrayList;
import java.util.List;
import oop.entities.Entity;
import oop.entities.Perishable;
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
class DataManagerPerishable<T extends Entity> extends DataManager<T> {

    public DataManagerPerishable() {
        refreshData();
        handler = EntityHandlerFactory.createEntityHandler(EntityHandlerType.PERISHABLE_HANDLER);
    }

    @Override
    public final void refreshData() {
        entities = (List<T>) Select.getAllProduct(EntityHandlerType.PERISHABLE_HANDLER);
    }

    @Override
    public List<Product> getProductsBelowCriticalQuantity(List<? extends Product> list) {
        List<Product> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Perishable d = (Perishable) list.get(i);
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
        boolean result = false;
        Perishable product = (Perishable) getEntityIfHaveWithId(p);
        if (product != null) {
            int actualQuantity = product.getQuantity();
            product.setQuantity(actualQuantity - quantity);

            if (checkEntityCanUpdate((T) product) && (result = updateEntityToDatabase((T) product))) {
                updateEntityInDataManager((T) product);
                Logger.createLog(product, LogType.DECREASE_QUANTITY);
                notifyListeners();
                result = true;
            } else {
                Logger.createLogError("Product not exist in Database: DataManagerPerishable.decreaseProductQuantity");
                throw new DataManagerException("Call the developer. (Database error)");
            }
        } else {
            throw new EntityException("Cant find product");
        }
        return result;
    }

    @Override
    public boolean increaseProductQuantity(Product p, int quantity) {
        boolean result = false;
        Perishable product = (Perishable) getEntityIfHaveWithId(p);
        if (product != null) {
            int actualQuantity = product.getQuantity();
            product.setQuantity(actualQuantity + quantity);

            if (checkEntityCanUpdate((T) product) && (result = updateEntityToDatabase((T) product))) {
                updateEntityInDataManager((T) product);
                Logger.createLog(product, LogType.INCREASE_QUANTITY);
                notifyListeners();
                result = true;
            } else {
                Logger.createLogError("Product not exist in Database: DataManagerPerishable.increaseProductQuantity");
                throw new DataManagerException("Call the developer. (Database error)");
            }
        } else {
            throw new EntityException("Cant find product");
        }
        return result;
    }

}
