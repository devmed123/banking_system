package com.example.banking_system.services;


import com.example.banking_system.Repositories.BuisnessRepository;
import com.example.banking_system.Repositories.PersonelRepository;
import com.example.banking_system.entities.Account;
import com.example.banking_system.entities.BuisnessAccount;
import com.example.banking_system.entities.PersonalAccount;
import com.example.banking_system.enume.AccountType;
import com.example.banking_system.factories.Factoryimp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    Factoryimp factoryimp;
    @Autowired
    BuisnessRepository buisnessRepository;
    @Autowired
    PersonelRepository personelRepository;
    public Account createAccount(AccountType type, Account account){
        if(type==AccountType.buisness){
            BuisnessAccount b= (BuisnessAccount) factoryimp.createAccount(AccountType.buisness);
            b= (BuisnessAccount)account;
            return buisnessRepository.save(b);
        }
        else {
            PersonalAccount p= (PersonalAccount) factoryimp.createAccount(AccountType.personel);
            p= (PersonalAccount) account;
            return personelRepository.save(p);
        }
    }
    public void deleteAccount(AccountType type, Long id){
        if(type==AccountType.buisness){
             buisnessRepository.deleteById(id);
        }
        else {
             personelRepository.deleteById(id);
        }
    }

    public Account getAccount(AccountType type, String rib){
        if(type==AccountType.buisness){
          return   buisnessRepository.findByRib(rib);
        }
        else {
           return personelRepository.findByRib(rib);
        }
    }
    public List<Account> Accounts(){
        List<Account> l=new ArrayList<>();
        for (BuisnessAccount b:buisnessRepository.findAll()){
            l.add(new Account().buildfrombuis(b));
        }
        for (PersonalAccount p:personelRepository.findAll()){
            l.add(new Account().buildfromper(p));
        }

        return l;
    }
    public Iterable<BuisnessAccount> allb(){
       return  buisnessRepository.findAll();
   }
    public List<PersonalAccount> allp(){
        return (List<PersonalAccount>) personelRepository.findAll();
    }

    public Account updateAccount(AccountType type, Account account, Long id){
        if(type==AccountType.buisness){
            BuisnessAccount b= (BuisnessAccount) factoryimp.createAccount(AccountType.buisness);
            b= (BuisnessAccount) account;
            b.setId(id);
            if(((BuisnessAccount) account).getCompany_name()==null){
                b.setCompany_name("sopra");
            }
           return  buisnessRepository.save(b);
        }
        else {
            PersonalAccount p= (PersonalAccount) factoryimp.createAccount(AccountType.personel);
            p= (PersonalAccount) account;
            p.setId(id);
           return personelRepository.save(p);
        }

    }
}
