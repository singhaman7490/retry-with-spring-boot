package com.rt.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;



@Service
public class Testing {

	@Value("${retry.timeinmillisecond:#{2}}")
	private long timeInMillisecond;

	@Value("${max.retry.time:#{1}}")
	private long maxAttemptTime;

	@Value("${max.retry:#{2}}")
	private long maxretry;
	
	public String messages() {
		
		long tm=timeInMillisecond;
		long ma=maxAttemptTime;
		System.out.println("timeInMillisecond"+timeInMillisecond+"-----"+tm);
		System.out.println("maxAttemptTime"+maxAttemptTime+"-------"+ma);
		return "Success";
	}
	
	
	
	
	
	
}
