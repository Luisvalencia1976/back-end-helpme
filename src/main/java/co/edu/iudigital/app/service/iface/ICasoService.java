package co.edu.iudigital.app.service.iface;
import java.util.List;

import co.edu.iudigital.app.dto.CasoDto;
import co.edu.iudigital.app.exception.RestException;
import co.edu.iudigital.app.models.Caso;

public interface ICasoService {
    //***SERVICIO DONDE SE LISTAN LOS CASOS***//
	public List<CasoDto> findAll() throws RestException;
	//***SERVICIO DONDE  SE GUARDAN LOS CASOS***//
	public Caso save(Caso caso) throws RestException;
	//***SERVICIO DONDE  SE VALIDAN LOS CASOS***//
	public Boolean visible(Boolean visible, Long id) throws RestException;
	//***SERVICIO DONDE  SE IMPLEMENTA LA BUSQUEDA POR ID***//
	public Caso findById(Long id) throws RestException;
}