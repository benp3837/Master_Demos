package com.revature.models;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;


@Component
@Entity
@Table(name="pokemon")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pokeId;
    private String name;

    private String image;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="userId")
    private User user;

    public Pokemon() {
        super();
    }

    public Pokemon(String name, String image, User user) {
        super();
        this.name = name;
        this.image = image;
        this.user = user;
    }

    public Pokemon(int pokeId, String name, String image, User user) {
        super();
        this.pokeId = pokeId;
        this.name = name;
        this.image = image;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "pokeId=" + pokeId +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", user=" + user +
                '}';
    }
}

