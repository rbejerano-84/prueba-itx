package com.itx;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Integration tests for price query endpoint.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class PriceIntegrationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    @DisplayName("Test 1: Request at 10:00 on day 14 for product 35455 and brand 1 (ZARA)")
    void test1_10amDay14() throws Exception {
        // Given: Query at 10:00 AM on June 14th
        String applicationDate = "2020-06-14T10:00:00Z";
        Long productId = 35455L;
        Long brandId = 1L;

        // When & Then: Call endpoint and verify response
        mockMvc.perform(get("/api/v1/prices")
                .param("applicationDate", applicationDate)
                .param("productId", String.valueOf(productId))
                .param("brandId", String.valueOf(brandId))
                .contentType(MediaType.APPLICATION_JSON))
                
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                
                // Verify response structure and values
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.productId", is(35455)))
                .andExpect(jsonPath("$.brandId", is(1)))
                .andExpect(jsonPath("$.priceList", is(1)))
                .andExpect(jsonPath("$.price", is(35.50)))
                .andExpect(jsonPath("$.curr", is("EUR")))
                .andExpect(jsonPath("$.startDate", notNullValue()))
                .andExpect(jsonPath("$.endDate", notNullValue()));
    }

    @Test
    @DisplayName("Test 2: Request at 16:00 on day 14 for product 35455 and brand 1 (ZARA)")
    void test2_4pmDay14() throws Exception {
        // Given: Query at 4:00 PM on June 14th (promotional price period)
        String applicationDate = "2020-06-14T16:00:00Z";
        Long productId = 35455L;
        Long brandId = 1L;

        // When & Then: Call endpoint and verify promotional price
        mockMvc.perform(get("/api/v1/prices")
                .param("applicationDate", applicationDate)
                .param("productId", String.valueOf(productId))
                .param("brandId", String.valueOf(brandId))
                .contentType(MediaType.APPLICATION_JSON))
                
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                
                // Verify promotional price (higher priority)
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.productId", is(35455)))
                .andExpect(jsonPath("$.brandId", is(1)))
                .andExpect(jsonPath("$.priceList", is(2)))
                .andExpect(jsonPath("$.price", is(25.45)))
                .andExpect(jsonPath("$.curr", is("EUR")))
                .andExpect(jsonPath("$.startDate", notNullValue()))
                .andExpect(jsonPath("$.endDate", notNullValue()));
    }

    @Test
    @DisplayName("Test 3: Request at 21:00 on day 14 for product 35455 and brand 1 (ZARA)")
    void test3_9pmDay14() throws Exception {
        // Given: Query at 9:00 PM on June 14th (after promotional period)
        String applicationDate = "2020-06-14T21:00:00Z";
        Long productId = 35455L;
        Long brandId = 1L;

        // When & Then: Call endpoint and verify back to regular price
        mockMvc.perform(get("/api/v1/prices")
                .param("applicationDate", applicationDate)
                .param("productId", String.valueOf(productId))
                .param("brandId", String.valueOf(brandId))
                .contentType(MediaType.APPLICATION_JSON))
                
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                
                // Verify back to regular price
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.productId", is(35455)))
                .andExpect(jsonPath("$.brandId", is(1)))
                .andExpect(jsonPath("$.priceList", is(1)))
                .andExpect(jsonPath("$.price", is(35.50)))
                .andExpect(jsonPath("$.curr", is("EUR")))
                .andExpect(jsonPath("$.startDate", notNullValue()))
                .andExpect(jsonPath("$.endDate", notNullValue()));
    }

    @Test
    @DisplayName("Test 4: Request at 10:00 on day 15 for product 35455 and brand 1 (ZARA)")
    void test4_10amDay15() throws Exception {
        // Given: Query at 10:00 AM on June 15th
        String applicationDate = "2020-06-15T10:00:00Z";
        Long productId = 35455L;
        Long brandId = 1L;

        // When & Then: Call endpoint and verify morning price on day 15
        mockMvc.perform(get("/api/v1/prices")
                .param("applicationDate", applicationDate)
                .param("productId", String.valueOf(productId))
                .param("brandId", String.valueOf(brandId))
                .contentType(MediaType.APPLICATION_JSON))
                
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                
                // Verify morning price on day 15
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.productId", is(35455)))
                .andExpect(jsonPath("$.brandId", is(1)))
                .andExpect(jsonPath("$.priceList", is(3)))
                .andExpect(jsonPath("$.price", is(30.50)))
                .andExpect(jsonPath("$.curr", is("EUR")))
                .andExpect(jsonPath("$.startDate", notNullValue()))
                .andExpect(jsonPath("$.endDate", notNullValue()));
    }

    @Test
    @DisplayName("Test 5: Request at 21:00 on day 16 for product 35455 and brand 1 (ZARA)")
    void test5_9pmDay16() throws Exception {
        // Given: Query at 9:00 PM on June 16th
        String applicationDate = "2020-06-16T21:00:00Z";
        Long productId = 35455L;
        Long brandId = 1L;

        // When & Then: Call endpoint and verify evening price on day 16
        mockMvc.perform(get("/api/v1/prices")
                .param("applicationDate", applicationDate)
                .param("productId", String.valueOf(productId))
                .param("brandId", String.valueOf(brandId))
                .contentType(MediaType.APPLICATION_JSON))
                
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                
                // Verify evening price on day 16
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.productId", is(35455)))
                .andExpect(jsonPath("$.brandId", is(1)))
                .andExpect(jsonPath("$.priceList", is(4)))
                .andExpect(jsonPath("$.price", is(38.95)))
                .andExpect(jsonPath("$.curr", is("EUR")))
                .andExpect(jsonPath("$.startDate", notNullValue()))
                .andExpect(jsonPath("$.endDate", notNullValue()));
    }

}