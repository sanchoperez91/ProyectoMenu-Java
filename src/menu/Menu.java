
package menu;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Menu {
    Scanner scan=new Scanner(System.in);
    ArrayList<Receta> listaRecetas=new ArrayList<>();
    ArrayList<Receta> listaSalud=new ArrayList<>();
    ArrayList<Receta> listaGordi=new ArrayList<>();
    Random rnd=new Random();


    public static void main(String[] args) {
        Menu menu=new Menu();
        menu.ejecutar();

    
    }
    public void ejecutar() {
        int opcion;
        do {
            opcion = mostrarOpciones();
            ejecutarOpcion(opcion);
        } while (opcion != 7);
    }
    
    public int mostrarOpciones(){
        System.out.println("___________________________________________________________");
        System.out.println("");
        System.out.println("Indique la eleccion de entre las posibles: ");
        System.out.println("1. Ingresar nueva receta");
        System.out.println("2. Visualizar una receta");
        System.out.println("3. Visualizar listado de recetas");
        System.out.println("4. Editar receta");
        System.out.println("5. Eliminar receta");
        System.out.println("6. Crear menu");
        System.out.println("7. Salir");
        
        int opcion=scan.nextInt();
        scan.nextLine(); // Limpiar el buffer del salto de línea
        return opcion;
    }
    public void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                ingresarReceta();
                break;
            case 2:
                System.out.println("Indique el nombre de la receta");
                String nombre=scan.nextLine();
                visualizarReceta(nombre);
                break;
            case 3:
                visualizarListadoRecetas();
                break;
            case 4:
                editarReceta();
                break;
            case 5:
                eliminarReceta();
                break;
            case 6:
                int opcionMenu=crearMenu();
                ejecutarMenuOpcion(opcionMenu);
                break;
            case 7:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no válida. Intente de nuevo.");
        }
    }
    
    public void ingresarReceta(){
        System.out.println("Indique el nombre de la receta");
            String nombre=scan.nextLine();
        System.out.println("indique si es saludable o gordita");
            String saludable=scan.nextLine();
            boolean healthy=false;
               if(saludable.equalsIgnoreCase("saludable")){
                healthy=true; 
               }           
        System.out.println("Indique el nivel de dificultad. 1 (facil) 2 (intermedio) 3 (dificil)");
            int dificil=scan.nextInt();
             scan.nextLine(); // Limpiar el buffer
        System.out.println("Indique la hora entre 1 (desayuno), 2 (comida) o 3 (cena)");
            int hora=scan.nextInt();
             scan.nextLine(); // Limpiar el buffer
        System.out.println("Indique el tipo: pasta, arroz, carne, pescado, verdura");
            String tipo=scan.nextLine();
        System.out.println("Indique si es plato unico, ¿si o no?");
            String platounico=scan.nextLine();
            boolean unico=false;
               if(platounico.equalsIgnoreCase("si")){
                unico=true; 
               }     
        System.out.println("Indique los ingredientes con cantidad y nombre, separado por una coma ");
            String ingredientes=scan.nextLine();
        
            listaRecetas.add(new Receta(nombre, healthy, dificil, hora, tipo, unico, ingredientes));
          System.out.println("Receta ingresada con éxito."); 
    }
    public void visualizarListadoRecetas(){
        for(int x=0; x<listaRecetas.size();x++){
            listaRecetas.get(x).imprimirReceta();
            System.out.println("");
        }
    }
    public void visualizarReceta(String nombre){ 
        for(int x=0; x<listaRecetas.size(); x++){
          if( listaRecetas.get(x).getNombre().equalsIgnoreCase(nombre)){
              listaRecetas.get(x).imprimirReceta();
          }
        }
    }
    public void editarReceta(){
      System.out.println("Indique el nombre de la receta que quiera editar");
        String nombre=scan.nextLine();
        
        for(int x=0; x<listaRecetas.size(); x++){
            if( listaRecetas.get(x).getNombre().equalsIgnoreCase(nombre)){
                System.out.println("Indique el nombre de la receta");
                    nombre=scan.nextLine();
                    listaRecetas.get(x).setNombre(nombre);
                System.out.println("indique si es saludable o gordita");
                    nombre=scan.nextLine();
                    boolean tf=false;
                    if(nombre.equalsIgnoreCase("saludable")){
                        tf=true; 
                    }
                    listaRecetas.get(x).setHealthy(tf);
                System.out.println("Indique el nivel de dificultad. 1 (facil) 2 (intermedio) 3 (dificil)");
                    int numero=scan.nextInt();
                    scan.nextLine(); // Limpiar el buffer
                    listaRecetas.get(x).setDificultad(numero);
                System.out.println("Indique la hora entre 1 (desayuno), 2 (comida) o 3 (cena)");
                    numero=scan.nextInt();
                    scan.nextLine(); // Limpiar el buffer
                    listaRecetas.get(x).setHora(numero);
                System.out.println("Indique el tipo: pasta, arroz, carne, pescado, verdura");
                    nombre=scan.nextLine();
                    listaRecetas.get(x).setTipo(nombre);
                System.out.println("Indique si es plato unico, ¿si o no?");
                    nombre=scan.nextLine();
                    tf=false;
                       if(nombre.equalsIgnoreCase("si")){
                        tf=true; 
                       }
                    listaRecetas.get(x).setUnico(tf);
                System.out.println("Indique los ingredientes con cantidad y nombre, separado por una coma ");
                    nombre=scan.nextLine();
                      listaRecetas.get(x).setIngredientes(nombre);
                System.out.println("Receta editada con éxito.");
                return;
            }
        }       
    }   
    public void eliminarReceta(){
        System.out.println("Indique el nombre de la receta que quiera eliminar");
        String nombre=scan.nextLine();   
        for(int x=0; x<listaRecetas.size(); x++){
            if( listaRecetas.get(x).getNombre().equalsIgnoreCase(nombre)){
            listaRecetas.remove(x);
                System.out.println("Receta eliminada con éxito.");
            return; // Salir del método después de eliminar la receta
            }
        }
        System.out.println("Receta no encontrada.");
    }   
    
    
    
    
    public int crearMenu(){
        System.out.println("");
        System.out.println("__________________________________________________________");
        System.out.println("");
        System.out.println("Seleccione de entre las opciones que tipo de MENU quiere.");
        System.out.println("1. Diario (desayuno, comida y cena)");
        System.out.println("2. Varios dias");
        System.out.println("3. Solo desayuno");
        System.out.println("4. Solo comida");
        System.out.println("5. Solo cena");
        System.out.println("6. Salir");
        int opcionMenu=scan.nextInt();
        scan.nextLine();
        System.out.println("");
        return opcionMenu;
    }
     public void ejecutarMenuOpcion(int opcion) {
        switch (opcion) {
            case 1:
                System.out.println("Quiere que el menu sea saludable o gordito");
                String healthy=scan.nextLine();
                diario(healthy);
                break;
            case 2:
                System.out.println("Indique cuantos dias quiere");
                int dias= scan.nextInt();
                scan.nextLine();
                System.out.println("Quiere que el menu sea saludable o gordito");
                healthy=scan.nextLine();
                semanal(healthy, 7);
                break;
            case 3:
                 System.out.println("Quiere que la el desayuno sea saludable o gordito");
                healthy=scan.nextLine();
                individual(healthy, 1);
                break;
            case 4:
                System.out.println("Quiere que la comida sea saludable o gordita");
                healthy=scan.nextLine();
                individual(healthy, 2);
                break;
            case 5:
                System.out.println("Quiere que la cena sea saludable o gordita");
                healthy=scan.nextLine();
                individual(healthy, 3);
                break;
            case 6:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no válida. Intente de nuevo.");
        }
    }
    public void diario(String healthy){
        
        
     individual(healthy, 1);
     individual(healthy, 2);
     individual(healthy, 3);
    }
    public void semanal(String healthy, int dias){
        String[] diasSemana = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        for(int x=0; x<(dias-1); x++ ){
            System.out.println("Dia "+diasSemana[x]);
            diario(healthy);       
        }
    }
     public void individual(String healthy, int hora){
         Random rnd=new Random();
         boolean saludable=healthy.equalsIgnoreCase("saludable");
        for(int x=0; x<listaRecetas.size(); x++){
            if(listaRecetas.get(x).getHora()==hora){
                if(saludable && listaRecetas.get(x).getHealthy()){
                        listaSalud.add(listaRecetas.get(x));
                                       
                }else {
                    listaGordi.add(listaRecetas.get(x));  
                }
            }    
        }
        if (saludable) {
            if (!listaSalud.isEmpty()) {
                // Seleccionar un índice aleatorio en listaSalud
                int x = rnd.nextInt(listaSalud.size());
                listaSalud.get(x).imprimirReceta();
            } else {
                System.out.println("No hay recetas saludables disponibles.");
            }
        } else {
            if (!listaGordi.isEmpty()) {
                // Seleccionar un índice aleatorio en listaGordi
                int y = rnd.nextInt(listaGordi.size());
                listaGordi.get(y).imprimirReceta();
            } else {
                System.out.println("No hay recetas gorditas disponibles.");
            }
        }
     
     }
}
