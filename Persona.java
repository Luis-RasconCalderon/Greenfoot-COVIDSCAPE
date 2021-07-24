import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Persona extends Actor
{
    MyWorld puntos;
    MyWorld contador;
    public void act() 
    {
        moveAndTurn();
        vacunacion();
        randomspawnVac();
        contador();
        spawnVir();
        desinf();
    }
    public boolean getInmunidad(){
        boolean inmunidad;
        inmunidad = true;
        if (contador.inmune == 10){
            inmunidad = true;
        }if (contador.inmune != 10){
            inmunidad = false;
         }
        return inmunidad;
    }
    private void desinf(){
        boolean a = getInmunidad();
        if (a == true){    
            Actor virus;
            virus = getOneObjectAtOffset(0, 0, Virus.class);
            if (virus != null)
            {
                World world;
                world = getWorld();
                world.removeObject(virus);
                contador.inmune = 0;
            }
        }
    }
    
     private void spawnVir(){
        if(contador.cont==5){
            int x = Greenfoot.getRandomNumber(500);
            int y = Greenfoot.getRandomNumber(350);
            getWorld().addObject(new Virus(), x, y);
            contador.cont = 0;
        }
    }  
    //Creditos: Coding club(8/62020) https://www.youtube.com/watch?v=AVqbtL1es6E&t=313s
    //Método que muestra en pantalla el contador de puntos conseguidos.
    private void contador(){
        getWorld().showText("Vacunas: " + puntos.vacunas, 100, 25);
        getWorld().showText("Contador: " + contador.cont, 100, 10);
        getWorld().showText("Inmunidad: " + contador.inmune, 100,40);
    }
    
    //Creditos de código: User: Pammota(21/6/2017) https://www.greenfoot.org/topics/59490/0
    //Método que hace aparecer vacunas al azar en el mapa y en el tiempo.
    private void randomspawnVac(){
        if (Greenfoot.getRandomNumber(75)==1){
            int x = Greenfoot.getRandomNumber(700);//Coordenada al azar de X
            int y = Greenfoot.getRandomNumber(550);///Coordenada al azar de Y
            getWorld().addObject(new Vacuna(), x, y);//Aparición de vacuna
        }
    }
    
    //Extraido de Greenfoot tutorials y contribuciones propias
    //Método que permite al personaje moverse utilizando las teclas.
    private void moveAndTurn()
    {    
        move(4);
        if (Greenfoot.isKeyDown("left"))//Mover a la izquierda
        {
            turn(-3);
        }
        if (Greenfoot.isKeyDown("right"))//Mover a la derecha
        {
            turn(3);
        }
        if (Greenfoot.isKeyDown("space"))//Alto
        {
            move(-4);
        }
    } 
    
    //Extraido de Greenfoot Tutorials y contribuciones propias
    //Método que permite al jugador recoger vacunas
    private void vacunacion()
    {
        Actor vacuna;
        vacuna = getOneObjectAtOffset(0, 0, Vacuna.class);
        if (contador.inmune != 1){
            if (vacuna != null)
            {
                World world;
                world = getWorld();
                world.removeObject(vacuna);
                puntos.vacunas++;
                contador.cont++;
                contador.inmune++;
            }
        }
    }    
}
