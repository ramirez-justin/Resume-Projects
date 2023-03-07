
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

// Towers of Hanoi game; runs on its own but requires n input for number of disks
public class TowersOfHanoi extends JFrame implements ActionListener, Runnable {
  int n = 6;  // number of disks
  int fwidth = 1000, fheight = 600;  // width of JLabel

  JLabel question = new JLabel("How many Disks Should we try?");
  JButton start = new JButton("Start");
  JButton exit = new JButton("Exit");
  Rectangle []peg = new Rectangle[3];
  Rectangle []disk = new Rectangle[n];
  JLabel numof_moves = new JLabel("Number of Moves : ");
  JLabel present_move = new JLabel("Present Move : ");
  JTextField answer = new JTextField(28);
  JTextArea title = new JTextArea();
     
  int [][]peg_capacity = new int[3][6];
  int []h = new int[3];
  int num, count = 1;
    
  Thread t = new Thread(this);
   
  public static void main(String[] args) {
    TowersOfHanoi toh = new TowersOfHanoi();
    toh.setVisible(true);
  }
   
  @Override
  public void run() {
    Hanoi(n,1,3,2);
  }
    
  public TowersOfHanoi() {
    h[0]=6;
    h[1]=0;
    h[2]=0;
    setLayout(null);
    setSize(fwidth, fheight);
    setTitle("Towers Of Hanoi ");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    start.setBounds(300, 520,100,25);
    exit.setBounds(600, 520,100,25);
    numof_moves.setBounds(100,50,300,25);
    present_move.setBounds(300,50,300,25);
    // title.setBounds(850,10,100,500);
    add(start);
    add(exit);
    add(numof_moves);
    add(present_move);
    // add(title);
        
    //disk[0] large size  
    for(int i=0;i<n;i++) {
      disk[i]=new Rectangle(150+i*12,475-i*25,200-i*25, 25);
      peg_capacity[0][i]=i; //pushing disk numbers in to first peg                
    }
         
    peg[0]=new Rectangle(250,200,15,300);
    peg[1]=new Rectangle(510,200,15,300);
    peg[2]=new Rectangle(760,200,15,300);
         
      
    start.addActionListener(this);
    exit.addActionListener(this);  
    }
    
    public int dy(int x) {
      return fheight-x;
    }
   
    @Override
    public void actionPerformed(ActionEvent ae) {
      if(ae.getSource()==start){
          t.start();   
      }
       
      if(ae.getSource()==exit){
        System.exit(0);
      }
    }
    
  public void Hanoi(int diskCount,int from, int dest, int by) {
	  if (diskCount == 1) {   
      int hor_displacement=260;
      try {
        Thread.sleep(500);
        // maintains number of disks in each peg
        peg_capacity[dest - 1][h[dest - 1]] = peg_capacity[from - 1][--h[from-1]];
                
        if((from == 1 && dest == 3) || (from == 2 && dest == 3))
          hor_displacement = hor_displacement*2;
        else if((from == 3 && dest==1) || (from==2 && dest==1))
          hor_displacement = 0;
          num = peg_capacity[dest - 1][h[dest - 1]++];
          disk[num].setLocation(150+num*12 + hor_displacement,475-(h[dest-1]-1)*25);
            
          repaint();
          numof_moves.setText("Number of Moves :"+(count++));
          present_move.setText("Present Move : Disk "+(num+1)+ " moved from "+(char)(from+64)+" --> "+(char)(dest+64));      
      }
      catch(Exception e) {}
    } else {
		  Hanoi(diskCount -1, from, by, dest);
		  Hanoi(1, from, dest, by);
		  Hanoi(diskCount -1, by, dest, from);
	  }
  }
    
    
  public void paint(Graphics g){
    super.paint(g);
    g.setColor(Color.BLUE);
      
    for(int i=0;i<3;i++) { 
      g.fillRect(peg[i].x,peg[i].y,peg[i].width,peg[i].height);
      g.drawString(""+(char)(i+65),peg[i].x+5,peg[i].y-10);
    }
      
    g.drawLine(100,500, 850,500);
     
       
    // drawing disks
    for(int i=0;i<n;i++) {
      g.setColor(Color.yellow);
      g.fillRoundRect(disk[i].x,disk[i].y,disk[i].width,disk[i].height,10,10);
      g.setColor(Color.BLACK);
      g.drawRoundRect(disk[i].x,disk[i].y,disk[i].width,disk[i].height,10,10);
      g.setColor(Color.black);
      g.drawString(" "+(i+1), disk[i].x+100-i*12,disk[i].y+12);
    }
  }      
}