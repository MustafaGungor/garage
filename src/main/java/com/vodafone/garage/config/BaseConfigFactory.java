package com.vodafone.garage.config;


import com.vodafone.garage.app.CreatePark;
import com.vodafone.garage.app.Leave;
import com.vodafone.garage.app.Park;
import com.vodafone.garage.app.Status;
import com.vodafone.garage.exception.NotFoundException;

public class BaseConfigFactory {
    public static BaseConfig getParkingConfig(String cmd) throws NotFoundException {

        if (cmd.contains("create_park"))
        {
            return new CreatePark();
        }
        else if (cmd.contains("park"))
        {
            return new Park();
        }
        else if (cmd.contains("leave"))
        {
            return new Leave();
        }
        else if (cmd.contains("status"))
        {
            return new Status();
        }
        else
        {
            throw new NotFoundException("cmd Not Found")	;
        }

    }
}
