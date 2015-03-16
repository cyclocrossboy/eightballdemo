package eightball.web;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter  {
	@Bean
	public ServletRegistrationBean dispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/v1/*");
	}
	
	@Bean(name = "eightball")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema eightballSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("eightballPort");
		wsdl11Definition.setLocationUri("http://localhost:8080/v1/eightball/");
		wsdl11Definition.setTargetNamespace("http://acompany.com/it/enterprise/eightball/v1");
		wsdl11Definition.setSchema(eightballSchema);
		return wsdl11Definition;
	}
	
	@Bean
	public XsdSchema eightballSchema() {
		return new SimpleXsdSchema(new ClassPathResource("eightball.xsd"));
	}
}
