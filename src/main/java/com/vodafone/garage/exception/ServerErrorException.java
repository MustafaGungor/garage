package com.vodafone.garage.exception;

public class ServerErrorException extends Exception
{
	public ServerErrorException(final String errorMessage)
	{
		super(errorMessage);
	}
	
	public ServerErrorException(final String errorMsg, final Throwable errorObject)
	{
		super(errorMsg, errorObject);
	}
}