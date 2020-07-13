package ar.edu.unju.fi.trackpersonas.service;

import java.util.List;

import ar.edu.unju.fi.trackpersonas.model.ValidadorCondicionSanitaria;

public interface IValidacionService {
	
	public List<ValidadorCondicionSanitaria> listarValidaciones();
	
	public void guardarValidacion(ValidadorCondicionSanitaria validacion);
	
	public ValidadorCondicionSanitaria buscarPorId(Long id);
	
	public void eliminar(Long id);
	
}
