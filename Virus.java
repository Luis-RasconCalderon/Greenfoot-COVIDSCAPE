import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Virus extends Actor
{    /**
     * Act - do whatever the Lobster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //Creditos de código: User: Pammota(21/6/2017) https://www.greenfoot.org/topics/59490/0
    MyWorld inmun;
    MyWorld perder; 
    public void act() 
    {
        int vacunas = 0;
        moveAndTurn();
        eat();
    }
    //Extraido de Greenfoot tutorials y contribuciones propias
    //Método que permite al virus moverse aleatoriamente por el mapa
    private void moveAndTurn()
    {
        move(2);
        if (Greenfoot.getRandomNumber(100)<10)
        {
            turn(Greenfoot.getRandomNumber(90)-45);
        }
        if (getX() <= 5|| getX() >= getWorld().getWidth() - 5)
        {
            turn(180);
        }
        if (getY() <= 5 || getY() >= getWorld().getWidth() - 5)
        {
            turn(180);
        }
    }
    
    public boolean getInmunidad(){
        boolean inmunidad;
        inmunidad = true;
        if (inmun.inmune == 10){
            inmunidad = true;
        }if (inmun.inmune != 10){
            inmunidad = false;
         }
        return inmunidad;
    }
    //Extraido de Greenfoot tutorials y contribuciones propias
    //Método que permite al virus infectar a la persona para terminar el juego.
    private void eat()
    {
        boolean b = getInmunidad();
        if (b == false){
            Actor persona;
            persona = getOneObjectAtOffset(0, 0, Persona.class);
            if (persona != null)
            {
                World world;
                world = getWorld();
                world.removeObject(persona);
                getWorld().showText("Perdiste! Tu puntaje fue de: " + perder.vacunas, 300, 250);
                //Greenfoot.playSound("eating.wav");
            }
        }
    }
    
}
