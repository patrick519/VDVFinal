/**
 * Created by pepij on 4-5-2017.
 */
import java.awt.Color;

//ChildClass of GameObject

public class Box extends GameObject {
    public Box() {
        this.color = Color.lightGray;
        this.movable = true;
        this.display = "B";
    }
}

