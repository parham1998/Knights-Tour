package knights_tour;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class chessboard {

    public man[][] m = new man[8][8];

    public static int getNum(int x, int y) {
        if (x >= 40 && x < 8 * 90 + 40 && y >= 40 && y < 8 * 90 + 40) {
            return 10 * (7 - (y - 40) / 90) + (x - 40) / 90;
        }
        return -1;
    }

    public void push(int i) {
        m[i / 10][i % 10] = new knight(i);
    }

    public void push_check(int i) {
        m[i / 10][i % 10] = new check(i);
    }

    public void drawboard(GraphicsContext gc) {
        gc.clearRect(0, 0, 800, 800);
        int size = 90;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (j - i == 0 || i - j == 2 || j - i == 2 || i - j == 4 || j - i == 4 || i - j == 6 || j - i == 6) {
                    gc.setFill(Color.ANTIQUEWHITE);
                }
                if (j + i == 7 || i + j == 5 || j + i == 9 || i + j == 3 || j + i == 1 || i + j == 11 || j + i == 13) {
                    gc.setFill(Color.CHOCOLATE);
                }
                gc.fillRect(j * 90 + 40, i * 90 + 40, size, size);
                gc.strokeRect(j * 90 + 40, i * 90 + 40, 90, 90);

                if (m[7 - i][j] != null) {
                    m[7 - i][j].draw(gc);
                }
            }
        }
    }
}
