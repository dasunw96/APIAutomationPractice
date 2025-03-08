package com.api.tests.AuthService;

import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.services.AuthService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginAPITest {

    @Test
    public void loginTest(){

        LoginRequest loginRequest = new LoginRequest("dasun123","dasun123");
        AuthService authService = new AuthService();
        Response response = authService.login(loginRequest);
        LoginResponse loginResponse = response.as(LoginResponse.class);
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(loginResponse.getUsername(),"dasun123");

    }
}
