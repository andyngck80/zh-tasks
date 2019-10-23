package com.home.electric.controller;

import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(executionPhase = BEFORE_TEST_METHOD, scripts = {"/sql/test-data.sql"})
@Sql(executionPhase = AFTER_TEST_METHOD, scripts = {"/sql/clean-up.sql"})
public class ElectricConsumptionReportControllerIntegrationTest {

    @LocalServerPort
    private int port;

    private String baseUrl;

    @Before
    public void setup() {
        baseUrl = "http://localhost:" + port + "/electric-consumption";
    }

    @Test
    public void testGetReport() {
        given()
                .accept(ContentType.JSON)
                .log().all()
        .when()
                .get(baseUrl + "/report?duration=24h")
                .prettyPeek()
        .then().assertThat()
                .statusCode(HttpStatus.OK.value());
    }
}