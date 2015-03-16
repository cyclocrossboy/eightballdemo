package eightball.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import eightball.model.EightBallRequest;
import eightball.model.EightBallResponse;
import eightball.repository.AnswerRepository;

@Endpoint
@ComponentScan("eightball.repository")
public class AnswerEndpoint {

	private static final String NAMESPACE_URI = "http://acompany.com/it/enterprise/eightball/v1";
	private AnswerRepository answerRepo;


	@Autowired
	public AnswerEndpoint(AnswerRepository answerRepo){
		this.answerRepo = answerRepo;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "eightBallRequest")
	@ResponsePayload
	public EightBallResponse getAnswer(@RequestPayload EightBallRequest question) throws EightballSOAPFault{ 
		if (question.getQuestion().length() == 0){
			throw new EightballSOAPFault(" You need to ASK a Question Wanker!");
		}
		EightBallResponse answer = new EightBallResponse();
		answer.setAnswer(answerRepo.getAnswer(question));
		return answer;
	
	}
	
}
