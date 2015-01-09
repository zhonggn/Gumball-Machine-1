import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GumballMachine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GumballMachine extends Actor
{
    Message m = new Message();
    Actor haveCoin;
    
    public GumballMachine()
    {
        GreenfootImage image = getImage() ;
        image.scale( 350, 400 ) ; 
    }
    
    private void setMessage(String msg){
        int mouseX, mouseY;
        MouseInfo mouse = Greenfoot.getMouseInfo();
        mouseX = mouse.getX();
        mouseY = mouse.getY();
        World world = getWorld();
        if(m.getWorld() != null){
            world.removeObject(m);
        }
        world.addObject(m, mouseX, mouseY);
        m.setText(msg);
    }
    
    public void act() 
    {
        
        if(Greenfoot.mousePressed(this)){
            if(haveCoin == null){
                setMessage("No coin in Slot!");
            }else{
                setMessage("Crank Turned!");
                GumballWorld world = (GumballWorld) getWorld();
                world.getInspector().startInspect((Coin)haveCoin);
                haveCoin = null;
            }
        }
        
        Actor coin;
        coin = getOneObjectAtOffset(+10, +10, Coin.class);
        
        
        if ( coin != null )
        {   
            if(haveCoin != null){
                coin.move(-300);
            }else{
                haveCoin = coin;
                setMessage("Have Coin");
                ((Coin)coin).inSlot();
                
                
            }
        }
    } 
    
}
