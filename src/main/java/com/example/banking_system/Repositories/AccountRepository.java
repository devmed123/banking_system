package com.example.banking_system.Repositories;

import com.example.banking_system.entities.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.web.bind.annotation.CrossOrigin;

@NoRepositoryBean
public interface AccountRepository<T extends Account> extends CrudRepository<T, Long> {
  T findByRib(String rib);
}