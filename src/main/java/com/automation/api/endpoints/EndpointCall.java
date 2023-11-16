package com.automation.api.endpoints;

import com.automation.api.BaseApi;
import com.automation.helpers.ServiceUrlProvider;

import static io.restassured.RestAssured.given;

public class EndpointCall extends BaseApi {

    public void makePostCallToService(String param1, String param2){
        String url = ServiceUrlProvider.getEndpointUrl() + "/post";
        serverResponse = given()
                .header("Content-Type", "application/json")
                .relaxedHTTPSValidation()
                .body(String.format("{\"param1\" : \"%s\", \"param1\" : \"%s\"}", param1, param2))
                .when()
                .post(url)
                .then()
                .extract()
                .response();
    }
    public void makeGetCallToService(){
        String url = ServiceUrlProvider.getEndpointUrl() + "/get";
        serverResponse = given()
                .header("Content-Type", "application/json")
                .relaxedHTTPSValidation()
                .when()
                .get(url)
                .then()
                .extract()
                .response();
    }

//    public boolean isPostResponseSchemaValid(){return validateSchema(ServiceResponse.class)}

    public String getResponseDataForGivenField(String fieldName){
        return serverResponse.getBody().jsonPath().getString("Response.Structure" + fieldName)
                .replaceAll("\\p{P}}","");
    }
}
