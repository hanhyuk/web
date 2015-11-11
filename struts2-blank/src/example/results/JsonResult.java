package example.results;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.StrutsStatics;

import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;

@SuppressWarnings("serial")
public class JsonResult implements Result {
	@SuppressWarnings("unused")
	public void execute(ActionInvocation invocation) throws Exception {
		final ActionContext actionContext = invocation.getInvocationContext();
		final HttpServletRequest request = (HttpServletRequest)actionContext.get(StrutsStatics.HTTP_REQUEST);
		final HttpServletResponse response = (HttpServletResponse)actionContext.get(StrutsStatics.HTTP_RESPONSE);

		final Object jsonObject = invocation.getStack().findValue("jsonObject");

		response.setContentType("text/plain;charset=utf-8");
		if (jsonObject != null) {
			final String jsonString = new GsonBuilder().serializeNulls().setPrettyPrinting().create().toJson(jsonObject);
			response.getOutputStream().write(jsonString.getBytes("UTF-8"));
		}
	}
}