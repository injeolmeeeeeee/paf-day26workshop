package vttp.nus.iss.day26workshop.model;

import org.bson.Document;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Comment {
    private String user;
    private String text;
    private Integer rating;
    private Integer gid;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    @Override
    public String toString() {
        return "Comment [user= "
                .concat(this.user)
                .concat(", text=")
                .concat(this.text)
                .concat(", rating=")
                .concat("" + this.rating)
                .concat(", score=")
                .concat("" + this.gid)
                .concat("]");
    }

    public static Comment create(Document d) {
        Comment c = new Comment();
        c.setUser(d.getString("user"));
        c.setText(d.getString("c_text"));
        c.setRating(d.getInteger("rating"));
        c.setGid(d.getInteger("gid"));
        return c;
    }

    public JsonObject toJSON() {
        return Json.createObjectBuilder()
                .add("user", getUser())
                .add("c_text", getText())
                .add("rating", getRating())
                .add("gid", getGid())
                .build();
    }

}