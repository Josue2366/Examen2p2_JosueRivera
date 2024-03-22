/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen2p2_josuerivera;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

/**
 *
 * @author josue
 */
public class Barra extends Thread{
    JProgressBar barra1;
    JProgressBar barra2;
    Boolean vive;
    Boolean Juan;
    Carro x;
    Carro y;
    JLabel hora;

    public Barra(JProgressBar barra1, JProgressBar barra2, Carro x, Carro y,JLabel hora) {
        this.hora = hora;
        this.barra1 = barra1;
        this.barra2 = barra2;
        this.vive = true;
        this.Juan = true;
        this.x = x;
        this.y = y;
    }

    public JProgressBar getBarra1() {
        return barra1;
    }

    public void setBarra1(JProgressBar barra1) {
        this.barra1 = barra1;
    }

    public JProgressBar getBarra2() {
        return barra2;
    }

    public void setBarra2(JProgressBar barra2) {
        this.barra2 = barra2;
    }

    public Boolean getVive() {
        return vive;
    }

    public void setVive(Boolean vive) {
        this.vive = vive;
    }

    public Boolean getJuan() {
        return Juan;
    }

    public void setJuan(Boolean Juan) {
        this.Juan = Juan;
    }

    public Carro getX() {
        return x;
    }

    public void setX(Carro x) {
        this.x = x;
    }

    public Carro getY() {
        return y;
    }

    public void setY(Carro y) {
        this.y = y;
    }

    @Override
    public void run() {
        
        int cont = 0;
        int min = 0;
        int sec = 0;
        while(vive){
            
            if(barra1.getValue() == 100 && barra2.getValue() == 100){
                vive = false;
                cont = 1;
            }
            else if(barra1.getValue() == 100 || barra2.getValue() == 100){
                vive = false;
                
            }
            else{
                barra1.setValue(barra1.getValue()+ x.getVelocidad());
                barra2.setValue(barra2.getValue()+ y.getVelocidad());
                sec++;
                if(sec == 60){
                    min++;
                    sec = 0;
                }
                hora.setText(min+":"+sec);
                
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
        if(cont == 1){
            JOptionPane.showMessageDialog(null, "Empate");
            JOptionPane.showMessageDialog(null, "se tardaron "+min+" minutos y "+sec+" segundos");
            barra1.setValue(0);
            barra2.setValue(0);
        }
        
        else if(barra1.getValue() == 100){
            JOptionPane.showMessageDialog(null, "Gano: "+x.toString());
            JOptionPane.showMessageDialog(null, "Gano en "+min+" minutos y "+sec+" segundos");
            barra1.setValue(0);
            barra2.setValue(0);
        }
        else{
            JOptionPane.showMessageDialog(null, "Gano: "+y.toString());
            JOptionPane.showMessageDialog(null, "Gano en "+min+" minutos y "+sec+" segundos");
            barra1.setValue(0);
            barra2.setValue(0);

        }
            
        
    }
    
    
    
}
