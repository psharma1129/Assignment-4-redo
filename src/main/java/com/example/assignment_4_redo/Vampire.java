package com.example.assignment_4_redo;
import java.time.LocalDate;
import java.util.Arrays;

public class Vampire extends horror_character implements Transformable
{
    public boolean Transformed = false;

    /**
     * initialized the variables
     * @param health a integer value for how much health the character has
     * @param name a string for the horror character
     */
    Vampire(int health,String name,LocalDate date,boolean transform)
    {
        super(health,name,"Vampire",date,transform);
    }

    /**
     * makes an arraylist that adds the vulnerabilities specific to the class from the vulnerability emum
     */
             Vulnerability[] vamp_weakness =
            {
                    Vulnerability.HOLYWATER,
                    Vulnerability.SUNLIGHT
            };

    /**
     * a boolean method that returns true when called, making the vampire turn into a bat explained by string
     * Transformed is a boolean variable that turns true when the object transforms to implement new attacks in bat state
     */
    @Override
    public boolean transform()
    {
        System.out.println("the vampire shape shifts as a bat ");
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
            System.out.println("BAT ATTACK");
        }else
        {
            System.out.println("the vampire bites");
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
            System.out.println("the bat flies away");
        }else
        {
            System.out.println("the vampire vanishes");
        }
        }

    /**
     * the display info method displays the name, health, and weaknesses of the class
     */
    public void display_info()
        {
            System.out.println("name: " + name);
            System.out.println("health: " + health);
            System.out.println("Vulnerabilities: " + Arrays.toString(vamp_weakness));

        }


}
