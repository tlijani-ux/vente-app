package com.java.vente.app.repositories;

import com.java.vente.app.models.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<Customers , Long> {

}
