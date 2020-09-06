package com.job.portal.core.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.job.portal.common.Messages;
import com.job.portal.core.ResponseStatus;
import com.job.portal.core.ResponseView;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

	@ExceptionHandler(value = BusinessLogicException.class)
	public ResponseView businessLogicException(BusinessLogicException e) {

		ResponseView responseView = new ResponseView();
		if (e.getMessage() == null)
			responseView.setMessage(e.getCause().getMessage());
		else
			responseView.setMessage(e.getMessage());

		responseView.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		responseView.setStatusType(ResponseStatus.FAILURE);
		return responseView;

	}

	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	public ResponseView messageNotReadableException() {
		ResponseView responseView = new ResponseView();
		responseView.setMessage(Messages.BAD_JSON_ERROR);
		responseView.setStatus(HttpStatus.BAD_REQUEST.value());
		responseView.setStatusType(ResponseStatus.FAILURE);
		return responseView;
	}

	@ExceptionHandler(value = DataAccessException.class)
	public ResponseView dataAccessException(DataAccessException e) {
		ResponseView responseView = new ResponseView();
		responseView.setMessage(Messages.DATABASE_ERROR);
		responseView.setStatus(HttpStatus.BAD_REQUEST.value());
		responseView.setStatusType(ResponseStatus.FAILURE);
		return responseView;
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseView genericException(Exception e) {
		ResponseView responseView = new ResponseView();
		responseView.setMessage(e.getMessage());
		responseView.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		responseView.setStatusType(ResponseStatus.FAILURE);
		return responseView;
	}

}
