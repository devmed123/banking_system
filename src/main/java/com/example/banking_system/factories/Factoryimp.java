package com.example.banking_system.factories;

import com.example.banking_system.entities.Account;
import com.example.banking_system.entities.BuisnessAccount;
import com.example.banking_system.entities.PersonalAccount;
import com.example.banking_system.enume.AccountType;

public class Factoryimp implements AccountFactory{
    @Override
    public Account createAccount(AccountType type) {
        if(type==AccountType.personel){
            return new PersonalAccount();
        }
        else{
            return new BuisnessAccount();
        }
    }
}
