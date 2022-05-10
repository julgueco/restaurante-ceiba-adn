package com.ceiba.dominio.excepcion;

public class ExcepcionCantidadInvalida extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionCantidadInvalida(String message) {
        super(message);
    }
}
