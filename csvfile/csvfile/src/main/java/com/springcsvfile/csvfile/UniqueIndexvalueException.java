package com.springcsvfile.csvfile;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
public class UniqueIndexvalueException extends RuntimeException {
	public UniqueIndexvalueException(String exception){
		super (exception);
	}
	}

