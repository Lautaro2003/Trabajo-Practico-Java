package com.informatorio;

public class CuentaCorriente extends Cuenta {
    private double limiteSobregiro;

    public CuentaCorriente(Cliente titular, double saldoInicial, double limiteSobregiro) {
        super(titular, saldoInicial);
        this.limiteSobregiro = limiteSobregiro;
    }

    public double getLimiteSobregiro() {
        return limiteSobregiro;
    }

    @Override
    public void retirar(double monto) {
        if (monto > 0) {
            if (monto <= getSaldo() + limiteSobregiro) {
                super.retirar(monto);
                System.out.println("Retiro de $" + monto + " realizado. Saldo actual: $" + getSaldo());
            } else {
                System.out.println("Error: Retiro excede el límite de sobregiro permitido.");
            }
        } else {
            System.out.println("Error: El monto del retiro debe ser mayor que cero.");
        }
    }
}
