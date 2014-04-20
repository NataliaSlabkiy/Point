package Data; /**
 * Created by Natalia on 20.04.2014.
 */
import java.lang.String;

public class ResultData {
    private double x, y, r;
    private String area;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public void setArea(String area){
        this.area = area;
    }

    public String getArea(){
        return area;
    }
}
