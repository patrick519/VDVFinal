/**
 * Created by pepij on 5-5-2017.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.Color;

//ChildClass of Playboard

public class Game extends PlayBoard {
    //Constructor
    public Game(int x, int y) {
        super(x,y);
        this.SetPlayer(0,0);
        this.SetEnemy(this.maxX - 1, this.maxY - 1);
        this.SetRandom(5,25);
    }

    public void SetRandom(int perBlk, int perBox){
        Random rand = new Random();
        int randX, randY, percent;
        //fill % Blocks
        percent = (boardSize*perBlk)/100;
        for (int i = 0; i < percent; i++){
            randX = rand.nextInt(this.maxX);
            randY = rand.nextInt(this.maxY);
            if (!IsObject(randX,randY))
                SetBlock(randX,randY);
            else
                i--;
        } //for
        //fill % Boxes
        percent = (boardSize*perBox)/100;
        for (int i = 0; i < percent; i++){
            randX = rand.nextInt(this.maxX);
            randY = rand.nextInt(this.maxY);
            if (!IsObject(randX,randY))
                SetBox(randX,randY);
            else
                i--;
        } //for
    } //SetRandom

    /*
    private void MovePlayer(char direction){

    } //MovePlayer

    private void MoveEnemy(){

    } //MoveEnemy

    private void MoveBox()(char direction){

    } //MoveBox

    private boolean DeadPlayer(){
        return false;
    } //DeadPlayer

    private boolean DeadEnemy(){
        return false;
    } //DeadPlayer
    */

} //Game
