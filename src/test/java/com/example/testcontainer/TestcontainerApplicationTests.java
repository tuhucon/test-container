package com.example.testcontainer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.containers.NginxContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootTest
@Testcontainers
class TestcontainerApplicationTests {

//    @Container
//    static NginxContainer<?> nginx = new NginxContainer<>("nginx");

    @Container
    static MySQLContainer<?> mysql = new MySQLContainer<>("mysql:8");

    @DynamicPropertySource
    static void registerMySQLProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mysql::getJdbcUrl);
        registry.add("spring.datasource.username", mysql::getUsername);
        registry.add("spring.datasource.password", mysql::getPassword);
        System.out.println(mysql.getJdbcUrl());
    }


    @Test
    void contextLoads() throws IOException, InterruptedException {
//        var client = HttpClient.newHttpClient();
//        var uri = "http://" + nginx.getHost() + ":" + nginx.getFirstMappedPort();
//
//        var request = HttpRequest.newBuilder(URI.create(uri)).GET().build();
//        var response = client.send(request, HttpResponse.BodyHandlers.ofString());
//
//        Assertions.assertTrue(response.body().contains("Thank you for using nginx."));
    }

}
