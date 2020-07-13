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
	
	@Autowired
	private BarrioRepository barrioserviceImp;

	@Override
	public void guardarBarrio(Barrio unBarrio) {
		barrioserviceImp.save(unBarrio);
		
	}

	@Override
	public Barrio obtenerBarrioNombre(String nombre) {
		// TODO Auto-generated method stub
		return barrioserviceImp.findByNombre(nombre);
	}

	@Override
	public List<Barrio> obtenerBarrios() {
		return (List<Barrio>) barrioserviceImp.findAll();
	}

	

}
