package com.informatorio;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int numeroUnico;
    private String nombre;
    private String direccion;
    private List<Cuenta> cuentas;

    public Cliente(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.cuentas = new ArrayList<>();
    }

    public int getNumeroUnico() {
        return numeroUnico;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void agregarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
        System.out.println("Cuenta " + cuenta.getNumero() + " agregada al cliente " + nombre);
    }

    public double consultarSaldoTotal() {
        double saldoTotal = 0;
        for (Cuenta cuenta : cuentas) {
            saldoTotal += cuenta.consultarSaldo();
        }
        return saldoTotal;
    }
}

