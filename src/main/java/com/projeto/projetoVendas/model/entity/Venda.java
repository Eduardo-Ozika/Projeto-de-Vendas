/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.projetoVendas.model.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author eduar
 */
@Entity
@Table(name = "tb_venda")
public class Venda {
    @Id
    @GeneratedValue
    private Long id;
    private Date data;
    
    @OneToMany(mappedBy = "venda")
    private List<ItemVenda> itemvenda;
    
    public Double total(){
    return null;
    }
    
}
