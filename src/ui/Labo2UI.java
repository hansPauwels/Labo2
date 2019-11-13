package ui;

import service.Labo2Service;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Labo2UI {

    public Labo2UI(Stage stage) {
        Label choiceLabel = new Label("Choose method: ");
        ComboBox<String> choiceCombo = new ComboBox<>();
        Labo2Service service = new Labo2Service();
        Label encodeChoiceLabel = new Label("Encode? / Decode?");

        ComboBox<String> encodeOrDecodeCombo = new ComboBox<>();
        ObservableList<String> types = FXCollections.observableList(service.getStrategyList());
        choiceCombo.setItems(types);
        Label textLabel = new Label("Enter text: ");
        TextField textField = new TextField();
        Button enterButton = new Button("Go");
        Label resultLabel = new Label();

        encodeOrDecodeCombo.getItems().add("Encode");
        encodeOrDecodeCombo.getItems().add("Decode");
        GridPane root = new GridPane();
        Scene scene = new Scene(root, 300, 350);
        stage.setScene(scene);
        stage.setTitle("Labo 2: Strategy");

        root.add(choiceLabel, 0,0);
        root.add(choiceCombo, 0,1);
        root.add(encodeChoiceLabel, 0,2);
        root.add(encodeOrDecodeCombo, 0,3);
        root.add(textLabel, 0,4);
        root.add(textField, 0, 5);
        root.add(enterButton, 0,7);
        root.add(resultLabel, 0,8);

        stage.show();

        enterButton.setOnAction(actionEvent -> {
            String strategy = choiceCombo.getSelectionModel().getSelectedItem();
            String choice = encodeOrDecodeCombo.getSelectionModel().getSelectedItem();
            String text = textField.getText();
            String result;

            service.setText(text);
            if(strategy == null || strategy.trim().isEmpty()) {
                throw new IllegalArgumentException("Strategy cannot be empty");
            }

            if(strategy.equals("CAESAR")) {
                service.setStrategy(service.createStrategy("CAESAR"));

                if(choice.equals("Encode")) {
                        result = service.encode();
                        resultLabel.setText(result);
                    } else {
                        result = service.decode();
                        resultLabel.setText(result);
                    }
                } else if(strategy.equals("MIRROR")) {
                    //CodeerContext spiegelContext = new CodeerContext(new SpiegelStrategy(), text);
                    service.setStrategy(service.createStrategy("MIRROR"));
                    if(choice.equals("Encode")) {
                        result = service.encode();
                        resultLabel.setText(result);
                    } else {
                        result = service.decode();
                        resultLabel.setText(result);
                    }
            } else if(strategy.equals("RANDOM")) {
                service.setStrategy(service.createStrategy("RANDOM"));
                if(choice.equals("Encode")) {
                    result = service.encode();
                    resultLabel.setText(result);
                } else {
                    result = service.decode();
                    resultLabel.setText(result);
                }

            }
        });
    }

//    @Override
//    public void start(Stage stage) throws Exception {
////        choiceCombo.getItems().add("Caesar cipher");
////        choiceCombo.getItems().add("Mirror text");
//
//
//        enterButton.setOnAction(actionEvent -> {
//            String strategy = choiceCombo.getSelectionModel().getSelectedItem();
//            String choice = encodeOrDecodeCombo.getSelectionModel().getSelectedItem();
//            String text = textField.getText();
//            String result = "";
//
//            if(strategy != null || !strategy.trim().isEmpty()) {
//                if(strategy.equals("Caesar cipher")) {
//                    codeerContext.setStrategy(new CaesarStrategy());
//                    if(choice.equals("Encode")) {
//                        result = codeerContext.encode();
//                        resultLabel.setText(result);
//                    } else {
//                        result = codeerContext.decode();
//                        resultLabel.setText(result);
//                    }
//                } else if(strategy.equals("Mirror text")) {
//                    //CodeerContext spiegelContext = new CodeerContext(new SpiegelStrategy(), text);
//                    codeerContext.setStrategy(new SpiegelStrategy());
//                    if(choice.equals("Encode")) {
//                        result = codeerContext.encode();
//                        resultLabel.setText(result);
//                    } else {
//                        result = codeerContext.decode();
//                        resultLabel.setText(result);
//                    }
//                }
//            }
//        });
//    }
}
