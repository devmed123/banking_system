package com.example.banking_system.Repositories;

import com.example.banking_system.entities.BuisnessAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface BuisnessRepository extends AccountRepository<BuisnessAccount> {

}
