import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
public class BattleshipsWindow {	
	protected int Length;
	ArrayList<Integer> shipLengths;

	public BattleshipsWindow(int Length){
		this.Length = Length;
		shipLengths = new ArrayList<Integer>(Arrays.asList(2,2,3,3,3,4,5));
	}

	public JFrame createWindow(){
		JFrame frame = new JFrame("Battleships");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel buttonPanel = new JPanel();
	    JPanel enemyPanel = new JPanel(new GridLayout(Length,Length,5,5));
	    JPanel myPanel = new JPanel(new GridLayout(Length,Length,5,5));
	    NumberArray arrayN = new NumberArray();
        LetterArray arrayL = new LetterArray();
        String [] numArray = arrayN.getArray(Length);
        String [] letArray = arrayL.getArray(Length);
	    for (int i = 0; i < Length; i++) {
	        for (int j = 0; j < Length; j++) {
	        	JPanel enemyBlock = new JPanel();
	            JPanel myBlock = new JPanel();
	            myBlock.setName("m"+letArray[j]+numArray[i]);
	            enemyBlock.setBackground(Color.blue);           
	            myBlock.setBackground(Color.decode("#09eee8"));
	            enemyPanel.add(enemyBlock);
	            myPanel.add(myBlock);
	            enemyPanel.setBackground(Color.black);
	            myPanel.setBackground(Color.white);
	        }
	    }

		 
        JPanel containerPanel = new JPanel();
        JPanel conContainer = new JPanel();
        
        
        containerPanel.setLayout(new GridLayout(1,Length));
        conContainer.setLayout(new GridLayout(1,1));
        buttonPanel.setLayout(new GridLayout(Length,Length));
        
      
        for (int i=0; i<Length; i++){
        	for (int j=0; j<Length; j++){
        		JButton button = new JButton(letArray[j]+numArray[i]);
        		button.setName(letArray[j]+numArray[i]);
        		int count = 0;
        		while(!myPanel.getComponent(count).getName().equals("m"+button.getName())){
        			count++;
        		}
        		int loc = count;
        		int checkLeft = loc-shipLengths.get(0);
        		int checkRight = loc-shipLengths.get(0);
        		button.addActionListener(new ActionListener(){
        			public void actionPerformed(ActionEvent e)
        		      {
        					
        							
        							button.addKeyListener(new KeyListener(){

        								@Override
        								public void keyPressed(KeyEvent e) {
        									// TODO Auto-generated method stub
        									boolean checked = false;
        									for (int k=loc; k>checkLeft; k--){
        		        						if(!myPanel.getComponent(k).getBackground().equals(Color.gray)){
        		        							
        		        							checked = true;
        		        							System.out.println(checked);
        		        						} else {
        		        							checked = false;
        		        						}
        									}
        									if (e.getKeyCode() == KeyEvent.VK_LEFT && checked && (loc % Length)!= 0 ){
        										for(int j=1; j<shipLengths.get(0); j++){
        											myPanel.getComponent(loc).setBackground(Color.gray);
        											myPanel.getComponent(loc-j).setBackground(Color.gray);											
        										}
        										shipLengths.remove(0);
        									}
									
									
									
        									/*if (e.getKeyCode() == KeyEvent.VK_RIGHT && checked && )){
        										myPanel.getComponent(loc+12).setBackground(Color.gray);
        									}*/							
        								

        								
        									
        						
        							}

										@Override
										public void keyReleased(KeyEvent e) {
											// TODO Auto-generated method stub
											
										}

										@Override
										public void keyTyped(KeyEvent e) {
											// TODO Auto-generated method stub
											
										}
        						});
        					        		        
        		      }
        		});
        		Font font = new Font("Arial",Font.PLAIN,8);
        		button.setFont(font);
        		buttonPanel.add(button);
        	}
        }
        
        containerPanel.setPreferredSize(new Dimension(300*Length, 50*Length));
        
        buttonPanel.setPreferredSize(new Dimension(100/Length, 50/Length));
        containerPanel.add(buttonPanel); 
        containerPanel.add(myPanel);
        containerPanel.add(enemyPanel);
        containerPanel.setBackground(Color.black);
        
        frame.getContentPane().add(containerPanel);    
        frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setBackground(Color.black);
		return frame;
		
	}
}
		
	
		

