package com.mello.revisao.services;

import com.mello.revisao.domain.customermodel.Customer;
import com.mello.revisao.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public List<Customer> mostrarClientes(){
        return customerRepository.findAll();
    }

    public Customer buscarPorID(Long id){
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ID " + id + " não encontrado!"));
    }

    public Customer salvar(Customer customer){
        System.out.println("Cliente registrado com sucesso!");
        return customerRepository.save(customer);
    }

    public Customer atualizarCliente(Long id, Customer customerUpdate) {
        return customerRepository.findById(id)
                .map(customerMapped -> {
                    customerMapped.setNome(customerUpdate.getNome());
                    customerMapped.setEmail(customerUpdate.getEmail());
                    return customerRepository.save(customerMapped);
                }).orElseThrow(() -> new RuntimeException("ID " + id + " não encontrado!"));
    }

    public Customer atualizarClienteParcial(Long id, Customer customerUpdate) {
        return customerRepository.findById(id)
                .map(customerMapped -> {
                    if (customerUpdate.getNome() != null) {
                        customerMapped.setNome(customerUpdate.getNome());
                    }
                    if (customerUpdate.getEmail() != null) {
                        customerMapped.setEmail(customerUpdate.getEmail());
                    }
                    return customerRepository.save(customerMapped);
                }).orElseThrow(() -> new RuntimeException("ID " + id + " não encontrado!"));
    }

    public void deletar(Long id){
        if (!customerRepository.existsById(id)) {
            throw new RuntimeException("ID " + id + " não encontrado!");
        }
        customerRepository.deleteById(id);
    }
}
