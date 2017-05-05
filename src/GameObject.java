/**
 * Created by pepij on 4-5-2017.
 */
import java.util.*;
import java.awt.Color;

//ParentClass of all game object (Block, Box, Player, Enemy)

class GameObject {
    public boolean movable;
    public Color color;
    public String display;

    public GameObject() {
    }

    String getDisplay() {
        return this.display;
    }
}
