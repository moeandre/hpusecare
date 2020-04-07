package br.com.wamais.houseCare.handler;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	public static final String FORMATO_MENSAGEM = "'%s' %s";

	// error handle for @Valid
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, final HttpHeaders headers,
			final HttpStatus status, final WebRequest request) {

		final Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", new Date());
		body.put("status", status.value());

		final List<String> errors = new ArrayList<String>();
		for (final FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
			errors.add(String.format(FORMATO_MENSAGEM, fieldError.getField(), fieldError.getDefaultMessage()));
		}

		body.put("errors", errors);

		return new ResponseEntity<Object>(body, headers, status);

	}

}
