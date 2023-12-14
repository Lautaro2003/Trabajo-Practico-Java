package com.informatorio;

public class CuentaDeAhorro extends Cuenta {
    private double tasaDeInteres;

    public CuentaDeAhorro(Cliente titular, double saldoInicial, double tasaDeInteres) {
        super(titular, saldoInicial);
        this.tasaDeInteres = tasaDeInteres;
    }

    public double getTasaInteres() {
        return tasaDeInteres;
    }

    public void calcularYAgregarIntereses() {
        double intereses = getSaldo() * tasaDeInteres / 100;
        depositar(intereses);
        System.out.println("Intereses calculados y agregados al saldo. Saldo actual: $" + getSaldo());
    }

    @Override
    public void retirar(double monto) {
        super.retirar(monto);
    }
}
