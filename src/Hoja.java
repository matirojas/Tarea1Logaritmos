import java.util.ArrayList;

public class Hoja extends AbstractComposite {
    public Hoja() {
        super();
    }

    @Override
    public ArrayList<Rectangle> buscar(Rectangle r) {
        ArrayList<Rectangle> founded = new ArrayList<>();
        for (int i=0; i< rectangulos.size(); i++){
            Rectangle ri = rectangulos.get(i);
            if(ri.intersect(r)){
                founded.add(ri);
            }
        }
        return founded;
    }

    @Override
    public void insertar(Rectangle r) {
        rectangulos.add(r);
        // if > M, splot

    }

    @Override
    public boolean esHoja() {
        return true;
    }

    @Override
    public IComposite linearSplit() {
        // setear minint y maxint reales
        Rectangle dimensionxbajo = new Rectangle(0,0,0,0);
        Rectangle dimensionxalto = new Rectangle(0,0,0,0);
        Rectangle dimensionybajo = new Rectangle(0,0,0,0);
        Rectangle dimensionyalto = new Rectangle(0,0,0,0);
        int menorx=1000000;
        int mayorx=-1000000;
        int menory=1000000;
        int mayory=-1000000;

        //Indice negativo para indexar si se ha añadido un rectangulo o no.
        int indiceXBajo = -1;
        int indiceXAlto = -1;
        int indiceYBajo = -1;
        int indiceYAlto = -1;

        for(int i =0; i<rectangulos.size(); i++){

            if (rectangulos.get(i).getX()<menorx){
                menorx = rectangulos.get(i).getX();
            }

            if (rectangulos.get(i).getX()+rectangulos.get(i).getWidth() > mayorx){
                mayorx = rectangulos.get(i).getX()+rectangulos.get(i).getWidth();
            }

            if (rectangulos.get(i).getY()<menory){
                menory = rectangulos.get(i).getY();
            }

            if (rectangulos.get(i).getY()+rectangulos.get(i).getHeight() > mayory){
                mayory = rectangulos.get(i).getY()+rectangulos.get(i).getHeight();
            }


            if (indiceXBajo == -1) {
                dimensionxbajo = rectangulos.get(i);
                indiceXBajo = i;
            }
            else if (rectangulos.get(i).getX() > dimensionxbajo.getX() && indiceXAlto != i) {
                    dimensionxbajo = rectangulos.get(i);
                    indiceXBajo = i;
            }
            if (indiceXAlto == -1){
                dimensionxalto = rectangulos.get(i);
                indiceXAlto = i;
            }
            else if (rectangulos.get(i).getX()+rectangulos.get(i).getWidth()<dimensionxalto.getX()+dimensionxalto.getWidth() && indiceXBajo != i){
                dimensionxalto = rectangulos.get(i);
                indiceXAlto = i;
            }

            if(indiceYAlto == -1){
                dimensionyalto = rectangulos.get(i);
                indiceYAlto = i;
            }
            else if(rectangulos.get(i).getY()+rectangulos.get(i).getHeight() < dimensionyalto.getY()+dimensionyalto.getHeight() && indiceYBajo != i){
                dimensionyalto = rectangulos.get(i);
                indiceYAlto = i;
            }
            if(indiceYBajo == -1){
                dimensionybajo = rectangulos.get(i);
                indiceYBajo = i;
            }
            else if(rectangulos.get(i).getY()> dimensionybajo.getY() && indiceYAlto != i){
                dimensionybajo = rectangulos.get(i);
                indiceYBajo = i;
            }

        }
        int separaciondimensionx = dimensionxalto.getX()+dimensionxalto.getWidth() - dimensionxbajo.getX();
        int separaciondimensiony = dimensionyalto.getY()+dimensionyalto.getHeight() - dimensionybajo.getY();
        int rangox = mayorx-menorx;
        int rangoy = mayory-menory;
        separaciondimensionx=separaciondimensionx/rangox;
        separaciondimensiony=separaciondimensiony/rangoy;
        if(separaciondimensionx>separaciondimensiony){
            // OCUPAMOS dimensionxbajo y dimensionxalto
            // ocupamos indiceXBajo e indiceXAlto

        }
        else{
            // OCUPAMOS dimensionybajo y dimensionyalto
            // ocupamos indiceYBajo e indiceYAlto
        }
    }

    @Override
    public ArrayList<Rectangle> getRectangulos() {
        return rectangulos;
    }



}
