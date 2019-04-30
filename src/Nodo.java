import java.util.ArrayList;

public class Nodo extends AbstractComposite {

    public Nodo(ArrayList<Rectangle> rectangulos) {
        super();
        //if (rectangulos.size() < m || rectangulos.size() > M  ) throw error
        this.rectangulos = rectangulos;
    }


    public void insertar(Rectangle r){
        int aux;
        if (rectangulos.get(0).getHijo().esHoja()){
            int mayor = M;
            int k = 0;
            for (int i=0; i<rectangulos.size(); i++){
                int sizeI = rectangulos.get(i).getHijo().getRectangulos().size();
                if (sizeI < mayor){
                    k = i;
                    mayor = sizeI;
                }
            }
            rectangulos.get(k).getHijo().insertar(r);
        }
        else{
            int indiceMejor = 0;
            int menorArea = Integer.MAX_VALUE;
            for(int i = 0; i<rectangulos.size(); i++){
                aux = rectangulos.get(i).growRectangle(r);
                if (aux < menorArea){
                    menorArea = aux;
                    indiceMejor = i;
                }
                else if(aux == menorArea){
                    if(rectangulos.get(i).area()<rectangulos.get(indiceMejor).area()){
                        indiceMejor = i;
                    }
                    else if(rectangulos.get(indiceMejor).area()==rectangulos.get(i).area()){
                        double numeroRandom = Math.random();
                        if (numeroRandom < 0.5) {
                            indiceMejor = i;
                        }
                    }
                }
            }
            Rectangle mejorRectangulo = rectangulos.get(indiceMejor);
            mejorRectangulo.getHijo().insertar(r);
        }
    }

    @Override
    public boolean esHoja() {
        return false;
    }

    @Override
    public IComposite linearSplit() {
        return this;
    }

    //Devuelve una lista con los datos que INTERSECTAN al rectangulo buscado.
    @Override
    public ArrayList<Rectangle> buscar(Rectangle r){

        ArrayList<Rectangle> founded = new ArrayList<>();
        for (int i=0; i< rectangulos.size(); i++){
            Rectangle ri = rectangulos.get(i);
            if(ri.intersect(r)){
                IComposite compositeHijo = ri.getHijo();
                System.out.println(compositeHijo);
                founded.addAll(compositeHijo.buscar(r));
            }
        }
        return founded;
    }

    @Override
    public ArrayList<Rectangle> getRectangulos() {
        return this.rectangulos;
    }

    /*   ArrayList<Hoja> founded = new ArrayList<>();
        for(int i =0; i < hijos.size(); i++){
            IComposite data = hijos.get(i);
            if(r.intersect(data.getRectangle())){
                founded.addAll(data.buscar(r));
            }
        }
        return founded;
    }
    */
}
