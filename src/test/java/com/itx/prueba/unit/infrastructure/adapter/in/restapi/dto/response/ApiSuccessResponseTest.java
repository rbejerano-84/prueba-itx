package com.itx.prueba.unit.infrastructure.adapter.in.restapi.dto.response;

import com.itx.prueba.infrastructure.adapter.in.restapi.dto.response.ApiSuccessResponse;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ApiSuccessResponseTest {
    @Test
    void gettersAndSetters() {
        ApiSuccessResponse<String> response = new ApiSuccessResponse<>("mensaje", "data");
        assertEquals(200, response.getStatus());
        assertEquals("mensaje", response.getMsg());
        assertEquals("data", response.getData());
        response.setStatus(404);
        response.setMsg("otro");
        response.setData("nuevo");
        assertEquals(404, response.getStatus());
        assertEquals("otro", response.getMsg());
        assertEquals("nuevo", response.getData());
    }
}
