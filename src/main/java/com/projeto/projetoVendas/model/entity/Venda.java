/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.projetoVendas.model.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author eduar
 */
@Scope("session")
@Component
@Entity
@Table(name = "tb_venda")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date data;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<ItemVenda> getItemvenda() {
        return itemvenda;
    }

    public void setItemvenda(List<ItemVenda> itemvenda) {
        this.itemvenda = itemvenda;
    }
    
    @OneToMany(mappedBy = "venda")
    private List<ItemVenda> itemvenda;
    
    public Double total(){
        double total=0;
        for(int i=0;itemvenda.size()>i;i++){
            total = itemvenda.get(i).total() + total;
        }
    return total;
    }
    
}
