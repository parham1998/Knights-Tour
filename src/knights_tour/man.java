package knights_tour;

import javafx.scene.canvas.GraphicsContext;

public abstract class man {

    protected static int X = 40, Y = 40, size = 90;
    protected int i, j, num;

    public man(int NUM) {
        this.i = NUM / 10;
        this.j = NUM % 10;
        this.num = NUM;
    }

    public abstract void draw(GraphicsContext gc);

    public abstract int type();
}
