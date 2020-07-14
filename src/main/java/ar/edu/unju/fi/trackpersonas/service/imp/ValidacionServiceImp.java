package ar.edu.unju.fi.trackpersonas.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.trackpersonas.model.ValidadorCondicionSanitaria;
import ar.edu.unju.fi.trackpersonas.repository.ValidacionRepository;
import ar.edu.unju.fi.trackpersonas.service.IValidacionService;

@Service
public class ValidacionServiceImp implements IValidacionService {

	/**
	 * Objeto del repository que permite usar métodos de CrudRepository
	 */
	@Autowired
	private ValidacionRepository validacionRepository;

	/**
	 * Obtiene todos los objetos de tipo ValidadorCondicionSanitaria
	 */
	@Override
	public List<ValidadorCondicionSanitaria> listarValidaciones() {
		return (List<ValidadorCondicionSanitaria>) validacionRepository.findAll();
	}

	/**
	 * Permite guardar un objeto de tipo ValidadorCondicionSanitaria
	 */
	@Override
	public void guardarValidacion(ValidadorCondicionSanitaria validacion) {
		validacionRepository.save(validacion);
	}

	/**
	 * Buscar por id un objeto de tipo ValidadorCondicionSanitaria
	 */
	@Override
	public ValidadorCondicionSanitaria buscarPorId(Long id) {
		return validacionRepository.findById(id).orElse(null);
	}

	/**
	 * Permite eliminar un objeto de tipo ValidadorCondicionSanitaria
	 */
	@Override
	public void eliminar(Long id) {
		validacionRepository.deleteById(id);
	}

}
