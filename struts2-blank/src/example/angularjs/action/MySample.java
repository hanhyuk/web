package example.angularjs.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

import lombok.Getter;
import lombok.Setter;

/**
 * action 맵핑을 위한 xml 파일 작성을 피하기 위해 struts2-convention-plugin-2.3.24.jar 추가. annotation 지정으로 맵핑을 처리한다.
 * 
 */

@Namespace(value="/agr")
public class MySample extends ActionSupport {

	private org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager.getLogger();
	
	final Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
	
	@Getter @Setter Object jsonObject;
	
	@Action(value="s1", results={@Result(name="success", location="s1.jsp")})
	public String s1() throws Exception {
		//http://localhost:8088/agr/s1
		//angularJS 기본 예제
		
		return SUCCESS;
	}
	
	@Action(value="s2", results={@Result(name="success", location="s2.jsp")})
	public String s2() throws Exception {
		//http://localhost:8088/agr/s2
		//페이지가 뜰때 리스트를 조회해서 화면에 뿌리는 예제
		return SUCCESS;
	}
	
	@Action(value="s2_agr", results={@Result(name="success", location="s2_agr.jsp")})
	public String s2_agr() throws Exception {
		//http://localhost:8088/agr/s2_agr
		//페이지가 뜰때 리스트를 조회해서 화면에 뿌리는 예제
		//angularJS 으로 구현
		return SUCCESS;
	}
	
	@Action(value="s21_agr", results={@Result(name="success", location="s21_agr.jsp")})
	public String s21_agr() throws Exception {
		//http://localhost:8088/agr/s21_agr
		//페이지가 뜰때 리스트를 조회해서 화면에 뿌리는 예제
		//angularJS 으로 구현
		return SUCCESS;
	}
	
	@Action(value="getList")
	public String getList() throws Exception {
		//http://localhost:8088/agr/getList
		//list -> Json 형태로 변환 후 리턴한다.

		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> map = null;
		int i = 1;
		map = new HashMap<String, Object>(); map.put("no", "no" + i); map.put("name", "name" + i); map.put("address", "addresss" + i); i++; list.add(map);
		map = new HashMap<String, Object>(); map.put("no", "no" + i); map.put("name", "name" + i); map.put("address", "addresss" + i); i++; list.add(map);
		map = new HashMap<String, Object>(); map.put("no", "no" + i); map.put("name", "name" + i); map.put("address", "addresss" + i); i++; list.add(map);
		map = new HashMap<String, Object>(); map.put("no", "no" + i); map.put("name", "name" + i); map.put("address", "addresss" + i); i++; list.add(map);
		map = new HashMap<String, Object>(); map.put("no", "no" + i); map.put("name", "name" + i); map.put("address", "addresss" + i); i++; list.add(map);
		map = new HashMap<String, Object>(); map.put("no", "no" + i); map.put("name", "name" + i); map.put("address", "addresss" + i); i++; list.add(map);
		map = new HashMap<String, Object>(); map.put("no", "no" + i); map.put("name", "name" + i); map.put("address", "addresss" + i); i++; list.add(map);
		map = new HashMap<String, Object>(); map.put("no", "no" + i); map.put("name", "name" + i); map.put("address", "addresss" + i); i++; list.add(map);
		map = new HashMap<String, Object>(); map.put("no", "no" + i); map.put("name", "name" + i); map.put("address", "addresss" + i); i++; list.add(map);
		map = new HashMap<String, Object>(); map.put("no", "no" + i); map.put("name", "name" + i); map.put("address", "addresss" + i); i++; list.add(map);
		map = new HashMap<String, Object>(); map.put("no", "no" + i); map.put("name", "name" + i); map.put("address", "addresss" + i); i++; list.add(map);
		
		jsonObject = list;
		
		return "json";
	}
	
	@Action(value="s3_agr", results={@Result(name="success", location="s3_agr.jsp")})
	public String s3_agr() throws Exception {
		//http://localhost:8088/agr/s3_agr
		//트리구조 예제
		//angularJS 으로 구현
		return SUCCESS;
	}
	
	
}
