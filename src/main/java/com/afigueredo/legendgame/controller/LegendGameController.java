package com.afigueredo.legendgame.controller;

import com.afigueredo.legendgame.document.LegendGame;
import com.afigueredo.legendgame.repository.LegendGameRepository;
import com.afigueredo.legendgame.service.LegendGameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

import static com.afigueredo.legendgame.constants.LegendGameConstant.LEGEND_GAME_ENDPOINT_LOCAL;

@RestController
public class LegendGameController {
  LegendGameService legendGameService;

  LegendGameRepository legendGameRepository;

  private static final Logger log =
    LoggerFactory.getLogger(LegendGameController.class);

  public LegendGameController(LegendGameService legendGameService, LegendGameRepository legendGameRepository) {
    this.legendGameService = legendGameService;
    this.legendGameRepository = legendGameRepository;
  }

  @GetMapping(LEGEND_GAME_ENDPOINT_LOCAL)
  @ResponseStatus(HttpStatus.OK)
  public Flux<LegendGame> getAllItems() {
    log.info("Requisitando todos os títulos de jogos lendários");
    return legendGameService.findAll();
  }

  @GetMapping(LEGEND_GAME_ENDPOINT_LOCAL + "/{id}")
  public Mono<ResponseEntity<LegendGame>> findByIdLegendGame(@PathVariable String id) {
    log.info("Requisitando jogo lendário por id {}", id);
    return legendGameService.findByIdLegendGame(id)
            .map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
            .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping(LEGEND_GAME_ENDPOINT_LOCAL)
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<LegendGame> createLegendGame(@RequestBody LegendGame legendGame) {
    log.info("Criando um novo jogo lendário");

    return legendGameService.save(legendGame);
  }

  @DeleteMapping(LEGEND_GAME_ENDPOINT_LOCAL + "/{id}")
  public Mono<ResponseEntity<String>> deleteByIdLegendGame(@PathVariable String id) {

      log.info("Deletando jogo lendário por id {}", id);

      try {
        legendGameService.deleteByIdLegendGame(id);
        return Mono.just(new ResponseEntity<>("", HttpStatus.OK));
      } catch (Exception e) {
        log.error(e.getMessage());
        return Mono.just(new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
      }

  }

  @PutMapping(LEGEND_GAME_ENDPOINT_LOCAL+ "/{id}")
  @ResponseStatus(code = HttpStatus.OK)
  public Mono<LegendGame> updateByIdLegendGame(@PathVariable String id, @RequestBody LegendGame legendGameUpdate) {
    Optional<LegendGame> legendGameFoundById = this.findByIdForUpdateLegendGame(id);

    if (!legendGameFoundById.isPresent()) {
      log.error("Id {} inexistente", id);
      return null;
    }

    log.info("Atualizando jogo lendário de id {}", id);
    updateLegendGame(legendGameUpdate, legendGameFoundById.get());

    return legendGameService.save(legendGameFoundById.get());
  }

  private void updateLegendGame(LegendGame legendGameUpdate, LegendGame legendGameFound) {
    legendGameFound.setGame(legendGameUpdate.getGame());
    legendGameFound.setFranchise(legendGameUpdate.getFranchise());
    legendGameFound.setGeneralTitles(legendGameUpdate.getGeneralTitles());
    legendGameFound.setGenre(legendGameUpdate.getGenre());
    legendGameFound.setTitle(legendGameUpdate.getTitle());
    legendGameFound.setYearLaunch(legendGameUpdate.getYearLaunch());
  }

  public Optional<LegendGame> findByIdForUpdateLegendGame(String id) {
    log.info("Requisitando jogo lendário por id para atualização {}", id);
    return legendGameService.findByIdIUpdateLegendGame(id);
  }

}
