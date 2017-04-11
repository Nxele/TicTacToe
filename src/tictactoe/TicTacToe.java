/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.Button;
import java.awt.Label;
import javax.swing.*;
import sun.applet.AppletViewer;
import static tictactoe.Game.*;
import javax.swing.JFrame.*;
/**
 *
 * @author sizwe.nxele
 */
public class TicTacToe {
    /**
     * @param btn
     * @param args the command line argument
     */
    
    private String [][]ticTac=new String [3][3];
    private int countMoves,count,winnerX,winnerO;
    private String playerX,playerO;
    
    //Game gameForm = new Game();
    
    //this is the constructor receiveing paramater from the form
    public TicTacToe(){
        this.countMoves = 1;
        this.count = 1;
        this.playerO = "O";
        this.playerX = "X";
        this.winnerO = 0;
        this.winnerX = 0;
        onLoad();
    }
    public void validatePlayer(JButton button,int btnNumber,JLabel Moveslabel){
        playedNum++;
        Moveslabel.setText(Integer.toString(playedNum));
        
        if(count==1)
        {
           playGame(button,playerX,btnNumber);
           count=0;
        }
        else
        {
            playGame(button,playerO,btnNumber);
            count=1;
        }
    }
    public void playGame(JButton btn,String player,int number)
    {
                
        if(player.equals("X")){
           btn.setText("X");
            insertXO("X",number);
        }
        if(player.equals("O")){
            btn.setText("O");
            insertXO("O",number);
        }
        countMoves++;
    }
    public void insertXO(String symbol,int num)
    {
        if(num==1){ticTac[0][0]=symbol;}
        if(num==2){ticTac[0][1]=symbol;}
        if(num==3){ticTac[0][2]=symbol;}
        if(num==4){ticTac[1][0]=symbol;}
        if(num==5){ticTac[1][1]=symbol;}
        if(num==6){ticTac[1][2]=symbol;}
        if(num==7){ticTac[2][0]=symbol;}
        if(num==8){ticTac[2][1]=symbol;}
        if(num==9){ticTac[2][2]=symbol;}
     
        if(countMoves >= 5 && ! symbol.equals("H"))
        {
            winner();
        }
    }
    //this method check for the winner
    public void winner()
    {
        //checking the winner in rows
        for(int index = 0;index < 3; index++)
        { 
            for(int in = 0;in < 3; in++)
            {      
                if(ticTac[index][in].equals(ticTac[index][1]) && ticTac[index][in].equals(ticTac[index][2]) && ticTac[index][in] !="H")
                {
                    JOptionPane.showMessageDialog(null,"Player "+ticTac[index][in]+" Won The Table");
                    increamentWinner(ticTac[index][in]);
                    break;
                }
            }  
        }
        //checking the winner in colums
        
        //checking the winner diogninal
    }
    public void increamentWinner(String winner)
    {
        if(winner.equals("X")){
            winnerX++;
            lbScoreX.setText(Integer.toString(winnerX));
        }
        if(winner.equals("O")){
            winnerO++;
            lbScoreO.setText(Integer.toString(winnerO));
        }
        onLoad();
    }
    public void resetGame(JButton btn1,JButton btn2,JButton btn3,JButton btn4,JButton btn5,JButton btn6,JButton btn7,JButton btn8,JButton btn9){
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        
        for(int index = 1;index <= 9;index++){
            insertXO("H",index);
        }
        countMoves = 1;
        displayArrays();
    }
    public void displayArrays(){
        for(int index =0;index < 3; index++)
        { 
            System.out.println();
            for(int in = 0;in < 3; in++)
            {      
                System.out.print(ticTac[index][in]);
            }  
        }
    }
    public void onLoad(){
        for(int index =0;index < 3; index++)
        { 
            System.out.println();
            for(int in = 0;in < 3; in++)
            {      
                ticTac[index][in]="H";
            }  
        }
    }
}
