package com.gamegeeks.api.v1.openapi;

import com.gamegeeks.api.v1.model.UserModel;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Usuários", description = "Gerencia usuários")
@SecurityRequirement(name = "security_auth")
public interface UserRegistrationControllerOpenApi {

    List<UserModel> search();
}
