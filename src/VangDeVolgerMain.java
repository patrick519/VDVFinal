/**
 * Created by pepij on 4-5-2017.
 */
public class VangDeVolgerMain {
    PlayBoard bord;
    UI ui;

    public VangDeVolgerMain() {
        bord = new PlayBoard(10,10);
        bord.SetRandom(5,25);
        ui = new UI(bord);


    }

    public static void main(String[] args){

        VangDeVolgerMain spel = new VangDeVolgerMain();

    }
}
