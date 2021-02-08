package com.example.kotlinflow.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

@Entity
public class Customer {
    @ColumnInfo
    @SerializedName("id")
    int id;

    @ColumnInfo
    @SerializedName("name")
    String name= "";

    @PrimaryKey
    @NotNull
    @SerializedName("email")
    String email;

    @ColumnInfo
    @SerializedName("avatar")
    String avatar= "";

    public int getId()
    {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
