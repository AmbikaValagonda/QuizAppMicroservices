package com.telusko.dao;

import java.awt.print.Pageable;
import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.telusko.model.Question;
@Repository
public interface QuestionDao extends JpaRepository<Question, Integer>{

    List<Question> findByCategory(String category);

   
    @Query(value = "SELECT q.id FROM question q Where q.category=:category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
    List<Integer> findByTopic(String category, Integer numQ);

}
