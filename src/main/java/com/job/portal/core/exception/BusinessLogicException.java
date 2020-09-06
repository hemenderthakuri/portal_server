package com.job.portal.core.exception;

public class BusinessLogicException extends ApplicationException {

    private static final long serialVersionUID = 2986558567060952922L;

    private String exceptionMessage;

    public BusinessLogicException(final Exception e) {
        super(e);
    }

    public BusinessLogicException(final String exceptionMessage) {
        super(exceptionMessage);
        this.exceptionMessage = exceptionMessage;
    }

    public BusinessLogicException(final String exceptionMessage, final Exception e) {
        super(exceptionMessage, e);
        this.exceptionMessage = exceptionMessage;
    }
    
    public String getMessage() {
        return exceptionMessage;
    }

}
