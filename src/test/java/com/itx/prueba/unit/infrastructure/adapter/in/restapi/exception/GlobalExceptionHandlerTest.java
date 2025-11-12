package com.itx.prueba.unit.infrastructure.adapter.in.restapi.exception;

import com.itx.prueba.infrastructure.adapter.in.restapi.exception.GlobalExceptionHandler;
import com.itx.prueba.infrastructure.adapter.in.restapi.exception.PriceNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GlobalExceptionHandlerTest {
    private final GlobalExceptionHandler handler = new GlobalExceptionHandler();

    @Test
    void handlePriceNotFoundException_returnsMessage() {
        PriceNotFoundException ex = new PriceNotFoundException("no encontrado");
        Map<String, String> resp = handler.handlePriceNotFoundException(ex);
        assertEquals("no encontrado", resp.get("message"));
    }

    @Test
    void handleIllegalArgumentException_returnsMessage() {
        IllegalArgumentException ex = new IllegalArgumentException("error arg");
        Map<String, String> resp = handler.handleIllegalArgumentException(ex);
        assertEquals("error arg", resp.get("message"));
    }

    @Test
    void handleHttpMessageNotReadable_returnsMessage() {
        HttpMessageNotReadableException ex = new HttpMessageNotReadableException("json mal");
        Map<String, String> resp = handler.handleHttpMessageNotReadable(ex);
        assertEquals("Faltan campos obligatorios o el JSON es inválido", resp.get("message"));
    }
}
