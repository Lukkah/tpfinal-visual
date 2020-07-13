package ar.edu.unju.fi.trackpersonas.service;

import java.util.Optional;

import ar.edu.unju.fi.trackpersonas.model.Barrio;
/**
 * 
 * @author kry_m
 *
 */
public interface IBarrioService {
	public void guardarBarrio(Barrio barrio);
	public Optional<Barrio> obtenerBarrioNombre(String nombre);
}
