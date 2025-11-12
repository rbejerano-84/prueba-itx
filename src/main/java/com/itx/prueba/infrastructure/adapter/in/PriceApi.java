package com.itx.prueba.infrastructure.adapter.in;

import org.springframework.http.ResponseEntity;

import com.itx.prueba.infrastructure.adapter.in.restapi.dto.request.PriceRequestDTO;
import com.itx.prueba.infrastructure.adapter.in.restapi.dto.response.ApiSuccessResponse;
import com.itx.prueba.infrastructure.adapter.in.restapi.dto.response.PriceResponseDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Price", description = "Operaciones para gestionar los rangos de precios")
public interface PriceApi {
	@Operation(summary = "Obtiene el precio aplicable para un producto, marca y fecha dados")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Precio encontrado"),
        @ApiResponse(responseCode = "400", description = "Solicitud inválida"),
        @ApiResponse(responseCode = "404", description = "No se encontró precio para los parámetros proporcionados")
    })
	ResponseEntity<ApiSuccessResponse<PriceResponseDTO>> getPriceByIdIdCadDate(
			@RequestBody @Valid PriceRequestDTO request);

}
