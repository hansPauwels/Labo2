package ui;

import javafx.application.Application;
import javafx.stage.Stage;

public class Labo2Launcher extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        new Labo2UI(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
