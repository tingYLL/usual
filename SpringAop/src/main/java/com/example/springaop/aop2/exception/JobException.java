package com.example.springaop.aop2.exception;

/*
	异常类
 */
public class JobException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public JobException(String message){
		super(message);
	}

	public JobException(Throwable cause)
	{
		super(cause);
	}

	public JobException(String message, Throwable cause)
	{
		super(message,cause);
	}
}
