package ui;

import domain.CaesarStrategyFactoryFactory;
import domain.CodeerContextFactory;
import domain.SpiegelStrategy;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Labo2UI extends Application {
    private Label choiceLabel = new Label("Choose method: ");
    private ComboBox<String> choiceCombo = new ComboBox<>();
    private CodeerContextFactory codeerContextFactory;
    private Label encodeChoiceLabel = new Label("Encode? / Decode?");
    private ComboBox<String> encodeOrDecodeCombo = new ComboBox<>();
    private Label textLabel = new Label("Enter text: ");
    private TextField textField = new TextField();
    private Button enterButton = new Button("Go");
    private Label resultLabel = new Label();

    @Override
    public void start(Stage stage) throws Exception {
        choiceCombo.getItems().add("Caesar cipher");
        choiceCombo.getItems().add("Mirror text");
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
            String result = "";
            codeerContextFactory = new CodeerContextFactory(new CaesarStrategyFactoryFactory(), text);
            if(strategy != null || !strategy.trim().isEmpty()) {
                if(strategy.equals("Caesar cipher")) {
                    codeerContextFactory.setStrategy(new CaesarStrategyFactoryFactory());
                    if(choice.equals("Encode")) {
                        result = codeerContextFactory.encode();
                        resultLabel.setText(result);
                    } else {
                        result = codeerContextFactory.decode();
                        resultLabel.setText(result);
                    }
                } else if(strategy.equals("Mirror text")) {
                    //CodeerContext spiegelContext = new CodeerContext(new SpiegelStrategy(), text);
                    codeerContextFactory.setStrategy(new SpiegelStrategy());
                    if(choice.equals("Encode")) {
                        result = codeerContextFactory.encode();
                        resultLabel.setText(result);
                    } else {
                        result = codeerContextFactory.decode();
                        resultLabel.setText(result);
                    }
                }
            }
        });
    }
}
