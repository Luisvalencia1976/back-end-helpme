package co.edu.iudigital.app.service.impl;
//***LIBRERIAS***//
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.iudigital.app.dto.CasoDto;
import co.edu.iudigital.app.exception.BadRequestException;
import co.edu.iudigital.app.exception.ErrorDto;
import co.edu.iudigital.app.exception.RestException;
import co.edu.iudigital.app.models.Caso;
import co.edu.iudigital.app.repository.ICasoRepository;
import co.edu.iudigital.app.service.iface.ICasoService;
//***@Service PERMITE USAR UN SERVICIO AUTOMATICAMENTE***//
@Service
public class CasoServiceImpl implements ICasoService{
	
//***@Autowired SE USA PARA INYECTAR LAS DEPENDENCIAS***//
	@Autowired
	private ICasoRepository casoRepository;
	//***@Transactional INDICA SI SE PUEDEN HACER CRUD ESPECIFICAS***//
	//***@Override PERMITE SOBRECARGAR UN METODO DE INSTANCIA***//
	@Transactional(readOnly = true)
	@Override
	public List<CasoDto> findAll() throws RestException {
		List<Caso> casos = casoRepository.findAll();
		// TODO: REFACTORIZAR Y MAPEAR
		List<CasoDto> casosDto = new ArrayList<>();
		casos.stream().forEach(c -> {
			CasoDto casoDto = new CasoDto();
			casoDto.setId(c.getId());
			casoDto.setFechaHora(c.getFechaHora());
			casoDto.setLatitud(c.getLatitud());
			casoDto.setLongitud(c.getLongitud());
			casoDto.setVisible(c.getVisible());
			casoDto.setDescripcion(c.getDescripcion());
			casoDto.setUrlMap(c.getUrlMap());
			casoDto.setRmiMap(c.getRmiMap());
			casoDto.setUsuarioId(c.getUsuario().getId());
			casoDto.setImage(c.getUsuario().getImage());
			casoDto.setNombre(c.getUsuario().getNombre());
			casosDto.add(casoDto);
		});
		return casosDto;
	}

	@Transactional
	@Override
	public Caso save(Caso caso) throws RestException {
		if(Objects.isNull(caso)) {
			throw new BadRequestException(ErrorDto.getErrorDto(
					HttpStatus.BAD_REQUEST.getReasonPhrase(), 
					"Mala petición", //TODO: CREAR CONSTANTE EN CONSUTIL
					HttpStatus.BAD_REQUEST.value())
				);
		}
		return casoRepository.save(caso);
	}

	@Transactional
	@Override
	public Boolean visible(Boolean visible, Long id) throws RestException {
		return casoRepository.setVisible(visible, id);
	}

	@Transactional(readOnly = true)
	@Override
	public Caso findById(Long id) throws RestException {
		return casoRepository.findById(id).get();// TODO: VALIDAR CON ISPRESENT
	}

}