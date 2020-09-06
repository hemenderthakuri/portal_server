package com.job.portal.controller;

import com.job.portal.core.IPortalView;
import com.job.portal.core.ResponseStatus;
import com.job.portal.core.ResponseView;

public class AbstractController {
    
    protected ResponseView getResponseView(int httpStatus, ResponseStatus responseStatus, String responseMessage) {
        ResponseView responseView = new ResponseView();
        responseView.setStatus(httpStatus);
        responseView.setStatusType(responseStatus);
        responseView.setMessage(responseMessage);
        return responseView;
    }


    protected ResponseView getResponseView(int httpStatus, ResponseStatus responseStatus, String responseMessage,
            IPortalView data) {
        ResponseView responseView = new ResponseView();
        responseView = getResponseView(httpStatus, responseStatus, responseMessage);
        responseView.setData(data);
        return responseView;
    }
}
