//Heman Baral
//Programming Assignment 7
//Race.java



import java.util.Random;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Race {

    //privately instalizing race1, 2 and 3

    private int racer1;
    private int racer2;
    private int racer3;

    private boolean reset = false;



    public Race() {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                Timer t = new Timer(50, null);

                JFrame frame = new JFrame("Race Track");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                frame.add(new ButtonPane(t), BorderLayout.NORTH);
                frame.add(new RaceTrack(t));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    //creating and instalizing buttons
    public class ButtonPane extends JPanel {

        private JButton Rstart = new JButton("Start");
        private JButton Rstop = new JButton("Pause");
        private JButton Rreset = new JButton("Reset");
        public ButtonPane(final Timer t) {
           Rstart.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    t.start();
                }
            });

            Rstop.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    t.stop();
                }
            });

            Rreset.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    racer1 = 5; racer2 = 5; racer3 = 5;
                    reset = true;
                    t.start();
                }
            });

            setLayout(new GridBagLayout());
            add(Rstart);
            add(Rstop);
            add(Rreset);
        }

    }



    //changing img pixel
    private class RaceTrack extends JPanel {
        private int finish_Line = 460;
        private Random num = new Random();



    //timer 
        public RaceTrack(Timer t) {


            t.addActionListener(new ActionListener() {
                @Override

                public void actionPerformed(ActionEvent e) {
                    if (status()) {

                        ((Timer)e.getSource()).stop();
                    }
                }
            });
        }


        //get status on change state of each racer
        protected boolean status() {

            if(reset == true){
                reset = false;
                repaint();
                return true;
            }
            //installing random 0-10 pixels forward
            racer1 += num.nextInt(10) + 1;
            racer2 += num.nextInt(10) + 1;
            racer3 += num.nextInt(10) + 1;

            if(racer1 >= finish_Line){
                JOptionPane.showMessageDialog(null, "Winner is Racer 1");
                return true;
            } else if(racer2 >= finish_Line){
                JOptionPane.showMessageDialog(null, "Winner is Racer 2");
                return true;
            } else if(racer3 >= finish_Line){
                JOptionPane.showMessageDialog(null, "Winner is Racer 3");
                return true;
            }

            repaint();

            return racer1 >= finish_Line || racer2 >= finish_Line || racer3 >= finish_Line;
        }
        @Override
        public Dimension getPreferredSize() {
            //Frame set
            return new Dimension(500, 200);
        }

        @Override
        public void paintComponent(Graphics garphic) {


            //System.out.println(">>");

            //draw 3 rectangle track
            super.paintComponent(garphic);
            garphic.setColor(Color.GRAY);
            garphic.fillRect(50, 90, 430, 25);

            garphic.setColor(Color.GRAY);
            garphic.fillRect( 50, 130, 430, 25);

            garphic.setColor(Color.GRAY);
            garphic.fillRect(50, 170, 430, 25);

            Image image = new ImageIcon("sportive-car.png").getImage();

            garphic.drawImage(image, racer1,80,this);

            garphic.drawImage(image, racer2,120,this);

            garphic.drawImage(image, racer3,160,this);

        }
    }




}
