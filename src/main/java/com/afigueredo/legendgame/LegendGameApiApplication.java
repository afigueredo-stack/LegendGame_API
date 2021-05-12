package com.afigueredo.legendgame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;

import static com.afigueredo.legendgame.constants.LegendGameConstant.*;

@SpringBootApplication
@EnableDynamoDBRepositories
public class LegendGameApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(LegendGameApiApplication.class, args);
    System.out.println("Gerenciador de Jogos Lendários com WebFlux - Endpoint: " + LEGEND_GAME_BASEURL + LEGEND_GAME_ENDPOINT_LOCAL);
  }

}

