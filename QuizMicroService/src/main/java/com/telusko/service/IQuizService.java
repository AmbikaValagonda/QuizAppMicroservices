package com.telusko.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.telusko.model.QuestionWrapper;
import com.telusko.model.Response;

public interface IQuizService {

	ResponseEntity<String> createQuiz(String category, int numQ, String title);

	ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id);

	ResponseEntity<Integer> calculateResult(Integer id, List<Response> response);

	
}
