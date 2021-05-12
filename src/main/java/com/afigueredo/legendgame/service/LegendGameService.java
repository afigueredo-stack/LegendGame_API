package com.afigueredo.legendgame.service;

import com.afigueredo.legendgame.document.LegendGame;
import com.afigueredo.legendgame.repository.LegendGameRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;


@Service
public class LegendGameService {
  private final LegendGameRepository legendGameRepository;

  public LegendGameService(LegendGameRepository legendGameRepository) {
    this.legendGameRepository = legendGameRepository;
  }

  public Flux<LegendGame> findAll(){
    return Flux.fromIterable(this.legendGameRepository.findAll());
  }

  public Mono<LegendGame> findByIdLegendGame(String id){
    return Mono.justOrEmpty(this.legendGameRepository.findById(id));
  }

  public Optional<LegendGame> findByIdIUpdateLegendGame(String id){

    return this.legendGameRepository.findById(id);
  }

  public Mono<LegendGame> save(LegendGame legendGame){
    return Mono.justOrEmpty(this.legendGameRepository.save(legendGame));
  }

  public void deleteByIdLegendGame(String id) {
      legendGameRepository.deleteById(id);
  }

}
