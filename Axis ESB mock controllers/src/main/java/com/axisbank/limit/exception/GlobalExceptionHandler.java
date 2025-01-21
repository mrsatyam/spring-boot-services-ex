package com.axisbank.limit.exception;

import java.util.Locale;

import com.axisbank.limit.ratelimit.ApiErrorMessage;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.axisbank.limit.constants.AxisMessageStatusCodes;
import com.axisbank.limit.dto.AxisMessages;
import com.axisbank.limit.dto.ResponseDto;
import com.axisbank.limit.service.AxisMessageService;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private AxisMessageService axisMessageService;
	@ExceptionHandler(RateLimitException.class)
	public ResponseEntity<ApiErrorMessage> handleInvalidFieldsInValidJson(final RateLimitException rateLimitException, final HttpServletRequest request) {
		final ApiErrorMessage apiErrorMessage = rateLimitException.toApiErrorMessage(request.getRequestURI());
		logIncomingCallException(rateLimitException, apiErrorMessage);
		return new ResponseEntity<>(apiErrorMessage, HttpStatus.TOO_MANY_REQUESTS);
	}

	private static void logIncomingCallException(final RateLimitException rateLimitException, final ApiErrorMessage apiErrorMessage) {
		log.error(String.format("%s: %s", apiErrorMessage.getId(), rateLimitException.getMessage()), rateLimitException);
	}
	@ExceptionHandler({ Exception.class })
	protected ResponseEntity<ResponseDto> handleException(Exception e, Locale locale) {
		ResponseDto response = ResponseDto.builder().code(500L).message(e.getMessage()).build();
		return ResponseEntity.internalServerError().body(response);
	}

	@ExceptionHandler({ AxisException.class })
	protected ResponseEntity<ResponseDto> handleAxisException(AxisException e, Locale locale) {
		if (StringUtils.isNotBlank(e.getAxisErrorCode())) {
			AxisMessages axisMessage =axisMessageService.findAxisMessageByStatusCode(e.getAxisErrorCode());

			ResponseDto response = ResponseDto.builder().code(210).statusCode(e.getAxisErrorCode())
					.message(axisMessage != null ? axisMessage.getMessage()
							: AxisMessageStatusCodes.valueOf(e.getAxisErrorCode()).getMessage())
					.build();
			return ResponseEntity.status(210).body(response);
		}
		return ResponseEntity.badRequest().body(null);
	}

}
