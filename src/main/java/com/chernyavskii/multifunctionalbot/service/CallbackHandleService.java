package com.chernyavskii.multifunctionalbot.service;

import com.chernyavskii.multifunctionalbot.dto.CallbackDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class CallbackHandleService {

    @Value("${vk.confirmation}")
    private String key;
    @Value("${vk.access-token}")
    private String accessToken;
    @Value("${vk.api-version}")
    private String version;

    private final RestTemplate restTemplate;
    private static final String CONFIRMATION_TYPE = "confirmation";
    private static final String MESSAGE_TYPE = "message_new";

    @Autowired
    public CallbackHandleService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String handleCallback(CallbackDto callbackDto) {
        if (callbackDto.getType().equals(CONFIRMATION_TYPE)) {
            return key;
        } else if (callbackDto.getType().equals(MESSAGE_TYPE)) {
            sendMessage(callbackDto);
            return "ok";
        }
        return "Not supported operation";
    }

    private void sendMessage(CallbackDto message) {
        URI uri = createUri(message);
        restTemplate.postForEntity(uri, null, Object.class);
    }

    public URI createUri(CallbackDto dto) {
        return UriComponentsBuilder.fromHttpUrl("https://api.vk.com/method/messages.send")
                .queryParam("access_token", accessToken)
                .queryParam("v", version)
                .queryParam("peer_id", dto.getObject().get("message").get("peer_id"))
                .queryParam("message", "Вы сказали: " + dto.getObject().get("message").get("text"))
                .queryParam("group_id", dto.getGroupId())
                .queryParam("random_id", dto.getObject().get("message").hashCode())
                .build()
                .toUri();
    }

}
