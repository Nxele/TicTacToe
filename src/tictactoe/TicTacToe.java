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
    private int countMoves,count,winnerX,winnerO,row,col;
    private String playerX,playerO,winner;
    private boolean foundWinner;
    private final String ticX ="XXX";
    private final String ticO ="OOO";
    
    //Game gameForm = new Game();
    
    //this is the constructor receiveing paramater from the form
    public TicTacToe(){
        this.countMoves = 1;
        this.count = 1;
        this.playerO = "O";
        this.playerX = "X";
        this.winner = "";
        this.winnerO = 0;
        this.winnerX = 0;
        this.foundWinner = false;
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
                
        if(player.equals(playerX)){
           btn.setText(playerX);
            insertXO(playerX,number);
            lbTurn.setText(playerO);
        }
        if(player.equals(playerO)){
            btn.setText(playerO);
            insertXO(playerO,number);
            lbTurn.setText(playerX);
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
            winneRowWinner();
        }
    }
    //checking the winner in rows
    
    public void winneRowWinner(){
        this.winner = "";
        for(int index = 0;index < 3; index++)
        { 
            for(int in = 0;in < 3; in++)
            {      
                if(ticTac[index][in].equals(ticTac[index][1]) && ticTac[index][in].equals(ticTac[index][2]) && ticTac[index][in] !="H")
                {
                    winner = winner+ticTac[index][in]+ticTac[index][1]+ticTac[index][2];
                    break;
                }
            }  
        }
        if(winner.equals(ticO) || winner.equals(ticX)){
            System.out.print(winner);
            foundWinner = true;
            increamentWinner(winner);
        }
        else{winnnerLeftDiogninal();}
    }
    public void winnnerLeftDiogninal(){
        this.winner="";
        this.row = 0;
        this.col = 0;
        for(int i = 0;i < ticTac.length;i++){
            winner = winner+ticTac[row][col];
            row++;col++;
        }
        if(winner.equals(ticO) || winner.equals(ticX)){
            foundWinner = true;
            increamentWinner(winner);
        }
        else{winnerRightDiogninal();}
    }
    public void winnerRightDiogninal(){
        this.winner="";
        this.row = 0;
        this.col = 2;
        for(int i =0;i < ticTac.length;i++){
            winner = winner+ticTac[row][col];
            row++;col--;
        }
        if(winner.equals(ticO) || winner.equals(ticX)){
            foundWinner = true;
            increamentWinner(winner);
        }
        else{winnerColumn();}
    }
    //this method check for the winner   
    public void winnerColumn()
    {
        this.winner="";
        for(int i =0;i < ticTac.length;i++){
            for(int x =0;x < ticTac.length;x++){
                if(ticTac[x][i].equals(ticTac[1][i]) && ticTac[x][i].equals(ticTac[2][i]) && ticTac[x][i] !="H"){
                    winner=winner+ticTac[x][i]+ticTac[1][i]+ticTac[2][i];
                    break;
                }
            }
        }
        if(winner.equals(ticO) || winner.equals(ticX)){
            foundWinner = true;
            increamentWinner(winner);
        }
        else{}
    }
    public void increamentWinner(String winner)
    {
        JOptionPane.showMessageDialog(null,"Player "+winner.charAt(0)+" Won The Table");
        
        if(winner.charAt(0)=='X'){
            winnerX++;
            lbScoreX.setText(Integer.toString(winnerX));
        }
        if(winner.charAt(0)=='O'){
            winnerO++;
            lbScoreO.setText(Integer.toString(winnerO));
        }
        resetGame();
        onLoad();
    }
    public void resetGame(){
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        
        onLoad();
        this.countMoves = 0;
        this.winner="";
        this.foundWinner=false;
        //displayArrays();
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
