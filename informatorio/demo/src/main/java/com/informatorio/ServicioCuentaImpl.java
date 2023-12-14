package com.informatorio;

public class ServicioCuentaImpl implements ServicioCuenta {

    @Override
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

    @Override
    public void realizarDeposito(Cuenta cuenta, double monto) {
        // Implementa la lógica para realizar un depósito en la cuenta.
        cuenta.depositar(monto);
        System.out.println("Depósito de $" + monto + " realizado en la cuenta " + cuenta.getNumero());
    }

    @Override
    public void realizarRetiro(Cuenta cuenta, double monto) {
        // Implementa la lógica para realizar un retiro en la cuenta.
        cuenta.retirar(monto);
        System.out.println("Retiro de $" + monto + " realizado en la cuenta " + cuenta.getNumero());
    }
}