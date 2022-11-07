package com.gamegeeks.api.v1.openapi;

import com.gamegeeks.api.v1.model.GenreModel;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Gêneros", description = "Gerencia gêneros de jogos")
@SecurityRequirement(name = "security_auth")
public interface GenreRegistrationControllerOpenApi {

    List<GenreModel> search();
}
