package com.api.tests.userManagementService;

import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import com.api.services.AuthService;
import com.api.services.UserManagementService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class UpdateProfileTest {


    @Test
    public void updateProfile(){
        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("dasun123","dasun123"));
        LoginResponse loginResponse = response.as(LoginResponse.class);
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(loginResponse.getUsername(),"dasun123");

        UserManagementService userManagementService = new UserManagementService();
        ProfileRequest payload = new ProfileRequest.Builder()
                .firstName("dasun11")
                .lastName("weda")
                .email("dasun@yahoo.com")
                .mobileNumber("0123456789")
                .build();
        Response response1 = userManagementService.updateProfile(loginResponse.getToken(),payload);
        UserProfileResponse userProfileResponse = response1.as(UserProfileResponse.class);
        Assert.assertEquals(response1.getStatusCode(),200);
        Assert.assertEquals(userProfileResponse.getEmail(),"dasun@yahoo.com");


    }


}
