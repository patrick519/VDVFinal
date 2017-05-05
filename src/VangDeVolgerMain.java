/**
 * Created by pepij on 4-5-2017.
 */
class VangDeVolgerMain {
    PlayBoard bord;
    UI ui;

    public VangDeVolgerMain() {
        bord = new Game(10,10);
        ui = new UI(bord);
    }

    public static void main(String[] args){

        VangDeVolgerMain spel = new VangDeVolgerMain();
    }
}
