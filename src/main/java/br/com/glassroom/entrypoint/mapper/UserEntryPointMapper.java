package br.com.glassroom.entrypoint.mapper;

import br.com.glassroom.entrypoint.model.UserModel;
import br.com.glassroom.usecase.entity.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserEntryPointMapper {

	public static User from(UserModel model) {
		return User.builder().id(model.getId()).build();
	}
	
}
