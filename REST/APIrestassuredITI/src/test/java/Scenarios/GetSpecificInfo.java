package Scenarios;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class GetSpecificInfo {
    @Test
    public void getSpecificStudent(){
        given()
                .baseUri("https://655a860c6981238d054d8d2c.mockapi.io")
                .queryParam("country","Italy")
        .when()
                .get("Students")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }
    @Test
    public void getAnotherSpecificStudent(){
        given()
                .baseUri("https://655a860c6981238d054d8d2c.mockapi.io")
                .queryParam("country","Paraguay")
                .queryParam("id",4)
        .when()
                .get("Students")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }

    @Test
    public void getMoreSpecificInfo(){
        HashMap<String,String> queries = new HashMap<>();
        queries.put("country","Italy");
        queries.put("name","Steve Wiegand");
        given()
                .baseUri("https://655a860c6981238d054d8d2c.mockapi.io")
                .queryParams(queries)
        .when()
                .get("Students")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }

}
