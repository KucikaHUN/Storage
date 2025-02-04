/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.logs;

import java.util.List;
import oop.entities.Entity;
import oop.entities.Product;
import oop.fileHandler.FileHandler;
import oop.types.LogType;
import oop.utils.Util;

/**
 *
 * @author kucik
 */
public class Logger {

    private final static String path;
    private final static String pathError;

    static {
        path = "C:\\Users\\kucik\\Documents\\NetBeansProjects\\Vizsga\\logs\\log.log";
        pathError = "C:\\Users\\kucik\\Documents\\NetBeansProjects\\Vizsga\\logs\\errorLog.log";
    }

    private Logger() {
    }
    
    public static void createLogError(String error){
        FileHandler.createTextFileIfNotExist(pathError);
        List<String> logs = FileHandler.readFile(pathError);
        String logText = createLogTextError(error);
        logs.add(logText);
        FileHandler.writeFile(pathError, logs);
    }

    public static void createLog(Entity entity, LogType type) {
        FileHandler.createTextFileIfNotExist(path);
        List<String> logs = FileHandler.readFile(path);
        String logText = createLogText(entity, type);
        logs.add(logText);
        FileHandler.writeFile(path, logs);
    }

    private static String createLogText(Entity entity, LogType type) {
        String result = "";
        String delimiter = ";";
        result += Util.createCurrentTime();
        result += delimiter;
        result += entity.getId();
        result += delimiter;
        result += type.toString();
        result += delimiter;
        if (isChangeOnlyQuantity(type)) {
            Product p = (Product) entity;
            result += "new quantity: " + p.getQuantity();
            result += delimiter;
        }
        return result;
    }

    private static boolean isChangeOnlyQuantity(LogType type) {
        boolean result = false;
        if (type.equals(LogType.INCREASE_QUANTITY)
                || type.equals(LogType.DECREASE_QUANTITY)) {
            result = true;
        }
        return result;
    }
    
    public static void saveLogsToPath(String otherPath){
        List<String> logs = FileHandler.readFile(path);
        FileHandler.writeFile(otherPath+"\\log.txt", logs);
        FileHandler.clearTextFile(path);
    }
    
    public static void saveErrorLogsToPath(String otherPath){
        List<String> logs = FileHandler.readFile(pathError);
        FileHandler.writeFile(otherPath+"\\errorLog.txt", logs);
        FileHandler.clearTextFile(pathError);
    }

    private static String createLogTextError(String error) {
        String result = "";
        String delimiter = ";";
        result += Util.createCurrentTime();
        result += delimiter;
        result += error;
        result += delimiter;
        return result;
    }
}
