import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MyFrame extends JFrame implements ActionListener{
	private final int SMALL_LENGTH=60;
	private final int MED_LENGTH=70;
	private final int LARGE_LENGTH=80;

    private BraceletPanel innerPanel = new BraceletPanel();
    //private JPanel inputPanel;
    private JLabel sizeLabel = new JLabel("Size: ");
    private JComboBox sizeOptions;
    private JLabel contentLabel = new JLabel("Content: ");
    private JTextField contentField = new JTextField(10);
    private JButton display = new JButton("Display");
    private JButton save = new JButton("Save");
    
    private JPanel outerPanel = new JPanel(new BorderLayout());
    
    private String sizeString;
    private Bracelet bracy;
    
    private JButton bcButton=new JButton("Choose Background Colour");
    private JButton lcButton=new JButton("Choose Letter Colour");
    
    private JButton heartButton = new JButton("\u2764");
    private JLabel specialLabel = new JLabel("special characters: ");

	public MyFrame(){
		setTitle("Anything String Bracelet Maker"); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel inputPanel = new JPanel(new GridLayout(0,1));
        JPanel panel1 = new JPanel(new FlowLayout());
        JPanel panel2 = new JPanel(new FlowLayout());
        JPanel panel3 = new JPanel(new FlowLayout());
        JPanel panel4 = new JPanel(new FlowLayout());
        bracy = new Bracelet();        
        
        String[] sizeList = {"Small","Medium","Large"};
        sizeOptions = new JComboBox(sizeList);
        panel1.add(sizeLabel);
        panel1.add(sizeOptions);
        panel1.add(contentLabel);
        panel1.add(contentField);
        
        panel2.add(specialLabel);
        panel2.add(heartButton);
        
        panel3.add(bcButton);
        panel3.add(lcButton);
        
        panel4.add(display);
        panel4.add(save);
        
        inputPanel.add(panel1);
        inputPanel.add(panel2);
        inputPanel.add(panel3);
        inputPanel.add(panel4);
        
        setLayout(new FlowLayout());
        outerPanel.setPreferredSize(new Dimension(bracy.boxSize*LARGE_LENGTH,(bracy.boxSize+1)*10));
        innerPanel.setSize(new Dimension(bracy.boxSize*bracy.length,bracy.boxSize*10));
        outerPanel.add(innerPanel,BorderLayout.CENTER);
        add(outerPanel);
        add(inputPanel);
        
        display.addActionListener(this);
        save.addActionListener(this);
        bcButton.addActionListener(this);
        lcButton.addActionListener(this);
        heartButton.addActionListener(this);
        pack();
        setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source==display){
			sizeString = (String)sizeOptions.getSelectedItem();
			if(sizeString.equals("Small"))
				bracy.length=SMALL_LENGTH;
			else if (sizeString.equals("Medium"))
				bracy.length=MED_LENGTH;
			else	//=="Large"
				bracy.length=LARGE_LENGTH;
			
			bracy.content = contentField.getText();
			bracy.reCalculate();
	        innerPanel.setSize(new Dimension(bracy.boxSize*bracy.length,bracy.boxSize*10));
			innerPanel.repaint();
		}
		else if(source==save){
			Dimension size = innerPanel.getSize();
	        BufferedImage image = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_RGB);
	        Graphics2D g2 = image.createGraphics();
	        innerPanel.paint(g2);
	        try
	        {
	            ImageIO.write(image, "png", new File(System.getProperty("user.home")+"/EVERYTHING/Bracelets/designs from program/"+bracy.content+".png"));

	        }
	        catch(Exception ex){}
		}
		else if(source==bcButton){
			bracy.bc= JColorChooser.showDialog(this,"Choose background color", Color.white);
		}
		else if(source==lcButton){
			bracy.lc= JColorChooser.showDialog(this,"Choose letter color", Color.white);			
		}
		else if(source==heartButton){
			String current =contentField.getText();
			contentField.setText(current+"\u2764");
		}
	}

	private class BraceletPanel extends JPanel{
		public BraceletPanel() {
	        //setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
	    } 
	    public void paintComponent(Graphics gc) {
	        super.paintComponent(gc);
	        bracy.paint(gc);
	    } 
	} 
	
	public static void main(String args[]) {
	    new MyFrame();
	}

}
