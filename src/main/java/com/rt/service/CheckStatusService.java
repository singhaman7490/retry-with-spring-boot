package com.rt.service;

import org.springframework.http.HttpStatus;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpStatusCodeException;

@Service
public class CheckStatusService {

	static int counter=0;
    @Retryable(value = {HttpStatusCodeException.class, NullPointerException.class}, maxAttempts = 3, backoff = @Backoff(3000), exclude =
            HttpClientErrorException.class)
    public String checkStatus(String trackingNumber) {

        // another microservice call to get status.
        //rest template call
    	System.out.println("Retry count"+ ++counter);
    	String str=null;
        str.length();
    	System.out.println("calling another service to get status!!");
    //    throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);

         return "approved";
    }

    @Recover
    public String recover(HttpServerErrorException exception) {
    	System.out.println("Please try after some time!!");
        return "Please try after some time!!";
    }
    @Recover
    public String recover(NullPointerException exception) {
    	System.out.println("Please try after some time null pointer!!");
        return "Please try after some time null pointer!!";
    }
}
