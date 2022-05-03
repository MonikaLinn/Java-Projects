package threadproject;

import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.paint.Color;
import javafx.scene.Node;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javafx.geometry.Insets;

public class DrawArcs extends Pane {
    
    private double startAngle = 15; // Start angle of arcs
    private Timeline fan; // animation
    private Pane paneForBlades = new Pane(); // Create four arcs
    private Arc arc;
    double w = 250, h = 250;
    double clockRadius = Math.min(w, h) * 0.8 * 0.5;
    double centerX = w / 2;
    double centerY = h / 2;
    
    public DrawArcs() {
                Circle circle = new Circle(centerX, centerY, clockRadius);
		setPadding(new Insets(10, 10, 10, 10));
		circle.setStroke(Color.TRANSPARENT);
		circle.setFill(Color.SALMON);
		getBlades();
		getChildren().addAll(circle, paneForBlades);
		fan = new Timeline(
			new KeyFrame(Duration.millis(250), e -> spinFan()));
		fan.setCycleCount(Timeline.INDEFINITE);
	}

    /** Animate fan blades */
    protected void spinFan() {
            ObservableList<Node> list = paneForBlades.getChildren();
            for (Node n: list) {
                    ((Arc)n).setStartAngle(((Arc)n).getStartAngle() + startAngle);
            }
    }

    /** Pause animation */
	public void pause() {
		fan.pause();
	}

	/** Resume animation */
	public void play() {
		fan.play();
	}
    
// The class for drawing arcs on a panel
    private void getBlades() {
		double angle = 0;
		for (int i = 0; i < 4; i++) {
			arc = new Arc(centerX, centerY, clockRadius, 100.0f, 100.0f, 100.0f); 
			
			arc.setStartAngle(angle + 90);
			arc.setLength(30);
			arc.setFill(Color.BLACK);
			arc.setType(ArcType.ROUND);
			paneForBlades.getChildren().add(arc);
			angle += 90;
		}
	}

}

