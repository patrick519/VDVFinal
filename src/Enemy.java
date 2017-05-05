/**
 * Created by pepij on 4-5-2017.
 */
import java.awt.Color;
//ChildClass of GameObject

public class Enemy extends GameObject {
    public Enemy() {
        this.color = Color.red;
        this.movable = true;
        this.display = "E";
    }
}

