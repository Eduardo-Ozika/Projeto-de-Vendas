/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.projetoVendas.controller;

/**
 *
 * @author eduar
 */

import com.projeto.projetoVendas.model.entity.ItemVenda;
import com.projeto.projetoVendas.model.entity.Produto;
import com.projeto.projetoVendas.model.entity.Venda;
import com.projeto.projetoVendas.model.repository.ProdutoRepository;
import com.projeto.projetoVendas.model.repository.VendaRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

@Transactional
@Controller
@Scope("request")
@RequestMapping("vendas")
public class VendasController {

    @Autowired
    VendaRepository repository;
    
    @Autowired
    ProdutoRepository repositoryprod;
    
    @Autowired
    Venda venda;

    @GetMapping("/form")
    public String form(Venda venda){
        return "/vendas/form";
    }

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {       
        model.addAttribute("vendas", repository.vendas());
        return new ModelAndView("/vendas/list", model);
    }
    @GetMapping("/carrinho")
    public ModelAndView carrinho(ModelMap model) {       
        model.addAttribute("vendas", repository.vendas());
        return new ModelAndView("/vendas/carrinho", model);
    }
    
    @PostMapping("/save")
    public ModelAndView save(Venda venda){
        repository.save(venda);
        return new ModelAndView("redirect:/vendas/list");
    }
    @GetMapping("/savecarrinho/{id}")
    public ModelAndView savecarrinho(@PathVariable("id") Long id, ItemVenda itemvenda){
        itemvenda.setProduto(repositoryprod.produto(id));
        venda.addItemvenda(itemvenda);
        System.out.println(venda.getItemvenda().get(0).getQtd());
        return new ModelAndView("redirect:/produtos/index");
    }
        
    
    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id){
        repository.remove(id);
        return new ModelAndView("redirect:/vendas/list");
    }

    
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("venda", repository.venda(id));
        return new ModelAndView("/vendas/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(Venda venda) {
        repository.update(venda);
        
        return new ModelAndView("redirect:/vendas/list");
    }
    
}
