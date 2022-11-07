package com.gamegeeks.api.v1.openapi;

import com.gamegeeks.api.v1.model.PlatformModel;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Plataformas", description = "Gerencia plataformas de jogos")
@SecurityRequirement(name = "security_auth")
public interface PlatformRegistrationControllerOpenApi {

    List<PlatformModel> search();
}
