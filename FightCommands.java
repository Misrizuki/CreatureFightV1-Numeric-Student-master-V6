/**
 * Write a description of class FightCommands here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FightCommands implements MenuCommands 
{
    // instance variables - replace the example below with your own
    public void execute( int idx, Creature c )
    {
        c.attack(idx);  
    }

}
