/**
 * Created by pepij on 4-5-2017.
 */
import java.awt.Color;

public class Enemy extends GameObject {
    public Enemy() {
        this.color = Color.red;
        this.movable = true;
        this.display = "E";
    }
}
