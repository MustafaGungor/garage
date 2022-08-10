package com.vodafone.garage;

import com.vodafone.garage.controller.GarageController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class GarageControllerTest {

    @Autowired
    private GarageController controller;

    @Test
    public void setGarageControl(){
        assertThat(controller).isNotNull();
    }
}
