package com.example.ocpizza.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.List;
@Entity(tableName = "User",
        foreignKeys = @ForeignKey(
                entity = Function.class,
                parentColumns = "id",
                childColumns = "id"))
public class User implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    private String name;

    @NonNull
    private Function function;

    @NonNull
    @PrimaryKey
    private String email;

    @NonNull
    private String password;

    private String address;

    @Nullable
    private List<Pizza> choice;

    public User() {
    }

    public User(@NonNull String name, @NonNull Function function,
                @NonNull String email, @NonNull String password,
                String address, @Nullable List<Pizza> choice) {
        this.name = name;
        this.function = function;
        this.email = email;
        this.password = password;
        this.address = address;
        this.choice = choice;
    }

    protected User(Parcel in) {
        id = in.readInt();
        name = in.readString();
        email = in.readString();
        password = in.readString();
        address = in.readString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public Function getFunction() {
        return function;
    }

    public void setFunction(@NonNull Function function) {
        this.function = function;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Nullable
    public List<Pizza> getChoice() {
        return choice;
    }

    public void setChoice(@Nullable List<Pizza> choice) {
        this.choice = choice;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
    
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(email);
        dest.writeString(password);
        dest.writeString(address);
    }
}
