package neko.herenciaeinterfaces2;

import java.util.Locale;

public class Circulo extends FiguraCircular {

    public Circulo(int f) {
        this.radio = f;
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int f) {
        this.radio = f;
    }
    
    @Override
    public double calcularArea(){
        return Math.PI * Math.pow(radio, 2);
        
    }
    
    @Override
    public double calcularPerimetro(){
        return 2 * Math.PI * radio;
        
    }
    
    @Override
    public String imprimeFigura(){
        return super.imprimeFigura() + String.format(Locale.US, "Se imprime un Circulo con radio: %d, area: % 2f, perimetro: %2f", radio, calcularArea(), calcularPerimetro());
        
    }
    
}