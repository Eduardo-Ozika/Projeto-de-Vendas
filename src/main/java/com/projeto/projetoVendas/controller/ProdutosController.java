/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.projetoVendas.controller;

/**
 *
 * @author eduar
 */

import com.projeto.projetoVendas.model.entity.Produto;
import com.projeto.projetoVendas.model.repository.ProdutoRepository;
import javax.transaction.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

@Transactional
@Controller
@RequestMapping("produtos")
public class ProdutosController {

    @Autowired
    ProdutoRepository repository;

    @GetMapping("/form")
    public String form(Produto produto){
        return "/produtos/form";
    }
    
    @GetMapping("/index")
    public ModelAndView index(ModelMap model) {
        model.addAttribute("produtos", repository.produtos());
        return new ModelAndView("/produtos/index", model);
    }

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("produtos", repository.produtos());
        return new ModelAndView("/produtos/list", model);
    }

    @PostMapping("/save")
    public ModelAndView save(Produto produto){
        repository.save(produto);
        return new ModelAndView("redirect:/produtos/list");
    }
        
    
    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id){
        repository.remove(id);
        return new ModelAndView("redirect:/produtos/list");
    }

    
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("produto", repository.produto(id));
        return new ModelAndView("/produtos/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(Produto produto) {
        repository.update(produto);
        
        return new ModelAndView("redirect:/produtos/list");
    }

}
