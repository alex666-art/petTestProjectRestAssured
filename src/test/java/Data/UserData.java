package Data;

import Data.pojo.Permissions;
import Data.pojo.Teams;
import SetUp.SetUp;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserData extends SetUp {
    public static String getUserToken() {

        RestAssured.baseURI = get_URL_Property();
        RequestSpecification request = RestAssured.given();

        String payload = "{\n" +
                "\"email\": " + "\"" + get_LOGIN_Property() + "\",\n" +
                "\"password\": " + "\"" + get_PASSWORD_Property() + "\"\n" +
                "}";

        Response response = request
                .when()
                .contentType(ContentType.JSON)
                .body(payload)
                .post("/auth/login");

        String jsonBody = response.getBody().asString();
        return JsonPath.from(jsonBody).getString("token");
    }

    public static String getUserName(String token) {

        RestAssured.baseURI = get_URL_Property();
        RequestSpecification request = RestAssured.given();

        request.header("Authorization", "Bearer " + token);

        Response response = request
                .when()
                .contentType(ContentType.JSON)
                .get("/user/data");

        String jsonBody = response.getBody().asString();
        return JsonPath.from(jsonBody).getString("name");
    }

    public static String getStatus(String token) {

        RestAssured.baseURI = get_URL_Property();
        RequestSpecification request = RestAssured.given();

        request.header("Authorization", "Bearer " + token);

        Response response = request
                .when()
                .contentType(ContentType.JSON)
                .get("/user/data");

        return String.valueOf(response.getStatusCode());
    }

    public static List<Teams> getUserTeamsJSON(String token) {

        RestAssured.baseURI = get_URL_Property();
        return given()
                .when()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + UserData.getUserToken())
                .get(get_URL_Property() + "/user/data")
                .then().log()
                .all()
                .extract().body().jsonPath().getList("teams", Teams.class);
    }

    public static List<Permissions> getUserPermissionJSON(String token, Integer id) {

        RestAssured.baseURI = get_URL_Property();
        return given()
                .when()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + UserData.getUserToken())
                .get(get_URL_Property() + "/user/" + id + "/permissions")
                .then().log()
                .all()
                .extract().body().jsonPath().getList("7", Permissions.class);
    }
}