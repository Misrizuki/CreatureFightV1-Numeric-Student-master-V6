import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
/**
 * Write a description of class Pikachu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lapras extends Creature
{
    private Creature enemy;
    private String enemyType;
    
    public void attack( int idx )
    {
        //Indentation issues
        CreatureWorld world = (CreatureWorld)getWorld();
        enemy = world.getPlayerOne();
        enemyType = enemy.getType();
        attackAnimation();
        
        if ( idx == 0 )
        {
            enemy.getHealthBar().add(-30);
        }
        else
        {
            if(enemyType == "Fire")
            {
                enemy.getHealthBar().add(-100*2); 
                getWorld().showText(" it's very effective...",getWorld().getWidth()/2,getWorld().getHeight()/2+26);
                Greenfoot.delay(30);
            }
            else if(enemyType == "Rock")
            {
                enemy.getHealthBar().add(-100*2); 
                getWorld().showText(" it's very effective...",getWorld().getWidth()/2,getWorld().getHeight()/2+26);
                Greenfoot.delay(30);
            }
            else if(enemyType == "Grass")
            {
                enemy.getHealthBar().add(-100/2); 
                getWorld().showText(" it's not very effective...",getWorld().getWidth()/2,getWorld().getHeight()/2+26);
                Greenfoot.delay(30);
            }
            enemy.getHealthBar().add(-70);
        }
        world.setTurnNumber( true );
    }
   
    /**
     *  attackAnimation show the creature's attack animation
     *  
     *  @param there is no parameters
     *  @return there is now return
     */
    public void attackAnimation()
    {
        int originalX = getX();
        int originalY = getY();
        
        for( int i = 0; i< 15 ;i++)
        {
            setLocation( getX() +1,getY() -2);
            
            Greenfoot.delay(1);
        }
        setLocation(originalX,originalY);
    }
    
    /**
     *  switchCreature sets the new creature
     *  
     *  @param index of creatures that can be switched
     *  @return there is now return
     */
    public void switchCreature(int idx)
    {
        CreatureWorld world = (CreatureWorld)getWorld();
        Creature switchCreature;
      
        if( idx == 0 )
        {
            switchCreature = world.getNewTwoCreature(0);
        }
        else
        {
            switchCreature = world.getNewTwoCreature(2);
        }
        
        if(getHealthBar().getCurrent() <=0)
        {
            JOptionPane.showMessageDialog( null, "This creature has fainted! Please select a different creature." );
        }
        else
        {
            while( getX() < getWorld().getWidth() - 1)
            {
                setLocation( getX() +5,getY());
                
                Greenfoot.delay(2);
            }
            getImage().setTransparency(0);
            getHealthBar().getImage().setTransparency(0);
            
            if ( idx == 0 )
            {
                world.changePlayerTwo("Pikachu");
            }
            else
            {
                world.changePlayerTwo("Pidgeot");   
            }
            
            switchCreature.switchedIn();
            world.setTurnNumber(true);
        }
        
    }
    
     /**
     *  switchIn sets the new creature for playertwo
     *  
     *  @param there is no parameters
     *  @return there is now return
     */ 
    public void switchedIn()
    {
        getImage().setTransparency(255);
        getHealthBar().getImage().setTransparency(255);
        
        while( getX() > 325)
        {
            setLocation( getX() - 5,getY());
            
            Greenfoot.delay(2);
        }
        
    }
    
    public Lapras( World w )
    {
       super(900, false, "Water");
       
       getImage().scale(150,100);
       
       w.addObject( getHealthBar(),100,25);
       getHealthBar().getImage().setTransparency(0);
    }
    
    /**
     * Act - do whatever the Pikachu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        CreatureWorld playerWorld = (CreatureWorld)getWorld();
        
        if(getHealthBar().getCurrent() <=0)
        {
            getWorld().showText("Lapras has fainted...",getWorld().getWidth()/2,getWorld().getHeight()/2+26);
            Greenfoot.delay(30);
            if(playerWorld.getNewTwoCreature(0).getHealthBar().getCurrent() > 0)
            {
                switchCreature(0);
                playerWorld.setTurnNumber(false);
                getWorld().showText("",getWorld().getWidth()/2,getWorld().getHeight()+ 26);
                getWorld().removeObject(this);
            }
            else if(playerWorld.getNewTwoCreature(2).getHealthBar().getCurrent() > 0)
            {
                switchCreature(1);
                playerWorld.setTurnNumber(false);
                getWorld().showText("",getWorld().getWidth()/2,getWorld().getHeight()+ 26);
                getWorld().removeObject(this);
            }
        }
        
    } 
    
}

