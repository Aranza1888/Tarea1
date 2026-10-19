import neko.herenciaeinterfaces2.Circulo;
import neko.herenciaeinterfaces2.Figura2D;
import neko.herenciaeinterfaces2.TrianguloRect;

public class Herenciaeinterfaces2 {
    public static void SOUT(String texto){
        System.out.println();
    
    }
    
    public static void main(String[] args) {
        Figura2D f = new TrianguloRect(3,4);
            SOUT(f.imprimeFigura());
            
            f = new Circulo(3);
            SOUT(f.imprimeFigura());
            
    }
}
