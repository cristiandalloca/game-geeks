package com.gamegeeks.api.v1.openapi;

import com.gamegeeks.api.v1.model.GameModeModel;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Modos de Jogo", description = "Gerencia modos de jogo de jogos")
@SecurityRequirement(name = "security_auth")
public interface GameModeRegistrationControllerOpenApi {

    List<GameModeModel> search();
}
