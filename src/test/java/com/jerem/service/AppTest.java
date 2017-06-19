package com.jerem.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AppTest {

    private static final Logger log = LoggerFactory.getLogger(AppTest.class);

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() {
        ResponseEntity<String> entity = this.restTemplate.getForEntity("/", String.class);
        log.info(entity.getStatusCode() + " : " + entity.getBody());
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);

        entity = this.restTemplate.getForEntity("/people", String.class);
        log.info(entity.getStatusCode() + " : " + entity.getBody());
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);

        // TODO : check the post
        entity = this.restTemplate.postForEntity("/people", new Customer("Toto", "Titi"), String.class);
        log.info(entity.getStatusCode() + " : " + entity.getBody());
        // assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);

        entity = this.restTemplate.getForEntity("/people/1", String.class);
        log.info(entity.getStatusCode() + " : " + entity.getBody());
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}
