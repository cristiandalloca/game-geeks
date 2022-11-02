package com.gamegeeks.api.exception;

import com.gamegeeks.api.exception.model.ProblemModel;
import com.gamegeeks.api.exception.model.ProblemType;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;

import java.time.OffsetDateTime;
import java.util.List;

@UtilityClass
public class ProblemModelFactory {

    public static ProblemModel make(HttpStatus status, ProblemType problemType, String detail, String userMessage) {
        return makeBuilder(status, problemType, detail, userMessage).build();
    }

    public static ProblemModel make(HttpStatus status, ProblemType problemType, String detail) {
        return makeBuilder(status, problemType, detail, detail).build();
    }

    public static ProblemModel make(HttpStatus status, ProblemType problemType, String detail, List<ProblemModel.Field> problemFields) {
        return makeBuilder(status, problemType, detail, detail).fields(problemFields).build();
    }

    private static ProblemModel.ProblemModelBuilder makeBuilder(HttpStatus status, ProblemType problemType, String detail, String userMessage) {
        return ProblemModel.builder()
                .timestamp(OffsetDateTime.now())
                .status(status.value())
                .type(problemType.getUri())
                .title(problemType.getTitle())
                .detail(detail)
                .userMessage(userMessage);
    }
}
