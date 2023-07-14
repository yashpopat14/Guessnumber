import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class App extends Application{
    @FXML
    private Button guessBtn;

    @FXML
    private TextField input;

    @FXML
    private Label message;

    @FXML
    private Button restartBtn;

    public static void main(String[] args) throws Exception {
        launch(args);
    }
    int random=(int)(Math.random()*100)+1;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root=FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    int attempts=0;

    public void check()
    {
        String number=input.getText();
        int inputNumber;
        try{
            inputNumber=Integer.parseInt(number);
        }
        catch(NumberFormatException e)
        {
            message.setText("Invalid Value");
            return;
        }

        attempts++;
        if(inputNumber==random)
        {
            message.setText("You Guess Correct Number...!  "+ "Attempts : "+attempts);
        }
        else if(inputNumber>random)
        {
            message.setText("Enter Lower Value.... " +  "Attempts : "+attempts);
        }
        else
        {
            message.setText("Enter Higher Value.... " + "Attempts : "+attempts);
        }
        input.clear();

    }

}
