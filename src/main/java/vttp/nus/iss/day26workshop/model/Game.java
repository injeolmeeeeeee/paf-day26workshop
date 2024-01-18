package vttp.nus.iss.day26workshop.model;

import org.bson.Document;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Game {
    private Integer gid;
    private String name;
    private Integer year;
    private Integer ranking;
    private Integer userRated;
    private String url;
    private String image;

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public Integer getUserRated() {
        return userRated;
    }

    public void setUserRated(Integer userRated) {
        this.userRated = userRated;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    //for logging
    @Override
    public String toString() {
        return "Game [gid= "
                .concat("" + this.gid)
                .concat(", name=")
                .concat(this.name)
                .concat(", year=")
                .concat("" + this.year)
                .concat(", ranking=")
                .concat("" + this.ranking)
                .concat(", usersRated=")
                .concat("" + this.userRated)
                .concat(", url=")
                .concat(this.url)
                .concat(", image=")
                .concat(this.image)
                .concat("]");
    }

    //JSON to Game(object)
    public static Game fromJSON(Document jsonObject) {
        Game game = new Game();
        game.setGid(jsonObject.getInteger("gid"));
        game.setName(jsonObject.getString("name"));
        game.setYear(jsonObject.getInteger("year"));
        game.setRanking(jsonObject.getInteger("ranking"));
        game.setUserRated(jsonObject.getInteger("user_rated"));
        game.setUrl(jsonObject.getString("url"));
        game.setImage(jsonObject.getString("image"));
        return game;
    }

      //Game(object) to JSON
      public JsonObject toJSON() {
        return Json.createObjectBuilder()
                .add("gid", getGid())
                .add("name", getName())
                .add("year", getYear())
                .add("ranking", getRanking())
                .add("user_rated", getUserRated())
                .add("url", getUrl())
                .add("image", getImage())
                .build();
    }
}
