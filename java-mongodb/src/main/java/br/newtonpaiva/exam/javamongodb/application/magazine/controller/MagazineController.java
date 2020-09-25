package br.newtonpaiva.exam.javamongodb.application.magazine.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import br.newtonpaiva.exam.javamongodb.api.magazine.request.MagazineRequest;
import br.newtonpaiva.exam.javamongodb.api.magazine.resource.MagazineResource;
import br.newtonpaiva.exam.javamongodb.api.magazine.response.MagazineResponse;
import br.newtonpaiva.exam.javamongodb.common.exception.NotFoundException;
import br.newtonpaiva.exam.javamongodb.domain.entity.Magazine;
import br.newtonpaiva.exam.javamongodb.domain.service.MagazineService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@Validated

public class MagazineController implements MagazineResource {
	
	@Autowired
	private MagazineService magazineService;
	

	public ResponseEntity<List<MagazineResponse>> getAll() {
		log.info("GET magazines");
		
		List<Magazine> lista = magazineService.getMagazines();
		List<MagazineResponse> response = new ArrayList<MagazineResponse>();
		lista.forEach(magazine -> {
			response.add(new MagazineResponse(magazine));
		});

		return ResponseEntity.ok(response);
	}

	public ResponseEntity<MagazineResponse> getById(Optional<String> id) {
		log.info("GET magazine by ID: {}", id);

		Magazine magazine = magazineService.getById(id.get());
		
		if (magazine == null) {
			throw new NotFoundException(id.get());
		}
		
		return ResponseEntity.ok(new MagazineResponse(magazine));
	}


	public ResponseEntity<MagazineResponse> create(Optional<MagazineRequest> request) {
		log.info("POST criar magazine: {}", request);
		
		log.info(request.get().toString());

		Magazine magazine = new Magazine()
				.withTitulo(request.get().getTitulo())
				.withId(UUID.randomUUID().toString())
				.withAutor(request.get().getAutor())
				.withEditora(request.get().getEditora())
				.withStatus(request.get().getStatus());
		
		magazine.setCreated(LocalDateTime.now());
		magazine.setModified(LocalDateTime.now());
		
		// salvar em memória
		magazine = magazineService.create(magazine);
		
		// devolver a resposta do magazine criado
		return ResponseEntity.status(HttpStatus.CREATED).body(new MagazineResponse(magazine));
	}

	
	public ResponseEntity<MagazineResponse> update(
			Optional<String> id, 
			Optional<MagazineRequest> request
			) {
		log.info("PUT atualizar magazine: {} {}", id, request);

		Magazine magazine = new Magazine()
				.withTitulo(request.get().getTitulo())
				.withAutor(request.get().getAutor())
				.withEditora(request.get().getEditora());
		

		magazine = magazineService.update(id.get(), magazine);
		
		return ResponseEntity.status(HttpStatus.OK).body(new MagazineResponse(magazine));
	}

	
	public ResponseEntity<Void> deleteById(Optional<String> id) {
		log.info("DELETE remover magazine: {}", id);

		magazineService.deleteById(id.get());
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
