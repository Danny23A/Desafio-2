package com.Facturacion.dominio;

import java.time.LocalDate;

public abstract class Factura{

    private long valor;
    private String cliente;
    private LocalDate fechaVencimiento;

    public Factura(long valor, String cliente, LocalDate fechaVencimiento){
        this.valor = valor;
        this.cliente = cliente;
        this.fechaVencimiento = fechaVencimiento;
    }

    public abstract long calcularTotal();

    public long getValor() {
        return valor;
    }

    public String getCliente() {
        return cliente;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }
}
