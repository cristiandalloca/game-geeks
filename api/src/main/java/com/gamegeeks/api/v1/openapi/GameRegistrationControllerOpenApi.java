package com.gamegeeks.api.v1.openapi;

import com.gamegeeks.api.v1.model.GameModel;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Jogos", description = "Gerencia jogos")
@SecurityRequirement(name = "security_auth")
public interface GameRegistrationControllerOpenApi {

    List<GameModel> search();

}
