package com.vodafone.garage.app;


import com.vodafone.garage.config.BaseConfig;
import com.vodafone.garage.exception.ServerErrorException;
import com.vodafone.garage.model.GarageResponse;

import java.util.ArrayList;

public class CreatePark extends BaseConfig {

	@Override
	public void setPark(String[] commandArray) throws ServerErrorException {
		try {
			Integer placeCount = 10;
			ArrayList<Integer> placesInGarrage = new ArrayList<>();
			for (int i = 1; i <= placeCount; i++) {
				placesInGarrage.add(i);
			}
			left = placesInGarrage;
			total_size = placeCount;
			String outputMessage = "Created a parking "+placeCount+" places";
			System.out.println(outputMessage);
		}
		catch (Exception e) {
			throw new ServerErrorException(e.getMessage(), e);
		}
	}
}