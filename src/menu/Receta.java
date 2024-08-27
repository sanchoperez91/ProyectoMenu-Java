
package menu;

public class Receta {
    String nombre;
    boolean healthy;
    int dificultad;
    int hora;
    String tipo;
    boolean unico;
    String ingredientes;

    public Receta(){
    }

    public Receta(String nombre, boolean healthy, int dificultad, int hora, String tipo, boolean unico, String ingredientes){
        this.nombre=nombre;
        this.healthy=healthy;
        this.dificultad=dificultad;
        this.hora=hora;
        this.tipo=tipo;
        this.unico=unico;
        this.ingredientes=ingredientes;
    }
    
    //getters
    public String getNombre(){
        return nombre;
    }
    public boolean getHealthy(){
        return healthy;
    }
    public int getDificultad(){
        return dificultad;
    }
    public int getHora(){
        return hora;
    }
    public String getTipo(){
        return tipo;
    }
    public boolean getUnico(){
        return unico;
    }

    public String getIngredientes() {
        return ingredientes;
    }
            
    
    //Setters
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setHealthy(boolean healthy){
        this.healthy=healthy;
    }
    public void setDificultad(int dificultad){
        this.dificultad=dificultad;
    }
    public void setHora(int hora){
        this.hora=hora;
    }
    public void setTipo(String tipo){
        this.tipo=tipo;
    }
    public void setUnico(boolean unico){
        this.unico=unico;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    // imprimir receta
    public void imprimirReceta(){
        System.out.println("Nombre "+nombre);
        System.out.println("En cuanto a la dificultad,1 (facil) 2 (intermedio) 3 (dificil), este receta es un "+dificultad);
        System.out.print("En cuanto a sus calorias, ");
        if (healthy){
            System.out.println("esta receta es saludable.");
        }else {System.out.println("esta receta es gordita.");}
        
        System.out.print("En cuanto al horario,  ");
        if(hora<=1){System.out.println("esta receta es DESAYUNO.");}
        if(hora==2){System.out.println("esta receta es COMIDA.");}
        if(hora>=3){System.out.println("esta receta es CENA.");}
        
        System.out.println("El tipo de comida de la receta es "+tipo+".");
        
        if (unico){
            System.out.println("Esta receta es PLATO UNICO.");
        }else {System.out.println("Esta receta es plato PARA ACOMPAÑAR.");
            }
        
        System.out.println("Los ingredientes son: "+ingredientes);
    }
    
}
