package com.informatorio;

import java.util.List;

public class ServicioCliente {

    public static void mostrarClientes(List<Cliente> clientes) {
        System.out.println("Lista de Clientes:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }
}