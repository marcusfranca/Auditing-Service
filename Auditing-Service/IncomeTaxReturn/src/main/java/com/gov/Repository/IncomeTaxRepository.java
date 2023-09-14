package com.gov.Repository;

import com.gov.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeTaxRepository extends JpaRepository<Customer, Long> {
}
