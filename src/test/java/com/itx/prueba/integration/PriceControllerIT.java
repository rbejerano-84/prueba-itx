package com.itx.prueba.integration;

// TEST DE INTEGRACIÓN
// Este test arranca el contexto real de Spring y prueba los endpoints REST y la base de datos H2.
// Se recomienda mantener los tests de integración en el paquete integration o con sufijo IT.

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerIT {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Test 1: 14/06/2020 10:00 producto 35455 brand 1")
    void test1() throws Exception {
        mockMvc.perform(post("/api/v1/findByIdRange")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{" +
                        "\"productId\":35455," +
                        "\"brandId\":1," +
                        "\"applicationDate\":\"2020-06-14-10.00.00\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.productId").value(35455))
                .andExpect(jsonPath("$.data.brandId").value(1))
                .andExpect(jsonPath("$.data.priceList").value(1))
                .andExpect(jsonPath("$.data.startDate").value("2020-06-14T00:00:00"))
                .andExpect(jsonPath("$.data.endDate").value("2020-12-31T23:59:59"))
                .andExpect(jsonPath("$.data.price").value(35.5))
                .andExpect(jsonPath("$.data.currency").value("EUR"));
    }

    @Test
    @DisplayName("Test 2: 14/06/2020 16:00 producto 35455 brand 1")
    void test2() throws Exception {
        mockMvc.perform(post("/api/v1/findByIdRange")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{" +
                        "\"productId\":35455," +
                        "\"brandId\":1," +
                        "\"applicationDate\":\"2020-06-14-16.00.00\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.productId").value(35455))
                .andExpect(jsonPath("$.data.brandId").value(1))
                .andExpect(jsonPath("$.data.priceList").value(2))
                .andExpect(jsonPath("$.data.startDate").value("2020-06-14T15:00:00"))
                .andExpect(jsonPath("$.data.endDate").value("2020-06-14T18:30:00"))
                .andExpect(jsonPath("$.data.price").value(25.45))
                .andExpect(jsonPath("$.data.currency").value("EUR"));
    }

    @Test
    @DisplayName("Test 3: 14/06/2020 21:00 producto 35455 brand 1")
    void test3() throws Exception {
        mockMvc.perform(post("/api/v1/findByIdRange")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{" +
                        "\"productId\":35455," +
                        "\"brandId\":1," +
                        "\"applicationDate\":\"2020-06-14-21.00.00\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.productId").value(35455))
                .andExpect(jsonPath("$.data.brandId").value(1))
                .andExpect(jsonPath("$.data.priceList").value(1))
                .andExpect(jsonPath("$.data.startDate").value("2020-06-14T00:00:00"))
                .andExpect(jsonPath("$.data.endDate").value("2020-12-31T23:59:59"))
                .andExpect(jsonPath("$.data.price").value(35.5))
                .andExpect(jsonPath("$.data.currency").value("EUR"));
    }

    @Test
    @DisplayName("Test 4: 15/06/2020 10:00 producto 35455 brand 1")
    void test4() throws Exception {
        mockMvc.perform(post("/api/v1/findByIdRange")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{" +
                        "\"productId\":35455," +
                        "\"brandId\":1," +
                        "\"applicationDate\":\"2020-06-15-10.00.00\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.productId").value(35455))
                .andExpect(jsonPath("$.data.brandId").value(1))
                .andExpect(jsonPath("$.data.priceList").value(3))
                .andExpect(jsonPath("$.data.startDate").value("2020-06-15T00:00:00"))
                .andExpect(jsonPath("$.data.endDate").value("2020-06-15T11:00:00"))
                .andExpect(jsonPath("$.data.price").value(30.5))
                .andExpect(jsonPath("$.data.currency").value("EUR"));
    }

    @Test
    @DisplayName("Test 5: 16/06/2020 21:00 producto 35455 brand 1")
    void test5() throws Exception {
        mockMvc.perform(post("/api/v1/findByIdRange")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{" +
                        "\"productId\":35455," +
                        "\"brandId\":1," +
                        "\"applicationDate\":\"2020-06-16-21.00.00\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.productId").value(35455))
                .andExpect(jsonPath("$.data.brandId").value(1))
                .andExpect(jsonPath("$.data.priceList").value(4))
                .andExpect(jsonPath("$.data.startDate").value("2020-06-15T16:00:00"))
                .andExpect(jsonPath("$.data.endDate").value("2020-12-31T23:59:59"))
                .andExpect(jsonPath("$.data.price").value(38.95))
                .andExpect(jsonPath("$.data.currency").value("EUR"));
    }

    @Test
    @DisplayName("Test formato incorrecto")
    void testFormatoIncorrecto() throws Exception {
        String response = mockMvc.perform(post("/api/v1/findByIdRange")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{" +
                        "\"productId\":35455," +
                        "\"brandId\":1," +
                        "\"applicationDate\":\"2020/06/14 10:00:00\"}"))
                .andExpect(status().isBadRequest())
                .andReturn().getResponse().getContentAsString();
        System.out.println("MENSAJE DE ERROR DEVUELTO: " + response);
        org.assertj.core.api.Assertions.assertThat(response).contains("debe tener formato yyyy-MM-dd-HH.mm.ss");
    }

    @Test
    @DisplayName("Test producto no encontrado")
    void testProductoNoEncontrado() throws Exception {
        mockMvc.perform(post("/api/v1/findByIdRange")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{" +
                        "\"productId\":99999," +
                        "\"brandId\":1," +
                        "\"applicationDate\":\"2020-06-14-10.00.00\"}"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("No se encontró un precio para los parámetros proporcionados."));
    }
}
