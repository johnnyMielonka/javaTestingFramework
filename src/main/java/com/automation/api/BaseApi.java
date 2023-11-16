package com.automation.api;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import io.restassured.response.Response;

import java.time.OffsetDateTime;

public class BaseApi {
    protected static Response serverResponse;
    static Gson gsonInstance = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .setPrettyPrinting()
            .registerTypeAdapter(OffsetDateTime.class, (JsonDeserializer<OffsetDateTime>)
                    (json, type, context) -> OffsetDateTime.parse(json.getAsString()))
            .create();

    public static String getResponseBody() {
        return serverResponse.getBody().asString();
    }

    public static int getStatusCode() {
        return serverResponse.getStatusCode();
    }

    protected static boolean validateSchema(Class c) {
        boolean result = true;
        try {
            gsonInstance.fromJson(getResponseBody(), c);
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }
}
