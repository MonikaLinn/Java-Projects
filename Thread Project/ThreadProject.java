package threadproject;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.paint.Color;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text; 
import java.util.Timer;

public class ThreadProject extends Application {
                
   @Override // Override the start method in the application class
	public void start(Stage primaryStage) {
		
                HBox paneClock1 = new HBox(5);
                paneClock1.setPadding(new Insets(0, 15, 20, 0));
                
                HBox paneClock2 = new HBox(5);
                paneClock2.setPadding(new Insets(0, 15, 20, 0));
                
                HBox paneClock3 = new HBox(5);
                paneClock3.setPadding(new Insets(0, 15, 20, 0));
                
                StillClock clock1 = new StillClock();
		StillClock clock2 = new StillClock();
                StillClock clock3 = new StillClock();
                
                EventHandler<ActionEvent> eventHandler = e -> {
                    clock1.setCurrentTime();
                    clock2.setCurrentTime2();
                    clock3.setCurrentTime1();
                };
                
                paneClock1.getChildren().addAll(clock1);
                
                paneClock2.getChildren().addAll(clock2);
                
                paneClock3.getChildren().addAll(clock3);
                
              // Create a four hboxs
		HBox paneForFan1 = new HBox(5);
		paneForFan1.setAlignment(Pos.CENTER);
		paneForFan1.getChildren().addAll(getFan());

                HBox paneForFan2 = new HBox(5);
		paneForFan2.setAlignment(Pos.CENTER);
		paneForFan2.getChildren().addAll(getFan());
                
                HBox paneForFan3 = new HBox(5);
		paneForFan3.setAlignment(Pos.CENTER);
		paneForFan3.getChildren().addAll(getFan());
                
		HBox paneForButtons = new HBox(5);
		paneForButtons.setAlignment(Pos.CENTER);

                //Create 1 more hbox
                HBox paneForMoreButtons = new HBox(5);
		paneForMoreButtons.setAlignment(Pos.CENTER);
		paneForMoreButtons.getChildren().addAll(getButtons());
                
                HBox paneForMoreButtons1 = new HBox(5);
		paneForMoreButtons1.setAlignment(Pos.CENTER);
		paneForMoreButtons1.getChildren().addAll(getButtons());
                
                HBox paneForMoreButtons2 = new HBox(5);
		paneForMoreButtons2.setAlignment(Pos.CENTER);
		paneForMoreButtons2.getChildren().addAll(getButtons());
                
                // Create a pane
		GridPane pane1 = new GridPane();;
		pane1.add(paneClock1, 0, 0, 1, 1);
                pane1.add(paneClock2, 1, 0, 1, 1);
                pane1.add(paneClock3, 2, 0, 1, 1);
                pane1.add(paneForFan1, 0, 1, 1, 1);
                pane1.add(paneForFan2, 1, 1, 1, 1);
                pane1.add(paneForFan3, 2, 1, 1, 1);
                pane1.add(paneForMoreButtons, 0, 2, 1, 1);
                pane1.add(paneForMoreButtons1, 1, 2, 1, 1);
                pane1.add(paneForMoreButtons2, 2, 2, 1, 1);
                
                paneClock1.setStyle("-fx-background-color: yellow;");
                paneClock2.setStyle("-fx-background-color: yellow;");
                paneClock3.setStyle("-fx-background-color: yellow;");
                pane1.setStyle("-fx-background-color: silver;");
                
                Timeline animation = new Timeline(new KeyFrame(Duration.millis(1111), eventHandler));
                animation.setCycleCount(Timeline.INDEFINITE);
                animation.play();
                
                Scene scene = new Scene(pane1, 736, 650, Color.YELLOW);
                primaryStage.setTitle("Thread Project");
                primaryStage.setResizable(false);
                primaryStage.sizeToScene();
                primaryStage.setScene(scene);
                primaryStage.show();
               
        }
     
        public GridPane getFan() {
            
            // Create two buttons
            Button btForceStop = new Button("Force Stop");
            Button btForceStart = new Button("Force Start");

            HBox paneForButtons = new HBox(25);
            paneForButtons.getChildren().addAll(btForceStop, btForceStart);
            paneForButtons.setAlignment(Pos.CENTER);
            paneForButtons.setBackground(new Background(new BackgroundFill(Color.SILVER,null,null)));
	
            // Create a fan pane
            DrawArcs fan1 = new DrawArcs();

            // Create a border pane
            GridPane pane = new GridPane();
            pane.setVgap(10);
            pane.add(fan1, 0, 1 , 1 , 1); 
            pane.add(paneForButtons, 0, 6, 1, 1); 

            pane.setStyle("-fx-background-color: salmon;");

            // Create and register the handlers
            btForceStop.setOnAction(e -> {
                    fan1.pause();
            });

            btForceStart.setOnAction(e -> {
                    fan1.play();
            });

            return pane;
	}
        
        public GridPane getButtons() {
            
            Button btStartTimer = new Button("Start Timer");
            
            Timer timer = new Timer();
            
            Label label1 = new Label("Start Time (HH:MM:SS): ");
            TextField textField = new TextField ();
            textField.setPrefWidth(70);
            HBox startBox = new HBox();
            startBox.getChildren().addAll(label1, textField);
            startBox.setSpacing(7);
            startBox.setAlignment(Pos.CENTER);
            
            Label label2 = new Label("End Time (HH:MM:SS): ");
            TextField textField1 = new TextField ();
            textField1.setPrefWidth(70);
            HBox stopBox = new HBox();
            stopBox.getChildren().addAll(label2, textField1);
            stopBox.setSpacing(5);
            stopBox.setAlignment(Pos.CENTER);
           
            // Place buttons in a hbox
              
            HBox Timer = new HBox();
            Text text = new Text("Timer OFF");
            Timer.getChildren().addAll(text);
            Timer.setSpacing(5);
            
            HBox paneForTimerButton = new HBox(5);
            paneForTimerButton.getChildren().addAll(btStartTimer, text);
            paneForTimerButton.setAlignment(Pos.CENTER);
            
            GridPane buttons = new GridPane();
            buttons.setVgap(5);
            buttons.add(startBox, 0, 1, 2, 2);
            buttons.add(stopBox, 0, 3, 2, 2); 
            buttons.add(paneForTimerButton, 1, 8, 1, 1);
            buttons.add(Timer, 1, 8, 1, 1);
            
            buttons.setStyle("-fx-background-color: silver;");
            
            return buttons;
        }
        
        
        
        
}
