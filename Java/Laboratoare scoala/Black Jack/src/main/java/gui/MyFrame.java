package gui;

import pack_carte.Mana;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class MyFrame extends JFrame implements ActionListener {
    private final ArrayList<JLabel> cards = new ArrayList<>();

    private static MyFrame instance = new MyFrame( );

    private final int CARD_WIDTH = 160;       // size width
    private final int CARD_HEIGHT = 245;      // size height
    private final int BETWEEN_CARD = 25;
    private final int BETWEEN_BORDER = 40;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private final int WINDOW_WIDTH = (int) screenSize.getWidth();
    private final int WINDOW_HEIGHT = (int) screenSize.getHeight();
    private final int WINDOW_HALF_X = WINDOW_WIDTH / 2;
    private final int WINDOW_HALF_Y = WINDOW_HEIGHT / 2;
    public final int playerPositionOffset = WINDOW_HEIGHT - CARD_HEIGHT - BETWEEN_BORDER;
    public final int computerPositionOffset = WINDOW_HALF_Y;

    public String buttonOption = "0";


    ///BUTTONS TEXT FIELDS LABELS
    JLabel background;
    JLabel puncte = new JLabel("Puncte: 0");
    JButton button1 = new JButton("Take card");
    JButton button2 = new JButton("Check");
    JButton button3 = new JButton("show ");
    JButton button4 = new JButton("New game");
    JTextArea endText = new JTextArea();

    //singleton

    private MyFrame() {
        // Exists only to defeat instantiation.
    }
    public void deleteInstance(){
        this.instance=null;

    }

    public static MyFrame getInstance() {
        if(instance == null) {
            instance = new MyFrame();
        }
        return instance;
    }


    public void initWindow() {
        System.out.println("RESOLUTION: " + WINDOW_WIDTH + "x" + WINDOW_HEIGHT);

//initializam fereastra
        this.setTitle("Blackjack-GAME");
        this.setLayout(null);

        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
//adaugam background-ul
        ImageIcon img = new ImageIcon("F:\\isp\\30124_1_chereches_raul_isp_labs\\Black Jack\\src\\main\\resources\\background\\green_table.jpg");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        ImageIcon icon = new ImageIcon("src/main/resources/cards/icon.jpg");
        this.setIconImage(icon.getImage());

///buttons and text fields set
        puncte.setForeground(Color.WHITE);
        puncte.setBounds(1, 1, 100, 50);
        puncte.setText("Puncte: 0");
        this.add(puncte);
//take a card
        this.button1.addActionListener(this);
        button1.setBounds(1, 50, 100, 50);
        this.add(button1);
//stop
        this.button2.addActionListener(this);
        button2.setBounds(1, 190, 100, 50);
        this.add(button2);
///show
        this.button3.addActionListener(this);
        button3.setBounds(1, 120, 100, 50);
        this.add(button3);

        //new game
        this.button4.addActionListener(this);
        button4.setBounds(WINDOW_HALF_X, WINDOW_HALF_Y, 100, 50);


        endText.setBounds(0, WINDOW_HEIGHT - 500, 300, 500);
        this.add(endText);

        this.getContentPane().add(background);
        this.setVisible(true);
        repaint();
    }

    public void addCard(int x, int y, String name) {

        ImageIcon icon = new ImageIcon("src/main/resources/cards/" + name + ".jpg");


        JLabel card = new JLabel();

        card.setIcon(icon);
        card.setBounds(x, y, CARD_WIDTH, CARD_HEIGHT);

        setVisible(true);
        add(card);

        this.getContentPane().add(background);

        repaint();

        cards.add(card);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button1) {
            buttonOption = "take card";

        }
        if (e.getSource() == button2) {
            buttonOption = "stop";

        }
        if (e.getSource() == button3) {
            buttonOption = "show";

        }

        if (e.getSource() == button4) {
            buttonOption = "new game";
            System.out.println(buttonOption);

        }



    }

    public String getOption() {
        return buttonOption;

    }

    public void optionReset() {
        buttonOption = "0";
    }

    public void reDrawHand(Mana mana, String who) {
        int handHeight = 0;

        if (mana.size() == 0)
            return;

        this.clear();//se sterge tabla
//aici se modifica punctele pe tabela
        //Score.update();
        if (who == "player") {
            handHeight = playerPositionOffset - 20;
            //redraw for player
            puncte.setText("Puncte: " + mana.getSuma());
        } else if (who == "computer") {
            //redraw for computer

        }

        int offset;
        int card_number = 0;


        if (mana.size() % 2 == 1) {//numar impar de carti in mana


            offset = WINDOW_HALF_X - CARD_WIDTH / 2;//cand avem in mana o carte
            addCard(offset, handHeight, nextCardTexture(mana, card_number));
            System.out.println(nextCardTexture(mana, card_number));
            card_number++;

            for (int i = 1; i <= mana.size() / 2; i++) {
                offset -= BETWEEN_CARD;//scadem de i ori
                offset -= CARD_WIDTH;//

                addCard(offset, handHeight, nextCardTexture(mana, i));//DE LA OFFSET
                card_number++;
                addCard(WINDOW_HALF_X + WINDOW_HALF_X - offset - CARD_WIDTH, handHeight, nextCardTexture(mana, card_number));//IN OGLINDA
                card_number++;
            }

        } else if (mana.size() % 2 == 0) {//numar par de carti in mana


            offset = WINDOW_HALF_X + (BETWEEN_CARD / 2);//cand sunt 2 carti
            addCard(offset, handHeight, nextCardTexture(mana, card_number));//cartea in oglinda
            card_number++;

            offset = WINDOW_HALF_X - (BETWEEN_CARD / 2) - CARD_WIDTH;//cand sunt 2 carti
            addCard(offset, handHeight, nextCardTexture(mana, card_number));
            card_number++;


            for (int i = 1; i <= mana.size() / 2 - 1; i++) {
                offset -= BETWEEN_CARD;//scadem de i ori
                offset -= CARD_WIDTH;//

                addCard(offset, handHeight, nextCardTexture(mana, card_number));//DE LA OFFSET
                card_number++;
                addCard(WINDOW_HALF_X + WINDOW_HALF_X - offset - CARD_WIDTH, handHeight, nextCardTexture(mana, card_number));//IN OGLINDA
                card_number++;
            }

//avem card_number deoarece vrem sa stim cate carti avem in mana,
// ca sa le putem orienta corespunzator

        }


    }

    public void clear() {

        for (JLabel i : cards) {
            this.remove(i);
        }

        cards.clear();


    }

    public String nextCardTexture(Mana mana, int card_number) {
//card_number >=0 textura normala
        if (card_number >= 0)
            return mana.getMana().get(card_number).afisareNumeComplet();
        if (card_number == -1) {
            return "purple_back";
        } else if (card_number == -2) {
            return "yellow_back";
        } else if (card_number == -3) {
            return "blue_back";
        }


        return "0";
    }


    public void writeConsole(String s) {

        endText.setText(s + "\n");

    }


    public void endingScene() {
        this.add(button4);//new game
        this.getContentPane().add(background);
        repaint();
    }

}