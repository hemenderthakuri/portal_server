package com.job.portal.core;

public enum ResponseStatus {

	SUCCESS, FAILURE, PERMISSION_DENIED, ACCESS_DENIED, UNAUTHORIZED;

    public String getResponseStatus() {
        return this.name();
    }
}
