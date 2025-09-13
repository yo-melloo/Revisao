package com.mello.revisao.repository;

import com.mello.revisao.domain.customermodel.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
