package com.volodichev.frdemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

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
}
