package pages;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.runner.Request;
import support.QueryDB;

import java.util.Map;

import static support.TestContext.getConfig;
import static support.TestContext.setTestData;

public class RestApiRequests {
    private String baseUrl = getConfig().baseApiUrl;
    private static String loginToken;
    private static String loginId;

    QueryDB userInf = new QueryDB();

    public static final String CONTENT_TYPE = "Content-Type";
    public static final String JSON = "application/json";
    public static final String AUTH = "authorization";

    public void loginAPI(Map<String, String > user){
        RequestSpecification request = RestAssured
                .given()
                .log().all()
                .baseUri(baseUrl)
                .basePath("/sign-in")
                .header(CONTENT_TYPE, JSON)
                .body(user);
        Response response = request
                .when()
                .post();
        Map<String, Object> result = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");
        loginToken = "Bearer " + result.get("token");
        Map<String, Object> resp = (Map<String, Object>)result.get("user");
        loginId = resp.get("id").toString();
    }

    public Map<String, Object> registrationAPI(Map<String, String> user){
        RequestSpecification request = RestAssured
                .given()
                .log().all()
                .baseUri(baseUrl)
                .basePath("/sign-up")
                .header(CONTENT_TYPE, JSON)
                .body(user);
        Response response = request
                .when()
                .post();
        Map<String, Object> results = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");
        setTestData("NewUser", results);
        return results;

    }
    public void activateUserAPI(String userEmail){
        String actCode = userInf.getDBQuery("SELECT * FROM users WHERE email = '"+ userEmail +"';", "activationCode");
        String userId = userInf.getDBQuery("SELECT * FROM users WHERE email = '"+ userEmail +"';", "id");
        RestAssured
                .given()
                .log().all()
                .baseUri(baseUrl)
                .basePath("/activate/" + userId + "/" + actCode)
                .when()
                .get()
                .then()
                .log().all()
                .statusCode(200);
    }

    public void changeUserRoleAPI(String userEmail, Map<String, String> role){
        String userId = userInf.getDBQuery("SELECT * FROM users WHERE email = '"+ userEmail +"';", "id");
        RestAssured
                .given()
                .log().all()
                .baseUri(baseUrl)
                .basePath("/users/change-role/" + userId)
                .header(CONTENT_TYPE, JSON)
                .header(AUTH, loginToken)
                .body(role)
                .when()
                .put()
                .then()
                .log().all()
                .statusCode(200);
    }

    public void deleteUserAPI(String userEmail){
        String userId = userInf.getDBQuery("SELECT * FROM users WHERE email = '"+ userEmail +"';", "id");
        RestAssured
                .given()
                .log().all()
                .baseUri(baseUrl)
                .basePath("/users/" + userId)
                .header(AUTH, loginToken)
                .when()
                .delete()
                .then()
                .log().all()
                .statusCode(200);
    }
}
