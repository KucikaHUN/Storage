/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.exceptions;

/**
 *
 * @author kucik
 */
public class NullPropertyException extends ErrorException{

    public NullPropertyException() {
    }

    public NullPropertyException(String message) {
        super(message);
    }

    public NullPropertyException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullPropertyException(Throwable cause) {
        super(cause);
    }
    
}
