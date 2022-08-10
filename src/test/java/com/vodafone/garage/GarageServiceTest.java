package com.vodafone.garage;

import com.vodafone.garage.config.BaseConfig;
import com.vodafone.garage.config.BaseConfigFactory;
import com.vodafone.garage.exception.NotFoundException;
import com.vodafone.garage.model.GarageRequest;
import com.vodafone.garage.service.GarageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class GarageServiceTest {

    @Autowired
    private GarageService garageService;

    public List<String> initOneRequest() {
        List<String> list = new ArrayList<>();
        list.add("park 34-SO-1988 Black Car");
        list.add("park 34-BO-1987 Red Truck");
        list.add("park 34-VO-2018 Blue Jeep");
        list.add("park 34-HBO-2020 Black Truck");
        return list;
    }

    public List<String> initTwoRequest() {
        List<String> list = new ArrayList<>();
        list.add("park 34-SO-1988 Black Car");
        list.add("");
        list.add("deneme");
        list.add("park 34-HBO-2020 Black Truck");
        return list;
    }



    @Test
    public void getGarageStateTest(){
        assertThat(garageService).isNotNull();

        GarageRequest request = new GarageRequest();
        request.setInput(initOneRequest());
        assertThat(garageService.getGarageState(request)).isNotNull();
    }

    @Test()
    public void getGarageStateTestNull() throws NotFoundException{
        GarageRequest request = new GarageRequest();
        request.setInput(initTwoRequest());
        assertThat(garageService.getGarageState(request)).isNotNull();
    }
}
