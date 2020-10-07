package ru.geekbrains.java.homework.j2.lesson4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.geekbrains.java.homework.j2.lesson4.Controller.Controller;
import ru.geekbrains.java.homework.j2.lesson4.model.User;

import java.net.URL;
import java.util.List;

public class Main extends Application {
    public static final User user = new User(User.DEFAULT_USER_NAME);
    public static List<User> users = List.of(new User("Sergei"),new User("Andrew"),new User("Pavel"),user);
    public static URL MESSAGE_VIEW = null;
    {
        MESSAGE_VIEW = getClass().getResource("view/messageElement.fxml");
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("view/sample.fxml"));


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/sample.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Lesson_4 chat");
        primaryStage.setScene(new Scene(root));

        Controller controller = loader.getController();
        controller.sendButton.setDisable(true);
        controller.addUsers();

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
