package com.informatorio;

public class Cuenta {
    private static int contadorNumeros = 1;  
    private int numero;
    private Cliente titular;
    private double saldo;

    public Cuenta(Cliente titular, double saldoInicial) {
        this.numero = generarNumeroUnico();
        this.titular = titular;
        this.saldo = 0.0;
        this.saldo = saldoInicial;  
    }

    private static int generarNumeroUnico() {
        return contadorNumeros++;
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Depósito de $" + monto + " realizado. Saldo actual: $" + saldo);
        } else {
            System.out.println("Error: El monto del depósito debe ser mayor que cero.");
        }
    }

    public void retirar(double monto) {
        if (monto > 0) {
            if (monto <= saldo) {
                saldo -= monto;
                System.out.println("Retiro de $" + monto + " realizado. Saldo actual: $" + saldo);
            } else {
                System.out.println("Error: Fondos insuficientes para realizar el retiro.");
            }
        } else {
            System.out.println("Error: El monto del retiro debe ser mayor que cero.");
        }
    }

    public double consultarSaldo() {
        return saldo;
    }
}