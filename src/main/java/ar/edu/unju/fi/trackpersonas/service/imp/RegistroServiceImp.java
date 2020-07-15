package ar.edu.unju.fi.trackpersonas.service.imp;

import java.time.LocalDateTime;
import java.util.ArrayList;
//import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.trackpersonas.model.Barrio;
import ar.edu.unju.fi.trackpersonas.model.Persona;
import ar.edu.unju.fi.trackpersonas.model.RegistroTracking;
import ar.edu.unju.fi.trackpersonas.model.ValidadorCondicionSanitaria;
import ar.edu.unju.fi.trackpersonas.repository.BarrioRepository;
import ar.edu.unju.fi.trackpersonas.repository.RegistroRepository;
import ar.edu.unju.fi.trackpersonas.service.IRegistroService;

@Service
public class RegistroServiceImp implements IRegistroService {

	/**
	 * Objeto del repository que permite usar métodos de CrudRepository
	 */
	@Autowired
	private RegistroRepository registroRepository;
	
	/**
	 * Permite guardar un objeto de tipo RegistroTracking
	 */
	@Override
	public void guardarRegistro(RegistroTracking registro) {
		registroRepository.save(registro);

	}
	
	@Override
	public List<RegistroTracking> obtenerRegistrosLocalidad(Barrio localidad) {
		// TODO Auto-generated method stub
		List<RegistroTracking> registros= registroRepository.findByLocalidad(localidad);
		return registros;
	}

	@Override
	public List<RegistroTracking> obtenerRegistroEntreFechas(LocalDateTime desde, LocalDateTime hasta) {
		List<RegistroTracking> registros= registroRepository.findByFechaHoraBetween(desde, hasta);
		return registros;
	}

	@Override
	public List<RegistroTracking> obtenerRegistroEntreFechasLocalidad(LocalDateTime desde, LocalDateTime hasta,
			Barrio localidad) {
		List<RegistroTracking> registros= registroRepository.findByFechaHoraBetweenAndLocalidad(desde, hasta, localidad);
		return registros;
	}
	
	@Autowired
	private BarrioRepository barrioRepository;
	



	@Override
	public List<RegistroTracking>  buscarPersonas(Persona persona) {
		RegistroTracking reg = new RegistroTracking();
		List<RegistroTracking> registros = new ArrayList<RegistroTracking>();
		List<ValidadorCondicionSanitaria> validaciones = new ArrayList<ValidadorCondicionSanitaria>();
		for(RegistroTracking r: (List<RegistroTracking>) registroRepository.findAll()) {
			validaciones = new ArrayList<ValidadorCondicionSanitaria>();
			for(ValidadorCondicionSanitaria v: r.getValidaciones()) {
				if(v.getPersona().getDocumento().equals(persona.getDocumento())) {
					validaciones.add(v);
					reg.setValidaciones(validaciones);
				}
			}

			System.out.println("cantidad de validaciones"+reg.getValidaciones().size());
			if(reg.getValidaciones().size()==1) {
				reg.setDetalleLugarRegistro(r.getDetalleLugarRegistro());
				reg.setFechaHora(r.getFechaHora());
				reg.setLocalidad(barrioRepository.findById(r.getLocalidad().getId()).get());
				registros.add(reg);
				reg = new RegistroTracking();
			}
		}
		return registros;
	}
}
