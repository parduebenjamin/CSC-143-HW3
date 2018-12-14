import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.lang.*;

public class Application {
	
	public static final Node nullAttraction =new Node(" ", " ", " ", 0, 0, null, null);
	public static final Node nullCity = new Node(" ", " ", " ", 0, 0, null, null);
	JFrame frame = new JFrame("Input Dialog Example");
	
	
	public static void main(String[] args) {
		Node attractionList = new Node(" ", " ", " ", 0, 0, null, null);
		Node locationList = new Node(" ", " ", " ", 0, 0, null, null);
		Pointer attractionPointer = new Pointer(attractionList);
		Pointer locationPointer = new Pointer(locationList);
		Component frame = null;
		intro();
		JOptionPane.showMessageDialog(frame,"First, do you want to add, delete, or print the list?");
		boolean running = true;
		do  {
		
		String action = actions();
		
	    if (action == "Add") {
	    	//JOptionPane.showMessageDialog(frame,"so far so good");
			String attraction = addAttraction();
			String city = addCity();
			String country = addCountry();
			Double distance = addDistance();
			int length = addStayLength();
			
			if (attractionList.getNextAttraction() == null) {
				attractionList.setNextAttraction(new Node(attraction,city,country,distance,length,null,null));
				locationList.setNextLocation(new Node(attraction,city,country,distance,length,null,null));

			} else if (attractionList.getNextAttraction() != null) {
				Node tempLocNode = locationList;
				Node wagonLocNode = tempLocNode;
				Node tempAttNode = attractionList.getNextAttraction();
				Node wagonAttNode = tempAttNode;
				int count = 0;
				int alphabet = attraction.compareTo(tempAttNode.getAttraction());
				while (tempLocNode.getNextLocation() != null) {
					count++;
					//wagonLocNode = tempLocNode;
					tempLocNode =tempLocNode.getNextLocation();
					
				}
				tempLocNode.setNextLocation(new Node(attraction,city,country,distance,length,null,null));
				if (alphabet<=0) {
					wagonAttNode.setNextAttraction(new Node(attraction,city,country,distance,length,tempAttNode.getNextAttraction(),null));
				} else {
				while (alphabet > 0 && tempAttNode.getNextAttraction() != null) {
					
					wagonAttNode = tempAttNode;
					tempAttNode = tempAttNode.getNextAttraction();
					alphabet = attraction.compareTo(tempAttNode.getAttraction());
				}
				
				wagonAttNode.setNextAttraction(new Node(attraction,city,country,distance,length,tempAttNode,null));
				
				
			}}
				
	    	//System.exit(0);
	        }
	    if (action == "Remove") {
	    	  if (locationList.getNextLocation() == null) {
		        	JOptionPane.showMessageDialog(frame,"There's nothing to remove!");
		        } else {
		        String removedCity = JOptionPane.showInputDialog(frame, "What city do you want to remove from the list?");
		        Node tempAttractionNode = attractionList;
		        Node tempCityNode = locationList;
		        Node tempAttractionNodeWagon = tempAttractionNode;
		        Node tempCityNodeWagon = tempCityNode;
		      
		        while (tempCityNode.getNextLocation() != null) {
					if (tempCityNode.getCity() == removedCity) {
						tempCityNodeWagon.setNextLocation(tempCityNode.getNextLocation());
					}
					tempCityNodeWagon = tempCityNode;
					tempCityNode = tempCityNode.getNextLocation();
				}
		        while (tempAttractionNode.getNextAttraction() != null) {
					if (tempAttractionNode.getCity() == removedCity) {
						tempAttractionNodeWagon.setNextAttraction(tempAttractionNode.getNextAttraction());
					}
					tempAttractionNodeWagon = tempAttractionNode;
					tempAttractionNode = tempAttractionNode.getNextAttraction();
				}}
		       
		    	
	    }
	    
	    if (action == "Print by Attraction") {
	    	Node tempNode = attractionList;
	    	if (tempNode.getNextAttraction() != null) {
	    	while (tempNode.getNextAttraction() != null) {
	    		JOptionPane.showMessageDialog(frame, "Attraction Name " + tempNode.getNextAttraction().getAttraction()
	    		+ "\n" + "Attraction City " + tempNode.getNextAttraction().getCity()
	    		+ "\n" + "Attraction Country " + tempNode.getNextAttraction().getCountry()
	    		+ "\n" + "Distance from Seattle " + tempNode.getNextAttraction().getDistance());
	    		tempNode = tempNode.getNextAttraction();
	    	}} else JOptionPane.showMessageDialog(frame, "the list is empty ");
	    	
	    	//System.exit(0);
	    }
	    if (action == "Print by Location") {
	    	Node tempNode = locationList;
	    	if (tempNode.getNextLocation() != null) {
	    	while (tempNode.getNextLocation() != null) {
	    		JOptionPane.showMessageDialog(frame, "Attraction Name " + tempNode.getNextLocation().getAttraction()
	    		+ "\n" + "Attraction City " + tempNode.getNextLocation().getCity()
	    		+ "\n" + "Attraction Country " + tempNode.getNextLocation().getCountry()
	    		+ "\n" + "Distance from Seattle " + tempNode.getNextLocation().getDistance());
	    		tempNode = tempNode.getNextLocation();
	    	}} else JOptionPane.showMessageDialog(frame, "the list is empty ");


	    }
	    if (action == "Quit") {
	    	//System.exit(0);
	    	running = false;
	    }
		
	    
	    

		} while(running == true);
	    System.exit(0);
		
		}
	


	

	public static void printAttractionList(Node list){
		Node temp = list;
		while (temp.getNextAttraction() != null) {
			System.out.println("Attraction Name " + temp.getAttraction());
			System.out.println("Attraction City " + temp.getCity());
			System.out.println("Attraction Country " + temp.getCountry());
			System.out.println("Distance from Seattle " + temp.getDistance());
			System.out.println();
			temp = temp.getNextAttraction();
		}
		
	}
	public static void printLocationList(Node list){
		Node temp = list;
		while (temp.getNextLocation() != null) {
			System.out.println("Attraction Name " + temp.getAttraction());
			System.out.println("Attraction City " + temp.getCity());
			System.out.println("Attraction Country " + temp.getCountry());
			System.out.println("Distance from Seattle " + temp.getDistance());
			System.out.println();
			temp = temp.getNextLocation();
		}	
		}
	public static void intro() {

		Component frame = null;
		JOptionPane.showMessageDialog(frame,"WANDERLUST"
				 + "\n" + "This program allows you to add destinations to a list,"
				 + "\n" + "remove destinations from a list, and print the list."
				 + "\n" + "We just need a city, a country, distance from home, duration"
				 + "\n" + "of your stay, and a special attraction at that destination."
				 + "\n" + "This program will take care of sorting the list" 
				);
	}

	  public static final String[] actions = { "Add", "Remove", "Print by Attraction", "Print by Location", "Quit" };

	  public static String actions()  {
	    JFrame frame = new JFrame("Input Dialog Example 3");
	    String action = (String) JOptionPane.showInputDialog(frame, 
	        "What would you like to do?",
	        "Next Action",
	        JOptionPane.QUESTION_MESSAGE, 
	        null, 
	        actions, 
	        actions[0]);

	    return action;
	  }

	  public static String addCity() {
		  JFrame frame = new JFrame("Input Dialog Example 3");
	        String newCity = JOptionPane.showInputDialog(frame, "What's the city?");
	        return newCity;

	  }
	public static String addCountry() {
		JFrame frame = new JFrame("Input Dialog Example 3");
		String newCountry = JOptionPane.showInputDialog(frame, "What's the Country?");
		return newCountry;
	}
	public static String addAttraction() {
		JFrame frame = new JFrame("Input Dialog Example 3");
		String newAttraction = JOptionPane.showInputDialog(frame, "What's an attraction there?");
		return newAttraction;
	}
	public static Double addDistance() {
		JFrame frame = new JFrame("Input Dialog Example 3");
		String newDist = JOptionPane.showInputDialog(frame, "How far is it from home?");
        double newDistance = Double.parseDouble(newDist);
		return newDistance;
	}
	public static int addStayLength() {
		JFrame frame = new JFrame("Input Dialog Example 3");
        String newStay = JOptionPane.showInputDialog(frame, "How many days are you staying?");
        int newStayLength = Integer.valueOf(newStay);
		return newStayLength;
	}

	}
