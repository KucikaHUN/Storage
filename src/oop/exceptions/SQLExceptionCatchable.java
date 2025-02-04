/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.exceptions;

/**
 *
 * @author kucik
 */
public class SQLExceptionCatchable extends ErrorException{

    public SQLExceptionCatchable() {
    }

    public SQLExceptionCatchable(String message) {
        super(message);
    }

    public SQLExceptionCatchable(String message, Throwable cause) {
        super(message, cause);
    }

    public SQLExceptionCatchable(Throwable cause) {
        super(cause);
    }
    
    
}
