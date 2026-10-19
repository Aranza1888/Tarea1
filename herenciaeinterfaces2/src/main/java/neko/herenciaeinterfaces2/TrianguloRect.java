package neko.herenciaeinterfaces2;

import java.util.Locale;

public class TrianguloRect extends FiguraRecta {

    public TrianguloRect(int sitx, int theven) {
        this.alto = sitx;
        this.ancho = theven;
        
    }

    
    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }
    
    @Override
    public double calcularArea(){
        return (ancho * alto) / 2.0;
        
    }
    
    @Override
    public double calcularPerimetro(){
        double hipotenusa = Math.sqrt(Math.pow(ancho, 2) + Math.pow(alto, 2));
        return ancho + alto + hipotenusa;
        
    }
    
    @Override
    public String imprimeFigura(){
        return super.imprimeFigura() + String.format(Locale.US, "Se imprime un Triangulo con alto: %d, ancho: %d, area: %.2f, perimetro: %.2f\n", alto, ancho, calcularArea(), calcularPerimetro());
        
    }
}