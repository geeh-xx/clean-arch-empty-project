package br.com.glassroom.configuration;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.glassroom.GlassroomApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GlassroomApplication.class)
public abstract class ConfigurationEndPointIntegrationTest {
}
