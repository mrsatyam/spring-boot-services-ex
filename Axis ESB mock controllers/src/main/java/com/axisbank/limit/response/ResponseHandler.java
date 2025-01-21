package com.axisbank.limit.response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;

import com.axisbank.limit.constants.HttpStatusCodes;
import com.axisbank.limit.dto.AxisMessages;
import com.axisbank.limit.dto.ResponseDto;
import com.axisbank.limit.service.AxisMessageService;

@Component
public class ResponseHandler {

	private static AxisMessageService axisMessageService;

	@Autowired
	private ResponseHandler(AxisMessageService axisMessageService) {
		ResponseHandler.axisMessageService = axisMessageService;
	}

	public static ResponseEntity<ResponseDto> generateResponse(String statusCode, HttpStatusCodes status,
			Object responseObj) {
		AxisMessages axisMessages = axisMessageService.findAxisMessageByStatusCode(statusCode);
		ResponseDto responseDto = ResponseDto.builder().code(status.getValue())
				.message(axisMessages != null ? axisMessages.getMessage() : statusCode).statusCode(statusCode)
				.data(responseObj).build();
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.valueOf(status.getValue()));
	}



	public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", message);
		map.put("status", status);
		map.put("data", responseObj);
		return new ResponseEntity<Object>(map, status);
	}

	public static ResponseEntity<Object> generateResponse(String responseMessage, HttpStatus status) {
		ResponseDto responseDto = ResponseDto.builder().code(status.value()).message(responseMessage)
				.statusCode(status.toString()).build();
		return new ResponseEntity<Object>(responseDto, status);
	}
	
	public static ResponseEntity<Object> generateResponse(List<FieldError> errorMessages) {
		StringBuilder errors = new StringBuilder();
		for (FieldError error : errorMessages) {
			errors.append(error.getDefaultMessage());
			errors.append("\n");
		}
		ResponseDto responseDto = ResponseDto.builder().code(HttpStatus.BAD_REQUEST.value()).message(errors.toString())
				.statusCode(HttpStatus.BAD_REQUEST.toString()).build();
		return new ResponseEntity<Object>(responseDto, HttpStatus.BAD_REQUEST);
	}
}