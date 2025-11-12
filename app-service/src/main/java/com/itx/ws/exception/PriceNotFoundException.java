package com.itx.ws.exception;

/**
 * Exception thrown when no applicable price is found for given parameters.
 * Triggers 404 response with proper ErrorResponse body.
 */
public class PriceNotFoundException extends RuntimeException {
    
    public PriceNotFoundException(String message) {
        super(message);
    }
    
    public PriceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public static PriceNotFoundException forParameters(Long brandId, Long productId, String applicationDate) {
        return new PriceNotFoundException(
            String.format("No applicable price found for brandId=%d, productId=%d, applicationDate=%s", 
                         brandId, productId, applicationDate)
        );
    }
}