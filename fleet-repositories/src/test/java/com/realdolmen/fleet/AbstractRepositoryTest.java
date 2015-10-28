package com.realdolmen.fleet;

import com.realdolmen.fleet.config.RepositoryTestConfig;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RepositoryTestConfig.class)
@ActiveProfiles("test")
@Transactional
public abstract class AbstractRepositoryTest {
}
