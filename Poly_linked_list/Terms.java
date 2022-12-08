package Poly_linked_list;

public class Terms {
	protected double coeff;
	protected int power;
	
	
	public Terms(double coeff, int power) {
		this.coeff = coeff;
		this.power = power;
	}
	public double getCoeff() {
		return coeff;
	}
	public void setCoeff(double coeff) {
		this.coeff = coeff;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
}
