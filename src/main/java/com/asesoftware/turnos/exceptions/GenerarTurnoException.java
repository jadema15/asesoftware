package com.asesoftware.turnos.exceptions;

public class GenerarTurnoException extends RuntimeException {
    public GenerarTurnoException(String mensaje) {
        super(mensaje);
    }
    public GenerarTurnoException(String mensaje, Throwable error) {
        super(mensaje, error);
    }
}
