package tests;

import config.UserConfig;
import models.*;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.Specs.*;

@DisplayName("API tests for reqres.in")
public class ReqresTests {

    static UserConfig config = ConfigFactory.create(UserConfig.class, System.getProperties());
    String userName = config.getUsername();
    String userJobName = config.getJobName();
    String userEmail = config.getEmail();
    String userPassword = config.getPassword();

    @Test
    @DisplayName("Check user id")
    void idUserTest() {
        Integer expectedUserId = 2;

        UserResponse response = step("Make a request", () -> given(requestSpec)
                .when()
                .get("/users/2")
                .then()
                .spec(response200Spec)
                .extract().as(UserResponse.class));

        step("Check expected id", () ->
                assertThat(response.getData().getId()).isEqualTo(expectedUserId));
    }

    @Test
    @DisplayName("Check for non-existent user")
    void userNotFoundTest() {
        BadRequestResponse response = step("Make a request", () -> given(requestSpec)
                .when()
                .get("/users/23")
                .then()
                .spec(response404Spec)
                .extract().as(BadRequestResponse.class));

        step("Check error in the response", () ->
                assertThat(response.getError()).isNull());
    }

    @Test
    @DisplayName("Check user ids")
    void listUserIdsTest() {
        Integer expectedIdOfFirstUser = 7;
        Integer expectedIdOfLastUser = 12;

        UsersResponse response = step("Make a request", () -> given(requestSpec)
                .when()
                .get("/users?page=2")
                .then()
                .spec(response200Spec)
                .extract().as(UsersResponse.class));

        step("Check ID of first user in response", () ->
                assertThat(response.getData().getFirst().getId()).isEqualTo(expectedIdOfFirstUser));

        step("Check ID of last user in response", () ->
                assertThat(response.getData().getLast().getId()).isEqualTo(expectedIdOfLastUser));
    }

    @Test
    @DisplayName("Check user creation")
    void createUserTest() {
        CreateUserBody requestBody = new CreateUserBody();
        requestBody.setName(userName);
        requestBody.setJob(userJobName);

        CreateUserResponse response = step("Make a request", () -> given(requestSpec)
                .body(requestBody)
                .when()
                .post("/users")
                .then()
                .spec(response201Spec)
                .extract().as(CreateUserResponse.class));

        step("Check user name in response", () ->
                assertThat(response.getName()).isEqualTo(userName));

        step("Check user ID in response", () ->
                assertThat(response.getId()).isNotNull());
    }

    @Test
    @DisplayName("Check successful registration")
    void successfulRegisterTest() {
        RegisterBody requestBody = new RegisterBody();
        requestBody.setEmail(userEmail);
        requestBody.setPassword(userPassword);

        RegisterResponse response = step("Make a request", () -> given(requestSpec)
                .body(requestBody)
                .when()
                .post("/register")
                .then()
                .spec(response200Spec)
                .extract().as(RegisterResponse.class));

        step("Check user ID in response", () ->
                assertThat(response.getId()).isNotNull());

        step("Check token in response", () ->
                assertThat(response.getToken()).isNotNull());
    }

    @Test
    @DisplayName("Check failed registration without password")
    void negativeRegisterTest() {
        String expectedResponse = "Missing password";

        RegisterBody requestBody = new RegisterBody();
        requestBody.setEmail(userEmail);

        BadRequestResponse response = step("Make a request", () -> given(requestSpec)
                .body(requestBody)
                .when()
                .post("/register")
                .then()
                .spec(response400Spec)
                .extract().as(BadRequestResponse.class));

        step("Check error in the response", () ->
                assertThat(response.getError()).isEqualTo(expectedResponse));
    }

    @Test
    @DisplayName("Check user deletion")
    void deleteUserTest() {
        step("Check user deletion", () ->
                given(requestSpec)
                        .when()
                        .delete("/users/2")
                        .then()
                        .spec(response204Spec));
    }
}
