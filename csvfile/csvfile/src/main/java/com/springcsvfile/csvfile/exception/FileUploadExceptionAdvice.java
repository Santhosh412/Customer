package com.springcsvfile.csvfile.exception;

import com.springcsvfile.csvfile.UniqueIndexvalueException;
import com.springcsvfile.csvfile.message.ResponseMessage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class FileUploadExceptionAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public ResponseEntity<ResponseMessage> handleMaxSizeException(MaxUploadSizeExceededException exc) {
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("File too large!"));
	}
	/*
	 * @ExceptionHandler(UniqueIndexvalueException.class) public
	 * ResponseEntity<Object> handleUserNotFoundException(UniqueIndexvalueException
	 * ex) { return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new
	 * ResponseMessage("Unique index or primary key violation")); }
	 */

	@ExceptionHandler(UniqueIndexvalueException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(UniqueIndexvalueException ex, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse("Duplicate key for index data", details);
		return new ResponseEntity(error, HttpStatus.EXPECTATION_FAILED);
	}

}