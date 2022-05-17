package com.Facturacion.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Facturacion {
    public static final long VALOR_PARA_IVA = 100000;
    private List<Factura> facturas;

    public Facturacion() {
        this.facturas = new ArrayList<>();
    }

    public void generarFacturas(String cliente, long valor, short valorIva, LocalDate fecha){

        Factura factura;
        if(fecha.isBefore(LocalDate.now())){
            factura = new FacturaVencida(valor, cliente, fecha);
        }else{
            if(valor >= VALOR_PARA_IVA){
                factura = new FacturaConIva(valor, cliente, fecha, valorIva);
            }else {
                factura = new FacturaSinIva(valor, cliente, fecha);
            }
        }
        facturas.add(factura);
    }

    public long getTotalFacturacion(){
        return this.facturas.stream().mapToLong(Factura::calcularTotal).sum();
    }

    public Factura getFacturaMasCara(){
        return this.facturas.stream().max(Comparator.comparing(factura -> factura.calcularTotal())).orElse(null);
    }
    public List<FacturaSinIva> getFacturasSinIva(){
        return this.facturas.stream().filter(factura -> factura instanceof FacturaSinIva).map(fact -> (FacturaSinIva) fact).collect(Collectors.toList());
    }
}
