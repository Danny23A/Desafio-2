package com.Facturacion.dominio;

import java.time.LocalDate;

public class FacturaConIva extends Factura{

    private short valorIva;

    public FacturaConIva(long valor, String cliente, LocalDate fechaVencimiento, short valorIva) {
        super(valor, cliente, fechaVencimiento);
        this.valorIva = valorIva;
    }

    @Override
    public long calcularTotal() {
        return super.getValor()+calcularIva();
    }
    public long calcularIva(){
        return (valorIva/100)*super.getValor();
    }
}
