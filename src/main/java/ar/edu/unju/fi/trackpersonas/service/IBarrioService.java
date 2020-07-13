package ar.edu.unju.fi.trackpersonas.service;

import java.util.List;

import ar.edu.unju.fi.trackpersonas.model.Barrio;
/**
 * 
 * @author kry_m
 *
 */
public interface IBarrioService {
	public void guardarBarrio(Barrio barrio);
	public Barrio obtenerBarrioNombre(String nombre);
	
	public List<Barrio> obtenerBarrios();
}
