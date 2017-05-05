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
    public JTable var6;

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
        var6 = new JTable(var3, var2);

        this.setTitle("Vang de Volger");
        this.setDefaultCloseOperation(3);

        this.setContentPane(panel);
        this.setSize((aantVakjes * afmetingVakje)+ 500, (aantVakjes * afmetingVakje) + 500);
        this.setLayout(new GridBagLayout());
        this.maakLayout();
        this.setVisible(true);
        this.pack();
        this.setVisible(true);

    }

    public void maakLayout() {
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        panel.add(pauzeKnop, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        panel.add(resetKnop, c);

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 2;
        panel.add(speelVeld, c);

        c.gridx = 2;
        panel.add(var6, c);

    }

    public void repaint() {
        super.repaint();
        speelVeld.paintComponents(getGraphics());
    }

    public class veld extends JComponent {
        veld (int rij, int kolom) {
            this.setMinimumSize(new Dimension(afmetingVakje * aantVakjes, afmetingVakje * aantVakjes));
            this.setPreferredSize(new Dimension(afmetingVakje * aantVakjes, afmetingVakje * aantVakjes));
            this.setMaximumSize(new Dimension(afmetingVakje * aantVakjes, afmetingVakje * aantVakjes));
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

                g.setColor(getCellcolor(board.Display(i,j)));
            }

            g.fillRect(j * afmetingVakje, i * afmetingVakje, afmetingVakje, afmetingVakje);
        }

        private Color getCellcolor(String input) {
            switch (input) {
                case "X":
                    return Color.MAGENTA;
                case "P":
                    return Color.blue;
                case "E":
                    return Color.red;
                case "B":
                    return Color.black;
                default:
                    return Color.yellow;

            }
        }
    }
}
