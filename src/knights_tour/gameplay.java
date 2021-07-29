package knights_tour;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class gameplay {

    int row, col;
    boolean flag = true;
    chessboard board = new chessboard();
    int[] aa = new int[8];
    int[] bb = new int[8];
    int[] cc = new int[8];
    
    Timer timer = new Timer();

    //check array index
    boolean check_index_1(int i, int j) {
        return !(i > 7 || i < 0 || j > 7 || j < 0);
    }

    boolean check_index_2(int i, int j) {
        return i != j && i != -j && i != 0 && j != 0;
    }

    public void font(GraphicsContext gc) {
        Font theFont = Font.font("Times New Roman", FontWeight.NORMAL, 18);
        gc.setFill(Color.DARKBLUE);
        gc.setFont(theFont);
        gc.fillText("a                  b                  c                  d                  e                   f                   g                  h", 80, 30);
        gc.fillText("a                  b                  c                  d                  e                   f                   g                  h", 80, 780);
        gc.fillText("8", 20, 90);
        gc.fillText("7", 20, 180);
        gc.fillText("6", 20, 270);
        gc.fillText("5", 20, 360);
        gc.fillText("4", 20, 450);
        gc.fillText("3", 20, 540);
        gc.fillText("2", 20, 630);
        gc.fillText("1", 20, 720);
        gc.fillText("8", 770, 90);
        gc.fillText("7", 770, 180);
        gc.fillText("6", 770, 270);
        gc.fillText("5", 770, 360);
        gc.fillText("4", 770, 450);
        gc.fillText("3", 770, 540);
        gc.fillText("2", 770, 630);
        gc.fillText("1", 770, 720);
        gc.fillText("choose \na place\n\nthen", 810, 100);
        gc.fillText("Press Enter \nto continue", 810, 200);
    }

    public void start(Stage stage) {
        Group g = new Group();
        Scene s = new Scene(g);
        
        stage.setScene(s);
        
        Canvas c = new Canvas(900, 800);
        g.getChildren().add(c);
        GraphicsContext gc = c.getGraphicsContext2D();
        board.drawboard(gc);
        font(gc);
        stage.show();

        s.setOnMousePressed((e) -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                int i = chessboard.getNum((int) e.getX(), (int) e.getY());
                if (i != -1 && flag == true) {
                    board.push(i);
                    board.drawboard(gc);
                    font(gc);
                    row = i / 10;
                    col = i % 10;
                    flag = false;
                }
            }
        });

        s.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            for (int i = 0; i < 8; i++) {
                aa[i] = 0;
                bb[i] = 0;
                cc[i] = 0;
            }
            int k = 0;
            boolean end_flag = true;
            
            for (int x1 = -2; x1 <= 2; x1++) {
                for (int y1 = -2; y1 <= 2; y1++) {
                    if (check_index_2(x1, y1) && check_index_1(row + x1, col + y1) && board.m[row + x1][col + y1] == null) {
                        for (int x = -2; x <= 2; x++) {
                            for (int y = -2; y <= 2; y++) {
                                if (check_index_2(x, y) && check_index_1(row + x + x1, col + y + y1) && board.m[row + x1 + x][col + y1 + y] == null) {
                                    aa[k]++;
                                    bb[k] = x1;
                                    cc[k] = y1;
                                    end_flag = false;
                                }
                            }
                        }
                        k++;
                    }
                }
            }
            //
            int min = aa[0];
            int hold_index = 0;
            for (int i = 1; i < 8; i++) {
                if (aa[i] != 0 && aa[i] <= min) {
                    min = aa[i];
                    hold_index = i;
                }
            }
            //
            board.push_check(row * 10 + col);
            
            row = row + bb[hold_index];
            col = col + cc[hold_index];
            board.push(row * 10 + col);
            //last move            
            if (end_flag == true) {
                int ihold = 0, jhold = 0;
                int counter = 0;
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (board.m[i][j] == null) {
                            counter++;
                            ihold = i;
                            jhold = j;
                        }
                    }
                }
                if (counter == 1) {
                    board.push(ihold * 10 + jhold);
                }
            
                board.push_check(row * 10 + col);
                gc.fillText("Finish !", 810, 600);
            }
            
            board.drawboard(gc);
            font(gc);
        });
    }

}
