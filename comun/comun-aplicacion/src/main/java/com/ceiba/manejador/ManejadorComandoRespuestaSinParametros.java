package com.ceiba.manejador;

import org.springframework.transaction.annotation.Transactional;

public interface ManejadorComandoRespuestaSinParametros<C> {

	@Transactional
	C ejecutar();
}