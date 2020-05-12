package com.bossdga.githubclient.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Class that represents a repo owner
 */
public class Owner {

    @Expose
    @SerializedName("id")
    private int id;
    @Expose
    @SerializedName("login")
    private String login;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}