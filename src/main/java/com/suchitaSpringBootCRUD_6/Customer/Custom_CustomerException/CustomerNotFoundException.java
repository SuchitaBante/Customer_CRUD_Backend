package com.suchitaSpringBootCRUD_6.Customer.Custom_CustomerException;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException (String message){
        super(message);
    }
}
