import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Alien here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Alien extends Actor
{

    public Alien()
    {
        GreenfootImage image = getImage() ;
        image.scale( 150, 180 ) ; 
    }

    public void act() 
    {
        // Add your action code here.
    }  
    public void setMessage(String msg){
        Message m = new Message();
        World world = getWorld();
        if(m.getWorld() != null){
            world.removeObject(m);
        }
        world.addObject(m, this.getX(), this.getY());
        m.setText(msg);
    }
}
