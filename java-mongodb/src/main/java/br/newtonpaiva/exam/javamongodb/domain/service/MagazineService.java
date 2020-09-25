package br.newtonpaiva.exam.javamongodb.domain.service;

import java.util.List;

import br.newtonpaiva.exam.javamongodb.domain.entity.Magazine;

public interface MagazineService {
	
	Magazine getById(String id);
	
	List<Magazine> getMagazines();
	
	Magazine create(Magazine magazine);
	
	Magazine update(String id, Magazine magazine);
	
	void deleteById(String id);

}
