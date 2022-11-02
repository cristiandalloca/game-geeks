package com.gamegeeks.api.infrastructure;

import com.gamegeeks.api.exception.model.ProblemModel;
import com.gamegeeks.api.exception.model.ProblemType;
import io.swagger.v3.core.converter.ModelConverters;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import io.swagger.v3.oas.models.tags.Tag;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Configuration
public class SpringDocConfig {

    private static final String BAD_REQUEST_RESPONSE = "BadRequestResponse";
    private static final String NOT_FOUND_RESPONSE = "NotFoundResponse";
    private static final String NOT_ACCEPTABLE_RESPONSE = "NotAcceptableResponse";
    private static final String INTERNAL_SERVER_ERROR_RESPONSE = "InternalServerErrorResponse";

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Game Geeks API")
                        .version("v1")
                        .description("REST API do Game Geeks"))
                .tags(List.of(
                        new Tag().name("Jogos").description("Gerencia jogos")))
                .components(new Components()
                        .responses(generateResponses()));
    }

    @Bean
    public OpenApiCustomiser openApiCustomiser() {
        return openApi -> {
            openApi.getComponents().getSchemas().putAll(generateSchemas());
            openApi.getPaths()
                    .values()
                    .forEach(pathItem -> pathItem.readOperationsMap()
                            .forEach((httpMethod, operation) -> {
                                ApiResponses responses = operation.getResponses();
                                switch (httpMethod) {
                                    case GET, POST, PUT -> {
                                        responses.addApiResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()), new ApiResponse().$ref(BAD_REQUEST_RESPONSE));
                                        responses.addApiResponse(String.valueOf(HttpStatus.NOT_FOUND.value()), new ApiResponse().$ref(NOT_FOUND_RESPONSE));
                                        responses.addApiResponse(String.valueOf(HttpStatus.NOT_ACCEPTABLE.value()), new ApiResponse().$ref(NOT_ACCEPTABLE_RESPONSE));
                                        responses.addApiResponse(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), new ApiResponse().$ref(INTERNAL_SERVER_ERROR_RESPONSE));
                                    }
                                    default -> responses.addApiResponse("500", new ApiResponse().$ref(INTERNAL_SERVER_ERROR_RESPONSE));
                                }
                            })
                    );
        };
    }

    private Map<String, ApiResponse> generateResponses() {
        final var responses = new HashMap<String, ApiResponse>();

        Content content = new Content()
                .addMediaType(APPLICATION_JSON_VALUE,
                        new MediaType().schema(new Schema<ProblemModel>().$ref(ProblemModel.class.getSimpleName())));

        responses.put(BAD_REQUEST_RESPONSE, new ApiResponse()
                .description(ProblemType.INVALID_DATA.getTitle())
                .content(content));

        responses.put(NOT_FOUND_RESPONSE, new ApiResponse()
                .description(ProblemType.RESOURCE_NOT_FOUND.getTitle())
                .content(content));

        responses.put(NOT_ACCEPTABLE_RESPONSE, new ApiResponse()
                .description(ProblemType.NOT_ACCEPTABLE_RESPONSE.getTitle())
                .content(content));

        responses.put(INTERNAL_SERVER_ERROR_RESPONSE, new ApiResponse()
                .description(ProblemType.SYSTEM_ERROR.getTitle())
                .content(content));

        return responses;
    }

    private Map<String, Schema> generateSchemas() {
        final var schemas = new HashMap<String, Schema>();

        Map<String, Schema> problemSchema = ModelConverters.getInstance().read(ProblemModel.class);
        Map<String, Schema> problemObjectSchema = ModelConverters.getInstance().read(ProblemModel.Field.class);

        schemas.putAll(problemSchema);
        schemas.putAll(problemObjectSchema);

        return schemas;
    }
}
