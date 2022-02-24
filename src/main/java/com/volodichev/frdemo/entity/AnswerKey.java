package com.volodichev.frdemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AnswerKey implements Serializable {
    @Column(name = "client_id")
    private long clientId;
    @Column(name = "question_id")
    private long questionId;

    public AnswerKey() {
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long question_id) {
        this.questionId = question_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnswerKey answerKey = (AnswerKey) o;
        return clientId == answerKey.clientId && questionId == answerKey.questionId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, questionId);
    }
}
