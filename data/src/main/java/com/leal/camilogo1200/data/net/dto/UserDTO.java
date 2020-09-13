
package com.leal.camilogo1200.data.net.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class UserDTO implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("createdDate")
    @Expose
    private String createdDate;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("birthday")
    @Expose
    private String birthday;
    @SerializedName("photo")
    @Expose
    private String photo;
    private final static long serialVersionUID = -3570433245102323912L;

    /**
     * No args constructor for use in serialization
     */
    public UserDTO() {
    }

    /**
     * @param birthday
     * @param createdDate
     * @param name
     * @param photo
     * @param id
     */
    public UserDTO(Integer id, String createdDate, String name, String birthday, String photo) {
        super();
        this.id = id;
        this.createdDate = createdDate;
        this.name = name;
        this.birthday = birthday;
        this.photo = photo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @NotNull
    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", createdDate='" + createdDate + '\'' +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
