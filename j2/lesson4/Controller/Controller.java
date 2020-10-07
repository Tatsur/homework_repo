package ru.geekbrains.java.homework.j2.lesson4.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import ru.geekbrains.java.homework.j2.lesson4.Main;
import ru.geekbrains.java.homework.j2.lesson4.model.Message;
import ru.geekbrains.java.homework.j2.lesson4.model.User;

import java.io.IOException;
import java.util.Date;

public class Controller {
    @FXML
    public TextArea messageTypeField;
    @FXML
    public ListView<String> usersListView;
    @FXML
    public Button sendButton;

    @FXML
    private ListView<SplitPane> messagesList;

    private static  final String messageView = "view/messageElement.fxml";
    private static  final float MESSAGE_WRAP_SCALE = 1.3f;


    public void addMessage(String messageView) throws IOException {

        Message message = new Message("some text", new Date(), Main.user);
        SplitPane messagePane = FXMLLoader.load(Main.MESSAGE_VIEW);
        
        //set user name to message view
        AnchorPane userNamePane = (AnchorPane) messagePane.getItems().get(0);
        Label userLabelName = (Label) userNamePane.getChildren().get(0);
        userLabelName.setText(message.getUser());
        
        //set message text to message view
        AnchorPane textLabelPane = (AnchorPane) messagePane.getItems().get(1);
        TextArea textField = (TextArea) textLabelPane.getChildren().get(0);
        Text text = new Text(messageTypeField.getText());
        text.setWrappingWidth(MESSAGE_WRAP_SCALE * textField.getPrefWidth());
        textField.setPrefHeight(text.getLayoutBounds().getHeight());
        textField.setText(messageTypeField.getText());
        
        messagePane.setPrefHeight(textField.getPrefHeight() + 20);
        
        messagesList.getItems().add(messagePane);
        messagesList.scrollTo(messagePane);
        messageTypeField.clear();
    }
    public void addUsers(){
        for (User user : Main.users) {
            usersListView.getItems().add(user.getUserName());
        }
    }
    @FXML
    private void onClickSend(MouseEvent mouseEvent) throws IOException {
        addMessage(messageView);
    }
    @FXML
    public void typeFieldOnKeyTyped(KeyEvent keyEvent) {
        String text = messageTypeField.getText();
        if(text.isBlank()) {
            if (!sendButton.isDisabled()) sendButton.setDisable(true);
        }
        else if(sendButton.isDisabled()) sendButton.setDisable(false);
    }
}
