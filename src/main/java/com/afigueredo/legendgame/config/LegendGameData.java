package com.afigueredo.legendgame.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;

import static com.afigueredo.legendgame.constants.LegendGameConstant.ENDPOINT_DYNAMO;
import static com.afigueredo.legendgame.constants.LegendGameConstant.REGION_DYNAMO;

public class LegendGameData {
  public static void main(String[] args) {

    AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
            .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
            .build();
    DynamoDB dynamoDB = new DynamoDB(client);

    Table table = dynamoDB.getTable("legend_game");

    Item game1 = new Item()
            .withPrimaryKey("id", "2")
            .withString("game", "Resident Evil")
            .withString("genre", "Survival Horror")
            .withString("franchise", "CAPCOM")
            .withString("title", "Resident Evil 0")
            .withNumber("year_launch", 1996)
            .withNumber("general_titles", 8);

    Item game2 = new Item()
            .withPrimaryKey("id", "3")
            .withString("game", "Resident Evil")
            .withString("genre", "Survival Horror")
            .withString("franchise", "CAPCOM")
            .withString("title", "Resident Evil 2")
            .withNumber("year_launch", 1998)
            .withNumber("general_titles", 8);

    Item game3 = new Item()
            .withPrimaryKey("id", "4")
            .withString("game", "Resident Evil")
            .withString("genre", "Survival Horror")
            .withString("franchise", "CAPCOM")
            .withString("title", "Resident Evil 3 - Nemesis")
            .withNumber("year_launch", 1999)
            .withNumber("general_titles", 8);

    try {
      table.putItem(game1);
      table.putItem(game2);
      table.putItem(game3);

      System.out.println("Dados inseridos com sucesso ");
    } catch (Exception e) {
      System.err.println("Erro ao inserir o Game Legend");
      e.printStackTrace();
    }

  }

}
