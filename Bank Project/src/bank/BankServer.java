package bank;    

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

public class BankServer extends Application {
    private ArrayList<Bank> bankAccounts = new ArrayList<>();
    private int accountCount = 0;
    private int port = 8000;

    TextArea taServer;

    @Override
    public void start(Stage primaryStage) {
        taServer = new TextArea();
        Scene scene = new Scene(new ScrollPane(taServer), 400, 350);

        primaryStage.setOnCloseRequest((e) -> {
            Platform.exit();
            System.exit(0);
        });
        primaryStage.setTitle("Bank Server");
        primaryStage.setScene(scene);
        primaryStage.show();

        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(port);
                Platform.runLater(() -> taServer.appendText("Server started at " + new Date() + "\n\nServer awaiting connections\n\n"));
                Socket socket;

                while (true) {
                    socket = serverSocket.accept();
                    new Thread(new HandleClient(socket)).start();

                    Platform.runLater(() -> taServer.appendText("Connection to Client successful\n"));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    class HandleClient implements Runnable {
        private Socket client;

        public HandleClient(Socket client) {
            this.client = client;
        }

        public void run() {
            try {
                DataInputStream in = new DataInputStream(client.getInputStream());
                DataOutputStream out = new DataOutputStream(client.getOutputStream());

                // Operation 1 = balance, 2 = deposit, 3 = withdraw, 4 = client exit
                int operation = 0;
                while (operation != 4) {
                    operation = in.readInt();
                    int accountNumber = in.readInt();
                    double amount = in.readDouble();

                    switch(operation) {
                        case 1 : balance(accountNumber, out); break;
                        case 2 : deposit(accountNumber, amount, out); break;
                        case 3 : withdraw(accountNumber, amount, out);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            Platform.runLater(() -> taServer.appendText("From Client --> Quit\nQuit\nYour session is being terminated\n"));
        }

        private int exists(int accountNumber) {
            for (int i = 0; i < accountCount; i++) {
                if (Integer.parseInt(bankAccounts.get(i).getAccountNumber()) == accountNumber) {
                    return i;
                }
            }
        
            return -1;
        }

        private void balance(int accountNumber, DataOutputStream out) throws IOException {
            Platform.runLater(() -> taServer.appendText("From Client --> Balance " + accountNumber + "\n"));
            int index = exists(accountNumber);

            if (index == -1) {
                out.writeDouble(-1);
                Platform.runLater(() -> taServer.appendText("Account " + accountNumber + " doesn't exist\n"));
            } else {
                Bank account = bankAccounts.get(index);
                out.writeDouble(account.getBalance());
                Platform.runLater(() -> taServer.appendText("Your balance in your account " + accountNumber + " is "
                        + account.getBalance() + "\n"));
            }
        }

        private void deposit(int accountNumber, double amount, DataOutputStream out) throws IOException {
            Platform.runLater(() -> taServer.appendText("From Client --> Deposit " + accountNumber + " " + amount + "\n"));
            int index = exists(accountNumber);
            Bank account;

            if (index == -1) {
                account = new Bank(String.valueOf(accountNumber));
                bankAccounts.add(account);
                accountCount++;
            } else {
                account = bankAccounts.get(index);
            }

            if (account.deposit(amount)) {
                out.writeDouble(account.getBalance());
                Platform.runLater(() -> taServer.appendText("You deposited " + amount + " in account " + accountNumber +
                        ". New Balance is " + account.getBalance() + "\n"));
            } else {
                Platform.runLater(() -> taServer.appendText("Invalid Deposit\n"));
                out.writeDouble(-1);
            }
        }

        private void withdraw(int accountNumber, double amount, DataOutputStream out) throws IOException {
            Platform.runLater(() -> taServer.appendText("From Client --> Withdraw " + accountNumber + " " + amount + "\n"));
            int index = exists(accountNumber);

            if (index == -1) {
                out.writeDouble(-1);
                Platform.runLater(() -> taServer.appendText("Account " + accountNumber + " doesn't exist\n"));
            } else {
                Bank account = bankAccounts.get(index);
                boolean valid = account.withdraw(amount);

                if (valid) {
                    out.writeDouble(account.getBalance());
                    Platform.runLater(() -> taServer.appendText("You withdrew " + amount + " in account " + accountNumber +
                            ". New Balance is " + account.getBalance() + "\n"));
                } else {
                    out.writeDouble(-2 - account.getBalance());
                    Platform.runLater(() -> taServer.appendText("Invalid Withdraw\n"));
                }
            }
        }
    }

    public static void main(String[] args) { launch(args); }
}
