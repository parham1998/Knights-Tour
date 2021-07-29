package knights_tour;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class main extends Application {

    @Override
    public void start(Stage stage) {
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 967, 550);

        scene.setOnMousePressed((MouseEvent event) -> {
                stage.close();
                gameplay g = new gameplay();
                g.start(stage);
        });

        ImageView im = new ImageView(getClass().getResource("main.png").toExternalForm());
        root.getChildren().add(im);

        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
