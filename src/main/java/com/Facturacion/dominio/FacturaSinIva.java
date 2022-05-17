package com.Facturacion.dominio;

import java.time.LocalDate;

public class FacturaSinIva extends Factura {


    public FacturaSinIva(long valor, String cliente, LocalDate fechaVencimiento) {
        super(valor, cliente, fechaVencimiento);
    }

    @Override
    public long calcularTotal() {
        return super.getValor();
    }
}
