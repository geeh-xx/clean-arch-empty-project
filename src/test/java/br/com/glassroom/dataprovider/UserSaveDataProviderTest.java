package br.com.glassroom.dataprovider;

import static br.com.glassroom.dataprovider.mapper.UserDataProviderMapper.from;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.glassroom.Exception.TechnicalException;
import br.com.glassroom.dataprovider.repository.UserRepository;
import br.com.glassroom.dataprovider.repository.entity.UserEntity;
import br.com.glassroom.factory.UserFactory;
import br.com.glassroom.usecase.entity.User;

@RunWith(MockitoJUnitRunner.class)
public class UserSaveDataProviderTest {

	@Mock
	private UserRepository repository;

	@Captor
	private ArgumentCaptor<UserEntity> userCaptor;

	private UserSaveDataProvider dataProvider;

	@Before
	public void setup() {
		dataProvider = new UserSaveDataProvider(repository);
	}

	@Test
	public void testingSaveUser() {
		// given
		User core = UserFactory.validUser();
		UserEntity entity = from(core);

		when(repository.save(Mockito.any(UserEntity.class))).thenReturn(entity);

		// when
		User objReturn = dataProvider.saveUser(core);

		// then
		verify(repository, Mockito.times(1)).save(userCaptor.capture());
		assertEquals(userCaptor.getValue().getId(), core.getId());
		assertEquals(objReturn.getId(), core.getId());

	}

	@Test(expected = TechnicalException.class)
	public void comunicateDatabaseException() {
		// given
		User core = UserFactory.validUser();

		when(repository.save(Mockito.any(UserEntity.class)))
				.thenThrow(new TechnicalException("Erro ao conectar no banco de dados"));

		// when
		dataProvider.saveUser(core);

	}

}
