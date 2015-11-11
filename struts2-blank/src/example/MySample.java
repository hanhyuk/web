package example;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import lombok.Data;

//lombok 라이브러리를 사용하여 get/setter 를 자동으로 처리함(@Data 어노테이션)
@Data
public class MySample extends ActionSupport {
	private org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager.getLogger();
	
	Locale myLocale;
	
	//http://localhost:8088/sample/sample1
	public String execute() throws Exception {
		myLocale = Locale.KOREA;
		ActionContext.getContext().setLocale(myLocale);
		return SUCCESS;
	}
	//http://localhost:8088/sample/sample2
	public String changeLocale() throws Exception {
		myLocale = Locale.ENGLISH;
		ActionContext.getContext().setLocale(myLocale);
		
		return SUCCESS;
	}
	
	//http://localhost:8088/sample/sample_test1
	// * 와일드카드를 사용해서 액션명 == 메소드명 == jsp 파일명 까지 일치하여 사용.
	public String test1() throws Exception {
		
		logger.debug("test1() call!!!");
		
		return SUCCESS;
	}
	
	
	private String msg;
	//http://localhost:8088/sample/sample_test2
	// * 와일드카드를 사용해서 액션명 == 메소드명 == jsp 파일명 까지 일치하여 사용.
	public String test2() throws Exception {
		msg = "Hello";
		
		return SUCCESS;
	}

	private String name;
	//http://localhost:8088/sample/test3
	public String test3() throws Exception {
		name = "test3";
		
		return SUCCESS;
	}
	
	//SampleInterceptor 을 통한 세션에 특정값 넣기
	//http://localhost:8088/sample/inter1
	public String inter1() throws Exception {
		
		return SUCCESS;
	}
	
	
	private String param1;
	//inter1.jsp 에서 넘겨지는 특정값을 SampleInterceptor2에서 조작하기.
	//http://localhost:8088/sample/inter2
	public String inter2() throws Exception {
		
		logger.debug("inter1 페이지에서 넘어온 값 : " + param1);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		logger.debug("SampleInterceptor2 에서 넘어온 값 : " + request.getAttribute("before"));
		
		request.setAttribute("setValue", "setValue222");
		
		return SUCCESS;
	}
	
	//Result 를 직접구현하고, 이를 테스트한다.
	//이 예제에서는 액션에서 설정된 파라메터를 StringResult 객체에서 출력해 보는 정도. 
	//http://localhost:8088/sample/result
	public String resultTest() throws Exception {
		
		param1 = "resultTest";
		
		//Result 로 처리 할 경우 JSP 페이지까지 랜더링 처리 되지 않는다.
		//원래 SUCCESS 를 리턴할 경우 디스패처를 통해 JSP가 처리되는데... 내가 만든 예제에서는
		//그러한 부분이 없다 보니... 액션 호출시 하얀화면이 나온다.
		
		return "string";
	}
}
