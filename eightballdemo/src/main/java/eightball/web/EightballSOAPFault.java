package eightball.web;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.SERVER)
public class EightballSOAPFault extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9178834947744049287L;

	public EightballSOAPFault(String message){
		super(message);
	}

}
