/**
 * Created by pepij on 4-5-2017.
 */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class UI extends JFrame {
    public int height = 1000;
    public int width = 1000;
    public int afmetingVakje = 50;
    public JButton resetKnop;
    public JButton pauzeKnop;
    public JPanel panel;
    public JComponent speelVeld;
    public PlayBoard bord;


    public UI(PlayBoard var1) {
        super();
        panel = new JPanel();
        pauzeKnop = new JButton("Pauze");
        resetKnop = new JButton("Reset");
        bord = var1;

        setLayout(new BorderLayout());
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttons.add(pauzeKnop);
        buttons.add(resetKnop);
        panel.add(buttons, BorderLayout.NORTH);
        this.setFocusable(true);
        this.requestFocusInWindow();


        String[] var2 = new String[]{"", "", "", "", "", "", "", "", "", ""};
        Object[][] var3 = new Object[10][10];

        for(int var4 = 0; var4 < 10; ++var4) {
            for(int var5 = 0; var5 < 10; ++var5) {
                if(bord.IsObject(var4, var5)) {
                    var3[var4][var5] = bord.Display(var4, var5);
                } else {
                    var3[var4][var5] = "- ";
                }
            }
        }
        JTable var6 = new JTable(var3, var2);

        this.setTitle("Vang de Volger");
        this.setDefaultCloseOperation(3);
        panel.add(var6, BorderLayout.SOUTH);
        setContentPane(panel);
        setSize(height, width);
        setLayout(new GridBagLayout());
        setVisible(true);
        this.pack();
        this.setVisible(true);
    }

    public class veld extends JComponent {
        veld (int rij, int kolom) {
            setMinimumSize(new Dimension(afmetingVakje * 10, afmetingVakje * 10));
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (bord == null) {
                return;
            }

            for (int i = 0; i < bord.maxX; i++) {
                for (int j = 0; j < bord.maxY; j++) {
                    //tekenCell(g, bord.baseBoard, i, j);
                }
            }
        }

        public void tekenCell(Graphics g, ArrayList bord, int i, int j) {

        }
    }
}
