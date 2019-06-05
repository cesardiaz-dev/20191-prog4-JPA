/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.prog4.computadores.controllador;

import co.edu.utp.isc.prog4.computadores.modelo.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author DiazOspina
 */
public class ComputadoresService {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ComputadoresPU");

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Usuario guardarUsuario(Usuario usuario) {
        EntityManager em = getEntityManager();

        em.getTransaction().begin();
        usuario = em.merge(usuario);

        em.getTransaction().commit();
        em.close();
        return usuario;
    }

    public List<Usuario> listarUsuarios() {
        EntityManager em = getEntityManager();

        Query query = em.createQuery("SELECT u FROM Usuario u");
        List<Usuario> resp = (List<Usuario>) query.getResultList();

        em.close();
        return resp;
    }

    public Usuario consultarUsuario(Long identificador) {
        EntityManager em = getEntityManager();

        Usuario resp = em.find(Usuario.class, identificador);

        em.close();
        return resp;
    }

}
