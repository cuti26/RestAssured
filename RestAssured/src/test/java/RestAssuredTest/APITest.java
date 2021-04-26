package RestAssuredTest;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import org.json.simple.JSONObject;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;



public class APITest {
	//@Test
	public void funct1() {
	//Response code = RestAssured.get("https://reqres.in/api/users?page=2");
	baseURI="https://reqres.in/api";
	given()
		.get("/users?page=2");
	}

	//@Test
	public void postfunct() {
		Map <String,Object> in =  new HashMap <String,Object>();
//		in.put("name","pavan");
//		in.put("job","Technical");
		
		JSONObject request=new JSONObject();
		request.put("name","Raghav");
		request.put("job","Technical");
		
		baseURI="https://reqres.in/api/";
		given().body(request).post("/users").then().statusCode(201);
		
	}

@Test
   public void putfunct() {
	Map <String,Object> in =  new HashMap <String,Object>();
//	in.put("name","pavan");
//	in.put("job","Technical");
	
	JSONObject request=new JSONObject();
	request.put("name","Aish");
	request.put("job","Technical");
	
	baseURI="https://reqres.in/api/";
	given().
	header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON).
	body(request.toJSONString()).put("users/2").statusCode();
	
}

@Test
public void patchfunct() {
	Map <String,Object> in =  new HashMap <String,Object>();
//	in.put("name","pavan");
//	in.put("job","Technical");
	
	JSONObject request=new JSONObject();
	request.put("name","try");
	request.put("job","Techn");
	
	baseURI="https://reqres.in/api/";
	given().
	header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON).
	body(request.toJSONString()).patch("users/2").statusCode();
	
}


@Test
public void deletefunct() {
	
	baseURI="https://reqres.in/api/";
	when().delete("/users/2").then().statusCode(204);
	
                         }
	
}
