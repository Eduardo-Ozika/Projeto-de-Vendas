/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.projetoVendas.model.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author eduar
 */
@Entity
@Table(name = "tb_clientepf")
public class ClientePF extends Cliente{
    private String cpf;
    
    @OneToMany(mappedBy = "clientepf")
    private List<Venda> venda = new ArrayList();;
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Venda> getVenda() {
        return venda;
    }
    
    public void addVenda(Venda venda) {
        this.venda.add(venda);
    }

    public void setVenda(List<Venda> venda) {
        this.venda = venda;
    }
}
