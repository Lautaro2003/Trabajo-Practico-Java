package com.informatorio;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

public class Banco {
    private List<Cliente> clientes;
    private ServicioCuenta servicioCuenta;

    public Banco(ServicioCuenta servicioCuenta) {
        this.clientes = new ArrayList<>();
        this.servicioCuenta = servicioCuenta;  // Corregido usando "this"
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente " + cliente.getNombre() + " agregado al banco.");
    }

    public Cuenta abrirCuenta(Cliente cliente, TipoCuenta tipoCuenta) {
        Cuenta nuevaCuenta = null;
        double tasaDeInteres = 0.0;
        double limiteSobregiro = 1000.0;
    
        switch (tipoCuenta) {
            case AHORRO:
                nuevaCuenta = new CuentaDeAhorro(cliente, 0.0, tasaDeInteres);
                break;
            case CORRIENTE:
                nuevaCuenta = new CuentaCorriente(cliente, 1000.0, limiteSobregiro);
                break;
        }
    
        if (nuevaCuenta != null) {
            cliente.agregarCuenta(nuevaCuenta);
        }
    
        return nuevaCuenta;
    }
    public void mostrarClientes() {
        ServicioCliente.mostrarClientes(clientes);
    }
    
    public void mostrarCuentas(Cliente cliente) {
        System.out.println("Cuentas de " + cliente.getNombre() + ":");
        for (Cuenta cuenta : cliente.getCuentas()) {
            System.out.println(cuenta);
        }
    }

    public void realizarDeposito(Cuenta cuenta, double monto) {
        servicioCuenta.realizarDeposito(cuenta, monto);
    }

    public void realizarRetiro(Cuenta cuenta, double monto) {
        servicioCuenta.realizarRetiro(cuenta, monto);
    }


    public void realizarDivision(int numerador, int denominador) {
        try {
            int resultado = numerador / denominador;
            System.out.println("Resultado de la división: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Error: División por cero no permitida.");
        }
    }

    public void exportarCSV() {
    try {
        List<String[]> filas = new ArrayList<>();
        for (Cliente cliente : clientes) {
            for (Cuenta cuenta : cliente.getCuentas()) {
                String[] fila = {
                    String.valueOf(cuenta.getTitular().getNumeroUnico()),
                    cuenta.getTitular().getNombre(),
                    String.valueOf(cuenta.getSaldo()),
                    cuenta instanceof CuentaDeAhorro ? "Ahorro" : "Corriente"
                };
                filas.add(fila);
            }
        }

        CSVWriter writer = new CSVWriter(new FileWriter("cuentas.csv"));
        writer.writeAll(filas);
        writer.close();

        System.out.println("Cuentas exportadas correctamente a cuentas.csv");
        } catch (IOException e) {
        System.out.println("Error al exportar cuentas a CSV: " + e.getMessage());
        }
    }
}
