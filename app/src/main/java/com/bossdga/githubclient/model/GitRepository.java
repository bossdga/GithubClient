package com.bossdga.githubclient.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Class that represents a repository
 */
@Entity(tableName = "git_repo")
public class GitRepository {
    @Expose
    @SerializedName("id")
    @PrimaryKey
    @ColumnInfo(name = "id")
    private int id;
    @Expose
    @SerializedName("name")
    @ColumnInfo(name = "name")
    private String name;
    @Expose
    @SerializedName("html_url")
    @ColumnInfo(name = "html_url")
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}