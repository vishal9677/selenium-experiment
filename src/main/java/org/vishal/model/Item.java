package org.vishal.model;

import java.util.List;

public class Item {
    private List<String> aboutItem;

    private final String BULLETIN_UNICODE="\u2022";

    public Item(List<String> aboutItem) {
        this.aboutItem = aboutItem;
    }

    public void printItemInfo(){
        System.out.println("\n===============   ABOUT ITEM  ===============");
        aboutItem.stream().map(BULLETIN_UNICODE::concat).forEach(System.out::println);
        System.out.println("===============   ABOUT ITEM  ===============\n");
    }

    public Item and(){
        return this;
    }
}
