package com.vodafone.garage.service;

import com.vodafone.garage.config.BaseConfig;
import com.vodafone.garage.config.BaseConfigFactory;
import com.vodafone.garage.config.CommandParserFactory;
import com.vodafone.garage.exception.NotFoundException;
import com.vodafone.garage.exception.ServerErrorException;
import com.vodafone.garage.model.GarageRequest;
import com.vodafone.garage.model.GarageResponse;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class GarageService {
    public GarageResponse getGarageState(GarageRequest request){
        GarageResponse response = new GarageResponse();
        try {
            response = runGarage(request);
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (ServerErrorException e) {
            e.printStackTrace();
        }
        return response;
    }

    public GarageResponse runGarage(GarageRequest request) throws NotFoundException, ServerErrorException {
        GarageResponse response = new GarageResponse();
        if(BaseConfig.total_size == 0)
            BaseConfigFactory.getParkingConfig("create_park 10").setPark(new String[]{"create_park", "10"});
        System.out.println("Input: ");
        int i = 0;
        do {
            String command = request.getInput().get(i);
            final BaseConfig deployer = BaseConfigFactory.getParkingConfig(command);
            String[] commandArray = command.split("\\s+");
            deployer.setPark(commandArray);
            i++;
        } while (i < request.getInput().size());

        response.setOutput(BaseConfig.lastStateList);
        response.setMessage("State is success");
        return response;
    }
}
