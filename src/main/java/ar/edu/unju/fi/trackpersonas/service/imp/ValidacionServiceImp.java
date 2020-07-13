package ar.edu.unju.fi.trackpersonas.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.trackpersonas.model.ValidadorCondicionSanitaria;
import ar.edu.unju.fi.trackpersonas.repository.ValidacionRepository;
import ar.edu.unju.fi.trackpersonas.service.IValidacionService;

@Service
public class ValidacionServiceImp implements IValidacionService {
	
	@Autowired
	private ValidacionRepository validacionRepository;

	@Override
	public List<ValidadorCondicionSanitaria> listarValidaciones() {
		return (List<ValidadorCondicionSanitaria>) validacionRepository.findAll();
	}

	@Override
	public void guardarValidacion(ValidadorCondicionSanitaria validacion) {
		validacionRepository.save(validacion);
	}

	@Override
	public ValidadorCondicionSanitaria buscarPorId(Long id) {
		return validacionRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Long id) {
		validacionRepository.deleteById(id);
	}

}
