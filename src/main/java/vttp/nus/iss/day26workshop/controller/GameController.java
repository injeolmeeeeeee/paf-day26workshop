package vttp.nus.iss.day26workshop.controller;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import vttp.nus.iss.day26workshop.model.Game;
import vttp.nus.iss.day26workshop.model.Games;
import vttp.nus.iss.day26workshop.service.GameService;

@RestController
public class GameController {

    @Autowired
    GameService gameService;

    @GetMapping("/games")
    public ResponseEntity<String> getAllGames(@RequestParam Integer limit, @RequestParam Integer offset) {
        
        List<Game> allGames = gameService.getAllGames(limit, offset);

        JsonObject result = null;
        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
        Games games = new Games();

        games.setGames(allGames);
        games.setLimit(limit);
        games.setOffset(offset);
        games.setTimestamp(DateTime.now());
        games.setTotal(allGames.size());

        jsonObjectBuilder.add("ggdb", games.toJSON());
        result = jsonObjectBuilder.build();
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result.toString());
    }

    @GetMapping("/games/rank")
    public ResponseEntity<String> getGamesByRank(@RequestParam Integer limit, @RequestParam Integer offset) {
        List<Game> allGames = gameService.getGamesByRank();
        JsonObject result = null;
        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
        Games games = new Games();

        games.setGames(allGames);
        games.setLimit(limit);
        games.setOffset(offset);
        games.setTimestamp(DateTime.now());
        games.setTotal(allGames.size());

        jsonObjectBuilder.add("ggdb", games.toJSON());
        result = jsonObjectBuilder.build();
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result.toString());
    }

    @GetMapping("/games/{gameID}>")
    public ResponseEntity<String> getGamesByID(Integer gid) {
        Game game = new Game();
        game = gameService.getGameByID(gid);

        JsonObject result = null;
        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();

        jsonObjectBuilder.add("game", game.toJSON());
        result = jsonObjectBuilder.build();
        return ResponseEntity
            .status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(result.toString());
    }
    
}