package ar.edu.unju.fi.trackpersonas.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.trackpersonas.model.Barrio;
import ar.edu.unju.fi.trackpersonas.repository.BarrioRepository;
import ar.edu.unju.fi.trackpersonas.service.IBarrioService;
/**
 * 
 * @author kry_m
 *
 */
@Service
public class BarrioServiceImp implements IBarrioService{
	
	/**
	 * Objeto del repository que permite usar métodos de CrudRepository
	 */
	@Autowired
	private BarrioRepository barrioserviceImp;

	/**
	 * Permite guardar un barrio
	 */
	@Override
	public void guardarBarrio(Barrio unBarrio) {
		barrioserviceImp.save(unBarrio);
		
	}
	
	/**
	 * Obtiene un barrio, buscando por el nombre
	 */
	@Override
	public Barrio obtenerBarrioNombre(String nombre) {
		// TODO Auto-generated method stub
		return barrioserviceImp.findByNombre(nombre);
	}
	
	/**
	 * Obtiene una lista de todos los barrios
	 */
	@Override
	public List<Barrio> obtenerBarrios() {
		return (List<Barrio>) barrioserviceImp.findAll();
	}

	

}
