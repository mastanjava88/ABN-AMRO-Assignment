package com.abn.amro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/* Custom Exception RecordNotFoundException */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ObjectCreationException extends Exception {

	private static final long serialVersionUID = 1L;

	public ObjectCreationException(String message) {
		super(message);
	}

}
