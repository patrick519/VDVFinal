/**
 * Created by pepij on 4-5-2017.
 */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class UI extends JFrame {
    public int aantVakjes = 10;
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
        speelVeld = new veld(aantVakjes, aantVakjes);

        this.setFocusable(true);
        this.requestFocusInWindow();


        String[] var2 = new String[]{"", "", "", "", "", "", "", "", "", ""};
        Object[][] var3 = new Object[aantVakjes][aantVakjes];

        for(int var4 = 0; var4 < aantVakjes; ++var4) {
            for(int var5 = 0; var5 < aantVakjes; ++var5) {
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
        //panel.add(var6);
        setContentPane(panel);
        setSize((aantVakjes * afmetingVakje)+ 500, (aantVakjes * afmetingVakje) + 500);
        setLayout(new GridBagLayout());
        maakLayout();
        setVisible(true);
        this.pack();
        this.setVisible(true);

    }

    public void maakLayout() {
        GridBagConstraints layout = new GridBagConstraints();

        layout.fill = GridBagConstraints.BOTH;

        layout.gridx = 0;
        layout.gridy = 0;
        layout.weightx = 1.0;
        layout.weighty = 1.0;
        layout.gridheight = 2;
        panel.add(speelVeld, layout);

        layout.gridx = 1;
        layout.gridy = 0;
        layout.weightx = 0;
        layout.weighty = 1;
        layout.gridheight = 1;
        panel.add(pauzeKnop, layout);

        layout.gridy = 1;
        panel.add(resetKnop, layout);

    }

    public void repaint() {
        super.repaint();
        speelVeld.paintComponents(getGraphics());
    }

    public class veld extends JComponent {
        veld (int rij, int kolom) {
            setMinimumSize(new Dimension(afmetingVakje * aantVakjes, afmetingVakje * aantVakjes));
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (bord == null) {
                return;
            }

            for (int i = 0; i < bord.maxX; i++) {
                for (int j = 0; j < bord.maxY; j++) {
                    tekenCell(g, bord, i, j);
                }
            }

        }

        private void tekenCell(Graphics g, PlayBoard board, int i, int j) {
            g.setColor(Color.yellow);
            if (board.IsObject(i,j)) {
                System.out.print("i: " + i + " j: " + j + " " );
                g.setColor(Color.red);
            }

            g.fillRect(i * afmetingVakje, j * afmetingVakje, afmetingVakje, afmetingVakje);
        }

        private Color getColor(String input) {
            System.out.println(input);
            return Color.red;
        }
    }
}
