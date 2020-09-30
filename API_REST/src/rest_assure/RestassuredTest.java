package rest_assure;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RestassuredTest {

	 @Test
	public static void testGET_old() {
		Response res = RestAssured.get("https://reqres.in/api/users?page=2");
		// res= RestAssured.post("");
		System.out.println("resbody: "+res.body().asString());
		System.out.println("content type "+res.contentType());
		System.out.println("status code: "+res.statusCode());
		System.out.println(res.getStatusLine());
		System.out.println(res.getTime());
		System.out.println(res.prettyPrint());

		System.out.println(res.asString());

	}

	@Test
	public void testGET_new()// for new need to import rest assured pkg
								// statically import
	{

		// given().get("https://reqres.in/api/users?page=2").then().statusCode(200);

		Response res = given().header("content-type", "application/json").get("https://reqres.in/api/users?page=2");
		//
	}

	@Test
	public void testPost() {
		// Entity ety= new Entity(arg0, arg1, arg2)

		JSONObject obj = new JSONObject();

		obj.put("name", "hari");
		obj.put("job", "er");
		given().body(obj.toJSONString()).header("content-type", "application/json").when()
				.post("https://reqres.in/api/users").then().statusCode(201).log().all();

	}

	@Test
	public void testPost_jsonParse() {
		/*
		 * JSONObject obj = new JSONObject(); obj.put("name", "hari");
		 * obj.put("job", "er");
		 */
		Response res = given().header("content-type", "application/json").when()
				.get("https://reqres.in/api/users?page=2");			
		List<String> ja = res.jsonPath().getList("data");
		System.out.println(ja.size());
		for (int i = 0; i < ja.size(); i++) {
			System.out.print(res.jsonPath().get("data.id[" + i + "]  ").toString());
			System.out.println(res.jsonPath().get("  data.email[" + i + "]").toString());
		}
		/*
		 * str= res.jsonPath().get("page").toString(); System.out.println(str);
		 * str=res.jsonPath().get("data.id[0]").toString();
		 * System.out.println(str); str=res.jsonPath().get("data").toString();
		 * System.out.println(str); str=res.jsonPath().get("ad").toString();
		 * System.out.println(str);
		 */
	}
	@Test
	public void getJOFromRes() throws ParseException
	{
		Response res = given().header("content-type", "application/json").when()
				.get("https://reqres.in/api/users?page=2");	
		
		//JSONArray  jo = JSONParser
		// Object p = new JSONParser().parse(res.body().asString());
	   Object p = new JSONParser().parse(res.asString());
		JSONObject jo =(JSONObject)p; 
		System.out.println("total  :"+jo.get("total"));
		JSONArray ja = (JSONArray)jo.get("data");
		System.out.println("size :"+ja.size());
		for(int i=0;i<ja.size();i++)
		{
			jo=(JSONObject)ja.get(i);
			System.out.println(jo.get("email"));
		}
		/*JsonPath path = res.jsonPath();
		System.out.println("total :"+ path.get("total"));
		List<Object> ar = path.getList("data");*/
		/*for(Object str: ar)
		{
			Object obj = new JSONParser().parse("str");
			JSONObject joo = (JSONObject) obj;
			System.out.println(joo.get("avatar"));
		}*/
	}

	
//this is perfect test to understand JSONObject and JSONArray
	@Test()
	public void parseJsonFileByJO() throws ParseException, IOException {
		Object obj = new JSONParser().parse(new java.io.FileReader(new File("data.json")));
		JSONObject jo = (JSONObject) obj;
		JSONObject pg = (JSONObject) jo.get("pageInfo");
		System.out.println(pg.get("pageName"));
		JSONArray js = (JSONArray) jo.get("posts");	
		System.out.println("size : " + js.size());
		for (int i = 0; i < js.size(); i++) {
			jo = (JSONObject) js.get(i);
			if (jo.get("post_id").equals("2"))
				System.out.println(jo.get("author_name"));
		}	}

	@Test()
	public void parseJsonFileByJP() {
		JsonPath path = new JsonPath(new File("data.json"));
		System.out.println(path.get("pageInfo.pageName"));
		System.out.println("posts.post_id" + path.get("posts.post_id[0]"));
	}
}
