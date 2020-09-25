package br.newtonpaiva.exam.javamongodb.domain.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.newtonpaiva.exam.javamongodb.domain.entity.Magazine;

@Repository

public interface MagazineRepository extends MongoRepository <Magazine, String>{

		public List<Magazine> findByTitulo(String titulo);
		
	}

