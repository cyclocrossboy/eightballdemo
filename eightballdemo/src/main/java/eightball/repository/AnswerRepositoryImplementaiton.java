package eightball.repository;

import java.util.ArrayList;
import java.util.Random;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import eightball.model.EightBallRequest;

@Component
public class AnswerRepositoryImplementaiton implements AnswerRepository {

	private static final ArrayList<String> answers = new ArrayList<String>(20);

	@PostConstruct
	public void initdata(){
		answers.add(0, "As I see it, yes");
		answers.add(1, "It is certain");
		answers.add(2,"It is decidedly so" );
		answers.add(3,"Most likely");
		answers.add(4,"Outlook good");
		answers.add(5, "Signs point to yes");
		answers.add(6, "Without a doubt");
		answers.add(7, "Yes");
		answers.add(8, "Yes - definitely");
		answers.add(9, "You may rely on it");
		answers.add(10,"Reply hazy, try again");
		answers.add(11,"Better not tell you now");
		answers.add(12,"Cannot predict now");
		answers.add(13,"Concentrate and ask again");
		answers.add(14,"Don't count on it");
		answers.add(15,"My reply is no");
		answers.add(16,"My sources say no");
		answers.add(17,"Outlook not so good");
		answers.add(18,"Very doubtful");
		answers.add(19, "Ask again later");		
	}
	
	@Override
	public String getAnswer(EightBallRequest question) {
		// TODO Auto-generated method stub
		Assert.notNull(question);
		Random rand = new Random();		
		int iNum = rand.nextInt(20);	
		return answers.get(iNum).toString();
	}


}
