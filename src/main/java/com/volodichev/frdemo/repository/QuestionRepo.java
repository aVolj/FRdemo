package com.volodichev.frdemo.repository;

import com.volodichev.frdemo.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question, Long> {
}
