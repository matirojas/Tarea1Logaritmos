/*
(x,y+h)     (x+w, y+h)
.------------.
|            |
|            |
|            |
.------------.
(x,y)         (x+w,y)
*/

public class Rectangle{
    private int x;
    private int y;
    private int width;
    private int height;
    private IComposite hijo;

    public Rectangle(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.hijo = null;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public boolean intersect(Rectangle r){
        //Comprueba si el rectangulo this esta abajo
        if (this.getY() + this.getHeight() < r.getY()){
            return false;
        }
        //Comprueba si el rectangulo r esta abajo
        else if(r.getY() + r.getHeight() < this.getY()){
            return false;
        }
        //Comprueba si el rectangulo this esta a la izquierda
        else if (this.getX() + this.getWidth() < r.getX() ){
            return false;
        }
        //Comprueba si el rectangulo r esta a la izquierda
        else if(r.getX() + r.getWidth() < this.getX()){
            return false;
        }
        else{
            return true;
        }
    }

    public void setHijo(IComposite hijo) {
        this.hijo = hijo;
    }

    public IComposite getHijo() {
        return hijo;
    }

    public int area(){
        return width*height;
    }

    public int growRectangle(Rectangle r){
        int derecha;
        int izquierda;
        int abajo;
        int arriba;

        if(this.getX()+this.getWidth()<r.getX()+r.getWidth()){
            derecha = r.getX()+r.getWidth();
        }
        else{
            derecha = this.getX()+this.getWidth();
        }

        if(this.getX() > r.getX()){
            izquierda = r.getX();
        }
        else{
            izquierda = this.getX();
        }

        if(this.getY()+this.getHeight() < r.getY()+r.getHeight()){
            arriba = r.getY() + r.getHeight();
        }
        else{
            arriba = this.getY()+this.getHeight();
        }

        if(this.getY() > r.getY()){
            abajo = r.getY();
        }
        else{
            abajo = this.getY();
        }
        int ancho = derecha-izquierda;
        int alto = arriba-abajo;


        int nuevaArea = ancho * alto;
        System.out.println(nuevaArea);

        return nuevaArea - this.area();
    }

    /*
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(0,0,30, 30);
        Rectangle r2 = new Rectangle(15,15, 1,1);

        System.out.println(r1.growRectangle(r2));
    }
    */

}
