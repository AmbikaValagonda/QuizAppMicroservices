package com.telusko.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.model.QuestionWrapper;
import com.telusko.model.QuizDto;
import com.telusko.model.Response;
import com.telusko.service.IQuizService;


@RestController
@RequestMapping("quiz")
public class QuizController {
	@Autowired
	IQuizService quizService;
	

	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto){
		return quizService.createQuiz(quizDto.getCategory(), quizDto.getNumQuestions(), quizDto.getTitle());
		
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<List<QuestionWrapper>> createQuiz(@PathVariable int id){
		
		return quizService.getQuizQuestions(id);
		
		
	}
	
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> response) {
		return quizService.calculateResult(id, response);
		
	}

	

}
