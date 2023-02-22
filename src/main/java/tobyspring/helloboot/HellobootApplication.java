package tobyspring.helloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class HellobootApplication {

	public static void main(String[] args) {
		GenericWebApplicationContext applicationContext = new GenericWebApplicationContext();
		applicationContext.registerBean(HelloController.class);//어떤 class를 이용해서 Bean class를 생성할 것인가에 대한 Meta data를 넣어줌
		applicationContext.registerBean(SimpleHelloService.class);
		applicationContext.refresh();//구성정보로 container 초기화 -> Bean Object 생성

		TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
		WebServer webServer = serverFactory.getWebServer(servletContext -> {
			servletContext.addServlet("dispatcherServlet",
						new DispatcherServlet(applicationContext)
					).addMapping("/*");
		});
		webServer.start();
	}

}
