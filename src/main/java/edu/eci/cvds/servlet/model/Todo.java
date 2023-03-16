package main.java.edu.eci.cvds.servlet.model;

public class Todo {
    private int userId;
    private int id;
    private String title;
    private boolean completed;

    public Todo() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int new_user_id) {
        this.userId = new_user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int new_id) {
        this.id = new_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String new_title) {
        this.title = new_title;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean new_completed) {
        this.completed = new_completed;
    }
}
