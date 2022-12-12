package com.example.banking_system.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@MappedSuperclass
@Data
public  class Account {
    protected String name;
    private String rib;
    private double balance;
    public Account buildfrombuis(BuisnessAccount b){
        this.name=b.name;
        this.balance=b.getBalance();
        this.rib=b.getRib();
        return this;
    }
   public  Account buildfromper(PersonalAccount p){
        this.name=p.name;
        this.balance=p.getBalance();
        this.rib=p.getRib();
        return this;
    }
}
