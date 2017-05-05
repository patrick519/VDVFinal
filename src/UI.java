/**
 * Created by pepij on 4-5-2017.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
    boolean key_right, key_left, key_down, key_up; // Input booleans


    public UI(PlayBoard var1) {
        super();
        panel = new JPanel();
        pauzeKnop = new JButton("Pauze");
        resetKnop = new JButton("Reset");
        bord = var1;
        speelVeld = new veld(aantVakjes, aantVakjes);

        this.setFocusable(true);
        panel.addKeyListener(new KeyInput());
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
        this.pack();
        this.setVisible(true);

    }

//    public class GamePanel extends JPanel {
//        boolean key_right, key_left, key_down, key_up; // Input booleans
//
//        public GamePanel() {
//            this.setFocusable(true);
//            addKeyListener(new KeyInput());
//        }
//
//        public void paintComponent(Graphics g) {
//
//        }
//    }


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
            g.setColor(Color.pink);
            if(key_down) {
                //y ++
                g.setColor(Color.PINK);
            }
            if (key_up) { //y--
                g.setColor(Color.MAGENTA);
            }
            if (key_right) {
                g.setColor(Color.YELLOW);
                //x++
            }
            if (key_left) {
                g.setColor(Color.BLUE);
                //x--
            }

            g.fillRect(0, 0, afmetingVakje, afmetingVakje);
        }

        private void tekenCell(Graphics g, PlayBoard board, int i, int j) {
            if (board.IsObject(i,j)) {
                g.setColor(board.GetColor(i,j));
            }
            else
                g.setColor(Color.white);

            g.fillRect(j * afmetingVakje, i * afmetingVakje, afmetingVakje, afmetingVakje);
        }
    }
    private class KeyInput implements KeyListener {
        public void keyTyped(KeyEvent e) {}

        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == e.VK_DOWN) key_down = false;
            if (e.getKeyCode() == e.VK_UP) key_up= false;
            if (e.getKeyCode() == e.VK_RIGHT) key_right= false;
            if (e.getKeyCode() == e.VK_LEFT) key_left = false;
        }

        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == e.VK_DOWN) key_down = true;
            if (e.getKeyCode() == e.VK_UP) key_up= true;
            if (e.getKeyCode() == e.VK_RIGHT) key_right= true;
            if (e.getKeyCode() == e.VK_LEFT) key_left = true;
        }
    }
}
