package com.example.banking_system.factories;

import com.example.banking_system.entities.Account;
import com.example.banking_system.enume.AccountType;

public interface AccountFactory {
    public Account createAccount(AccountType type);
}
