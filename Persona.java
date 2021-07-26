import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Persona extends Actor
{
    MyWorld puntos;
    MyWorld contador;
    Menu dificultad;
    public void act() 
    {
        instrucciones();
        moveAndTurn();
        vacunacion();
        vacunacion2();
        randomspawnVac();
        contador();
        spawnVir();
        spawnVir2();
        desinf();
        desinf2();
    }
    
    public void instrucciones(){
        if (puntos.vacunas == 0){
            getWorld().showText("- Utiliza las flechas de tu teclado para moverte por el mapa. " , 300, 50);
            getWorld().showText("Instrucciones" , 300, 25);
            getWorld().showText("- Recoge vacunas y evita ser contagiado." , 300,75);
            getWorld().showText("- Cada 5 vacunas que recogas, un nuevo virus aparecerá" , 300,100);
            getWorld().showText("- Cada 10 vacunas, adquieres un estado de inmunidad y debes" , 300,125);
            getWorld().showText("eliminar un virus obligatoriamente," , 300,150);
            getWorld().showText("o no podrás seguir recogiendo vacunas." , 300,175);
        }if (puntos.vacunas !=0){
            getWorld().showText("" , 300, 50);
            getWorld().showText("" , 300, 25);
            getWorld().showText("" , 300,75);
            getWorld().showText("" , 300,100);
            getWorld().showText("" , 300,125);
            getWorld().showText("" , 300,150);
            getWorld().showText("" , 300,175);
        }
    }
    
    public boolean getInmunidad(){
        boolean inmunidad;
        inmunidad = true;
        if (contador.inmune == 15){
            inmunidad = true;
            getWorld().showText("¡Eres inmune!", 300,300);
            getWorld().showText("Debes eliminar a un virus", 300,350);
        }if (contador.inmune != 15){
            inmunidad = false;
            getWorld().showText("", 300,300);
            getWorld().showText("", 300,350);
         }
        return inmunidad;
    }
    
    public boolean getInmunidad2(){
        boolean inmunidad;
        inmunidad = true;
        if (contador.inmune == 10){
            inmunidad = true;
            getWorld().showText("¡Eres inmune!", 300,300);
            getWorld().showText("Debes eliminar a un virus", 300,350);
        }if (contador.inmune != 10){
            inmunidad = false;
            getWorld().showText("", 300,300);
            getWorld().showText("", 300,350);
         }
        return inmunidad;
    }
    private void desinf(){
        if(dificultad.opcion == 0){
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
                    Greenfoot.playSound("desinfeccion.wav");
                }
            }
        }
    }
    
    private void desinf2(){
        if(dificultad.opcion == 1){
            boolean a = getInmunidad2();
            if (a == true){    
                Actor virus;
                virus = getOneObjectAtOffset(0, 0, Virus.class);
                if (virus != null)
                {
                    World world;
                    world = getWorld();
                    world.removeObject(virus);
                    contador.inmune = 0;
                    Greenfoot.playSound("desinfeccion.wav");
                }
            }
        }
    }
    
    private void spawnVir(){
         if (dificultad.opcion == 0){
            if(contador.cont==10){
                int x = Greenfoot.getRandomNumber(500);
                int y = Greenfoot.getRandomNumber(350);
                getWorld().addObject(new Virus(), x, y);
                contador.cont = 0;
            }
        }
    }
    
    private void spawnVir2(){
         if (dificultad.opcion == 1){
            if(contador.cont==5){
                int x = Greenfoot.getRandomNumber(500);
                int y = Greenfoot.getRandomNumber(350);
                getWorld().addObject(new Virus(), x, y);
                contador.cont = 0;
            }
        }
    }
    //Creditos: Coding club(8/62020) https://www.youtube.com/watch?v=AVqbtL1es6E&t=313s
    //Método que muestra en pantalla el contador de puntos conseguidos.
    private void contador(){
        getWorld().showText("Vacunas: " + puntos.vacunas, 100, 25);
        getWorld().showText("Nuevo virus: " + contador.cont, 300, 25);
        getWorld().showText("Inmunidad: " + contador.inmune, 500,25);
        getWorld().showText("Modo: " + dificultad.opcion, 300,50);
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
        if (Greenfoot.isKeyDown("left"))//Mover a la izquierda
        {
            int x = getX();//Crédito: FRC Computer Science (24/7/2021) https://frccompsci.weebly.com/ways-you-can-move.html
            int y = getY();
            
            setLocation(x-5,y);
        }
        if (Greenfoot.isKeyDown("right"))//Mover a la derecha
        {
            int x = getX();//Crédito: FRC Computer Science (24/7/2021) https://frccompsci.weebly.com/ways-you-can-move.html
            int y = getY();
            
            setLocation(x+5,y);
        }
        if (Greenfoot.isKeyDown("down"))//Mover abajo
        {
            int x = getX();//Crédito: FRC Computer Science (24/7/2021) https://frccompsci.weebly.com/ways-you-can-move.html
            int y = getY();
            
            setLocation(x,y+5);
        }
        if (Greenfoot.isKeyDown("up"))//Mover arriba
        {
            int x = getX();//Crédito: FRC Computer Science (24/7/2021) https://frccompsci.weebly.com/ways-you-can-move.html
            int y = getY();
            
            setLocation(x,y-5);
        }
    } 
    
    //Extraido de Greenfoot Tutorials y contribuciones propias
    //Método que permite al jugador recoger vacunas
    private void vacunacion()
    {
        if(dificultad.opcion == 0){
            Actor vacuna;
            vacuna = getOneObjectAtOffset(0, 0, Vacuna.class);
            if (contador.inmune != 15){
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
    
    private void vacunacion2()
    {
        if(dificultad.opcion == 1){
            Actor vacuna;
            vacuna = getOneObjectAtOffset(0, 0, Vacuna.class);
            if (contador.inmune != 10){
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
}
