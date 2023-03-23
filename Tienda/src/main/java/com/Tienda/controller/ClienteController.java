package com.Tienda.controller;

import com.Tienda.dao.ClienteDao;
import com.Tienda.domain.Cliente;
import com.Tienda.service.ClienteService;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/cliente/listado")
    public String inicio(Model model) {

        var clientes = clienteService.getClientes();
        //var clientes = clienteService.getClienteNombre("Ana");

        model.addAttribute("clientes", clientes);
        return "/cliente/listado";
    }

    @GetMapping("/cliente/nuevo")
    public String nuevoCliente(Cliente cliente) {
        return "/cliente/modificar";
    }

    @GetMapping("/cliente/encontrar")
    public String encontrarCliente(Cliente cliente) {
        return "/cliente/buscar";
    }

    /*@GetMapping("/cliente/encontrar")
    public String encontrarCliente(Cliente cliente){
       var clientes = clienteService.getClienteApellido(apellidos);
       //var clientes = clienteService.getClientePorNombre("Ana");
       
        model.addAttribute("clientes", clientes);
        return "/cliente/listado";
    }*/
    @GetMapping("/cliente/buscar")
    public String buscarCliente(Cliente cliente, String apellidos, Model model) {
        List<Cliente> clientes = clienteService.findByApellidos(apellidos);
        model.addAttribute("resultados", clientes);
        return "/cliente/buscar";
    }

    

    @PostMapping("/cliente/guardar")
    public String guardarCliente(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/cliente/listado";
    }

    @GetMapping("/cliente/modificar/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model) {
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "/cliente/modificar";
    }

    @GetMapping("/cliente/eliminar/{idCliente}")
    public String elminarCliente(Cliente cliente) {
        clienteService.delete(cliente);
        return "redirect:/cliente/listado";
    }

}
