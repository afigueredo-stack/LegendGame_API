package com.afigueredo.legendgame.repository;

import com.afigueredo.legendgame.document.LegendGame;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@EnableScan
public interface LegendGameRepository extends CrudRepository<LegendGame, String>{

}
