package com.gamegeeks.api.v1.openapi;

import com.gamegeeks.api.v1.model.DeveloperModel;
import com.gamegeeks.api.v1.model.input.DeveloperInput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;


@Tag(name = "Developers", description = "Manage game developers")
@SecurityRequirement(name = "security_auth")
public interface DeveloperRegistrationControllerOpenApi {

    @Operation(summary = "List developers", description = "List all registered developers")
    List<DeveloperModel> search();

    @Operation(summary = "Register a developer")
    @ApiResponse(responseCode = "201", description = "Developer successfully registered",
            headers = @Header(name = "location", description = "Registered developer location URI"))
    ResponseEntity<DeveloperModel> insert(DeveloperInput developerInput);

    @Operation(summary = "Search a developer by identifier")
    @Parameter(name = "developerId", in = ParameterIn.PATH, description = "Developer identifier", example = "6362927a289959266849759a")
    @ApiResponse(responseCode = "400", description = "Invalid developer identifier")
    @ApiResponse(responseCode = "404", description = "Developer not found")
    DeveloperModel searchById(String developerId);

    @Operation(summary = "Update a developer by identifier")
    @ApiResponse(responseCode = "200", description = "Developer updated")
    @ApiResponse(responseCode = "404", description = "Developer not found")
    DeveloperModel updateById(String developerId, DeveloperInput developerInput);

    @Operation(summary = "Delete a developer by identifier")
    @ApiResponse(responseCode = "204", description = "Developer excluded")
    @ApiResponse(responseCode = "404", description = "Developer not found")
    void deleteById(String developerId);

}
