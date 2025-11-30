package com.example.assignment_4_redo;
import java.time.LocalDate;
import java.util.Arrays;

public class Zombie extends horror_character
{
    /**
     * initialized the variables
     * @param health a integer value for how much health the character has
     * @param name a string for the horror character
     */
    Zombie(int health,String name,LocalDate date,boolean transform)
    {
        super(health,name,"Zombie", date,transform);
    }

    /**
     * an attack method that when called prints a string
     * if the transformed method is called before the method the attack method will display a different string
     */
    @Override
    public void attack()
    {
        System.out.println("the zombie strikes");
    }

    /**
     * a flee method that when called prints a string
     * if the transformed method is called before the flee method the method will display a different string
     */
    @Override
    public void flee()
    {
        System.out.println("the zombie falls back");
    }

    /**
     * makes an arraylist that adds the vulnerabilities specific to the class from the vulnerability emum
     */
    Vulnerability[] zom_weakness =
            {
                    Vulnerability.FIRE,
                    Vulnerability.HOLYWATER
            };

    /**
     * the display info method displays the name, health, and weaknesses of the class
     */
    public void display_info()
    {
        System.out.println("name: " + name);
        System.out.println("health: " + health);
        System.out.println("Vulnerabilities: " + Arrays.toString(zom_weakness));

    }

}
