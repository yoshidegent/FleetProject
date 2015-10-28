package com.realdolmen.fleet;

import com.realdolmen.fleet.config.RepositoryConfig;
import com.realdolmen.fleet.config.ServicesTestConfig;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { ServicesTestConfig.class })
@ActiveProfiles("test")
public abstract class AbstractServiceTest {
}