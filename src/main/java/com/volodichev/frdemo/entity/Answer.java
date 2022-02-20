package com.volodichev.frdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Answer {
    @EmbeddedId
    private AnswerKey id;
    @JsonIgnore
    @ManyToOne
    @MapsId("clientId")
    @JoinColumn(name = "client_id")
    private Client client;
    @JsonIgnore
    @ManyToOne
    @MapsId("questionId")
    @JoinColumn(name = "question_id")
    private Question question;
    @Column
    private String answer;

    public Answer() {
    }

    public void setId(AnswerKey id) {
        this.id = id;
    }

    public AnswerKey getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
