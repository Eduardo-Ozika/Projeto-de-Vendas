/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.projetoVendas.controller;

/**
 *
 * @author eduar
 */

import com.projeto.projetoVendas.model.entity.ClientePF;
import com.projeto.projetoVendas.model.repository.ClientePFRepository;
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
@RequestMapping("clientePF")
public class ClientePFController {

    @Autowired
    ClientePFRepository repository;
    

    @GetMapping("/form")
    public String form(ClientePF Cliente){
        return "/CclientePF/form";
    }

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {       
        model.addAttribute("clientePF", repository.clientes());
        return new ModelAndView("/clientePF/list", model);
    }
    
    @PostMapping("/save")
    public ModelAndView save(ClientePF cliente){
        repository.save(cliente);
        return new ModelAndView("redirect:/clientePF/list");
    }
        
    
    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id){
        repository.remove(id);
        return new ModelAndView("redirect:/clientePF/list");
    }

    
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("clientePF", repository.cliente(id));
        return new ModelAndView("/clientePF/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(ClientePF cliente) {
        repository.update(cliente);
        
        return new ModelAndView("redirect:/clientePF/list");
    }
    
}
