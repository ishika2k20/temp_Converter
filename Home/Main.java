package Home;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class Main extends Application {

    public static void main(String[] args) {
        System.out.println("main");
        launch(args);
    }

    @Override
    public void init() throws Exception {
        System.out.println("init");
        super.init();
    }


    @Override

    public void start(Stage primaryStage) throws Exception{



        FXMLLoader loader =  new FXMLLoader(getClass().getResource("HomeScreen.fxml"));

        VBox rootNode = loader.load();


        MenuBar menuBar=createMenu();
        rootNode.getChildren().add(0,menuBar);

        Scene scene = new Scene(rootNode);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Temp Conv.");
        primaryStage.show();
    }

    private MenuBar createMenu() {



        Menu fileMenu=new Menu("File");
        MenuItem newMenuItem = new MenuItem("New");
        newMenuItem.setOnAction(event -> System.out.println("New Menu Item clicked"));

        SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();


        MenuItem quitMenuItem = new MenuItem("Quit");
        quitMenuItem.setOnAction(event -> { Platform.exit();
            System.exit(0);
        });
        fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);

        //help menu
        Menu helpMenu = new Menu("Help");
        MenuItem aboutApp = new MenuItem("About");
        aboutApp.setOnAction(event -> aboutApp());
        helpMenu.getItems().addAll(aboutApp);

        //menu bar
        MenuBar menubar=new MenuBar();
        menubar.getMenus().addAll(fileMenu,helpMenu);
        return menubar;

    }

    private void aboutApp() {
        //TODO
        Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("hello its my app");
        alertDialog.setHeaderText("Learning Javafx");
        alertDialog.setContentText("I am just a beginner but soon i will be pro and will develop awesome game and will let people stop pubg ");
        ButtonType yesBtn= new ButtonType("yes");
        ButtonType noBtn = new ButtonType("No");
        alertDialog.getButtonTypes().setAll(yesBtn,noBtn);


        Optional<ButtonType> clickedBtn=alertDialog.showAndWait();


        if(clickedBtn.isPresent() &&clickedBtn.get()== yesBtn){
            System.out.println("yes button clicked");
        }
        if(clickedBtn.isPresent()&&clickedBtn.get()==noBtn){
            System.out.println("no button clicked");
        }
    }


    @Override
    public void stop() throws Exception {
        System.out.println("stop");
        super.stop();
    }
}
