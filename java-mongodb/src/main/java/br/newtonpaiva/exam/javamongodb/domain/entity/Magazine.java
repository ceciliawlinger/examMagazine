package br.newtonpaiva.exam.javamongodb.domain.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import br.newtonpaiva.exam.javamongodb.common.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@AllArgsConstructor
@Data
@With
@NoArgsConstructor

public class Magazine {

	@Id
	private String id;
	
	private String titulo;
	
	private String autor;
	
	private String editora;
	
	private LocalDateTime dataDePublicacao;
	
	private Status status;
	
	private LocalDateTime created;
	
	private LocalDateTime modified;
}
