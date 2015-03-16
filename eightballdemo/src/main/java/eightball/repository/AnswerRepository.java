package eightball.repository;

import eightball.model.EightBallRequest;


public interface AnswerRepository {

	String getAnswer(EightBallRequest question);
}
