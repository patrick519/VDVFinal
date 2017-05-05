/**
 * Created by pepij on 4-5-2017.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.Color;

//ParentClass of the game

public class PlayBoard {

    //Constructor
    public PlayBoard(int x, int y) {
        this.maxX = x;
        this.maxY = y;
        this.boardSize = x * y;
        this.baseBoard = new Object[x][y];

        //setting the cells in the structure
        for(int i = 0; i < x; i++)
            for(int j = 0; j < y; j++)
                this.baseBoard[i][j] = new Cell();
        this.InitNeighbors();
    } //PlayBoard

    //Support functions------------------------------------

    private Cell GetCell(int x, int y) {
        Cell cll = (Cell)this.baseBoard[x][y];
        return cll;
    } //GetCell

    private void InitNeighbors(){
        Cell curr;
        for (int i = 0; i < this.maxX; i++)
            for (int j = 0; j < this.maxY; j++){
                curr = this.GetCell(i,j);
                if (i < 0) curr.L = this.GetCell(i-1,j);
                if (i > this.maxX) curr.R = this.GetCell(i+1,j);
                if (j < 0) curr.T = this.GetCell(i,j-1);
                if (j > this.maxY) curr.B = this.GetCell(i,j+1);
            } //for
    } //SetNeighbors

    //Default operations-----------------------------------

    public boolean IsObject(int x, int y) {
        Cell temp = this.GetCell(x,y);
        return temp.gobj != null;
    } //IsObject

    public void DelObject(int x, int y) {
        Cell temp = this.GetCell(x,y);
        temp.gobj = null;
    } //DelObject

    public void SetBlock(int x, int y) {
        Cell temp = this.GetCell(x,y);
        temp.gobj = new Block();
    } //SetBlock

    public void SetBox(int x, int y) {
        Cell temp = this.GetCell(x,y);
        temp.gobj = new Box();
    } //SetBox

    public void SetPlayer(int x, int y) {
        Cell temp = this.GetCell(x,y);
        temp.gobj = new Player();
    } //SetPlayer

    public void SetEnemy(int x, int y) {
        Cell temp = this.GetCell(x,y);
        temp.gobj = new Enemy();
    } //SetEnemy

    //UI operations---------------------------------------

    public String Display(int x, int y){
        Cell temp = this.GetCell(x,y);
        return temp.gobj.getDisplay();
    } //Display

    public Color GetColor(int x, int y){
        Cell temp = this.GetCell(x,y);
        return temp.gobj.color;
    } //GetColor

    //Variables-------------------------------------------

    public int maxX, maxY, boardSize;
    //Declaring the 2D objectArray
    public Object[][] baseBoard;
}
