package com.fnma;

import com.fnma.models.Brawler;

import java.util.*;

import static java.lang.Integer.valueOf;

/*This app will walk through the different Collection types and some of their concrete classes*/
public class Main {

    public static void main(String[] args) {

        System.out.println("================(Lists)");

        //Lists are the most "Array-ish" Collection
        //Ordered (by insertion), have indexes, no special behaviors/restrictions like a Set/Queue

        //ArrayList is probably the most Array-ish of them all
        ArrayList<Brawler> brawlerList = new ArrayList<>();

        //Add some brawlers to the List
        brawlerList.add(new Brawler("El Primo", "Rare", "Piledriver"));
        brawlerList.add(new Brawler("El Primo", "Rare", "Piledriver")); //duplicate
        brawlerList.add(new Brawler("Surge", "Rare", "Zap"));
        brawlerList.add(new Brawler("Edgar", "Epic", "Punch"));
        brawlerList.add(new Brawler("Mortis", "Mythic", "STAB you!!!!"));

        //Let's try to print out the ArrayList -
        //It's all memory addresses... UNTIL we @Override the toString method
        System.out.println(brawlerList);

        //Some List methods--------------

        //Getting values out of a List is very simple - get()
        System.out.println("Our first brawler is: " + brawlerList.get(0)); //can also use getFirst();

        //Getting the size of ArrayList is also simple - size()
        System.out.println("We have " + brawlerList.size() + " brawlers");

        //forEach() that does some logic FOR EACH value in the List
        brawlerList.forEach(brawler -> brawler.brawl("their emote"));

        /*What is that "arrow" syntax? ->

        This is called a Lambda, it's like a shorthand method
        They're good for throwaway one time use logic that you don't want to dedicate much space to */

        //Uh oh one Brawler died...

        System.out.println("================(Sets)");

        //Sets have all the methods of Collection, of course
        //But they're unordered, and unindexed. So it's a little harder to get individual values
        //Also they don't allow duplicates

        HashSet<Brawler> brawlerSet = new HashSet<>();

        brawlerSet.add(new Brawler("El Primo", "Rare", "Piledriver"));
        brawlerSet.add(new Brawler("El Primo", "Rare", "Piledriver")); //duplicate???
        brawlerSet.add(new Brawler("Surge", "Rare", "Zap"));
        brawlerSet.add(new Brawler("Edgar", "Epic", "Punch"));
        brawlerSet.add(new Brawler("Mortis", "Mythic", "STAB you!!!!"));

        //Instantiate a new Brawler to demo the no-duplicates behavior
        Brawler b = new Brawler("Clancy", "Mythic", "Paurnch");

        brawlerSet.add(b);
        brawlerSet.add(b);

        //Print out the set using an enhanced for, just for variety
        for(Brawler brawler : brawlerSet){
            System.out.println(brawler);
        }

        //Since Sets are unordered/unindexed, we can't get them by index
        //brawlerSet.get(0); <- Doesn't exist!

        //BUT we can make an iterator out of the Set
        Iterator<Brawler> brawlerIterator = brawlerSet.iterator();

        //Now we can now do stuff like remove elements in a loop! (Sets don't let you do that)
        while(brawlerIterator.hasNext()){
            if (brawlerIterator.next().rarity.equals("Rare")) {
                brawlerIterator.remove();
            }
        }
        //Trying this in a Set would throw a ConcurrentModificationException

        System.out.println("================(Queues)");

        //Instantiate a LinkedList - These implement List AND Queue
        LinkedList<Brawler> brawlerQueue = new LinkedList<>();

        //For the most part, queues are like lists, but they're FIFO First in, first out
        //We can only access and/or remove the first element. It's like a real-life line/queue!

        brawlerQueue.add(new Brawler("El Primo", "Rare", "Piledriver"));
        brawlerQueue.add(new Brawler("El Primo", "Rare", "Piledriver")); //duplicate
        brawlerQueue.add(new Brawler("Surge", "Rare", "Zap"));
        brawlerQueue.add(new Brawler("Edgar", "Epic", "Punch"));
        brawlerQueue.add(new Brawler("Mortis", "Mythic", "STAB you!!!!"));

        //2 methods you should know for queues -
            //peek() lets us view the first element
            //poll() lets us view the first element AND remove it

        System.out.println(brawlerQueue.peek()); //JUST access, don't remove
        System.out.println(brawlerQueue.poll()); //access, AND remove

        System.out.println(brawlerQueue); //the 1st El Primo is gone!

        //LinkedList is a slightly special case, since it also implements List
        //So it's a litttttle more flexible than purebred queues

        System.out.println("================(Maps - Not technically a Collection)");

        //Instantiate a HashMap to store Players of BrawlStars - Integer Key and String Value
        HashMap<Integer, String> players = new HashMap<>();

        //.put() adds elements to the Map
        players.put(1, "Jonah");
        players.put(2, "Robert");
        players.put(3, "Kush");

        System.out.println("The Players are: " + players);


    }

}
