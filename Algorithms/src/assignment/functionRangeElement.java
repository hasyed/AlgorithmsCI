package assignment;
public class functionRangeElement {
	double fnStart;
	double fnEnd;
	ElementData data;
	
	public functionRangeElement(double s,double e, ElementData elementData) {
		// TODO Auto-generated constructor stub
	fnStart=s;
	fnEnd=e;
	data=elementData;
	}

	public double getFnStart() {
		return fnStart;
	}

	public void setFnStart(double fnStart) {
		this.fnStart = fnStart;
	}

	public double getFnEnd() {
		return fnEnd;
	}

	public void setFnEnd(double fnEnd) {
		this.fnEnd = fnEnd;
	}

	public ElementData getData() {
		return data;
	}

	public void setData(ElementData data) {
		this.data = data;
	}
}
