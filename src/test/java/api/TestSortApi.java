package api;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;

public class TestSortApi {
    private final static String URL = "http://77.50.236.203:4879/";
    @Test
    public void sort(){
        Specifications.installSpecification(Specifications.requrstSpec(URL),Specifications.responseSpecOK200());
        List<UserData> users = given()
                .when()
                .get("users")
                .then().log().all()
                .extract().body().jsonPath().getList("$", UserData.class);
      //  List<Integer> id = users.stream().map(UserData::getId).collect(Collectors.toList());
      //  List<Integer> sortID = id.stream().sorted().collect(Collectors.toList());
     //   System.out.println(sortID);
      //  Assert.assertEquals(sortID, id);
        ArrayList<UserData> sortedList = new ArrayList<>(users);
        sortedList.sort((user1, user2) -> user1.getId() - user2.getId());
       // Assert.assertEquals(user1,user2);
    }

    @Test
    public void checkUser(){
        Specifications.installSpecification(Specifications.requrstSpec(URL),Specifications.responseSpecOK200());
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

}
