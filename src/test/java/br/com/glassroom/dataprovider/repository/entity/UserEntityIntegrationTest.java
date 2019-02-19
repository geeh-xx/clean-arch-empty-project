
package br.com.glassroom.dataprovider.repository.entity;

import static br.com.glassroom.factory.UserFactory.validEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.glassroom.dataprovider.repository.UserRepository;

public class UserEntityIntegrationTest extends ConfigurationEntityIntegrationTest {

	@Autowired
	private UserRepository repository;

	@Test
	public void testAllFildMapping() {
		// given
		UserEntity userSave = validEntity();

		// when
		repository.save(userSave);
		Optional<UserEntity> objReturn = repository.findById(userSave.getId());

		// then
		assertEquals(objReturn.get().getId(), userSave.getId());
	}
}
