package com.stock.gestionstock.exception;

import lombok.Getter;

import java.util.List;

public class InvalidEntityException extends  RuntimeException{
    @Getter
    private ErrorsCodes errorsCodes;
    @Getter
    private List<String> errors;

    public InvalidEntityException(String message, ErrorsCodes utilisateurChangePasswordObjectNotValid){
        super(message);
    }
    public InvalidEntityException(String message,Throwable cause){
        super(message,cause);

    }
    public InvalidEntityException(String message,Throwable cause,ErrorsCodes errorsCodes){
        super(message,cause);
        this.errorsCodes=errorsCodes;
    }
    public InvalidEntityException(String message,ErrorsCodes errorsCodes,List<String> errors){
        super(message);
        this.errorsCodes=errorsCodes;
        this.errors=errors;
    }
}
