package ar.edu.unju.fi.trackpersonas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.trackpersonas.model.ValidadorCondicionSanitaria;

@Repository
public interface ValidacionRepository extends CrudRepository<ValidadorCondicionSanitaria, Long>{

}
