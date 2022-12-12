package com.example.banking_system.services;

import com.example.banking_system.Repositories.TransferRepository;
import com.example.banking_system.entities.Transfer;
import com.example.banking_system.enume.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TranferService {
    @Autowired
    TransferRepository transferRepository;

    @Autowired
    AccountService accountService;
    public List<Transfer> gettransfers(String rib){
        List<Transfer> l=new ArrayList<>();
        for(Transfer t: transferRepository.findAllBySender(rib)){
            l.add(t);
        }
        for(Transfer t: transferRepository.findAllByReciever(rib)){
            l.add(t);
        }
        return  l;
    }
   public Iterable<Transfer> transfers(){
      return  transferRepository.findAll();
   }
    public Transfer transfer(String sender,String reciever, double amount){
        Transfer t=new Transfer();
        if(accountService.getAccount(AccountType.buisness, sender)!=null && accountService.getAccount(AccountType.buisness,reciever)!=null){
           if(accountService.getAccount(AccountType.buisness, sender).getBalance()>=amount){
               accountService.getAccount(AccountType.buisness, sender).setBalance(accountService.getAccount(AccountType.buisness, sender).getBalance()-amount);
               accountService.getAccount(AccountType.buisness, reciever).setBalance(accountService.getAccount(AccountType.buisness, reciever).getBalance()+amount);
               t.setSender(sender);
               t.setAmount(amount);

               t.setReciever(reciever);
               t.setDate(new Date());
               return transferRepository.save(t);
           }
        }
       else if(accountService.getAccount(AccountType.personel, sender)!=null && accountService.getAccount(AccountType.personel,reciever)!=null){
            if(accountService.getAccount(AccountType.personel, sender).getBalance()>=amount){
                accountService.getAccount(AccountType.personel, sender).setBalance(accountService.getAccount(AccountType.personel, sender).getBalance()-amount);
                accountService.getAccount(AccountType.personel, reciever).setBalance(accountService.getAccount(AccountType.personel, reciever).getBalance()+amount);
                t.setSender(sender);
                t.setReciever(reciever);
                t.setAmount(amount);

                t.setDate(new Date());
                return transferRepository.save(t);
            }
        }
        else if(accountService.getAccount(AccountType.personel, sender)!=null && accountService.getAccount(AccountType.buisness,reciever)!=null){
            if(accountService.getAccount(AccountType.personel, sender).getBalance()>=amount){
                accountService.getAccount(AccountType.personel, sender).setBalance(accountService.getAccount(AccountType.personel, sender).getBalance()-amount);
                accountService.getAccount(AccountType.buisness, reciever).setBalance(accountService.getAccount(AccountType.buisness, reciever).getBalance()+amount);
                t.setSender(sender);
                t.setReciever(reciever);
                t.setAmount(amount);

                t.setDate(new Date());
                return transferRepository.save(t);
            }
        }
        else if(accountService.getAccount(AccountType.buisness, sender)!=null && accountService.getAccount(AccountType.personel,reciever)!=null){
            if(accountService.getAccount(AccountType.buisness, sender).getBalance()>=amount){
                accountService.getAccount(AccountType.buisness, sender).setBalance(accountService.getAccount(AccountType.buisness, sender).getBalance()-amount);
                accountService.getAccount(AccountType.personel, reciever).setBalance(accountService.getAccount(AccountType.personel, reciever).getBalance()+amount);
                t.setSender(sender);
                t.setReciever(reciever);
                t.setAmount(amount);
                t.setDate(new Date());
                return transferRepository.save(t);
            }
        }
        else {
            return null;
        }
     return null;
    }
}
