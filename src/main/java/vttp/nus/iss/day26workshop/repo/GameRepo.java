package vttp.nus.iss.day26workshop.repo;


import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import vttp.nus.iss.day26workshop.model.Game;

@Repository
public class GameRepo{

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Game> getGamesByName(Integer limit, Integer offset) {
        Query query = new Query();
        query.skip(offset).limit(limit);
        return mongoTemplate.find(query, Document.class, "game")
                            .stream()
                            .map(t -> Game.fromJSON(t))
                            .toList();
        
    }

    public List<Game> getGamesByRank() {
        Query query = new Query();
        query.with(Sort.by(Sort.Direction.ASC, "ranking"));
        return mongoTemplate.find(query, Document.class, "game")
                            .stream()
                            .map(t -> Game.fromJSON(t))
                            .toList();

    }

    public Game getGameByID(Integer gid) {
        Query query = new Query();
        query.addCriteria(Criteria.where("gid").is(gid));
        return mongoTemplate.findOne(query, Game.class, "game");
    }

}