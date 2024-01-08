package Scenarios;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;
import org.testng.annotations.Test;

public class e2e {
    @Test
    public void test1(){
        given().baseUri("https://6557ec35bd4bcef8b6134053.mockapi.io")
                .when().get("Students")
                .then().log().all()
                .assertThat().statusCode(200)       //status code assertion

    ;}
    @Test
    public void test2(){
        given().baseUri("https://6557ec35bd4bcef8b6134053.mockapi.io")
                .when().get("Students")
                .then()
                .assertThat().body("[0].Fname", equalTo("Roslyn"))     // body assertion equal to
                .assertThat().body("Fname", hasItem("Joanne"))                // body assertion has Item
                .assertThat().body("Fname",not(hasItem("Ali")))             // body assertion NOT has Item
                /*.assertThat().body("[0]Fname",contains("Roslyn"))         // body assertion contains Items
                .assertThat().body("[0]Fname",containsInAnyOrder("Roslyn"))   // body assertion contains Items
                .assertThat().body("Fname",not(empty()))                // body assertion NOT empty
                .assertThat().body("Fname",hasSize(2))                   // body assertion has size
                .assertThat().body("Fname.size()",equalTo(2))   // body assertion has size*/
    ;}
    @Test
    public void test3(){
        given().baseUri("https://6557ec35bd4bcef8b6134053.mockapi.io")
                .when().get("Students")
                .then()
                .assertThat().body("[0]",hasKey("Fname"))               //body assertion has key
                .assertThat().body("[0]",hasValue("Roslyn"))               //body assertion has value
                .assertThat().body("[0]",hasEntry("Fname","Roslyn"))               //body assertion has entry( key+value)

        ;}

    @Test
    public void test4(){
        Response res = given().baseUri("https://6557ec35bd4bcef8b6134053.mockapi.io")
                .when().get(("Students"))
                .then().extract().response() ;      // extract all response
        String name = res.path("[0].Fname");        //extract name of 1st student
        System.out.println("all response is : "+res);     // print response on console
        System.out.println(("first student name is : "+name));      //print 1st student name
    }

    @Test
    public void test5(){
//        given().baseUri("https://6557ec35bd4bcef8b6134053.mockapi.io").log().all()     // get all request data
//                .when().get("Students")
//                .then().log().all();                                             // get all response data
//        given().baseUri("https://6557ec35bd4bcef8b6134053.mockapi.io").log().method()     // get request method
//                .when().get("Students")
//                .then().log().status();                                             // get status response
//        given().baseUri("https://6557ec35bd4bcef8b6134053.mockapi.io")
//                .when().get("Students")
//                .then().log().ifError();                // get all logs if there is an error
        given().baseUri("https://6557ec35bd4bcef8b6134053.mockapi.io")
                .when().get("Students")
                .then().log().ifValidationFails()       // get response data in case of next body assertion fails
                .body("[0].Fname",equalTo("Roslyn"));
    }

}
