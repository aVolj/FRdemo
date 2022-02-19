package com.volodichev.frdemo.entity;

import jakarta.persistence.*;

@Entity
public class Answer {
    @EmbeddedId
    @GeneratedValue
    AnswerKey id;
    @ManyToOne
    @MapsId("clientId")
    @JoinColumn(name = "client_id")
    Client client;
    @ManyToOne
    @MapsId("questionId")
    @JoinColumn(name = "question_id")
    Question question;
    @Column
    String answer;

}
