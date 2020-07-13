package ar.edu.unju.fi.trackpersonas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.trackpersonas.model.Barrio;
import ar.edu.unju.fi.trackpersonas.repository.IBarrioDAO;
/**
 * 
 * @author kry_m
 *
 */
@Service
public class BarrioServiceImp implements IBarrioService{
	
	@Autowired
	private IBarrioDAO barrioDaoImp;

	@Override
	public void guardarBarrio(Barrio unBarrio) {
		barrioDaoImp.save(unBarrio);
		
	}

	@Override
	public Optional<Barrio> obtenerBarrioNombre(String nombre) {
		// TODO Auto-generated method stub
		return barrioDaoImp.findByNombre(nombre);
	}

	

}
