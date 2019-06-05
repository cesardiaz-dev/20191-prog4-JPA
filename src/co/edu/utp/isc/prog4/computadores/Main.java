/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.prog4.computadores;

import co.edu.utp.isc.prog4.computadores.controllador.ComputadoresService;
import co.edu.utp.isc.prog4.computadores.modelo.Usuario;
import java.util.List;

/**
 *
 * @author DiazOspina
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ComputadoresService service = new ComputadoresService();

        System.out.println("Guardando Usuarios");

//        Usuario user = new Usuario(10030619L, "Cesar", "Diaz");
//        user.setGenero('M');
//        service.guardarUsuario(user);
//
//        user = new Usuario(12516017L, "Aleandro", "Cardenas");
//        user.setGenero('M');
//        service.guardarUsuario(user);

        System.out.println("Listando los usuarios creados");
        List<Usuario> listarUsuarios = service.listarUsuarios();
        for (Usuario usuario : listarUsuarios) {
            System.out.println(usuario);
        }

        System.out.println("Consultando un usuario existente");
        Usuario user2 = service.consultarUsuario(10030619L);
        System.out.println(user2.getNombre());
    }

}
