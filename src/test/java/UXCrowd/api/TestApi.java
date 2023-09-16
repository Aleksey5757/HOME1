package UXCrowd.api;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestApi {
    private final static String URL = "http://77.50.236.203:4879/";
    private final static String URLUXC = "https://dev-t.uxcrowd.ru/";
    @Test
    public void sort(){
        Specifications.installSpecification(Specifications.requrstSpec(URL), Specifications.responseSpecOK200());
        List<UserData> users = given()
                .when()
                .get("users")
                .then().log().all()
                .extract().body().jsonPath().getList("$", UserData.class);
        List<Integer> id = users.stream().map(UserData::getId).collect(Collectors.toList());
        List<Integer> sortID = id.stream().sorted().collect(Collectors.toList());
       System.out.println(sortID);
       System.out.println(id);
       Assert.assertEquals(sortID, id);
        ArrayList<UserData> sortedList = new ArrayList<>(users);
        sortedList.sort((user1, user2) -> user1.getId() - user2.getId());
       // Assert.assertEquals(user1,user2);
    }

    @Test
    public void checkUser(){
        Specifications.installSpecification(Specifications.requrstSpec(URL), Specifications.responseSpecOK200());
        Response response = given()
                .when()
                .get("user/4")
                .then().log().all()
                .body("id",equalTo(4))
                .body("firstName",equalTo("Peter"))
                .body("secondName",equalTo("Form"))
                .body("age",equalTo(25))
                .body("sex",equalTo("MALE"))
                .body("money",equalTo(26061.00F))
                .body("firstName",notNullValue())

                .extract().response();
    }

    @Test
    public void check(){
        Specifications.installSpecification(Specifications.requrstSpec(URLUXC), Specifications.responseSpecOK200());
        Response response = given()
                .when()
                .get("/api/v2/admin/tester-tasks/project-name")
                .then().log().all()
                .body("city",notNullValue())
                .body("email",notNullValue())
                .body("username",notNullValue())
                .extract().response();
    }



}
