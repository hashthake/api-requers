package in.reqres.products;

import in.reqres.model.StudentPojo;
import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StudentInfoTest extends TestBase {

    @Test
    public void getAllStudentsInfo() {
        Response response = given()
                .when()
                .get("/users/");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void getSingleStudentInfo() {
        Response response = given()
                .pathParams("id", 1)
                .when()
                .get("/{users/}");
        response.then().statusCode(200);
        response.prettyPrint();

    }
    @Test
    public void createStudent() {

        StudentPojo studentPojo = new StudentPojo();


        studentPojo.setEmail("eve.holt@reqres.in");
        studentPojo.setPassword("cityslicka");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(studentPojo)
                .when()
                .post("/login");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void deleteId(){
        Response response = given()
                .pathParams("id", 1)
                .when()
                .delete("/{users/}");
        response.then().statusCode(204);
        response.prettyPrint();

    }
    @Test
    public void updateStudentWithPatch(){
        StudentPojo studentPojo = new StudentPojo();

        Response response = given()
                .body(studentPojo)
                .when()
                .patch();
        response.then().statusCode(200);
        response.prettyPrint();

    }
}
