package bank;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.layout.Priority;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class BankClient extends Application {
  private int port = 8000;

  private Socket socket;
  private DataInputStream in;
  private DataOutputStream out;
  
  private TextField tfaccountNumber = new TextField();
  private TextField tfbalance = new TextField();
  
  private TextArea taServer;

  // Button for sending a student to the server
  private Button btBalance = new Button("Balance");
  private Button btDeposit = new Button("Deposit");
  private Button btWithdraw = new Button("Withdraw");
  private Button btQuit = new Button("Quit");

  // Host name or ip
  String host = "localhost";
  DataOutputStream toServer = null;
  DataInputStream fromServer = null;
  
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    GridPane pane = new GridPane();
    pane.add(new Label("Account Number"), 0, 0);
    pane.add(tfaccountNumber, 4, 0);    
    pane.add(new Label("Amount $"), 0, 1);
    pane.add(tfbalance, 4, 1);
    
    HBox paneForButtons = new HBox(5);
    paneForButtons.setPadding(new Insets(5,2,5,2));
    HBox.setHgrow(btBalance, Priority.ALWAYS);
    btBalance.setMaxWidth(Double.MAX_VALUE);
    HBox.setHgrow(btDeposit, Priority.ALWAYS);
    btDeposit.setMaxWidth(Double.MAX_VALUE);
    HBox.setHgrow(btWithdraw, Priority.ALWAYS);
    btWithdraw.setMaxWidth(Double.MAX_VALUE);
    HBox.setHgrow(btQuit, Priority.ALWAYS);
    btQuit.setMaxWidth(Double.MAX_VALUE);
    paneForButtons.getChildren().addAll(btBalance, btDeposit, btWithdraw, btQuit);
     
    
    taServer = new TextArea();
    ScrollPane spServer = new ScrollPane(taServer);
    
    VBox verticalPane = new VBox();
    verticalPane.getChildren().addAll(pane, paneForButtons, spServer);
    
    tfaccountNumber.setPrefColumnCount(20);
    tfbalance.setPrefColumnCount(20);
    pane.setHgap(30);
    pane.setVgap(10);
    
    
    btBalance.setOnAction(this::buttonPressed);
    btDeposit.setOnAction(this::buttonPressed);
    btWithdraw.setOnAction(this::buttonPressed);
    btQuit.setOnAction(this::buttonPressed);
    
    primaryStage.setOnCloseRequest((e) -> {
            try {
                out.writeInt(4);
                out.writeInt(0);
                out.writeDouble(0);
                socket.close();
            } catch (IOException ex) {}

            Platform.exit();
            System.exit(0);
        });
    
    // Create a scene and place it in the stage
    Scene scene = new Scene(verticalPane, 450, 300);
    primaryStage.setTitle("Client"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.setResizable(false);
    primaryStage.sizeToScene();
    primaryStage.show(); // Display the stage
    
    try {
            taServer.appendText("Attempting Connection to the Server!\n");
            socket = new Socket("localhost", port);

            in = new DataInputStream(socket.getInputStream()); //from SlideShow
            out = new DataOutputStream(socket.getOutputStream()); //from SlideShow

            if (socket.isConnected()) {
                taServer.appendText("Connected to " + socket.getInetAddress() + '\n' + "Got IO streams\n\n" +
                        "Your connection to client was successful!\n\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
  }
    public void buttonPressed(ActionEvent e) {
        try {
            if (socket.isConnected()) {
                if (e.getSource() == btQuit) {
                    out.writeInt(4);
                    out.writeInt(0);
                    out.writeDouble(0);
                    socket.close();

                    taServer.appendText("\nQuitting\n" + "Closing the Connection with the Client\n");
                } else {
                    int buttonNumber = 0;
                    int accountNumber = Integer.parseInt(tfaccountNumber.getText().trim());
                    double amount = Integer.parseInt(tfbalance.getText().trim());
                    double accbBalance = 0;

                    if (e.getSource() == btBalance) { buttonNumber = 1; }
                    else if (e.getSource() == btWithdraw) { buttonNumber = 2; }
                    else { buttonNumber = 3; }

                    out.writeInt(buttonNumber);
                    out.writeInt(accountNumber);
                    out.writeDouble(amount);
                    accbBalance = in.readDouble();

                    switch(buttonNumber) {
                        case 1 : {
                            taServer.appendText("Balance " + accountNumber + "\n");

                            if (accbBalance == -1) {
                                taServer.appendText("From Server --> Your Account " + accountNumber + " doesn't exist\n");
                            } else {
                                taServer.appendText("From Server --> Your balance in the account " + accountNumber + " is " + accbBalance + "\n");
                            }

                            break;
                        }
                        case 2 : {
                            taServer.appendText("Withdraw " + accountNumber + " " + amount + "\n");

                            if (accbBalance == -1) {
                                taServer.appendText("From Server --> Your Account " + accountNumber + " doesn't exist\n");
                            } else if (accbBalance <= -2) {
                                taServer.appendText("You cannot withdraw " + amount + " from account " + accountNumber +
                                        ". Your balance is " + Math.abs(accbBalance + 2) + '\n');
                            } else {
                                taServer.appendText("Your balance in your account " + accountNumber + " is " + accbBalance + "\n");
                            }
                        }
                                                case 3 : {
                            taServer.appendText("Deposit " + accountNumber + " " + amount + "\n");

                            if (accbBalance == -1){
                                taServer.appendText("Invalid Deposit - Try Again\n");
                            }
                            else {
                                taServer.appendText("You deposited " + amount + " in your account " + accountNumber + ". Your new balance is " +
                                        accbBalance + "\n");
                            }

                            break;
                        }
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }  
  
    public static void main(String[] args) {
        launch(args);
    }
    
}
