package com.astrapay.userconsumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserClient {

    @Value("${producer.port}")
    private Integer producerPort;
    private final RestTemplate restTemplate;

    UserClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public UserClientDto getUserById(Long id){

        ResponseEntity<UserClientDto> responseEntity =
                restTemplate.exchange("http://localhost:"+producerPort+"/user-service/users/"+id, HttpMethod.GET, null, UserClientDto.class);

        return responseEntity.getBody();
    }

}
