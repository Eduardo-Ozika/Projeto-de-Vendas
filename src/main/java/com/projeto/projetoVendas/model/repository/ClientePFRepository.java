/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.projetoVendas.model.repository;
import com.projeto.projetoVendas.model.entity.ClientePF;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author eduar
 */
@Repository
public class ClientePFRepository {
    
     @PersistenceContext
    private EntityManager em;

    public void save(ClientePF cliente){
        em.persist(cliente);
    }

    public ClientePF cliente(Long id){
        return em.find(ClientePF.class, id);
    }

    public List<ClientePF> clientes(){
        Query query = em.createQuery("from ClientePF");
        return query.getResultList();
    }

    public void remove(Long id){
        ClientePF c = em.find(ClientePF.class, id);
        em.remove(c);
    }

    public void update(ClientePF cliente){
        em.merge(cliente);
    }
}