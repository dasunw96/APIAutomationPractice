package com.api.tests.AuthService;

import com.api.services.AuthService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPasswordTest {

    @Test
    public void forgotPasswordTest(){

        AuthService authService = new AuthService();
        Response response = authService.forgotPassword("dasun@gmail.com");
        Assert.assertEquals(response.getStatusCode(),200);
        response.prettyPrint();
    }
}
