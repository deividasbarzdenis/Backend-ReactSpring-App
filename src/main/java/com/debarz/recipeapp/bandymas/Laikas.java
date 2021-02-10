package com.debarz.recipeapp.bandymas;

import java.util.Date;

public class Laikas {
    public static void main(String[] args){
        Date date = new Date();

        System.out.println(new Date(date.getTime()+7200000));
    }
}
