package com.vodafone.garage.config;

import com.vodafone.garage.exception.NotFoundException;
import com.vodafone.garage.exception.ServerErrorException;

public class CommandParserFactory {

	public static void getInputParserConfig(String string) throws NotFoundException, ServerErrorException {
		if(string.isEmpty()) {
			new CommandParser();
		}
	}
}
