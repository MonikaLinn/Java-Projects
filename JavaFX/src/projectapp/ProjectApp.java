
package projectapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Polyline;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Monika
 */
public class ProjectApp extends Application {
    Polyline polyline;
    
    @Override
    public void start(Stage primaryStage) {
       
        BorderPane root = new BorderPane();
        
        Pane pane = new Pane();
        
        polyline = null; 
        
        Button clear = new Button("Clear the Screen");
        
        
        clear.setOnAction( e ->{
         pane.getChildren().clear();   
         polyline = null;   
        });
        
        pane.setOnMouseClicked(e -> {
            
            if(e.getClickCount() == 1) {
             
                if(polyline == null) {
                    
                 polyline = new Polyline(e.getX(), e.getY());
                 
                 pane.getChildren().add(polyline);
                } else {
                    polyline.getPoints().addAll(e.getX(), e.getY());
                }
            } else {
                
                polyline = null; 
                
            }
            
        });
 
   root.setCenter(pane);
   root.setBottom(clear);
   Scene background = new Scene(root, 595, 300);    
   primaryStage.setScene(background);
   primaryStage.setTitle("Draw a Polyline");
   primaryStage.show();
   
    }
    

    public static void main(String[] args) {
        launch(args);
    }
    
}
