package de.codecentric.fletcher.tennis.endpoint;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import de.codecentric.fletcher.tennis.domain.Racket;
import de.codecentric.fletcher.tennis.service.RacketsService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RacketsController.class)
class RacketsControllerTest {

  @Autowired private MockMvc mvc;

  @MockBean private RacketsService service;

  @Test
  void validRequestShouldReturn200() throws Exception {
    Mockito.when(service.getRackets()).thenReturn(List.of(new Racket(45), new Racket(48)));
    this.mvc
        .perform(get("/rackets").accept(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isOk())
        .andExpect(content().string("[{\"lengthInCm\":45},{\"lengthInCm\":48}]"));
  }
}
