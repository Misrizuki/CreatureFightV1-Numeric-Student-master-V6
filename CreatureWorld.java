import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import javax.swing.JOptionPane;
import java.util.List;

/**
 * Write a description of class MyWorld here.
 * 
 * /**
 * Name: Saraya Chmilowsky
 * Course: CS20S
 * Teacher: Mr. Hardman
 * Lab #5, Program #1
 * Date Last Modified: 10:50 AM 1/17/2018
 * 
 * Mark: 1/5
 * -0.5 Mark: Did not update comment for Lab 3
 * -1 Mark: Broken program 
 * (forgot to change turnNumber and related methods to booleans)
 * -0.5 Mark: Button should not be included in this assignment
 * -1 Mark: Indentation issues
 * -1 Mark: Some variables do not follow camelCase
 *
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CreatureWorld extends World
{
    private String playerOneCreature;
    private String playerTwoCreature;

    private Creature[] playerOneCreatures;
    private Creature[] playerTwoCreatures;

    //Should be boolean
    private boolean turnNumber;

    private boolean playerOneTurn;
    private boolean start;
    private boolean playerOneMenusAdded;
    private boolean playerTwoMenusAdded;

    private String playerOneName;
    private String playerTwoName;

    private Menu oneFightMenu;
    private Menu oneSwitchMenu;
    private Menu twoFightMenu;
    private Menu twoSwitchMenu;

    /**
     * Default constructor for objects of class MyWorld.
     * 
     * @param There are no parameters
     * @return an object of class MyWorld
     */
    public CreatureWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(400, 400, 1);

        playerOneCreatures = new Creature[] { new Charmander(this), new Golem(this), new Ivysaur(this) };

        playerTwoCreatures = new Creature[] { new Pikachu(this), new Lapras(this), new Pidgeot(this) };

        prepareCreatures();

        start = true;

        playerOneCreature = "Charmander";
        playerTwoCreature = "Pikachu";

        Greenfoot.start();
    }

    /**
     * getTurnNumber change between the players
     * 
     * @param is the new, user-chosen current value
     * @return an boolean representing playerOnes's turn
     */
    public boolean getTurnNumber()
    {
        //Indentation issue
        return playerOneTurn;     
    }

    /**
     * setTurnNumer sets players turn number
     * 
     * @param is the new, user-chosen current value
     * @return an boolean representing turn value
     */
    public boolean setTurnNumber( boolean turn )
    {
        playerOneTurn = turn;
        return turn;
    }

    /**
     * prepareCreatures perpares players creature
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void prepareCreatures()
    {

        for ( int i = 0; i < playerOneCreatures.length; i++ )
        {
            if( i == 0)
            {
                addObject( playerOneCreatures[i], playerOneCreatures[i].getImage().getWidth()/2, getHeight() - playerOneCreatures[i].getImage().getHeight()/2 );
            }
            else
            {
                playerOneCreatures[i].getImage().setTransparency(0);
                addObject( playerOneCreatures[i], 0, getHeight() - playerOneCreatures[i].getImage().getHeight()/2 );
            }
        }

        for ( int j = 0; j < playerTwoCreatures.length; j++ )
        {
            if( j == 0)
            {
                addObject( playerTwoCreatures[j], getWidth() - playerTwoCreatures[j].getImage().getWidth()/2, playerTwoCreatures[j].getImage().getHeight()/2 );
            }
            else
            {
                playerTwoCreatures[j].getImage().setTransparency(0);
                addObject( playerTwoCreatures[j], getWidth(), playerTwoCreatures[j].getImage().getHeight()/2 );
            }

        }

    }

    /**
     * getPlayerOne set playerOne's current creature
     * 
     * @param There are no parameters
     * @return playerOne's current creature
     */
    public Creature getPlayerOne()
    {      
        Creature currentPlayerOne;

        if( playerOneCreature.equalsIgnoreCase("Charmander"))
        {
            currentPlayerOne = playerOneCreatures[0];   
        }
        else if (playerOneCreature.equalsIgnoreCase("Golem"))
        {
            currentPlayerOne = playerOneCreatures[1];  
        }
        else
        {
            currentPlayerOne = playerOneCreatures[2];
        }
        return currentPlayerOne;
    }

    /**
     * getPlayerTwo set playerTwo's current creature
     * 
     * @param There are no parameters
     * @return playerTwo's current creature
     */
    public Creature getPlayerTwo()
    {
        Creature currentPlayerTwo;

        if( playerTwoCreature.equalsIgnoreCase("Pikachu"))
        {
            currentPlayerTwo = playerTwoCreatures[0];   
        }
        else if (playerTwoCreature.equalsIgnoreCase("Lapras"))
        {
            currentPlayerTwo = playerTwoCreatures[1];  
        }
        else
        {
            currentPlayerTwo = playerTwoCreatures[2];
        }
        return currentPlayerTwo;
    }

    /**
     * changeplayerOne changing the players creature
     * 
     * @param creatures
     * @return there is no return
     */
    public void changePlayerOne(String creature)
    {
        playerOneCreature = creature;
        removeObject (oneFightMenu);
        removeObject (oneSwitchMenu);
        playerOneMenusAdded = false;
    }

    /**
     * changeplayerTwo changing the players creature
     * 
     * @param There are no parameters
     * @return there is no return
     */
    public void changePlayerTwo(String creature)
    {
        playerTwoCreature = creature;
        removeObject (twoFightMenu);
        removeObject (twoSwitchMenu);
        playerTwoMenusAdded = false;
    }

    /**
     * getNewOneCreature sets new creature to player one
     * 
     * @param index list of playerOne's creatures
     * @return an int representing playerOnes' new creature
     */
    public Creature getNewOneCreature(int index)
    {
        return playerOneCreatures[index];       
    }

    /**
     * getNewOneCreature sets new creature to player one
     * 
     * @param index list of playTwo's creatures
     * @return an int representing playerOnes' new creature
     */
    public Creature getNewTwoCreature(int index)
    {
        return playerTwoCreatures[index];       
    }

    /**
     * act will complete actions that the CreatureWorld object should
     * accomplish while the scenario is running
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void act()
    {
        List allObjects = getObjects(null);
        boolean playerOneLose = true;
        boolean playerTwoLose = true;

        if (start == true )
        {
            //Indentation issues
            playerOneName = JOptionPane.showInputDialog( "Player One, please enter your name:", null );
            playerTwoName = JOptionPane.showInputDialog( "Player Two, please enter your name:", null );
            
            start = false;
            playerOneTurn = true;
        }
        else if(playerOneTurn == true )
        {
            showText(playerOneName + "'s turn",getWidth()/2,getHeight()/2);

            showText("",getWidth()/2,getHeight()/2 + 26);
        }
        else
        {
            showText(playerTwoName + "'s turn",getWidth()/2,getHeight()/2);

            showText("",getWidth()/2,getHeight()/2 + 26);  
        }

        if( playerOneMenusAdded == false )
        {
            if(playerOneCreature == "Charmander")
            {
                oneFightMenu = new Menu( " Fight ", " Scratch \n Flamethrower ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands());
                oneSwitchMenu = new Menu(" Switch ", " Golem \n Ivysaur ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands());
            }
            else if( playerOneCreature == "Golem")
            {
                oneFightMenu = new Menu( " Fight ", " Tackle \n Earthquake ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands());
                oneSwitchMenu = new Menu(" Switch ", " Charmander \n Ivysaur ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands());
            }
            else
            {
                oneFightMenu = new Menu( " Fight ", " Tackle \n RazorLeaf ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands());
                oneSwitchMenu = new Menu(" Switch ", " Charmander \n Golem ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands());
            }

            addObject(oneFightMenu, 177, getHeight() - 100 );
            addObject(oneSwitchMenu, 241, getHeight() - 100);
            playerOneMenusAdded = true;
        }

        if( playerTwoMenusAdded == false)
        {
            if(playerTwoCreature == "Pikachu")
            {
                twoFightMenu = new Menu( " Fight ", " Tackle \n Thunderbolt ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands());
                twoSwitchMenu = new Menu(" Switch ", " Laparas \n Pidgeot ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands());
            }               
            else if( playerTwoCreature == "Lapras")
            {
                twoFightMenu = new Menu( " Fight ", " Tackle \n Hydro Pump ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands());
                twoSwitchMenu = new Menu(" Switch ", " Pikachu \n Pidgeot ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands());
            }
            else
            {
                twoFightMenu = new Menu( " Fight ", " Tackle \n Wing Attack ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands());
                twoSwitchMenu = new Menu(" Switch ", " Laparas \n Pikachu  ", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands());
            }

            addObject(twoFightMenu, 135, 75);
            addObject(twoSwitchMenu, 199, 75);
            playerTwoMenusAdded = true;  
        }

        for( int i = 0; playerOneLose == true &&i <playerOneCreatures.length; i++)
        {

            if(playerOneCreatures[i].getHealthBar().getCurrent() > 0)
            {
                playerOneLose = false;  
            }

        }

        for( int i = 0; playerTwoLose == true &&i <playerTwoCreatures.length; i++)
        {

            if(playerTwoCreatures[i].getHealthBar().getCurrent() > 0)
            {
                playerTwoLose = false; 
            }

        }

        if (playerOneLose == true)
        {
            //Indentation issues
            removeObjects(allObjects);

            showText("Player Two wins!",getWidth()/2,getHeight()/2);

            Greenfoot.stop();
        }

        if (playerTwoLose == true)
        {
            //Indentation issues
            removeObjects(allObjects);

            showText("Player One wins!",getWidth()/2,getHeight()/2);

            Greenfoot.stop();
        }

    }

}
