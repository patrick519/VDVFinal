/**
 * Created by pepij on 4-5-2017.
 */
import java.util.*;

class Cell{
    //Constructor
    public Cell(){
        L = null;
        gobj = null;
    }
    public GameObject gobj;
    public Cell L,R,T,B;
}

//           Top
//       _____________
//  Left |   gobj    | Right
//       -------------
//           Bottom
