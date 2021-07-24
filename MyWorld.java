import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * .
 * 
 * @Luis Rascón 
 * @Version 1- 20/7/2021
 */
public class MyWorld extends World
{
     //Creditos: Coding club(8/62020) https://www.youtube.com/watch?v=AVqbtL1es6E&t=313s
    public static int vacunas=0;
    public static int cont = 0;
    public static int inmune = 0;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        prespawnVac();
        prespawnPer();
        prespawnVir();
        reset();
    
    }
    //Creditos: Coding club(8/62020) https://www.youtube.com/watch?v=AVqbtL1es6E&t=313s
    //Método que reinicia el contador sin la necesidad de recompilar. 
    private void reset(){
        vacunas = 0;
        cont = 0;
        inmune = 0;
    }
    
    //Define el método
    public void Background(){
    setBackground(new GreenfootImage("bluerock.jpg"));    
    }
    
    //Creditos de código: User: Pammota(21/6/2017) https://www.greenfoot.org/topics/59490/0
    //Método privado que planta a la vacuna inicial.
    private void prespawnVac(){
        int x = Greenfoot.getRandomNumber(550);
        int y = Greenfoot.getRandomNumber(550);
        addObject(new Vacuna(), x, y);
    }
    
    //Creditos de código: User: Pammota(21/6/2017) https://www.greenfoot.org/topics/59490/0
    //Método privado que planta al personaje que usara el usuario.
    private void prespawnPer(){
        int x = Greenfoot.getRandomNumber(550);
        int y = Greenfoot.getRandomNumber(350);
        addObject(new Persona(), x, y);
    }
    
    //Creditos de código: User: Pammota(21/6/2017) https://www.greenfoot.org/topics/59490/0
    //Método privado que planta al viru enemigo inicial.
    private void prespawnVir(){
        int x = Greenfoot.getRandomNumber(550);
        int y = Greenfoot.getRandomNumber(350);
        addObject(new Virus(), x, y);
    }
    
}
