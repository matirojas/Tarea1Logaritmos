import java.util.ArrayList;

public abstract class AbstractComposite implements IComposite {
    public static int m;
    public static int M;
    public IComposite padre;
    public ArrayList<Rectangle> rectangulos;


    public AbstractComposite(){
        this.padre  = null;
        this.rectangulos = new ArrayList<>();
    }

    public void setPadre(IComposite nuevoPadre){
        this.padre = nuevoPadre;
    }

}
