package com.example.banking_system.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class PersonalAccount extends Account{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
