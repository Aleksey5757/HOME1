package api;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class TestSortApi {
    private final static String URL = "http://77.50.236.203:4879/";
    @Test
    public void sort(){
        Specifications.installSpecification(Specifications.requrstSpec(URL),Specifications.responseSpecOK200());
        List<UserData> users = given()
                .when()
                .get("users")
                .then().log().all()
                .extract().body().jsonPath().getList("root", UserData.class);
        List<Integer> id = users.stream().map(UserData::getId).collect(Collectors.toList());
        List<Integer> sortID = id.stream().sorted().collect(Collectors.toList());
        System.out.println(sortID);
    }

    @Test
    public void check(){




    }

}
