package com.informatorio;

public class Main {

    public static void main(String[] args) {
        ServicioCuenta servicioCuenta = new ServicioCuentaImpl(); // O cualquier otra implementación que tengas

        Banco informatorioBank = new Banco(servicioCuenta);

        Cliente cliente1 = new Cliente("Juan Pérez", "Calle 123");
        Cliente cliente2 = new Cliente("Ana Gómez", "Avenida 456");

        informatorioBank.agregarCliente(cliente1);
        informatorioBank.agregarCliente(cliente2);

        Cuenta cuentaAhorroJuan = informatorioBank.abrirCuenta(cliente1, TipoCuenta.AHORRO);
        Cuenta cuentaCorrienteAna = informatorioBank.abrirCuenta(cliente2, TipoCuenta.CORRIENTE);

        informatorioBank.realizarDeposito(cuentaAhorroJuan, 500.0);
        informatorioBank.realizarDeposito(cuentaCorrienteAna, 1000.0);

        informatorioBank.realizarRetiro(cuentaAhorroJuan, 200.0);
        informatorioBank.realizarRetiro(cuentaCorrienteAna, 800.0);

        informatorioBank.mostrarClientes();
        informatorioBank.mostrarCuentas(cliente1);
        informatorioBank.mostrarCuentas(cliente2);

        informatorioBank.exportarCSV();
    }
}
/*Acá le dejo la descripción de lo investigado profe: 
 * Cuentas de Ahorro:
Las cuentas de ahorro son instrumentos financieros diseñados para que los titulares depositen y acumulen fondos a largo plazo. Estas cuentas ofrecen un interés sobre el saldo, lo que significa que el dinero depositado generará ganancias adicionales en forma de intereses. Por lo general, las tasas de interés en cuentas de ahorro son más altas que las cuentas corrientes. Los titulares de cuentas de ahorro pueden realizar depósitos y retiros, pero hay restricciones en la frecuencia y cantidad de retiros debido a su naturaleza de ahorro a largo plazo.

Cuentas Corrientes:
Las cuentas corrientes, por otro lado, son cuentas diseñadas para facilitar transacciones diarias. Estas cuentas están destinadas a manejar un gran número de depósitos y retiros, y son adecuadas para transacciones comerciales y personales regulares. A diferencia de las cuentas de ahorro, las cuentas corrientes generalmente no generan intereses significativos. Los titulares de cuentas corrientes pueden realizar retiros ilimitados y no hay restricciones en la frecuencia o cantidad de transacciones.

Diferencias Clave:
Intereses: Las cuentas de ahorro generan intereses sobre el saldo, mientras que las cuentas corrientes generalmente no generan intereses significativos.
Uso: Las cuentas de ahorro están diseñadas para ahorros a largo plazo, mientras que las cuentas corrientes están destinadas a manejar transacciones diarias.
Restricciones: Las cuentas de ahorro pueden tener restricciones en la frecuencia y cantidad de retiros, mientras que las cuentas corrientes permiten retiros ilimitados.
 */

 /*Por cierto,no sabía si debía hacer lo de la exportación del CSV yo o usted,así que ya lo hice por las dudas */

 /*También quería decirle que me guiaba por los videos que subia en clase pero aveces me salía error en alguna parte y por eso buscaba en internet o en videos de youtube para poder resolverlo profe */