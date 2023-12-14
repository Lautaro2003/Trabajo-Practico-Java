package com.informatorio;

public interface ServicioCuenta {
    Cuenta abrirCuenta(Cliente cliente, TipoCuenta tipoCuenta);
    void realizarDeposito(Cuenta cuenta, double monto);
    void realizarRetiro(Cuenta cuenta, double monto);
    // Otras operaciones relacionadas con cuentas
}
