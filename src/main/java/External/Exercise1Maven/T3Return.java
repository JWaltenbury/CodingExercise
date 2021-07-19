package External.Exercise1Maven;


/**
 * Represents a single T3 return, which contains all applicable fields on the submission form
 */
public class T3Return {

	//Fields
	private String Tan;
	private String Not;
	private String City;
	private String Province;
	private String Pi;
	private String Ri;
	
	
	//Constructors
	public T3Return(String tan, String not, String city, String province, String pi, String ri)
	{
		this.Tan = tan;
		this.Not = not;
		this.City = city;
		this.Province = province;
		this.Pi = pi;
		this.Ri = ri;
	}

	
	//Get/sets
	public String getTan() {
		return Tan;
	}
	public void setTan(String tan) {
		Tan = tan;
	}
	public String getNot() {
		return Not;
	}
	public void setNot(String not) {
		Not = not;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getProvince() {
		return Province;
	}
	public void setProvince(String province) {
		Province = province;
	}
	public String getPi() {
		return Pi;
	}
	public void setPi(String pi) {
		Pi = pi;
	}
	public String getRi() {
		return Ri;
	}
	public void setRi(String ri) {
		Ri = ri;
	}

	
	//Methods
	/**
	 * Overridden toString() method that formats the T3 Return's data for reporting
	 */
	@Override
	public String toString()
	{
		
		return "TAN: " + this.getTan() + "\n" +
				"NOT: " + this.getNot() + "\n" +
				"City: " + this.getCity() + "\n" +
				"Province: " + this.getProvince() + "\n" +
				"PI: " + this.getPi() + "\n" +
				"RI: " + this.getRi();
	}

}
