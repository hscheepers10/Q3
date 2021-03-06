/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package q3_timer;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/*
 * @author User
 */

public class Q3_Timer extends JFrame{
    //Attributes.  
        JLabel timeLbl;
        JTextField timeTxtf;
        JButton startBtn, stopBtn;
        JPanel pane1,pane2;
        static int ms = 0;
        static int s = 0;
        static boolean pause = false;
        
        //Constructor for GUI.  
        public Q3_Timer(){
            //Code.  
            super("Edureka Timer");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(350,120);
            this.setResizable(false);
            
            //Pane1.  
            pane1 = new JPanel();
            pane1.setBorder(new EmptyBorder(20,20,10,20));
            timeLbl = new JLabel("Time(in seconds)");
            timeTxtf = new JTextField("0");
            timeTxtf.setEditable(false);
            
            //Pane1 Layout.  
            pane1.setLayout(new GridLayout(1,2));
            
            //Pane1 .add
            pane1.add(timeLbl);
            pane1.add(timeTxtf);
            
            //Pane 2.  
            pane2 = new JPanel();
            pane2.setBorder(new EmptyBorder(20,20,10,20));
            startBtn = new JButton("Start Timer");
            startBtn.addActionListener(new startThread());
            stopBtn = new JButton("Stop Timer");
            stopBtn.addActionListener(new pause());
            
            //Pane 2 Layout.  
            pane2.setLayout(new GridLayout(1,2));
            
            //Pane2 .add
            pane2.add(startBtn);
            pane2.add(stopBtn);
            
            //Main Frame Layout. 
            this.setLayout(new BorderLayout());
            
            //Add.  
            this.add(pane1, BorderLayout.NORTH);
            this.add(pane2, BorderLayout.SOUTH);
            this.setVisible(true);
        }
        
        
        class startThread implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            pause = false;
            
            Thread timer;
            timer = new Thread(){
                @Override
                public void run() {
                    
                    //for loop.  
                    for(;;) {
                        if(pause == false){
                            try{
                                //thread counts in seconds
                                sleep(1); 
                                //thousand milliseconds are a second
                                if(ms > 500) { 
                                    ms = 0;
                                    s++;
                                }
                                ms++;
                                timeTxtf.setText(""+s);
                            }
                            catch(InterruptedException e) {}
                        }
                        else{
                            break;
                        }
                    }
                }
            };
            timer.start();
        }
    }
    
    class pause implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            pause = true;
        }
    }
            //Main.  
            public static void main(String[] args) {
                Q3_Timer timer = new Q3_Timer();
        }
}
