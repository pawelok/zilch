package api;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ApiTests {

    long maxResponseTimeoutMs = 1000;
    String sampleUiToken = "1571807edab54ec89.1442995705|r=eu-west-1|meta=3|meta_width=335|meta_height=431|metabgclr=transparent|metaiconclr=%23757575|guitextcolor=%23000000|pk=D5264E07-85CF-434C-88E5-6F095A832C01|at=40|ag=101|cdn_url=https%3A%2F%2Fclient-api.arkoselabs.com%2Fcdn%2Ffc|lurl=https%3A%2F%2Faudio-eu-west-1.arkoselabs.com|surl=https%3A%2F%2Fclient-api.arkoselabs.com|smurl=https%3A%2F%2Fclient-api.arkoselabs.com%2Fcdn%2Ffc%2Fassets%2Fstyle-manager";
    String testEmail = "test@test.com";
    String testPassword = "88888888";

    @Test
    public void verifyIfServiceIsOnline() {
        Response res = CreateCustomerApiHelper.postCreateCustomer(testEmail, testPassword, sampleUiToken);
        Assertions.assertAll(
                () -> Assertions.assertFalse(res.statusCode() >= 500, "Server is probably offline. Status: " + res.statusCode()),
                () -> Assertions.assertTrue(res.getTime() <= maxResponseTimeoutMs, "Response was taking longer than " + res.getTime() + "ms")
        );
    }

    @Test
    public void postCreateUserWithIncorrectUiToken() {
        Response res = CreateCustomerApiHelper.postCreateCustomer(testEmail, testPassword, sampleUiToken);
        Assertions.assertAll(
                () -> Assertions.assertEquals(403, res.statusCode()),
                () -> Assertions.assertTrue(res.getTime() <= maxResponseTimeoutMs, "Response was taking longer than " + res.getTime() + "ms")
        );
    }

    @Test
    public void postCreateUserWithEmptyUiToken() {
        Response res = CreateCustomerApiHelper.postCreateCustomer(testEmail, testPassword, "");
        Assertions.assertAll(
                () -> Assertions.assertEquals(403, res.statusCode()),
                () -> Assertions.assertTrue(res.getTime() <= maxResponseTimeoutMs, "Response was taking longer than " + res.getTime() + "ms")
        );
    }
}
