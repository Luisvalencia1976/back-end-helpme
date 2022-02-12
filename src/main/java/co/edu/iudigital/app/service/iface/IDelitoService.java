package co.edu.iudigital.app.service.iface;

import java.util.List;

import co.edu.iudigital.app.dto.DelitoDto;
import co.edu.iudigital.app.exception.RestException;
import co.edu.iudigital.app.models.Delito;


public interface IDelitoService {

	public List<DelitoDto> findAll();
	
	public Delito findById(Long id);
	
	public Delito save(Delito delito);
	//***SERVICIO DE BORRADO DE DATOS***//
	public void delete(Long id) throws RestException;
	
	
	
}