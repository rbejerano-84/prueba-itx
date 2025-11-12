package com.itx.prueba.infrastructure.adapter.in.restapi.exception;

public class PriceNotFoundException extends RuntimeException {
    public PriceNotFoundException(String message) {
        super(message);
    }
}
