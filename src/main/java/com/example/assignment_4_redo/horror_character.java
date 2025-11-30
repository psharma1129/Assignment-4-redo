package com.example.assignment_4_redo;

import java.time.LocalDate;


abstract class horror_character
{


    String name;
    int health;
    Vulnerability[] vulnerabilities;
    String type;
    LocalDate date;
    boolean transform;



    /**
     * initialized the variables
     * @param health a integer value for how much health the character has
     * @param name a string for the horror character
     */
    public horror_character(int health, String name,String type, LocalDate date,boolean transform)
    {
        this.health = health;
        this.name = name;
        this.type = type;
        this.date = date;
        this.transform = transform;

    }


    /**
     * a void method meant to be given and overridden by the child classes
     */
    public void attack()
    {

    }
    /**
     * a void method meant to be given and overridden by the child classes
     */
    public void flee()
    {

    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public boolean isTransform() {
        return transform;
    }
    public void setTransform(boolean transform) {
        this.transform = transform;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    @Override
    public String toString() {
        return getName() +"| " + isTransform()+"| " + date + "| " + type;
    }









}
