package com.revature.SpringLambda2024.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    public List<String> getItems(){

        //...call DAO method to get items from database
        List<String> items = new ArrayList<>();

        items.add("soup");
        items.add("goop");
        items.add("coop");

        return items;

    }

}
