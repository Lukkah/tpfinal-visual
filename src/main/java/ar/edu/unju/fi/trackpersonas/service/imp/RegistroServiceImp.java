package ar.edu.unju.fi.trackpersonas.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.trackpersonas.model.RegistroTracking;
import ar.edu.unju.fi.trackpersonas.repository.RegistroRepository;
import ar.edu.unju.fi.trackpersonas.service.IRegistroService;

@Service
public class RegistroServiceImp implements IRegistroService {

	@Autowired
	private RegistroRepository registroRepository;
	
	@Override
	public void guardarRegistro(RegistroTracking registro) {
		registroRepository.save(registro);

	}

}
