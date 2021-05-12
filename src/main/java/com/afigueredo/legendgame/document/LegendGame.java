package com.afigueredo.legendgame.document;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import org.springframework.data.annotation.Id;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
@DynamoDBTable(tableName ="legend_game")
public class LegendGame {

  @Id
  @DynamoDBHashKey (attributeName = "id")
  private String id;

  @DynamoDBAttribute (attributeName = "game")
  private String game;

  @DynamoDBAttribute (attributeName = "genre")
  private String genre;

  @DynamoDBAttribute (attributeName = "franchise")
  private String franchise;

  @DynamoDBAttribute (attributeName = "title")
  private String title;

  @DynamoDBAttribute (attributeName = "year_launch")
  private int yearLaunch;

  @DynamoDBAttribute (attributeName = "general_titles")
  private int generalTitles;

  public LegendGame(String id, String game, String genre, String franchise, String title, int yearLaunch, int generalTitles) {
    this.id = id;
    this.game = game;
    this.genre = genre;
    this.franchise = franchise;
    this.title = title;
    this.yearLaunch = yearLaunch;
    this.generalTitles = generalTitles;
  }

}
