package com.realdolmen.fleet.config;

import com.realdolmen.fleet.CarOrderRepository;
import com.realdolmen.fleet.CarService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class ServicesTestConfig {

    @Bean
    public CarOrderRepository carOrderRepositoryMock()
    {
        return Mockito.mock(CarOrderRepository.class);
    }

    @Bean
    public CarService carServiceMock()
    {
        return Mockito.mock(CarService.class);
    }
}
