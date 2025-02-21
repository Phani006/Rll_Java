package com.mphasis.eLearning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mphasis.eLearning.entity.Questions;
@Repository
public interface QuestionsRepository extends JpaRepository<Questions, Integer>{
	
	@Query(value = "select q.correct_answer,q.weightage,q.question_id,q.option1,q.option2,q.option3,q.option4,q.question_name,q.quiz_ref_quiz_id "
			+ "from Questions q join quiz_questions_list ql  on q.question_id=ql.questions_list_question_id "
			+ "join quiz qz on ql.quiz_quiz_id=qz.quiz_id where qz.quiz_id=:quizId",nativeQuery = true)
	public List<Questions> getAllQuestions(@Param("quizId") int QuizId);

}
