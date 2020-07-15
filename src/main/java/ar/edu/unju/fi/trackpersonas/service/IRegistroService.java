package ar.edu.unju.fi.trackpersonas.service;

import java.time.LocalDateTime;
import java.util.List;

import ar.edu.unju.fi.trackpersonas.model.Barrio;
import ar.edu.unju.fi.trackpersonas.model.Persona;
import ar.edu.unju.fi.trackpersonas.model.RegistroTracking;

public interface IRegistroService {
	
	public void guardarRegistro(RegistroTracking registro);

	public List<RegistroTracking>obtenerRegistroEntreFechas(LocalDateTime desde, LocalDateTime hasta);

	public List<RegistroTracking>obtenerRegistrosLocalidad(Barrio localidad);

	public List<RegistroTracking>obtenerRegistroEntreFechasLocalidad(LocalDateTime desde, LocalDateTime hasta, Barrio localidad);
	
	public List<RegistroTracking> buscarPersonas(Persona persona);
	
}
