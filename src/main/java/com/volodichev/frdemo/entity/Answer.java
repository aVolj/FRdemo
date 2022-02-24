package com.volodichev.frdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Answer {
    @EmbeddedId
    private AnswerKey id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(insertable = false, updatable = false, name = "client_id")
    private Client client;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(insertable = false, updatable = false, name = "question_id")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return id.equals(answer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
