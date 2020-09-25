package br.newtonpaiva.exam.javamongodb.api.magazine.response;

import java.time.LocalDateTime;

import br.newtonpaiva.exam.javamongodb.common.enums.Status;
import br.newtonpaiva.exam.javamongodb.domain.entity.Magazine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.With;

@AllArgsConstructor
@Data
@With

public class MagazineResponse {
	
	private String id;
	
	private String titulo;
	
	private String autor;
	
	private String editora;
	
	private LocalDateTime dataDePublicacao;
	
	private Status status;
	
	private LocalDateTime created;
	
	private LocalDateTime modified;
	
	public MagazineResponse(Magazine magazine) {
		this.id = magazine.getId();
		this.titulo = magazine.getTitulo();
		this.autor = magazine.getAutor();
		this.editora = magazine.getEditora();
		this.status = magazine.getStatus();
		this.created = magazine.getCreated();
		this.modified = magazine.getModified();
	}
}



