package com.example.assignment_4_redo;
import java.time.LocalDate;
import java.util.Arrays;

public class Werewolf extends horror_character implements Transformable
{
    public boolean Transformed = false;
    /**
     * initialized the variables
     * @param health a integer value for how much health the character has
     * @param name a string for the horror character
     */
    Werewolf(int health, String name,LocalDate date, boolean transform)
    {
        super(health, name,"WereWolf",date,transform);
    }

    /**
     * a boolean method that returns true when called, making the Werewolf turn into a wol explained by string
     * Transformed is a boolean variable that turns true when the object transforms to implement new attacks in wolf state
     */
    @Override
    public boolean transform()
    {
        System.out.println("the beasts takes shape of a wolf");
        Transformed = true;
        return true;

    }

    /**
     * an attack method that when called prints a string
     * if the transformed method is called before the method the attack method will display a different string
     */
    @Override
    public void attack()
    {
        if(Transformed)
        {
            System.out.println("the wolf bites");
        } else
        {
            System.out.println("the beast swipes");
        }
    }
    /**
     * a flee method that when called prints a string
     * if the transformed method is called before the flee method the method will display a different string
     */
    @Override
    public void flee()
    {
        if(Transformed)
        {
            System.out.println("the wolf retreats");
        } else
        {
            System.out.println("the beast retreats");
        }

    }

    /**
     * makes an arraylist that adds the vulnerabilities specific to the class from the vulnerability emum
     */
    Vulnerability[] wolf_weakness =
            {
                    Vulnerability.SILVER,
                    Vulnerability.FIRE
            };

    /**
     * the display info method displays the name, health, and weaknesses of the class
     */
    public void display_info() {
        System.out.println("name: " + name);
        System.out.println("health: " + health);
        System.out.println("Vulnerabilities: " + Arrays.toString(wolf_weakness));

    }





}
