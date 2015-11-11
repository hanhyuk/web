package example.interceptors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class SampleInterceptor implements Interceptor {
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
		
		logger.debug("intercept() call!");
		
		actionInvocation.getInvocationContext().getSession().put("sesVal1", "sesVal1");
		
		
		//원하는 작업을 하고 나서는 아래와 같이 리턴값을 줘야 이후 프로세스가 정상적으로 실행된다.
		return actionInvocation.invoke();
		
		// null을 리턴할 경우 JSP 페이지를 볼 수 없다.
		//그리고 이후에 선언된 interceptor 들도 실행되지 않고, 여기서 중단 됨!
//		return null;
	}

}
