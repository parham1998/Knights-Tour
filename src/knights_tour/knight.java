package knights_tour;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class knight extends man {

    public knight(int NUM) {
        super(NUM);
    }

    @Override
    public void draw(GraphicsContext gc) {
        Image im = new Image("knights_tour/k.png");
        gc.drawImage(im, X + j * size + 20, Y + (7 - i) * size + 20, 50, 50);
    }

    @Override
    public int type() {
        return 1;
    }
}
