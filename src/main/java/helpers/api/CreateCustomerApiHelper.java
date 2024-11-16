package helpers.api;


import configuration.PropertiesReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class CreateCustomerApiHelper {

    private static final Logger LOG = LoggerFactory.getLogger(CreateCustomerApiHelper.class);

    private static final String SIGN_UP_ENDPOINT = "/customer-api/auth0/signup";

    static {
        RestAssured.baseURI = PropertiesReader.getApiBaseUrl();
    }

    public static Response postCreateCustomer(String email, String password, String uiToken) {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("emailId", email);
        requestBody.put("password", password);
        requestBody.put("termsAndConditions", true);
        requestBody.put("newsletter", false);
        requestBody.put("uiToken", uiToken);

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(SIGN_UP_ENDPOINT)
                .then()
                .log().all()
                .extract().response();
        LOG.info("Response status code: {}", response.statusCode());
        return response;
    }
}
