package com.gamegeeks.api.v1.openapi;

import com.gamegeeks.api.v1.model.FranchiseModel;
import com.gamegeeks.api.v1.model.input.FranchiseInput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Franchise", description = "Manage game franchises")
@SecurityRequirement(name = "security_auth")
public interface FranchiseRegistrationControllerOpenApi {

    @Operation(summary = "List Franchises", description = "List all registered franchises")
    List<FranchiseModel> search();

    @Operation(summary = "Register a franchise")
    @ApiResponse(responseCode = "201", description = "Franchise successfully registered",
            headers = @Header(name = "location", description = "Registered franchise location URI"))
    ResponseEntity<FranchiseModel> insert(FranchiseInput franchiseInput);

    @Operation(summary = "Search a franchise by identifier")
    @ApiResponse(responseCode = "400", description = "Invalid franchise identifier")
    @ApiResponse(responseCode = "404", description = "Franchise not found")
    FranchiseModel searchById(String franchiseId);
}
