/**
 * Created by pepij on 4-5-2017.
 */
import java.util.*;
import java.awt.Color;

//ChildClass of GameObject

public class Player extends GameObject {
    public Player() {
        this.color = Color.yellow;
        this.movable = true;
        this.display = "P";
    }
}