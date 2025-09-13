package com.mello.revisao.controllers;

import com.mello.revisao.domain.customermodel.Customer;
import com.mello.revisao.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> mostrarClientes(){
        return customerService.mostrarClientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> buscarPorId(@PathVariable Long id) {
        Customer customer = customerService.buscarPorID(id);
        return ResponseEntity.ok(customer);
    }

    @PostMapping
    public Customer salvar(@RequestBody Customer cliente) {
        return customerService.salvar(cliente);
    }

    @PutMapping("/{id}") // atualiza completamente
    public Customer atualizarCliente(@PathVariable Long id, @RequestBody Customer customerUpdate){
        return customerService.atualizarCliente(id, customerUpdate);
    }

    @PatchMapping("/{id}")
    public Customer atualizarClienteParcial(@PathVariable Long id, @RequestBody Customer customerUpdate){
        return customerService.atualizarClienteParcial(id, customerUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar (@PathVariable Long id){
        customerService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
