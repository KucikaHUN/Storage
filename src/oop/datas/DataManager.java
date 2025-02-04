/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.datas;

import oop.types.PropertyType;
import oop.types.SearchType;
import java.util.ArrayList;
import java.util.List;
import oop.entities.Entity;
import oop.entities.Product;
import oop.exceptions.DataManagerException;
import oop.exceptions.EntityException;
import oop.exceptions.NullPropertyException;
import oop.logs.Logger;
import oop.persistence.EntityHandler;
import oop.types.LogType;
import oop.utils.Util;

/**
 *
 * @author kucik
 * @param <T>
 */
public abstract class DataManager<T extends Entity> implements DataListener {

    private List<DataEventListener> listeners;
    protected List<T> entities;
    protected EntityHandler handler;
    

    public DataManager() {
        entities = new ArrayList<>();
        listeners = new ArrayList<>();
    }

    @Override
    public void notifyListeners() {
        for (DataEventListener listener : listeners) {
            listener.update();
        }
    }

    @Override
    public void addListener(DataEventListener l) {
        listeners.add(l);
    }

    @Override
    public void removeListener(DataEventListener l) {
        listeners.remove(l);
    }

    public synchronized boolean addEntity(T e) {
        boolean result = false;
        if (checkEntityCanAdd(e) && (result = addEntityToDatabase(e))) {
            entities.add(e);
            Logger.createLog(e, LogType.ADD);
            notifyListeners();
            result = true;
        } else {
            throw new DataManagerException("Entity cant add, because already exist.");
        }
        return result;
    }

    public synchronized boolean updateEntity(T e) {
        boolean result = false;

        if (checkEntityCanUpdate(e) && (result = updateEntityToDatabase(e))) {
            updateEntityInDataManager(e);
            Logger.createLog(e, LogType.UPDATE);
            notifyListeners();
            result = true;
        } else {
            throw new DataManagerException("Entity cant update, because not exist.");
        }
        return result;
    }

    public synchronized boolean deleteEntity(T e) {
        boolean result = false;
        if (checkEntityCanDelete(e) && (result = deleteEntityInDatabase(e))) {
            entities.remove(e);
            Logger.createLog(e, LogType.DELETE);
            notifyListeners();
            result = true;
        } else {
            throw new DataManagerException("Entity cant delete, because not exist.");
        }
        return result;
    }

    public List<T> getList() {
        return new ArrayList<>(entities);
    }

    public abstract void refreshData();

    public List<? extends Product> getProductsBelowCriticalQuantity(List<? extends Product> list) {
        Logger.createLogError("Products Below Critical Quantity method cant use in this level: DataManager");
        throw new EntityException("Call the developer. (Invalid method error)");
    }
    
    public boolean increaseProductQuantity(Product product, int quantity){
        Logger.createLogError("Increase Product Quantity method cant use in this level: DataManager");
        throw new EntityException("Call the developer. (Invalid method error)");
    }
    
    public boolean decreaseProductQuantity(Product product, int quantity){
        Logger.createLogError("Decrease Product Quantity method cant use in this level: DataManager");
        throw new EntityException("Call the developer. (Invalid method error)");
    }

    public <T extends Entity> List<T> searchWithWord(List<T> list,PropertyType propType, String searchWord, SearchType type) {
        return (List<T>)Util.search(list, propType, searchWord, type);
    }

    protected abstract boolean addEntityToDatabase(T e);

    protected abstract boolean updateEntityToDatabase(T e);

    protected abstract boolean deleteEntityInDatabase(T e);

    protected boolean checkEntityCanAdd(T e) {
        refreshData();
        return !haveInEntities(e);
    }

    protected boolean checkEntityCanUpdate(T e) {
        refreshData();
        return haveInEntities(e);
    }

    protected void updateEntityInDataManager(T e) {
        String existId;
        String itemId = e.getId();
        T item;
        for (int i = 0; i < entities.size(); i++) {
            item = entities.get(i);
            existId = item.getId();
            if (existId.equals(itemId)) {
                item = e;
                i = entities.size();
            }
        }
    }

    protected boolean checkEntityCanDelete(T e) {
        refreshData();
        return haveInEntities(e);
    }

    protected boolean haveInEntities(T e) {
        boolean result = false;
        String existId;
        String itemId = e.getId();
        for (int i = 0; i < entities.size(); i++) {
            existId = entities.get(i).getId();
            if (existId.equals(itemId)) {
                result = true;
                i = entities.size();
            }
        }
        return result;
    }
    
    protected <T extends Entity> T getEntityIfHaveWithId(T e){
        Entity result = null;
        String id = e.getId();
        String otherId;
        for (int i = 0; i < entities.size(); i++) {
            otherId = entities.get(i).getId();
            if(otherId.equals(id)){
                result = entities.get(i);
                i = entities.size();
            }
        }
        return (T)result;
    }
    
    public int getEntityQuantityIfHaveWithId(T e){
        Product result = (Product)getEntityIfHaveWithId(e);
        if(result == null){
            Logger.createLogError("Cant get quantity if entity null (DataManager.getEntityQuantityIfHaveWithId)");
            throw new NullPropertyException("Call the developer. (Null error)");
        }
        return result.getQuantity();
    }

    public <T extends Entity> List<T> sortByProperty(PropertyType type, List<T> list) {
        return (List<T>) Util.sortByProperty(type, list);
    }
    
    public <T extends Entity> List<T> reverseList(List<T> list){
        return (List<T>)Util.reverseList(list);
    }
}
