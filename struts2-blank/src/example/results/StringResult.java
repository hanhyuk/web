package example.results;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;

public class StringResult implements Result {

	@Override
	public void execute(ActionInvocation actionInvocation) throws Exception {
		final ActionContext actionContext = actionInvocation.getInvocationContext();
		final HttpServletRequest request = (HttpServletRequest)actionContext.get(StrutsStatics.HTTP_REQUEST);
		final HttpServletResponse response = (HttpServletResponse)actionContext.get(StrutsStatics.HTTP_RESPONSE);

		System.out.println("-----------------");
		System.out.println(actionInvocation.getStack().findValue("param1"));
		System.out.println(request.getAttribute("param1"));
		System.out.println("-----------------");
		//아래는 엑셀파일다운로드 처리할때 사용하는 코드 샘플이다.
//		response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(excelFileName, "UTF-8"));
//		response.setContentType("application/x-msexcel");
//		response.getOutputStream().write(excelByteArray);
		
		//아래는 gson 라이브러리를 이용하여, 자바 객체를 json 형태로 변환하여 리턴하는 샘플이다.
//		response.setContentType("text/plain;charset=utf-8");
//		if (jsonObject != null) {
//			final String jsonString = new GsonBuilder().serializeNulls().setPrettyPrinting().create().toJson(jsonObject);
//			response.getOutputStream().write(jsonString.getBytes("UTF-8"));
//		}
		
	}

}
