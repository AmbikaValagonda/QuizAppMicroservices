package com.telusko.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.telusko.dao.QuizDao;
import com.telusko.feign.QuizInterface;
import com.telusko.model.QuestionWrapper;
import com.telusko.model.Quiz;
import com.telusko.model.Response;

@Service
public class QuizService implements IQuizService {

	@Autowired
	QuizDao quizDao;
	
	@Autowired	
	QuizInterface quizInterface;
			
	@Override
	public ResponseEntity<String> createQuiz(String category, int numQuestions, String title) {
		List<Integer> questions = quizInterface.generateQuestionsForQuiz(category, numQuestions).getBody();
		
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestionIds(questions);
		quizDao.save(quiz);
		
		return new ResponseEntity<>("Success", HttpStatus.CREATED);

	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
		
		Quiz quiz = quizDao.findById(id).get();
		List<Integer> questionIds = quiz.getQuestionIds();
		ResponseEntity<List<QuestionWrapper>> questionsForUser = quizInterface.getQuestionsFromId(questionIds);
		
		return questionsForUser;
		
	}


	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> response) {
		ResponseEntity<Integer> score = quizInterface.getScore(response);
		return score;


	}

}
