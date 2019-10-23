package com.home.electric.controller;

import com.home.electric.dto.ElectricConsumptionCounterLogDTO;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.UUID;

import static com.home.electric.JsonUtil.toJson;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(executionPhase = BEFORE_TEST_METHOD, scripts = {"/sql/test-data.sql"})
@Sql(executionPhase = AFTER_TEST_METHOD, scripts = {"/sql/clean-up.sql"})
public class ElectricConsumptionControllerIntegrationTest {

    @LocalServerPort
    private int port;

    private String baseUrl;

    @Before
    public void setup() {
        baseUrl = "http://localhost:" + port + "/electric-consumption";
    }

    @Test
    public void testCreateCounter() {
        Long consumerId = 1000L;
        BigDecimal consumption = BigDecimal.valueOf(10000.001);

        given()
                .contentType(ContentType.JSON)
                .body(toJson(newLogDTO(consumerId, consumption)))
                .log().all()
        .when()
                .post(baseUrl + "/counter")
                .prettyPeek()
        .then().assertThat()
                .statusCode(HttpStatus.CREATED.value())
                .body("id", is(notNullValue()));
    }

    private ElectricConsumptionCounterLogDTO newLogDTO(Long id, BigDecimal consumption) {
        return new ElectricConsumptionCounterLogDTO(id, consumption);
    }
}
