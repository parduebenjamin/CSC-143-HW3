
public class Node {
	private String attraction;
	private String city;
	private String country;
	private double distance;
	private int numberDays;	
	private Node nextAttraction;
	private Node nextLocation;
	String cityName;
	
	public Node (String attraction, String city, String country, double distance, int numberDays, Node nextAttraction, Node nextLocation) {
		this.attraction = attraction;
		this.city = city;
		this.country = country;
		this.distance = distance;
		this.numberDays = numberDays;
		this.nextAttraction = nextAttraction;
		this.nextLocation = nextLocation;
	}
	

	
	public String getAttraction() { return attraction;}
	public String getCity() { return city;}
	public String getCountry() { return country;}
	public double getDistance() { return distance;}
	public int getNumberDays() { return numberDays;}
	
	public Node getNextAttraction() {return nextAttraction;}
	public Node getNextLocation() {return nextLocation;}
	
	//public void setData(String d) {data = d;}
	public void setAttraction(String a) {attraction = a;}
	public void setCity(String a) {city = a;}
	public void setCountry(String a) {country = a;}
	public void setDistance(double a) {distance = a;}
	public void setNumberDays(int a) {numberDays = a;}
	
	public void setNextAttraction(Node n) {nextAttraction = n;}
	public void setNextLocation(Node n) {nextLocation = n;}
}
