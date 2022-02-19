package com.volodichev.frdemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue
    private long id;
    @OneToMany(mappedBy = "client")
    private List<Answer> answers;
}
