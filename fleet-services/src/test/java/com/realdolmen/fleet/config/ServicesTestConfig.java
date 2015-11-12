package com.realdolmen.fleet.config;

import com.realdolmen.fleet.*;
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
    public CarOptionRepository carOptionRepositoryMock()
    {
        return Mockito.mock(CarOptionRepository.class);
    }

    @Bean
    public PhysicalCarRepository physicalCarRepositoryMock()
    {
        return Mockito.mock(PhysicalCarRepository.class);
    }

    @Bean
    public CarModelRepository carModelRepositoryMock()
    {
        return Mockito.mock(CarModelRepository.class);
    }

    @Bean
    public CarService carServiceMock()
    {
        return Mockito.mock(CarService.class);
    }

    @Bean
    public CarOptionService carOptionServiceMock()
    {
        return Mockito.mock(CarOptionService.class);
    }
}
