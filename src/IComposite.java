import java.util.ArrayList;

public interface IComposite {
    void setPadre(IComposite nuevoPadre);
    ArrayList<Rectangle> buscar(Rectangle r);
    ArrayList<Rectangle> getRectangulos();
    void insertar(Rectangle r);
    boolean esHoja();
    IComposite linearSplit();
}
