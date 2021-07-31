import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**Creditos para clase y función entera: Jaime BG (16/3/2020)https://youtu.be/ik5GVQhzf9A  
 */
public class Menu extends World
{
    Selector selector = new Selector();
    public static int opcion = 0;
    //Metodo constructor
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        preparacionMenu();
        setBackground(new GreenfootImage("space1.jpg")); 
        music();  
    }
    
    //Método que reproduce la música de fondo.
    //Creditos: Usuario danpost (3/5/2020) https://www.greenfoot.org/topics/1649
    /*Música creada en Groovepad iOS. https://apps.apple.com/es/app/groovepad-caja-de-ritmos/id1454398991 
     * Paquete de sonidos: Lo-Fi Chillhop. 
     * Autor de paquete: Tjam
     */
    private void music(){
        GreenfootSound  sound = new GreenfootSound("backgroundcovi-1.wav"); 
        if (sound.isPlaying() == false){
        sound.setVolume(25);
        sound.playLoop();
        }
    }
    
    //Método que explica en qué consiste cada modo y cómo afecta la forma de progreso.
    //También define el lugar de aparción de cada opción de dificultad en pantalla. 
    private void preparacionMenu(){
        showText("Selecciona la dificultad: ", 300, 25);
        showText("Utiliza las flechas y enter para escoger ", 300, 50);
        showText("Fácil: cada 10 puntos aparece un virus y", 200, 100);
        showText("   cada 15 puntos eres inmune.", 200, 125);
        showText("Difícil: cada 5 puntos aparece un virus y", 200, 175);
        showText("   cada 10 puntos eres inmune.", 200, 200);
        
        addObject(new Facil(), 300,275);
        addObject(new Dificil(), 300,375);
        addObject(selector, 200,275);
    }
    
    //Método que permite al selector moverse entre opciones de dificultad para poder escogerlas
    public void act(){
        if (Greenfoot.isKeyDown("up") && opcion!=0) {opcion++;}
        if (Greenfoot.isKeyDown("down") && opcion!=1) {opcion--;}
        
        if (opcion>=2) opcion=0;
        if (opcion <0) opcion=1;
        
        selector.setLocation(200,275+(opcion*100));
        
        if (Greenfoot.isKeyDown("space") || Greenfoot.isKeyDown("enter")){
            switch(opcion){
                case 0:
                    Greenfoot.setWorld(new MyWorld());
                    break;
                case 1:
                    Greenfoot.setWorld(new MyWorld());
                    break;
            }
        }
    }
}
