package com.volodichev.frdemo.repository;

import com.volodichev.frdemo.entity.Answer;
import com.volodichev.frdemo.entity.AnswerKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AnswerRepo extends JpaRepository<Answer, AnswerKey> {
    List<Answer> findAnswerByUser_Id(long id);
}
