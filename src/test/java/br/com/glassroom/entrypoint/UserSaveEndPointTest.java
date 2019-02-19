package br.com.glassroom.entrypoint;

import static br.com.glassroom.entrypoint.mapper.UserEntryPointMapper.from;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.glassroom.entrypoint.model.UserModel;
import br.com.glassroom.factory.UserFactory;
import br.com.glassroom.usecase.UserSaveUseCase;
import br.com.glassroom.usecase.entity.User;

@RunWith(MockitoJUnitRunner.class)
public class UserSaveEndPointTest {

	@Mock
	private UserSaveUseCase useCase;

	@Captor
	ArgumentCaptor<User> userCaptor;

	UserSaveEndPoint endPoint;

	@Before
	public void setup() {
		endPoint = new UserSaveEndPoint(useCase);
	}

	@Test
	public void verifyCallUseCase() {
		// given
		UserModel user = UserFactory.validModel();
		when(useCase.saveUser(Mockito.any(User.class))).thenReturn(from(user));

		// when
		ResponseEntity<Void> objReturn = endPoint.saveEndPoint(user);

		// then
		verify(useCase, times(1)).saveUser(userCaptor.capture());
		assertThat(objReturn.getStatusCode(), is(HttpStatus.CREATED));
		assertEquals(user.getId(), userCaptor.getValue().getId());

	}

}
