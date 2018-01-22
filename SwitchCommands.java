/**
 * Write a description of class SwitchCommands here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SwitchCommands implements MenuCommands
{
    // instance variables - replace the example below with your own
    public void execute( int idx, Creature c)
    {
        c.switchCreature(idx);
    }
}
