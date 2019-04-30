import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Rectangle r1 = new Rectangle(0,0,100,100);
        Rectangle r2 = new Rectangle(150,0,100,100);

        ArrayList<Rectangle> rectangles1 = new ArrayList<>();
        rectangles1.add(r1);
        rectangles1.add(r2);

        Rectangle r3 = new Rectangle( 20,20,30,40);
        Rectangle r4 = new Rectangle(70,20,10,40);

        ArrayList<Rectangle> rectangles2 = new ArrayList<>();
        rectangles2.add(r3);
        rectangles2.add(r4);

        Rectangle r5 = new Rectangle(30,30,1,1);
        Rectangle r6 = new Rectangle(40,40,1,1);

        ArrayList<Rectangle> rectangles3 = new ArrayList<>();
        rectangles3.add(r5);
        rectangles3.add(r6);

        Rectangle r7 = new Rectangle(75,30,1,1);
        Rectangle r8 = new Rectangle(75,50,1,1);

        ArrayList<Rectangle> rectangles4 = new ArrayList<>();
        rectangles4.add(r7);
        rectangles4.add(r8);

        Rectangle r9 = new Rectangle(170, 10, 30, 80);
        Rectangle r10 = new Rectangle(210,10, 20, 80);

        ArrayList<Rectangle> rectangles5 = new ArrayList<>();
        rectangles5.add(r9);
        rectangles5.add(r10);


        Rectangle r11 = new Rectangle(190,20,1,1);
        Rectangle r12 = new Rectangle(180,80, 1,1);

        ArrayList<Rectangle> rectangles6 = new ArrayList<>();
        rectangles6.add(r11);
        rectangles6.add(r12);

        Rectangle r13 = new Rectangle(220, 40, 1, 1);
        Rectangle r14 = new Rectangle(225, 60, 1, 1);

        ArrayList<Rectangle> rectangles7 = new ArrayList<>();
        rectangles7.add(r13);
        rectangles7.add(r14);


        Nodo nodo1 = new Nodo(rectangles1);
        Nodo nodo2 = new Nodo(rectangles2);
        Hoja hoja1 = new Hoja(rectangles3);
        Hoja hoja2 = new Hoja(rectangles4);

        Nodo nodo3 = new Nodo(rectangles5);
        Hoja hoja3 = new Hoja(rectangles6);
        Hoja hoja4 = new Hoja(rectangles7);

        nodo1.getRectangulos().get(0).setHijo(nodo2);
        nodo1.getRectangulos().get(1).setHijo(nodo3);
        nodo2.getRectangulos().get(0).setHijo(hoja1);
        nodo2.getRectangulos().get(1).setHijo(hoja2);
        nodo3.getRectangulos().get(0).setHijo(hoja3);
        nodo3.getRectangulos().get(1).setHijo(hoja4);

        System.out.println(nodo1.getRectangulos().get(1).getHijo());

        Rectangle r = new Rectangle(150,0,500,500);
        ArrayList<Rectangle> results = nodo1.buscar(r10);

        for (int i=0; i<results.size(); i++){
            Rectangle uwu = results.get(i);
            System.out.print(uwu.getX());
            System.out.print("-");
            System.out.print(uwu.getY());
            System.out.print("-");
            System.out.print(uwu.getWidth());
            System.out.print("-");
            System.out.println(uwu.getHeight());
        }









        /*
        Hoja hoja1= new Hoja(30,30,1,1);
        Hoja hoja2= new Hoja(40,40,1,1);
        Hoja hoja3= new Hoja(75,30,1,1);
        Hoja hoja4= new Hoja(75,50,1,1);

        nodo1.insertar(nodo2);
        nodo1.insertar(nodo3);

        nodo2.insertar(hoja1);
        nodo2.insertar(hoja2);

        nodo3.insertar(hoja3);
        nodo3.insertar(hoja4);

        Rectangle r = new Rectangle(-20,-20,290,250);
        ArrayList<Hoja> results = nodo1.buscar(r);
        for (int i=0; i<results.size(); i++){
            Rectangle uwu = results.get(i).getRectangle();
            System.out.print(uwu.getX());
            System.out.print("-");
            System.out.print(uwu.getY());
            System.out.print("-");
            System.out.print(uwu.getWidth());
            System.out.print("-");
            System.out.println(uwu.getHeight());

        }
        */
    }
}
