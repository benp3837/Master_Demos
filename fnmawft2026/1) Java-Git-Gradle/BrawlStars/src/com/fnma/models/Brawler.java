package com.fnma.models;

public class Brawler extends Object{

    public String name;
    public String attack;
    public String rarity;


    //one method just for spice
    public void brawl(String emote){
        System.out.println(name + " emotes with " + emote);
        System.out.println(name + " is attacking with " + attack);
        System.out.println(name + " emotes with " + emote);
    }


    //all-args constructor
    public Brawler(String name, String rarity, String attack) {
        this.name = name;
        this.rarity = rarity;
        this.attack = attack;
    }


    //toString() - a method that lets us print out the values of the object
    @Override
    public String toString() {
        return "Brawler{" +
                "name='" + name + '\'' +
                ", attack='" + attack + '\'' +
                ", rarity='" + rarity + '\'' +
                '}';
    }
}
