/**
 * Created by pepij on 4-5-2017.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayBoard {
    public int maxX;
    public int maxY;
    private int boardSize;
    public Object[][] baseBoard;

    public PlayBoard(int var1, int var2) {
        this.maxX = var1;
        this.maxY = var2;
        this.boardSize = var1 * var2;
        this.baseBoard = new Object[var1][var2];

        //setting the cells in the structure
        for(int var3 = 0; var3 < var1; ++var3) {
            for(int var4 = 0; var4 < var2; ++var4) {
                this.baseBoard[var3][var4] = new  Cell();
            }
        }

        this.SetNeigbors();
        this.SetPlayer();
        this.SetEnemy();
    }

    private Cell GetCell(int var1, int var2) {
        Cell var3 = (Cell)this.baseBoard[var1][var2];
        return var3;
    }

    private void SetNeigbors() {
        for(int var2 = 0; var2 < this.maxX; ++var2) {
            for(int var3 = 0; var3 < this.maxY; ++var3) {
                Cell var1 = this.GetCell(var2, var3);
                if(var2 < 0) {
                    var1.L = this.GetCell(var2 - 1, var3);
                }

                if(var2 > this.maxX) {
                    var1.R = this.GetCell(var2 + 1, var3);
                }

                if(var3 < 0) {
                    var1.T = this.GetCell(var2, var3 - 1);
                }

                if(var3 > this.maxY) {
                    var1.B = this.GetCell(var2, var3 + 1);
                }
            }
        }

    }

    public void SetPlayer() {
        Cell var1 = this.GetCell(0, 0);
        var1.gobj = new Player();
    }

    public void SetEnemy() {
        Cell var1 = this.GetCell(this.maxX - 1, this.maxY - 1);
        var1.gobj = new Enemy();
    }

    public boolean IsObject(int var1, int var2) {
        Cell var3 = this.GetCell(var1, var2);
        return var3.gobj != null;
    }

    public void SetBlock(int var1, int var2) {
        Cell var3 = this.GetCell(var1, var2);
        var3.gobj = new Block();
    }

    public void SetBox(int var1, int var2) {
        Cell var3 = this.GetCell(var1, var2);
        var3.gobj = new Box();
    }

    public void DelObject(int var1, int var2) {
        Cell var3 = this.GetCell(var1, var2);
        var3.gobj = null;
    }

    public void SetRandom(int var1, int var2) {
        Random var3 = new Random();
        int var6 = this.boardSize * var1 / 100;

        int var4;
        int var5;
        int var7;
        for(var7 = 0; var7 < var6; ++var7) {
            var4 = var3.nextInt(this.maxX);
            var5 = var3.nextInt(this.maxY);
            if(!this.IsObject(var4, var5)) {
                this.SetBlock(var4, var5);
            } else {
                --var7;
            }
        }

        var6 = this.boardSize * var2 / 100;

        for(var7 = 0; var7 < var6; ++var7) {
            var4 = var3.nextInt(this.maxX);
            var5 = var3.nextInt(this.maxY);
            if(!this.IsObject(var4, var5)) {
                this.SetBox(var4, var5);
            } else {
                --var7;
            }
        }

    }

    public String Display(int var1, int var2) {
        Cell var3 = this.GetCell(var1, var2);
        return var3.gobj.getDisplay();
    }
}