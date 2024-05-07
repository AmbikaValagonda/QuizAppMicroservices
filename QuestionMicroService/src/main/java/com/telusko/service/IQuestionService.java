package com.telusko.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.telusko.model.Question;
import com.telusko.model.QuestionWrapper;
import com.telusko.model.Response;

public interface IQuestionService {
	 public ResponseEntity<List<Question>> getAllQuestions();
	 public ResponseEntity<List<Question>> getQuestionsByCategory(String category);
	 public ResponseEntity<String> addQuestion(Question question);
	public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, Integer numQuestions);
	public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionIds);
	public ResponseEntity<Integer> getScore(List<Response> responses);
	 
	 
	 
	 
}
