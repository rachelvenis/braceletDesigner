import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;


public class Bracelet {
	int length;
	String content;
	Color bc;
	Color lc;
	Letter[] letters;
	int spaceSize;
	int eitherEnd;
	int boxSize=10;
	
	public Bracelet(){
		length = 60;
		content="";
		bc=Color.WHITE;
		lc=Color.BLACK;
		fillLetters();
	}
	public void reCalculate(){
		eitherEnd = 21;
		spaceSize =0;
		while(eitherEnd>20){
			spaceSize++;
			char current;
			int currentNum;
			int count=0;
			int upper=0;
			String check;
			int totalLetterBoxes=0;
			for (int i =0;i<content.length();i++){
	        	current = content.charAt(i);
				if (current==' '){
					totalLetterBoxes+=spaceSize*4;
				}
				else{
					
					if (current=='\u2764'){
	        			currentNum=52;
	        		}
					else{
						currentNum = (int)current;
						if(currentNum>=65 && currentNum<=90)
							currentNum-=65;
						else if(currentNum>=97 && currentNum<=172)
							currentNum-=71;
						else if(current>=48 && currentNum<=57)
							currentNum+=5;
						else if(currentNum==33)
							currentNum=64;
						else if(currentNum==46)
							currentNum=63;
						else{
							JOptionPane.showMessageDialog(null,"The text you inputted contains illegal characters");
							content="";
						}
							
					}
					totalLetterBoxes+=letters[currentNum].width+spaceSize;
				}
		    }		
			if(totalLetterBoxes-spaceSize>length){
				JOptionPane.showMessageDialog(null,"The text you inputted is too long for your chosen bracelet size");
				content="";
			}
			eitherEnd = (length-totalLetterBoxes-spaceSize)/2;	
		}
	}
	
	public void fillLetters(){
		letters = new Letter[65];
		
		letters[0]=new Letter('A',4);
		int[][] temp0 = {{1,0},{2,0},{0,1},{3,1},{0,2},{3,2},{0,3},{3,3},{0,4},{1,4},{2,4},{3,4},{0,5},{3,5},{0,6},{3,6},{0,7},{3,7}};
		letters[0].actualInfo=temp0;

		letters[1]=new Letter('B',4);
		int[][] temp1 = {{0,0},{1,0},{2,0},{0,1},{3,1},{0,2},{3,2},{0,3},{1,3},{2,3},{0,4},{3,4},{0,5},{3,5},{0,6},{3,6},{0,7},{1,7},{2,7}};
		letters[1].actualInfo=temp1;

		letters[2]=new Letter('C',4);
		int[][] temp2 = {{1,0},{2,0},{0,1},{3,1},{0,2},{0,3},{0,4},{0,5},{3,5},{0,6},{3,6},{1,7},{2,7}};
		letters[2].actualInfo=temp2;

		letters[3]=new Letter('D',4);
		int[][] temp3 = {{0,0},{1,0},{2,0},{0,1},{3,1},{0,2},{3,2},{0,3},{3,3},{0,4},{3,4},{0,5},{3,5},{0,6},{3,6},{0,7},{1,7},{2,7}};
		letters[3].actualInfo=temp3;
		
		letters[4]=new Letter('E',4);
		int[][] temp4 = {{0,0},{1,0},{2,0},{3,0},{0,1},{0,2},{0,3},{1,3},{2,3},{0,4},{0,5},{0,6},{0,7},{1,7},{2,7},{3,7}};
		letters[4].actualInfo=temp4;
		
		letters[5]=new Letter('F',4);
		int[][] temp5 = {{0,0},{1,0},{2,0},{3,0},{0,1},{0,2},{0,3},{1,3},{2,3},{0,4},{0,5},{0,6},{0,7}};
		letters[5].actualInfo=temp5;
		
		letters[6]=new Letter('G',4);
		int[][] temp6 = {{1,0},{2,0},{0,1},{3,1},{0,2},{0,3},{0,4},{2,4},{3,4},{0,5},{3,5},{0,6},{3,6},{1,7},{2,7},{3,7}};
		letters[6].actualInfo=temp6;
		
		letters[7]=new Letter('H',4);
		int[][] temp7 = {{0,0},{3,0},{0,1},{3,1},{0,2},{3,2},{0,3},{1,3},{2,3},{3,3},{0,4},{3,4},{0,5},{3,5},{0,6},{3,6},{0,7},{3,7}};
		letters[7].actualInfo=temp7;
		
		letters[8]=new Letter('I',3);
		int[][] temp8 = {{0,0},{1,0},{2,0},{1,1},{1,2},{1,3},{1,4},{1,5},{1,6},{0,7},{1,7},{2,7}};
		letters[8].actualInfo=temp8;
		
		letters[9]=new Letter('J',4);
		int[][] temp9 = {{3,0},{3,1},{3,2},{3,3},{3,4},{3,5},{0,5},{0,6},{3,6},{1,7},{2,7}};
		letters[9].actualInfo=temp9;
		
		letters[10]=new Letter('K',4);
		int[][] temp10 = {{0,0},{3,0},{0,1},{3,1},{0,2},{2,2},{0,3},{1,3},{0,4},{2,4},{0,5},{2,5},{0,6},{3,6},{0,7},{3,7}};
		letters[10].actualInfo=temp10;

		letters[11]=new Letter('L',4);
		int[][] temp11 = {{0,0},{0,1},{0,2},{0,3},{0,4},{0,5},{0,6},{0,7},{1,7},{2,7},{3,7}};
		letters[11].actualInfo=temp11;

		letters[12]=new Letter('M',5);
		int[][] temp12 = {{0,0},{4,0},{0,1},{1,1},{3,1},{4,1},{0,2},{1,2},{3,2},{4,2},{0,3},{2,3},{4,3},{0,4},{2,4},{4,4},{0,5},{2,5},{4,5},{0,6},{4,6},{0,7},{4,7}};
		letters[12].actualInfo=temp12;
		
		letters[13]=new Letter('N',5);
		int[][] temp13 = {{0,0},{4,0},{0,1},{1,1},{4,1},{0,2},{1,2},{4,2},{0,3},{2,3},{4,3},{0,4},{2,4},{4,4},{0,5},{3,5},{4,5},{0,6},{3,6},{4,6},{0,7},{4,7}};
		letters[13].actualInfo=temp13;
		
		letters[14]=new Letter('O',4);
		int[][] temp14 = {{1,0},{2,0},{0,1},{3,1},{0,2},{3,2},{0,3},{3,3},{0,4},{3,4},{0,5},{3,5},{0,6},{3,6},{1,7},{2,7}};
		letters[14].actualInfo=temp14;

		letters[15]=new Letter('P',4);
		int[][] temp15 = {{0,0},{1,0},{2,0},{0,1},{3,1},{0,2},{3,2},{0,3},{3,3},{0,4},{1,4},{2,4},{0,5},{0,6},{0,7}};
		letters[15].actualInfo=temp15;
		
		letters[16]=new Letter('Q',5);
		int[][] temp16 = {{1,0},{2,0},{0,1},{3,1},{0,2},{3,2},{0,3},{3,3},{0,4},{3,4},{0,5},{2,5},{3,5},{0,6},{3,6},{4,6},{1,7},{2,7}};
		letters[16].actualInfo=temp16;

		letters[17]=new Letter('R',4);
		int[][] temp17 = {{0,0},{1,0},{2,0},{0,1},{3,1},{0,2},{3,2},{0,3},{3,3},{0,4},{1,4},{2,4},{0,5},{2,5},{0,6},{3,6},{0,7},{3,7}};
		letters[17].actualInfo=temp17;

		letters[18]=new Letter('S',4);
		int[][] temp18 = {{1,0},{2,0},{0,1},{3,1},{0,2},{1,3},{2,3},{3,4},{3,5},{0,6},{3,6},{1,7},{2,7}};
		letters[18].actualInfo=temp18;

		letters[19]=new Letter('T',4);
		int[][] temp19 = {{0,0},{1,0},{2,0},{3,0},{4,0},{2,1},{2,2},{2,3},{2,4},{2,5},{2,6},{2,7}};
		letters[19].actualInfo=temp19;

		letters[20]=new Letter('U',4);
		int[][] temp20 = {{0,0},{3,0},{0,1},{3,1},{0,2},{3,2},{0,3},{3,3},{0,4},{3,4},{0,5},{3,5},{0,6},{3,6},{1,7},{2,7}};
		letters[20].actualInfo=temp20;

		letters[21]=new Letter('V',5);
		int[][] temp21 = {{0,0},{4,0},{0,1},{4,1},{0,2},{4,2},{0,3},{4,3},{1,4},{3,4},{1,5},{3,5},{2,6},{2,7}};
		letters[21].actualInfo=temp21;

		letters[22]=new Letter('W',5);
		int[][] temp22 = {{0,0},{4,0},{0,1},{4,1},{0,2},{2,2},{4,2},{0,3},{2,3},{4,3},{0,4},{3,4},{0,5},{2,5},{4,5},{1,6},{3,6},{1,7},{3,7}};
		letters[22].actualInfo=temp22;

		letters[23]=new Letter('X',4);
		int[][] temp23 = {{0,0},{3,0},{0,1},{3,1},{0,2},{3,2},{1,3},{2,3},{1,4},{2,4},{0,5},{3,5},{0,6},{3,6},{0,7},{3,7}};
		letters[23].actualInfo=temp23;

		letters[24]=new Letter('Y',5);
		int[][] temp24 = {{0,0},{4,0},{0,1},{4,1},{0,2},{4,2},{1,3},{3,3},{2,4},{2,5},{2,6},{2,7}};
		letters[24].actualInfo=temp24;

		letters[25]=new Letter('Z',4);
		int[][] temp25 = {{0,0},{1,0},{2,0},{3,0},{3,1},{3,2},{2,3},{1,4},{0,5},{0,6},{0,7},{1,7},{2,7},{3,7}};
		letters[25].actualInfo=temp25;

		letters[26]=new Letter('a',5);
		int[][] temp26 = {{1,2},{2,2},{0,3},{3,3},{3,4},{1,5},{2,5},{3,5},{0,6},{3,6},{1,7},{2,7},{4,7}};
		letters[26].actualInfo=temp26;

		letters[27]=new Letter('b',4);
		int[][] temp27 = {{0,1},{0,2},{0,3},{1,3},{2,3},{0,4},{3,4},{0,5},{3,5},{0,6},{3,6},{0,7},{1,7},{2,7}};
		letters[27].actualInfo=temp27;

		letters[28]=new Letter('c',4);
		int[][] temp28 = {{1,2},{2,2},{0,3},{3,3},{0,4},{0,5},{0,6},{3,6},{1,7},{2,7}};
		letters[28].actualInfo=temp28;

		letters[29]=new Letter('d',4);
		int[][] temp29 = {{3,1},{3,2},{1,3},{2,3},{3,3},{0,4},{3,4},{0,5},{3,5},{0,6},{3,6},{1,7},{2,7},{3,7}};
		letters[29].actualInfo=temp29;

		letters[30]=new Letter('e',4);
		int[][] temp30 = {{1,2},{2,2},{0,3},{3,3},{0,4},{1,4},{2,4},{3,4},{0,5},{0,6},{3,6},{1,7},{2,7}};
		letters[30].actualInfo=temp30;

		letters[31]=new Letter('f',4);
		int[][] temp31 = {{1,1},{2,1},{3,1},{1,2},{3,2},{1,3},{0,4},{1,4},{2,4},{1,5},{1,6},{1,7}};
		letters[31].actualInfo=temp31;

		letters[32]=new Letter('g',4);
		int[][] temp32 = {{1,2},{2,2},{0,3},{3,3},{0,4},{3,4},{1,5},{2,5},{3,5},{3,6},{0,7},{1,7},{2,7},{3,7}};
		letters[32].actualInfo=temp32;

		letters[33]=new Letter('h',4);
		int[][] temp33 = {{0,1},{0,2},{0,3},{1,3},{2,3},{0,4},{3,4},{0,5},{3,5},{0,6},{3,6},{0,7},{3,7}};
		letters[33].actualInfo=temp33;

		letters[34]=new Letter('i',1);
		int[][] temp34 = {{0,1},{0,3},{0,4},{0,5},{0,6},{0,7}};
		letters[34].actualInfo=temp34;

		letters[35]=new Letter('j',3);
		int[][] temp35 = {{2,1},{2,3},{2,4},{2,5},{0,6},{2,6},{0,7},{1,7},{2,7}};
		letters[35].actualInfo=temp35;

		letters[36]=new Letter('k',4);
		int[][] temp36 = {{0,1},{0,2},{3,2},{0,3},{2,3},{0,4},{1,4},{0,5},{2,5},{0,6},{3,6},{0,7},{3,7}};
		letters[36].actualInfo=temp36;

		letters[37]=new Letter('i',1);
		int[][] temp37 = {{0,1},{0,2},{0,3},{0,4},{0,5},{0,6},{0,7}};
		letters[37].actualInfo=temp37;
		
		letters[38]=new Letter('m',5);
		int[][] temp38 = {{1,2},{3,2},{0,3},{2,3},{4,3},{0,4},{2,4},{4,4},{0,5},{4,5},{0,6},{4,6},{0,7},{4,7}};
		letters[38].actualInfo=temp38;

		letters[39]=new Letter('n',4);
		int[][] temp39 = {{0,2},{2,2},{0,3},{1,3},{3,3},{0,4},{3,4},{0,5},{3,5},{0,6},{3,6},{0,7},{3,7}};
		letters[39].actualInfo=temp39;

		letters[40]=new Letter('o',4);
		int[][] temp40 = {{1,2},{2,2},{0,3},{3,3},{0,4},{3,4},{0,5},{3,5},{0,6},{3,6},{1,7},{2,7}};
		letters[40].actualInfo=temp40;

		letters[41]=new Letter('p',4);
		int[][] temp41 = {{0,2},{1,2},{2,2},{0,3},{3,3},{0,4},{3,4},{0,5},{1,5},{2,5},{3,5},{0,6},{0,7}};
		letters[41].actualInfo=temp41;

		letters[42]=new Letter('q',5);
		int[][] temp42 = {{1,2},{2,2},{0,3},{3,3},{0,4},{3,4},{1,5},{2,5},{3,5},{3,6},{4,6},{3,7}};
		letters[42].actualInfo=temp42;

		letters[43]=new Letter('r',4);
		int[][] temp43 = {{0,2},{2,2},{3,2},{0,3},{1,3},{3,3},{0,4},{0,5},{0,6},{0,7}};
		letters[43].actualInfo=temp43;

		letters[44]=new Letter('s',4);
		int[][] temp44 = {{1,2},{2,2},{3,2},{0,3},{1,4},{2,4},{3,5},{3,6},{0,7},{1,7},{2,7}};
		letters[44].actualInfo=temp44;

		letters[45]=new Letter('t',4);
		int[][] temp45 = {{1,1},{1,2},{0,3},{1,3},{2,3},{1,4},{1,5},{1,6},{1,7},{2,7}};
		letters[45].actualInfo=temp45;

		letters[46]=new Letter('u',4);
		int[][] temp46 = {{0,2},{3,2},{0,3},{3,3},{0,4},{3,4},{0,5},{3,5},{0,6},{2,6},{3,6},{1,7},{3,7}};
		letters[46].actualInfo=temp46;

		letters[47]=new Letter('v',5);
		int[][] temp47 = {{0,2},{4,2},{0,3},{4,3},{0,4},{4,4},{1,5},{3,5},{1,6},{3,6},{2,7}};
		letters[47].actualInfo=temp47;

		letters[48]=new Letter('w',5);
		int[][] temp48 = {{0,2},{4,2},{0,3},{4,3},{0,4},{4,4},{0,5},{2,5},{4,5},{0,6},{2,6},{4,6},{1,7},{3,7}};
		letters[48].actualInfo=temp48;

		letters[49]=new Letter('x',5);
		int[][] temp49 = {{0,2},{4,2},{1,3},{3,3},{2,4},{2,5},{1,6},{3,6},{0,7},{4,7}};
		letters[49].actualInfo=temp49;

		letters[50]=new Letter('y',4);
		int[][] temp50 = {{0,2},{3,2},{0,3},{3,3},{1,4},{2,4},{3,4},{3,5},{3,6},{0,7},{1,7},{2,7},{3,7}};
		letters[50].actualInfo=temp50;

		letters[51]=new Letter('z',4);
		int[][] temp51 = {{0,2},{1,2},{2,2},{3,2},{3,3},{2,4},{1,5},{0,6},{0,7},{1,7},{2,7},{3,7}};
		letters[51].actualInfo=temp51;
		
		letters[52]=new Letter(' ',7);
		int[][] temp52 = {{1,1},{2,1},{4,1},{5,1},{0,2},{1,2},{2,2},{3,2},{4,2},{5,2},{6,2},{0,3},{1,3},{2,3},{3,3},{4,3},{5,3},{6,3},{1,3},{2,3},{3,3},{4,3},{5,3},{1,4},{2,4},{3,4},{4,4},{5,4},{2,5},{3,5},{4,5},{3,6}};
		letters[52].actualInfo=temp52;

		letters[53]=new Letter('0',4);
		int[][] temp53 = {{1,0},{2,0},{0,1},{3,1},{0,2},{3,2},{0,3},{3,3},{0,4},{3,4},{0,5},{3,5},{0,6},{3,6},{1,7},{2,7}};
		letters[53].actualInfo=temp53;

		letters[54]=new Letter('1',3);
		int[][] temp54 = {{1,0},{0,1},{1,1},{1,2},{1,3},{1,4},{1,5},{1,6},{0,7},{1,7},{2,7}};
		letters[54].actualInfo=temp54;

		letters[55]=new Letter('2',4);
		int[][] temp55 = {{1,0},{2,0},{0,1},{3,1},{3,2},{2,3},{2,4},{1,5},{1,6},{0,7},{1,7},{2,7},{3,7}};
		letters[55].actualInfo=temp55;

		letters[56]=new Letter('3',4);
		int[][] temp56 = {{1,0},{2,0},{0,1},{3,1},{3,2},{1,3},{2,3},{3,4},{3,5},{0,6},{3,6},{1,7},{2,7}};
		letters[56].actualInfo=temp56;

		letters[57]=new Letter('4',4);
		int[][] temp57 = {{0,0},{3,0},{0,1},{3,1},{0,2},{3,2},{0,3},{1,3},{2,3},{3,3},{3,4},{3,5},{3,6},{3,7}};
		letters[57].actualInfo=temp57;

		letters[58]=new Letter('5',4);
		int[][] temp58 = {{0,0},{1,0},{2,0},{3,0},{0,1},{0,2},{0,3},{1,3},{2,3},{3,4},{3,5},{0,6},{3,6},{1,7},{2,7}};
		letters[58].actualInfo=temp58;

		letters[59]=new Letter('6',4);
		int[][] temp59 = {{1,0},{2,0},{0,1},{3,1},{0,2},{0,3},{0,4},{1,4},{2,4},{0,5},{3,5},{0,6},{3,6},{1,7},{2,7}};
		letters[59].actualInfo=temp59;

		letters[60]=new Letter('7',4);
		int[][] temp60 = {{0,0},{1,0},{2,0},{3,0},{3,1},{2,2},{2,3},{1,4},{1,5},{0,6},{0,7}};
		letters[60].actualInfo=temp60;

		letters[61]=new Letter('8',4);
		int[][] temp61 = {{1,0},{2,0},{0,1},{3,1},{0,2},{3,2},{1,3},{2,3},{0,4},{3,4},{0,5},{3,5},{0,6},{3,6},{1,7},{2,7}};
		letters[61].actualInfo=temp61;

		letters[62]=new Letter('9',4);
		int[][] temp62 = {{1,0},{2,0},{0,1},{3,1},{0,2},{3,2},{0,3},{3,3},{1,4},{2,4},{3,4},{3,5},{3,6},{3,7}};
		letters[62].actualInfo=temp62;

		letters[63]=new Letter('.',1);
		int[][] temp63 = {{0,7}};
		letters[63].actualInfo=temp63;

		letters[64]=new Letter('!',1);
		int[][] temp64 = {{0,1},{0,2},{0,3},{0,4},{0,5},{0,7}};
		letters[64].actualInfo=temp64;

	}
	
	public void paint(Graphics gc) {
        gc.setColor(bc);
        gc.fillRect(0,0,length*boxSize,boxSize*10);
        gc.setColor(Color.BLACK);
        for (int i =0;i<=length;i++){
        	gc.drawLine(i*boxSize, 0, i*boxSize,boxSize*10);
        }
        for (int j =0;j<=10;j++){
        	gc.drawLine(0, j*boxSize, boxSize*length, j*boxSize);
        }
        gc.setColor(lc);
        char current;
        String check;
        int currentNum;
        boolean space=false;
        int prevpos=eitherEnd*boxSize;
        for (int i =0;i<content.length();i++){
		        	current = content.charAt(i);
		        	if (current==' '){
		        		prevpos +=spaceSize*boxSize*4;
		        		space=true;
		        	}
		        	else{
		        		if (current=='\u2764'){
		        			currentNum=52;
		        		}
		        		else{
			        		currentNum = (int)current;
							if(currentNum>=65 && currentNum<=90)
								currentNum-=65;
							else if(currentNum>=97 && currentNum<=172)
								currentNum-=71;
							else if(currentNum>=48 && currentNum<=57)
								currentNum+=5;
							else if(currentNum==33)
								currentNum=64;
							else if(currentNum==46)
								currentNum=63;
		        		}
		        		for (int j = 0;j<letters[currentNum].actualInfo.length;j++){
			        		gc.fillRect(prevpos+boxSize*letters[currentNum].actualInfo[j][0],boxSize+(boxSize*letters[currentNum].actualInfo[j][1]),boxSize,boxSize);
			        	}
			        	prevpos += (letters[currentNum].width)*boxSize+spaceSize*boxSize;
		        	}
	        	}
			        	
		        	}

}
