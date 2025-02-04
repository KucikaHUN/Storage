/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.exceptions;

/**
 *
 * @author kucik
 */
public class DataManagerException extends ErrorException {

    public DataManagerException() {
    }

    public DataManagerException(String message) {
        super(message);
    }

    public DataManagerException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataManagerException(Throwable cause) {
        super(cause);
    }

}
