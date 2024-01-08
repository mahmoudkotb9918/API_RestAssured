package Scenarios;

import io.restassured.http.Header;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class GetInfo {
    @Test
    public void GetallStudentsInfo(){
        given()
                .baseUri("https://655a860c6981238d054d8d2c.mockapi.io")
        .when()
                .get("Students")
        .then()
                .log().all()
                .assertThat().statusCode(200);
    }

    @Test
    public void GetSpecificStudentInfo(){
        given()
                .baseUri("https://655a860c6981238d054d8d2c.mockapi.io")
                .header("country","Italy")
        .when()
                .get("Students/2")
        .then()
                .log().all()
                .assertThat().statusCode(200)
        ;
    }

    @Test
    public void GetAnotherSpecificInfo(){
        Header headerType = new Header("country","Italy");

        given().baseUri("https://655a860c6981238d054d8d2c.mockapi.io")
                .header(headerType)
        .when()
                .get("Students/3")
        .then()
                .log().all()
                .assertThat().statusCode(200)
                ;
    }

    @Test
    public void GetAnotherSpecificInfo2(){
        HashMap<String,String> infoHeader = new HashMap<>();
        infoHeader.put("country","Italy");
        infoHeader.put("name","Dianne Adams");

        given()
                .baseUri("https://655a860c6981238d054d8d2c.mockapi.io")
                .headers(infoHeader)
        .when()
                .get("Students")
        .then()
                .log().all()
                .assertThat().statusCode(200);

    }


}
