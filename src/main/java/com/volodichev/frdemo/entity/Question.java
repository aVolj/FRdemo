package com.volodichev.frdemo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Question {
    @Id
    private long id;
    @Column
    private String text;
    @Column
    @Enumerated(EnumType.STRING)
    private TypeQuestions type;
    @OneToMany(mappedBy = "question")
    List<Answer> answers;
}
