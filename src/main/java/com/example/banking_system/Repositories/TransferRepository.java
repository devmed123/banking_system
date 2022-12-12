package com.example.banking_system.Repositories;

import com.example.banking_system.entities.Transfer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends CrudRepository<Transfer,Long> {
    public Iterable<Transfer> findAllBySender(String sender);
    public Iterable<Transfer> findAllByReciever(String reciever);
}
