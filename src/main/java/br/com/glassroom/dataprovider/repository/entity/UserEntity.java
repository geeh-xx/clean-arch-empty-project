package br.com.glassroom.dataprovider.repository.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

}
