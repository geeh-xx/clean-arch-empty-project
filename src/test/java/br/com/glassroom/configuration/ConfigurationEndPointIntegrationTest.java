package br.com.glassroom.configuration;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import de.codecentric.boot.admin.client.registration.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public abstract class ConfigurationEndPointIntegrationTest {
}
