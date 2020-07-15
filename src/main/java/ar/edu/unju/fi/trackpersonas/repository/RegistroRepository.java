package ar.edu.unju.fi.trackpersonas.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.trackpersonas.model.Barrio;
import ar.edu.unju.fi.trackpersonas.model.RegistroTracking;
@Repository
public interface RegistroRepository extends JpaRepository<RegistroTracking,Long>{
	
	
	public List<RegistroTracking> findByLocalidad(Barrio localidad);
	
	//public List<RegistroTracking> findByFechaHora(LocalDateTime fechaHora);
	//public List<RegistroTracking> findByFechaHora(LocalDateTime fechaHora);
	//public List<RegistroTracking> findByFechaHoraAndLocalidad(LocalDateTime fechaHora,Barrio localidad);
	public List<RegistroTracking> findByFechaHoraBetween(LocalDateTime fechaHora1,LocalDateTime fechaHora2);
	public List<RegistroTracking> findByFechaHoraBetweenAndLocalidad(LocalDateTime fechaHora1,LocalDateTime fechaHora2,Barrio localidad);
	//public List<Barrio> findByFechaHoraBetweenAndLocalidad(LocalDateTime fechaHora1,LocalDateTime fechaHora2,Barrio localidad);	
}
