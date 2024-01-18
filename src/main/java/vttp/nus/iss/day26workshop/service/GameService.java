package vttp.nus.iss.day26workshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp.nus.iss.day26workshop.model.Game;
import vttp.nus.iss.day26workshop.repo.GameRepo;

@Service
public class GameService {

    @Autowired
    GameRepo gameRepo;
    
    public List<Game> getAllGames(Integer limit, Integer offset) {
        return gameRepo.getGamesByName(limit, offset);
    }

    public List<Game> getGamesByRank() {
        return gameRepo.getGamesByRank();
    }

    public Game getGameByID(Integer gid) {
        return gameRepo.getGameByID(gid);
    }
}
