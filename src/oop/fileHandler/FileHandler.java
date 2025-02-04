/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.fileHandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kucik
 */
public class FileHandler {

    private FileHandler() {
    }

    public static List<String> readFile(String path) {
        List<String> result = new ArrayList<>();
        String line;
        try (FileReader file = new FileReader(new File(path)); BufferedReader reader = new BufferedReader(file)) {
            while ((line = reader.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public static void writeFile(String path, List<String> list) {
        try (FileWriter w = new FileWriter(new File(path)); BufferedWriter writer = new BufferedWriter(w)) {
            for (String string : list) {
                writer.write(string);
                writer.write(System.lineSeparator());
            }
        } catch (IOException ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void createTextFileIfNotExist(String path) {
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    
    public static void clearTextFile(String path){
        try {
            FileWriter w = new FileWriter(new File(path));
        } catch (IOException ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
}
