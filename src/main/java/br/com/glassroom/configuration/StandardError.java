package br.com.glassroom.configuration;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StandardError implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long timesTemp;
	private Integer status;
	private String error;
	private String path;

}
