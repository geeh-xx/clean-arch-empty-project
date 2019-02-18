package br.com.glassroom.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.glassroom.gateway.UserSaveGateway;
import br.com.glassroom.usecase.entity.User;

@Component
public class UserSaveUseCase {

	private UserSaveGateway saveGateway;
	
	@Autowired
	public UserSaveUseCase(UserSaveGateway saveGateway) {
		this.saveGateway = saveGateway;
	}
	
	public User saveUser(User user) {
		return saveGateway.saveUser(user);
	}
	
}
