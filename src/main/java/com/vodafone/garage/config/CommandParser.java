package com.vodafone.garage.config;


import com.vodafone.garage.exception.NotFoundException;
import com.vodafone.garage.exception.ServerErrorException;

import java.util.Scanner;

public class CommandParser {
	public CommandParser() throws NotFoundException, ServerErrorException {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		BaseConfigFactory.getParkingConfig("create_park 10").setPark(new String[]{"create_park","10"});
		System.out.println("Input: ");
		do{
			String command = scanner.nextLine();
			final BaseConfig deployer = BaseConfigFactory.getParkingConfig(command);
			String[] commandArray = command.split("\\s+");
			deployer.setPark(commandArray);
		}while(true);
	}
}

