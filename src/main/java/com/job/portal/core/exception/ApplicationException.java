package com.job.portal.core.exception;
public class ApplicationException extends Exception{

    private static final long serialVersionUID = 8371855667664018440L;

    public ApplicationException(final Exception e){
        super(e);
    }
    
    public ApplicationException(final String exceptionMessage){
        super(exceptionMessage);
    }
    
    public ApplicationException(final String exceptionMessage, final Exception e){
        super(exceptionMessage,e);
    }
}

