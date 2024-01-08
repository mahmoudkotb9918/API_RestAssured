package Scenarios;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class PostLoginStudent {
    @Test
    public void addNewStudent(){
        String body = "{\n" +
                "    \"createdAt\": \"2023-11-19T04:26:38.753Z\",\n" +
                "    \"name\": \"Chester Reilly\",\n" +
                "    \"Course\": \"\\\"2R*U-'jP0\",\n" +
                "    \"grade\": 29010,\n" +
                "    \"country\": \"Chile\",\n" +
                "    \"id\": \"5\"\n" +
                "}";
        given()
                .baseUri("https://655a860c6981238d054d8d2c.mockapi.io")
//                .headers("Content-Type","application/json")
                .contentType(ContentType.JSON) //another way to define content type as previous row
                .body(body)
        .when()
                .post("Students")
        .then()
                .log().all()
                .assertThat().statusCode(201);
    }

    @Test
    public void addAnotherNewStudent(){         // using file path

        File body = new File("src/test/resources/login.json");
        given()
                .baseUri("https://655a860c6981238d054d8d2c.mockapi.io")
                .body(body)
        .when()
                .post("Students")
        .then()
                .log().all()
                .assertThat().statusCode(201);
    }
}
