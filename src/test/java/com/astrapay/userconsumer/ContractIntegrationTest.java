package com.astrapay.userconsumer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureStubRunner
        (ids = {"com.astrapay.user:user-service:+:stubs:8090"},
                stubsMode = StubRunnerProperties.StubsMode.LOCAL)
public class ContractIntegrationTest {


    @Test
    public void getProfile() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserClientDto> responseEntity = restTemplate.getForEntity("http://localhost:8090/user-service/users/200485/profile", UserClientDto.class);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
        UserClientDto hat = responseEntity.getBody();
        assertThat(hat.getName()).isEqualTo("Yugoz");
    }

    @Test
    public void getUserById1() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserClientDto> responseEntity = restTemplate.getForEntity("http://localhost:8090/user-service/users/200481", UserClientDto.class);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
        UserClientDto hat = responseEntity.getBody();
        assertThat(hat.getId()).isEqualTo(200481);
        assertThat(hat.getName()).isEqualTo("testing hotfix");
    }

    @Test
    public void getUsers() {
//        try {
        RestTemplate restTemplate = new RestTemplate();
        ParameterizedTypeReference<Map<Object, Object>> typeRef =
                new ParameterizedTypeReference<Map<Object, Object>>() {};
        ResponseEntity<Map<Object, Object>> responseEntity = restTemplate.exchange("http://localhost:8090/user-service/users",HttpMethod.GET,null, typeRef);


        responseEntity.getBody();
//        }
//        catch (HttpClientErrorException ex) {
//            assertThat(ex.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
//        }
    }


    @Test
    public void getUserBy2() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserClientDto> responseEntity = restTemplate.getForEntity("http://localhost:8090/user-service/users/10002905", UserClientDto.class);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
        UserClientDto hat = responseEntity.getBody();
        assertThat(hat.getId()).isEqualTo(10002905);
    }


}
