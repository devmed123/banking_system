package com.example.banking_system.controllers;

import com.example.banking_system.entities.Account;
import com.example.banking_system.entities.BuisnessAccount;
import com.example.banking_system.entities.PersonalAccount;
import com.example.banking_system.entities.Transfer;
import com.example.banking_system.enume.AccountType;
import com.example.banking_system.services.AccountService;
import com.example.banking_system.services.TranferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("accounts")
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {
    @Autowired
    AccountService accountService;
    @PostMapping(value = "save_personel",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Account savepAccount(@RequestBody PersonalAccount account){
       return   accountService.createAccount(AccountType.personel, account);
    }

    @PostMapping(value = "save_buisness",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Account savebAccount(@RequestBody BuisnessAccount account){
        return   accountService.createAccount(AccountType.buisness, account);
    }

    @DeleteMapping(value = "delete_personel/{id}")
    public void deletepAccount(@PathVariable Long id){
        accountService.deleteAccount(AccountType.personel, id);
    }

    @DeleteMapping(value = "delete_buisness/{id}")
    public void deletebAccount(@PathVariable Long id){
        accountService.deleteAccount(AccountType.personel, id);
    }

    @GetMapping(value = "get_personel/{rib}")
    public PersonalAccount getpAccount(@PathVariable String rib){
       return (PersonalAccount) accountService.getAccount(AccountType.personel, rib);
    }

    @GetMapping(value = "get_buisness/{rib}")
    public BuisnessAccount getbAccount(@PathVariable String rib){
        return (BuisnessAccount) accountService.getAccount(AccountType.buisness, rib);
    }

    @PutMapping(value = "update_personel/{id}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Account updatepAccount(@RequestBody PersonalAccount account,@PathVariable Long id){
        return   accountService.updateAccount(AccountType.personel, account,id);
    }

    @PutMapping(value = "update_buisness/{id}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Account updatebAccount(@RequestBody BuisnessAccount account,@PathVariable Long id){
        return   accountService.updateAccount(AccountType.buisness, account,id);
    }

    @GetMapping(value = "allbuisness")
    public Iterable<BuisnessAccount> allbuisness(){
        return  accountService.allb();
    }

    @GetMapping()
    public List<Account> accounts(){
        return  accountService.Accounts();
    }

    @GetMapping(value = "allpersonel")
    public Iterable<PersonalAccount> allpersonel(){
        return  accountService.allp();
    }
    @Autowired
    TranferService tranferService;
    @PostMapping(value = "create_transfer")
    public Transfer transfer(@RequestBody Transfer t){
        return  tranferService.transfer(t.getSender(), t.getReciever(),t.getAmount());
    }

    @GetMapping(value = "transfers")
    public Iterable<Transfer>  transfers(){
        return  tranferService.transfers();
    }

    @GetMapping(value = "get_transfers/{rib}")
    public List<Transfer> get_transfers(@PathVariable  String rib){
        return  tranferService.gettransfers(rib);
    }
}
