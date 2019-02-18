package br.com.glassroom.dataprovider;

import static br.com.glassroom.dataprovider.mapper.UserDataProviderMapper.from;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.glassroom.Exception.TechnicalException;
import br.com.glassroom.dataprovider.repository.UserRepository;
import br.com.glassroom.dataprovider.repository.entity.UserEntity;
import br.com.glassroom.gateway.UserSaveGateway;
import br.com.glassroom.usecase.entity.User;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UserSaveDataProvider implements UserSaveGateway {

	private UserRepository repository;

	@Autowired
	public UserSaveDataProvider(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public User saveUser(User user) {
		try {
			
			UserEntity entityReturn = repository.save(from(user));
			return from(entityReturn);
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new TechnicalException("Erro ao conectar ao banco de dados");
		}
	
	}

}
