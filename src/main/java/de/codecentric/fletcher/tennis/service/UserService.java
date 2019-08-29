package de.codecentric.fletcher.tennis.service;

import de.codecentric.fletcher.tennis.service.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class UserService {
//  public static final String HOSTNAME = "http://jsonplaceholder.typicode.com";
  public static final String HOSTNAME = "http://localhost:5001";

  WebClient webClient;

  public UserService(WebClient.Builder webClientBuilder) {
    this.webClient = webClientBuilder.baseUrl(HOSTNAME).defaultHeader("Host", "jsonplaceholder.typicode.com").build();
  }

  public String getUser(Integer id) {
    return this.webClient.get().uri("/users/{id}", id)
        .retrieve().bodyToMono(User.class).block().getName();
  }
}
