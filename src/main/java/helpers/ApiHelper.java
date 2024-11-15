package helpers;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiHelper {

    private static final Logger LOG = LoggerFactory.getLogger(ApiHelper.class);

    // Base URI for the API
    private static final String BASE_URL = "https://api-eu-ew1-prod.payzilch.com";
    private static final String SIGN_UP_ENDPOINT = "/customer-api/auth0/signup";

    private static String uiToken = "1571807edab54ec89.1442995705|r=eu-west-1|meta=3|meta_width=335|meta_height=431|metabgclr=transparent|metaiconclr=%23757575|guitextcolor=%23000000|pk=D5264E07-85CF-434C-88E5-6F095A832C01|at=40|ag=101|cdn_url=https%3A%2F%2Fclient-api.arkoselabs.com%2Fcdn%2Ffc|lurl=https%3A%2F%2Faudio-eu-west-1.arkoselabs.com|surl=https%3A%2F%2Fclient-api.arkoselabs.com|smurl=https%3A%2F%2Fclient-api.arkoselabs.com%2Fcdn%2Ffc%2Fassets%2Fstyle-manager";


    // Set the mobile.base URI for RestAssured requests
    static {
        RestAssured.baseURI = BASE_URL;
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
