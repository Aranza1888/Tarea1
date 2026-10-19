package neko.herenciaeinterfaces2;

public abstract class FiguraRecta extends Figura2D {
    protected int ancho;
    protected int alto;

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
    
    
}