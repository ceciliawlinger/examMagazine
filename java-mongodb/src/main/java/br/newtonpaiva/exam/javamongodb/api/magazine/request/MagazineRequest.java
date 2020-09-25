package br.newtonpaiva.exam.javamongodb.api.magazine.request;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.newtonpaiva.exam.javamongodb.common.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.With;

@AllArgsConstructor
@Data
@With

public class MagazineRequest {
	
	private String id;
	
	@NotBlank
	private String titulo;
	
	@NotBlank
	private String autor;

	@NotBlank
	private String editora;
	
	@NotNull
	private Status status;
	
	private LocalDateTime dataDePublicacao;

	public String getTitulo() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAutor() {
		// TODO Auto-generated method stub
		return null;
	}
}
