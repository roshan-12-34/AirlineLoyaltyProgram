
	package jp3;
	import java.util.Date;

	public class Flightactivity {
	    private int activityId;
	    private String flightNo;
	    private Date date;
	    private int distance;
	    private String fareClass;
	    private int milesEarned;

	    public Flightactivity(int activityId, String flightNo, Date date, int distance, String fareClass) {
	        this.activityId = activityId;
	        this.flightNo = flightNo;
	        this.date = date;
	        this.distance = distance;
	        this.fareClass = fareClass;
	        this.milesEarned = 0;
	    }

	    public int calculateMiles() {
	        int bonus = fareClass.equalsIgnoreCase("Business") ? 2 : 1;
	        milesEarned = distance * bonus;
	        return milesEarned;
	    }

	    @Override
	    public String toString() {
	        return "Flight " + flightNo + " | Distance: " + distance + " | Fare: " + fareClass;
	    }
	}


