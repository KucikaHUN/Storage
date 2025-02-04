/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.datas;

import oop.types.DataManagerType;
import java.util.HashMap;
import java.util.Map;
import oop.entities.Durable;
import oop.entities.Entity;
import oop.entities.Perishable;
import oop.entities.Tax;

/**
 *
 * @author kucik
 */
public class DataManagerFactory {

    private final static Map<DataManagerType, DataManager<? extends Entity>> datamanagers;

    static {
        datamanagers = new HashMap<>();
        datamanagers.put(DataManagerType.DURABLE_MANAGER, new DataManagerDurable());
        datamanagers.put(DataManagerType.PERISHABLE_MANAGER, new DataManagerPerishable());
        datamanagers.put(DataManagerType.TAX_MANAGER, new DataManagerTax());

    }

    private DataManagerFactory() {
    }

    public static <T extends Entity> DataManager<T> createDataManager(DataManagerType type) {
        return createDataManager(type, null);
    }

    public static <T extends Entity> DataManager<T> createDataManager(DataManagerType type, DataEventListener l) {
        DataManager<T> m = (DataManager<T>)datamanagers.get(type);
        if (l != null) {
            m.addListener(l);
        }
        return m;
    }
}
