package com.afigueredo.legendgame.config;


import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.*;

import java.util.Collections;

import static com.afigueredo.legendgame.constants.LegendGameConstant.ENDPOINT_DYNAMO;
import static com.afigueredo.legendgame.constants.LegendGameConstant.REGION_DYNAMO;

public class LegendGameTable {

  public static void main(String[] args) {

    AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
            .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
            .build();

    DynamoDB dynamoDB = new DynamoDB(client);

    String tableName = "legend_game";

    try {
      System.out.println("Criando tabela, aguarde...");
      Table table = dynamoDB.createTable(tableName,
              Collections.singletonList(new KeySchemaElement("id", KeyType.HASH)
              ),
              Collections.singletonList(new AttributeDefinition("id", ScalarAttributeType.S)
              ),
              new ProvisionedThroughput(5L, 5L));
      table.waitForActive();
      System.out.println("Tabela criada com sucesso " + table.getDescription().getTableStatus());

//    }
//    catch (Exception e) {
//      System.err.println("Não foi possível criar a tabela");
//      System.err.println(e.getMessage());
//    }

      } catch (InterruptedException e) {
        System.err.println("Não foi possível criar a tabela");
        e.printStackTrace();
      }
    }

  }