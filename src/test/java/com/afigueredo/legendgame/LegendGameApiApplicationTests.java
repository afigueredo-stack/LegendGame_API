package com.afigueredo.legendgame;

import com.afigueredo.legendgame.constants.LegendGameConstant;
import com.afigueredo.legendgame.repository.LegendGameRepository;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;


@RunWith(SpringRunner.class)
@DirtiesContext
@AutoConfigureWebTestClient
@SpringBootTest
public class LegendGameApiApplicationTests {

  @Autowired
  WebTestClient webTestClient;

  @Autowired
  LegendGameRepository legendGameRepository;


  @Test
  public void getOneLegendGameById(){

    webTestClient.get().uri(LegendGameConstant.LEGEND_GAME_ENDPOINT_LOCAL.concat("/{id}"),"2")
      .exchange()
      .expectStatus().isOk()
      .expectBody();
  }

  @Test
  public void getOneLegendGameNotFound(){

    webTestClient.get().uri(LegendGameConstant.LEGEND_GAME_ENDPOINT_LOCAL.concat("/{id}"),"10")
      .exchange()
      .expectStatus().isNotFound();
  }

  @Test
  public void deleteLegendGame(){
    webTestClient.delete().uri(LegendGameConstant.LEGEND_GAME_ENDPOINT_LOCAL.concat("/{id}"),"1")
      .accept(MediaType.APPLICATION_JSON)
      .exchange()
      .expectStatus().isNotFound()
      .expectBody();
  }

}
