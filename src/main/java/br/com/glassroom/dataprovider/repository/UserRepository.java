package br.com.glassroom.dataprovider.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.glassroom.dataprovider.repository.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
