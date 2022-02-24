package com.volodichev.frdemo.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Client {
    @Id
    @GeneratedValue
    private long id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private List<Answer> answers;

    public Client() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public void addAnswer(Answer answer){
        answers.add(answer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
