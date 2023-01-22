import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ChangeMyAccountAddresses {
    String cookieValue = "5645812353C23AC6CA72BFD1205F16B3BB5462973F35A26EFD7E6C557" +
            "A7B5384DDA5B2C2AE612DBC76CC6FA82454E98FCBA65E82ACC6" +
            "0832FE0A496C70F2112F9BC9B4AA44C45C20663E6E0C8DDDC49C650D3B90D37143A76" +
            "02CB5DC63348BCFA8C02418268FBD8D2DC0173C38C10E0256B403C6CCA317A7DF065D" +
            "BAF1DECE81DBEBCFCEB731C3F31460348D8E2A75180225C5FBEBAF6FA00F01C12E740F" +
            "9E7D515F2639758F5C869BCA9BECD782C113;";

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://demowebshop.tricentis.com";
        Configuration.baseUrl = "https://demowebshop.tricentis.com/";
    }


    @Test
    void changeAddress() {
        Map<String, String> keys = new HashMap<>();
        keys.put("Address.Id", "2907532");
        keys.put("Address.FirstName", "change");
        keys.put("Address.LastName", "nametest1234");
        keys.put("Address.Email", "nametest1234@mail.ru");
        keys.put("Address.Company", "Company");
        keys.put("Address.CountryId", "2");
        keys.put("Address.StateProvinceId", "63");
        keys.put("Address.City", "city32");
        keys.put("Address.Address1", "Address3");
        keys.put("Address.Address2", "Address4");
        keys.put("Address.ZipPostalCode", "4324324");
        keys.put("Address.PhoneNumber", "78979756");
        keys.put("Address.FaxNumber", "testFax");


        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookie("NOPCOMMERCE.AUTH", cookieValue)
                .formParams(keys)
                .when()
                .post("/customer/addressedit/2907532")
                .then()
                .statusCode(302)
                .log().all();

    }
}



