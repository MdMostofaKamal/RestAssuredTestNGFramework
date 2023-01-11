package com.spotify.oauth2.api;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static com.spotify.oauth2.api.Route.BASE_PATH;

public class SpecBuilder {
    //static String access_token = "BQA5_yy0o5Cmu2ZvAlDF5PREg4gIFCpJCRcwpcm9OT64WXmtpLbgwKHj2Nrit87l0M5deFXPTGBIcYdLcJ-uoCGD5krN-2fvzYJ24w7cpRXbBm6G_8qSiOpoGstjEnokUg8xKl8A8d7bYFq2tVgN3D5_9ZWgRyJw9VLXhGgFqOt34ZKUqpVaIClSE20k6QK2R1GjcsooIsoFcB7tXrU5FK3wr1yacHOA4F5_HKEddkNh23L6pHSDzNDscY-RzPwsWsKfCiygpYHS0KVc";

    public static RequestSpecification getRequestSpec(){
        return new RequestSpecBuilder().
                setBaseUri(System.getProperty("BASE_URI")).
                //setBaseUri("https://api.spotify.com").
                setBasePath(BASE_PATH).
                //addHeader("Authorization","Bearer "+access_token).
                setContentType(ContentType.JSON).
                addFilter(new AllureRestAssured()).
                log(LogDetail.ALL).
                build();

    }

    public static RequestSpecification getAccountRequestSpec(){
        return new RequestSpecBuilder().
                setBaseUri(System.getProperty("ACCOUNT_BASE_URI")).
                //setBaseUri("https://accounts.spotify.com").
                //addHeader("Authorization","Bearer "+access_token).
                setContentType(ContentType.URLENC).
                addFilter(new AllureRestAssured()).
                log(LogDetail.ALL).
                build();

    }
    public static ResponseSpecification getResponseSpec(){
        return new ResponseSpecBuilder().
                //expectContentType(ContentType.JSON).
                log(LogDetail.ALL).
                build();
    }
}
