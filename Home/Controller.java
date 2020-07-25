package Home;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    @FXML
    public Label welcomelabel;
    @FXML
    public ChoiceBox<String> choicebox;
    @FXML
    public TextField userInputfield;
    @FXML
    public Button convertBtn;

    private static final String C_TO_F_TEXT="Celsius to Fahrenheit";
    private static final String F_TO_C_TEXT="Fahrenheit to Celsius";

    private boolean isC_TO_F= true;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choicebox.getItems().add(C_TO_F_TEXT);
        choicebox.getItems().add(F_TO_C_TEXT);

        choicebox.setValue(C_TO_F_TEXT);

        choicebox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {


            if(newValue.equals(C_TO_F_TEXT)){
                isC_TO_F=true;

            }else{
                isC_TO_F=false;
            }
        });
        convertBtn.setOnAction(event -> {
            convert();

        } );

    }

    private void convert() {
        String input = userInputfield.getText();

        Float enteredTemperature=0.0f;
        try{
            enteredTemperature =Float.parseFloat(input);
        }
        catch (Exception exception) {
            WarnUser();
            return;
        }

        float newTemperature= 0.0f;
        if(isC_TO_F){

            newTemperature = (enteredTemperature*9/5)+32;
        }else{

            newTemperature=(enteredTemperature-32)*5/9;
        }
        display(newTemperature);
    }
    private void WarnUser() {
        Alert alert= new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Occurred");
        alert.setHeaderText("Invalid Temperature Given");
        alert.setContentText(" Please Enter The Valid Temperature");
        alert.show();
    }

    private void display(float newTemperature) {

        String unit= isC_TO_F?  "F" : "C";

        System.out.println("  The New Temperature : " + newTemperature + unit);

        Alert alert= new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setContentText(" The New Temperature : " + newTemperature + unit);
        alert.show();
    }


}
