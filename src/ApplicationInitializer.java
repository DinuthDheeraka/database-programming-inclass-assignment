import javafx.application.Application;
import javafx.stage.Stage;
import util.Navigations;

import java.io.IOException;

public class ApplicationInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Navigations.getInstance().setNewStage("main-form");
    }
}
