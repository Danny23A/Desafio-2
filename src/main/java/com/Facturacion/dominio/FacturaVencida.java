package com.Facturacion.dominio;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class FacturaVencida extends Factura{

    public static final int VALOR_DIA_VENCIDO = 10000;

    public FacturaVencida(long valor, String cliente, LocalDate fechaVencimiento) {
        super(valor, cliente, fechaVencimiento);
    }

    @Override
    public long calcularTotal() {
        return getValor()+getDiasVencidos()*VALOR_DIA_VENCIDO;
    }

    public int getDiasVencidos(){
        return (int) ChronoUnit.DAYS.between(getFechaVencimiento(), LocalDate.now());
    }
}
