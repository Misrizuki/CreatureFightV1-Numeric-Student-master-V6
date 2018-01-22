import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Creature here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Creature extends Actor
{
    private HealthBar creatureBar;
    private String type;
    
    private int healthNumber;

    private boolean playerOneCreature;

    /**
     * Default constructor for objects of the Creature class
     * 
     * @param There are no parameters
     * @return an object of the Creature class
     */
    public Creature()
    {
        healthNumber = 500;
        
        playerOneCreature = true;
        
        creatureBar = new HealthBar( healthNumber, healthNumber, 10);
    }

    /**
     * Constructor that allows customization of objects of the Creature class
     * 
     * @param health is the amount of health the Creature object will have
     * @param whichPlayer discusses whether the creature belongs to player 1 or player 2
     * @return an object of the Creature class
     */
    public Creature( int health, boolean isPlayerOne, String creatureType )
    {
        healthNumber = health;
        
        playerOneCreature =  isPlayerOne;
        
        creatureBar = new HealthBar( healthNumber, healthNumber, 10);
        
        type = creatureType;
    }
    
    /**
     * 
     */
    public String getType()
    {
        return type;  
    }
    
    /**
     * getHealthBar gets the creatres healthbar
     * 
     * @param there are not parameters
     * @return the creature's healthbar
     */
    protected HealthBar getHealthBar()
    {
        return creatureBar;
    }
    
    /**
     * getWeatherPlayerOne gets the creature for player one
     * 
     * @param there is no parameters
     * @return playerOneCreature
     */
    public boolean getWhetherPlayerOne()
    {
        return playerOneCreature ;
    }
    
    /**
     * attack is the code that is run when the Creature attacks its enemy
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void attack( int idx )
    {
        //empty method that will get overriden in subclasses
    }
    
    /**
     * attack is the code that is run when the Creature attacks its enemy
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void switchCreature( int idx )
    {
        //empty method that will get overriden in subclasses
    }

    /**
     * attack is the code that is run when the Creature attacks its enemy
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void switchedIn()
    {
        //empty method that will get overriden in subclasses
    }
    
    /**
     * act will complete actions that the Creature object should
     * accomplish while the scenario is running
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void act() 
    {
        //empty method that will get overriden in subclasses
    }   

}
