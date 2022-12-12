package com.example.banking_system.Repositories;

import com.example.banking_system.entities.PersonalAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonelRepository  extends AccountRepository<PersonalAccount>{

}
