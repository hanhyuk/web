package example.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class SampleInterceptor2 implements Interceptor {
	private Logger logger = LogManager.getLogger();
	
	@Override
	public void destroy() {
		logger.debug("destroy()");
	}

	@Override
	public void init() {
		logger.debug("init()");
	}

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		
		String result;
		
		logger.debug("intercept2() call!");

		HttpServletRequest request = (HttpServletRequest)actionInvocation.getInvocationContext().get(StrutsStatics.HTTP_REQUEST);
		HttpServletResponse response = (HttpServletResponse)actionInvocation.getInvocationContext().get(StrutsStatics.HTTP_RESPONSE);

		//파라메터로 넘어오는 값들을 action 실행전에 꺼내 볼수 있다
		request.setAttribute("before", "beforeValue");
		
		//액션 호출 전처리는 여기까지 
		result = actionInvocation.invoke();
		//액션 호출 후처리는 여기서부터한다.
		//아래와 같이 액션 호출 이후 속성값을 추가했지만, 실제 페이지에서 보면 해당 값이 나오지 않는다.
		//즉, 액션 호출 후처리에서 설정되는 값들은 페이지에서 보여줄수 없다.
		//- jsp 페이지가 이미 랜더링 처리가 완료된 상황 - 
		//페이지에서 처리해야 하는 데이터가 아닌것들... 예를 들어 로그처리 같은 경우에는 사용해 볼 수 있다.
		request.setAttribute("after", "after");
		request.setAttribute("setValue", "aaaaaaaaaaaaaaa");
		
		return result;
		// null을 리턴할 경우 JSP 페이지를 볼 수 없다.
//		return null;
	}

}
