package com.revature.models.DTOs;

//This DTO will send pokemon with just pokeId, name, image, and userId (instead of User)
//UserId is especially important, since the User object has a List of Pokemon objects
//That can cause ugly recursive issues if we don't use this DTO
public class OutgoingPokeDTO {

    private int pokeId;
    private String name;
    private String image;
    private int userId;

    public OutgoingPokeDTO() {
        super();
    }

    public OutgoingPokeDTO(int pokeId, String name, String image, int userId) {
        this.pokeId = pokeId;
        this.name = name;
        this.image = image;
        this.userId = userId;
    }

    public int getPokeId() {
        return pokeId;
    }

    public void setPokeId(int pokeId) {
        this.pokeId = pokeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "OutgoingPokeDTO{" +
                "pokeId=" + pokeId +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", userId=" + userId +
                '}';
    }
}
