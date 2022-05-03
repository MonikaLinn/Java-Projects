package threadproject;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.shape.Rectangle;

public class StillClock extends Pane {
	private int hour;
	private int minute;
	private int second;

	// Clock pane's width and height
	private double w = 250, h = 250;

	/** Construct a default clock with the current time */
	public StillClock() {
		setCurrentTime();
	}

	/** Construct a click with specified hour, minute, and second */
	public StillClock(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		paintClock();
	}

	/** Return hour */
	public int getHour() {
		return hour;
	}

	/** Set a new hour */
	public void setHour(int hour) {
		this.hour = hour;
		paintClock();
	}

	/** Return minute */
	public int getMinute() {
		return minute;
	}

	/** Set a new minute */
	public void setMinute(int minute) {
		this.minute = minute;
		paintClock();
	}

	/** Return second */
	public int getSecond() {
		return second;
	}

	/** Set a new second */
	public void setSecond(int second) {
		this.second = second;
		paintClock();
	}

	/** Return clock pane's width */
	public double getW() {
		return w;
	}

	/** Set clock pane's width */
	public void getW(double w) {
		this.w = w;
		paintClock();
	}

	/** Return clock pane's height */
	public double getH() {
		return h;
	}

	public void setH(double h) {
		this.h = h;
		paintClock();
	}
	
	/** Paint the clock */
	protected void paintClock() {
		// Initialize clock parameters
		double clockRadius = Math.min(w, h) * 0.8 * 0.5;
		double centerX = w / 2;
		double centerY = h / 2;

		// Draw circle
		Circle circle = new Circle(centerX, centerY, clockRadius);
		circle.setFill(Color.YELLOW);
		circle.setStroke(Color.BLACK);
		Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
		Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
		Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
		Text t4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");

		// Draw second hand
		double sLength = clockRadius * 0.8;
		double secondX = centerX + sLength *
			Math.sin(second * (2 * Math.PI / 60));
		double secondY = centerY - sLength *
			Math.cos(second * (2 * Math.PI / 60));
		Line sLine = new Line(centerX, centerY, secondX, secondY);
		sLine.setStroke(Color.RED);

		// Draw minute hand
		double mLength = clockRadius * 0.65;
		double xMinute = centerX + mLength *
			Math.sin(minute * (2 * Math.PI / 60));
		double minuteY = centerY - mLength *
			Math.cos(minute * (2 * Math.PI / 60));
		Line mLine = new Line(centerX, centerY, xMinute, minuteY);
		mLine.setStroke(Color.BLUE);

		// Draw hour hand 
		double hLength = clockRadius * 0.5;
		double hourX = centerX + hLength *
			Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
		double hourY = centerY - hLength * 
			Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
		Line hLine = new Line(centerX, centerY, hourX, hourY);
		hLine.setStroke(Color.GREEN);

		getChildren().clear();
		getChildren().addAll(circle, t1, t2, t3, t4, sLine, mLine, hLine);
	}
        
	public void setCurrentTime() {
		// Construct a Calendar for the current date and time
		Calendar calendar = new GregorianCalendar();

		// Set current hour, minute and second
		this.hour = calendar.get(Calendar.HOUR_OF_DAY);
		this.minute = calendar.get(Calendar.MINUTE);
		this.second = calendar.get(Calendar.SECOND);
                
                double clockRadius = Math.min(w, h) * 0.8 * 0.5;
		double centerX = w / 2;
		double centerY = h / 2;
              
                paintClock(); // Repaint the clock   centerX - 25, centerY - clockRadius + 35
                Text t5 = new Text(centerX - 5, centerY - clockRadius + 29, "CA");
                getChildren().addAll(t5);
              	}
        
        public void setCurrentTime1() { //Hawaii
		// Construct a Calendar for the current date and time
		Calendar calendar = new GregorianCalendar();
                
		// Set current hour, minute and second
		calendar.add(Calendar.HOUR_OF_DAY, -3);
                this.hour = calendar.get(Calendar.HOUR_OF_DAY);
                this.minute = calendar.get(Calendar.MINUTE);
                this.second = calendar.get(Calendar.SECOND);
              
                double clockRadius = Math.min(w, h) * 0.8 * 0.5;
		double centerX = w / 2;
		double centerY = h / 2;
                
                
		paintClock(); // Repaint the clock
                Text t5 = new Text(centerX - 16, centerY - clockRadius + 29, "Hawaii");
                getChildren().addAll(t5);
                   
	}
        
        public void setCurrentTime2() { //Korea
		// Construct a Calendar for the current date and time
		Calendar calendar = new GregorianCalendar();
                
		// Set current hour, minute and second
		calendar.add(Calendar.HOUR_OF_DAY, +17);
                this.hour = calendar.get(Calendar.HOUR_OF_DAY);
                this.minute = calendar.get(Calendar.MINUTE);
                this.second = calendar.get(Calendar.SECOND);
                
                double clockRadius = Math.min(w, h) * 0.8 * 0.5;
		double centerX = w / 2;
		double centerY = h / 2;
                
		paintClock(); // Repaint the clock
                Text t5 = new Text(centerX - 15, centerY - clockRadius + 29, "Korea");
                getChildren().addAll(t5);
                
	}
}