package com.gamegeeks.api.exception.handler;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.PropertyBindingException;
import com.gamegeeks.api.exception.ProblemModelFactory;
import com.gamegeeks.api.exception.model.ProblemModel;
import com.gamegeeks.api.exception.model.ProblemType;
import com.gamegeeks.domain.exception.BusinessException;
import com.gamegeeks.domain.exception.DocumentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.TypeMismatchException;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.lang.NonNull;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@RequiredArgsConstructor
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String MSG_ERRO_GENERICA_USUARIO_FINAL
            = "Ocorreu um erro interno inesperado no sistema. Tente novamente mais tarde, se "
            + "o problema persistir, entre em contato com o administrador do sistema.";

    private final MessageSource messageSource;

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleBusiness(BusinessException exception, WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ProblemType problemType = ProblemType.BUSINESS_ERROR;
        String detail = exception.getMessage();

        ProblemModel problem = ProblemModelFactory.make(status, problemType, detail);

        return this.handleExceptionInternal(exception, problem, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(DocumentNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFound(DocumentNotFoundException exception, WebRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ProblemType problemType = ProblemType.RESOURCE_NOT_FOUND;
        String detail = exception.getMessage();

        ProblemModel problem = ProblemModelFactory.make(status, problemType, detail);
        return this.handleExceptionInternal(exception, problem, new HttpHeaders(), status, request);
    }

    @Override
    @NonNull
    protected ResponseEntity<Object> handleMethodArgumentNotValid(@NonNull MethodArgumentNotValidException ex, @NonNull HttpHeaders headers, @NonNull HttpStatus status, @NonNull WebRequest request) {
        return this.handleValidationInternal(ex, headers, status, request);
    }

    private ResponseEntity<Object> handleValidationInternal(BindException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ProblemType problemType = ProblemType.INVALID_DATA;
        String detail = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.";

        BindingResult bindingResult = exception.getBindingResult();
        List<ProblemModel.Field> problemFields = bindingResult.getAllErrors().stream()
                .map(objectError -> {
                    String message = messageSource.getMessage(objectError, LocaleContextHolder.getLocale());

                    String name;
                    if (objectError instanceof FieldError fieldError) {
                        name = fieldError.getField();
                    } else {
                        name = objectError.getObjectName();
                    }

                    return ProblemModel.Field.builder()
                            .name(name)
                            .userMessage(message)
                            .build();
                }).toList();

        ProblemModel problem = ProblemModelFactory.make(status, problemType, detail, problemFields);

        return this.handleExceptionInternal(exception, problem, headers, status, request);
    }


    @Override
    @NonNull
    protected ResponseEntity<Object> handleTypeMismatch(@NonNull TypeMismatchException exception, @NonNull HttpHeaders headers,
                                                        @NonNull HttpStatus status, @NonNull WebRequest request) {

        if (exception instanceof MethodArgumentTypeMismatchException methodArgumentTypeMismatchException) {
            return handleMethodArgumentTypeMismatch(methodArgumentTypeMismatchException, headers, status, request);
        }

        return super.handleTypeMismatch(exception, headers, status, request);
    }

    private ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException exception,
                                                                    HttpHeaders headers, HttpStatus status, WebRequest request) {

        ProblemType problemType = ProblemType.INVALID_PARAMETER;
        String detail = getDetailMethodArgumentTypeMismatchException(exception);
        ProblemModel problem = ProblemModelFactory.make(status, problemType, detail, MSG_ERRO_GENERICA_USUARIO_FINAL);

        return this.handleExceptionInternal(exception, problem, headers, status, request);
    }

    private String getDetailMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException exception) {
        Class<?> requiredType = exception.getRequiredType();
        return String.format("O parâmetro de URL '%s' recebeu o valor '%s', "
                        + "que é de um tipo inválido. Corrija e informe um valor compatível com o tipo %s.",
                exception.getName(), exception.getValue(), requiredType == null ? "undefined" : requiredType.getSimpleName());
    }

    @Override
    @NonNull
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, @NonNull HttpHeaders headers, @NonNull HttpStatus status, @NonNull WebRequest request) {

        Throwable rootCause = ex.getRootCause();

        String detail;
        if (rootCause instanceof InvalidFormatException invalidFormatException) {
            detail = getDetailMessageInvalidFormat(invalidFormatException);
        } else if (rootCause instanceof PropertyBindingException propertyBindingException) {
            detail = getDetailMessagePropertyBinding(propertyBindingException);
        } else {
            detail = "O corpo da requisição está inválido. Verifique erro de sintaxe.";
        }

        ProblemType problemType = ProblemType.INCOMPREHENSIBLE_MESSAGE;
        ProblemModel problem = ProblemModelFactory.make(status, problemType, detail, MSG_ERRO_GENERICA_USUARIO_FINAL);

        return super.handleExceptionInternal(ex, problem, headers, status, request);
    }

    @ExceptionHandler(PropertyReferenceException.class)
    public ResponseEntity<Object> handleEntityNotFound(PropertyReferenceException exception, WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ProblemType problemType = ProblemType.INCOMPREHENSIBLE_MESSAGE;

        String detail = String.format("A propriedade '%s' não existe. "
                + "Corrija ou remova essa propriedade e tente novamente.", exception.getPropertyName());

        ProblemModel problem = ProblemModelFactory.make(status, problemType, detail, MSG_ERRO_GENERICA_USUARIO_FINAL);
        return this.handleExceptionInternal(exception, problem, new HttpHeaders(), status, request);

    }

    private String getDetailMessagePropertyBinding(PropertyBindingException exception) {
        String path = joinPath(exception.getPath());
        return String.format("A propriedade '%s' não existe. "
                + "Corrija ou remova essa propriedade e tente novamente.", path);
    }

    private String getDetailMessageInvalidFormat(InvalidFormatException exception) {
        String path = joinPath(exception.getPath());
        return String.format("A propriedade '%s' recebeu o valor '%s', "
                        + "que é de um tipo inválido. Corrija e informe um valor compatível com o tipo %s.",
                path, exception.getValue(), exception.getTargetType().getSimpleName());
    }

    private String joinPath(List<JsonMappingException.Reference> references) {
        return references.stream()
                .map(JsonMappingException.Reference::getFieldName)
                .collect(Collectors.joining("."));
    }
}
