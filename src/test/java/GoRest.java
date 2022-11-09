import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.factory.CreatePostDataFactory;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import model.Post.Request.PostRequest;
import model.Post.Response.PostResponse;
import model.employee.Response.EmployeeResponse;
import model.employee.Resquest.Builder.*;
import model.User.Request.UserRequest;
import model.User.Response.UserResponse;
import model.employee.Resquest.Builder.BuildNewEmployee;
import model.employee.Resquest.Builder.EmployeeRequestBuilder;
import model.employee.Resquest.EmployeeRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GoRest {

    String bearerToken="e99413b1c415ad6d592d5f2bef758493fc68c59188d9274a38219b8fc9cb5c55";
    ObjectMapper objectMapper = new ObjectMapper();
    Build buildUserRequest = new Build();
    EmployeeRequestBuilder employeenew= new BuildNewEmployee();
    EmployeeRequestBuilder employeeFake= new BuildNewEmployeeFake();

    EmployeeResponse responseBodyEmployee;

    PostResponse responseBodyPostEmployee;

    @BeforeEach
    public void setup(){

        RestAssured.baseURI="https://dummy.restapiexample.com";
        RestAssured.basePath="/api/v1/";
        RestAssured.filters(new RequestLoggingFilter(),new ResponseLoggingFilter());
        RestAssured.requestSpecification = new RequestSpecBuilder().setContentType(ContentType.JSON).build();

    }
    @Test
    public void createEmployeeNew() throws JsonProcessingException {
        buildUserRequest.setEmployeeRequestBuilder(employeenew);
        buildUserRequest.buildEmployeeRequest();
        EmployeeRequest employeeRequest = buildUserRequest.getEmployeeRequest();
       String response=
                given()
                        .body(employeeRequest)
                        .header("Authorization",
                                "Bearer " + bearerToken)
                        .when()
                        .post("create")
                        .then()
                        .statusCode(201)
                        .extract().asString();

        responseBodyEmployee = objectMapper.readValue(response, EmployeeResponse.class);
        assertThat(responseBodyEmployee.getData().getName(),equalTo(responseBodyEmployee.getData().getName()));

    }


    @Test
    public void createEmployeeFake() throws JsonProcessingException {
        buildUserRequest.setEmployeeRequestBuilder(employeeFake);
        buildUserRequest.buildEmployeeRequest();
        EmployeeRequest employeeRequest = buildUserRequest.getEmployeeRequest();
        String response=
                given()
                        .body(employeeRequest)
                        .header("Authorization",
                                "Bearer " + bearerToken)
                        .when()
                        .post("create")
                        .then()
                        .statusCode(201)
                        .extract().asString();

        responseBodyEmployee = objectMapper.readValue(response, EmployeeResponse.class);
        assertThat(responseBodyEmployee.getMessage(),equalTo(responseBodyEmployee.getMessage()));

    }

    @Test
    public void createPostHistory() throws JsonProcessingException {
        PostRequest postRequest = new PostRequest.Builder().postResumen().build();
        //String age=5943;
        String response=
                given()
                        .body(postRequest)
                        .header("Authorization",
                                "Bearer " + bearerToken)
                        .when()
                        .post("create")
                        .then()
                        .statusCode(201)
                        .extract().asString();

        responseBodyPostEmployee = objectMapper.readValue(response, PostResponse.class);
        assertThat(responseBodyPostEmployee.getAge(),equalTo("20"));

    }
    @Test
    public void createPostFitcion() throws JsonProcessingException {
        PostRequest postRequest = new PostRequest.Builder().postFitccion().build();
        //Integer idUser=5943;
        String response=
                given()
                        .body(postRequest)
                        .header("Authorization",
                                "Bearer " + bearerToken)
                        .when()
                        .post("create")
                        .then()
                        .statusCode(201)
                        .extract().asString();

        responseBodyPostEmployee = objectMapper.readValue(response, PostResponse.class);
        assertThat(responseBodyPostEmployee.getId(),equalTo(responseBodyEmployee.getData().getId()));

    }

    @Test
    public void createPostFitcionFakeMissingAllInformation() throws JsonProcessingException {
        PostRequest postRequest = CreatePostDataFactory.missingAllinformation();
        //Integer idUser=5943;
        String response=
                given()
                        .body(postRequest)
                        .header("Authorization",
                                "Bearer " + bearerToken)
                        .when()
                        .post("create")
                        .then()
                        .statusCode(422)
                        .extract().asString();

        responseBodyPostEmployee = objectMapper.readValue(response, PostResponse.class);
        assertThat(responseBodyPostEmployee.getSalary(),equalTo(responseBodyEmployee.getData().getSalary()));

    }
    @Test
    public void createPostFitcionFakeNews() throws JsonProcessingException {
        PostRequest postRequest = CreatePostDataFactory.news();
        //Integer idUser=5943;
        String response=
                given()
                        .body(postRequest)
                        .header("Authorization",
                                "Bearer " + bearerToken)
                        .when()
                        .post("create")
                        .then()
                        .statusCode(422)
                        .extract().asString();

        responseBodyPostEmployee = objectMapper.readValue(response, PostResponse.class);
        assertThat(responseBodyPostEmployee.getName(),equalTo(responseBodyEmployee.getData().getName()));

    }
}
