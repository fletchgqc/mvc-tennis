package de.codecentric.fletcher.tennis.endpoint;

import de.codecentric.fletcher.tennis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired private UserService userService;

  @GetMapping(value = "/users/{id}", produces = "text/plain; charset=utf-8")
  public String getUser(@PathVariable Integer id) {
    return userService.getUser(id) + "\n";
  }
}
