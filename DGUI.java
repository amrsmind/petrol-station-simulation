package os2;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class DGUI extends JFrame {
    public static void main(String[] args) {
         DGUI d = new DGUI(2);
         d.setVisible(true);
    }

    Vector<JTextArea> myPump;
    DGUI(int pumpnums){
        setTitle("GasStations");
        setSize(600,800);
        getContentPane().setLayout(new FlowLayout());
        myPump = new Vector<>(pumpnums);
        for(int i = 0;i<pumpnums;i++){
            ImageIcon ii=new ImageIcon("Pump.png");
            JLabel label=new JLabel(ii);
            myPump.add(new JTextArea(10,10));
            getContentPane().add(label);
            myPump.elementAt(i).setBackground(Color.yellow);
            getContentPane().add(myPump.elementAt(i));
        }
        getContentPane().setBackground(Color.white);
    }

}
