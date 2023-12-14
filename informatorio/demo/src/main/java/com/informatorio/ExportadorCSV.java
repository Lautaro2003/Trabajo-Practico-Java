package com.informatorio;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExportadorCSV {

    public static void exportarCuentas(List<Cliente> clientes, String nombreArchivo) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(nombreArchivo))) {

            Collections.sort(clientes, Comparator.comparingInt(cliente -> cliente.getNumeroUnico()));

            writer.writeNext(new String[]{"Número único del titular", "Nombre de titular", "Saldo", "Tipo"});

            for (Cliente cliente : clientes) {
                for (Cuenta cuenta : cliente.getCuentas()) {
                    int numeroUnico = cliente.getNumeroUnico();
                    String nombreTitular = cliente.getNombre();
                    double saldo = cuenta.getSaldo();
                    String tipo = (cuenta instanceof CuentaDeAhorro) ? "Ahorro" : "Corriente";

                    writer.writeNext(new String[]{String.valueOf(numeroUnico), nombreTitular, String.valueOf(saldo), tipo});
                }
            }

            System.out.println("Exportación a CSV exitosa.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

