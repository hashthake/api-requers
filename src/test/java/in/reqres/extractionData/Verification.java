package in.reqres.extractionData;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Verification {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://reqres.in/";
        RestAssured.basePath = "/api/";

        response = given()
                .when()
                .get("/users?page=2")
                .then().statusCode(200);
    }


    @Test
    public void test001() {
        //    tests["Check page"]=response.page == "2"

        int length = response.extract().path("page");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Page : " + length);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    public void test002() {
        //tests["Per_page"]= response.per_page == "6"
        int perPage = response.extract().path("per_page");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Per Page : " + perPage);
        System.out.println("------------------End of Test---------------------------");

    }

    @Test
    public void test003() {
        //tests["data[1].id = 8"]=response.data[1].id=="8"
        int id = response.extract().path("data[1].id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("data[1] id : " + id);
        System.out.println("------------------End of Test---------------------------");
    }


    @Test
    public void test004() {
        //tests["data[3].first_name"]=response.data[3].first_name=="Byron"

        String firstname = response.extract().path("data[3].first_name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("data[3] First Name : " + firstname);
        System.out.println("------------------End of Test---------------------------");
    }


    @Test
    public void test005() {
        //tests["data[5].avatar"]=response.data[5].avatar=="https://reqres.in/img/faces/12-image.jpg"

        String avatar = response.extract().path("data[5].avatar");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("data[5].avatar : " + avatar);
        System.out.println("------------------End of Test---------------------------");

    }

    @Test
    public void test006() {
        //tests["support.url"]=response. support.url=="https://reqres.in/#support-heading"

        String url = response.extract().path("support.url");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Support Url : " + url);
        System.out.println("------------------End of Test---------------------------");

    }

    @Test
    public void test007() {
        //tests["support.text"]=response.support.text== "To keep ReqRes free, contributions towards server costs are appreciated!"

        String supportText = response.extract().path("support.text");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Support Text : " + supportText);
        System.out.println("------------------End of Test---------------------------");
    }


    @Test
    public void test008() {
        //tests["list of data"]= response.data.length==6;

        List<Object> data = response.extract().path("data");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("data[3] First Name : " + data.size());
        System.out.println("------------------End of Test---------------------------");
    }
}
