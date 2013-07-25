package assignment;
public class ElementData implements Comparable<ElementData>{
	public ElementData() {

	}

	public ElementData(double x1, double y1, float fn1) {
		// TODO Auto-generated constructor stub
		x = x1;
		y = y1;
		fn = fn1;
	}

	double x;

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	double y;

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public float getFn() {
		return fn;
	}

	public void setFn(float fn) {
		this.fn = fn;
	}

	float fn;

	@Override
	public int compareTo(ElementData o) {
		// TODO Auto-generated method stub
		
        if (fn< o.fn) return 1;
        if (fn == o.fn) return 0;
        return -1;

	}
}
