package com.volodichev.frdemo.repo;

import com.volodichev.frdemo.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SurveyRepo extends JpaRepository<Survey, Long> {
    List<Survey> findAllByEndIsNull();
}
