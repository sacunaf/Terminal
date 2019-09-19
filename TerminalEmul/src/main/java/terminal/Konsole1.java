package terminal;

import procesarCLI.ProcesarCLI;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;

/**
 *
 * @author junta
 */
public class Konsole1 extends javax.swing.JFrame {

    private String hostname = "localhost";
    private String chroot = "~";
    private String pwd = "~";
    private String usuario = "root";
    private String promptSep = " # ";
    private String prompt;
   
    public Konsole1() {
        inicializar();
    }

    public Konsole1(String hostname) {
        this.hostname = hostname;
        this.pwd = "~";
        inicializar();
    }

    public Konsole1(String hostname, String usuario) {
        this.hostname = hostname;
        this.usuario = usuario;
        this.pwd = "/home/" + usuario;
        inicializar();
        
    }

    private void inicializar() {
        initComponents();
        jTextArea1.setText(this.getPrompt());
        jTextArea1.setCaretPosition(this.getPrompt().length());
        System.out.println(">>>>>>");
        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextArea1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                int longPrompt = this.getPrompt().length();
                int posCursor = jTextArea1.getCaretPosition();
                int lineaNro = jTextArea1.getLineOfOffset(posCursor);                
                int posInicioLinea = jTextArea1.getLineStartOffset(lineaNro)+longPrompt;
                int posFinalLinea = jTextArea1.getLineEndOffset(lineaNro);
                String lineaTextoIngresada = jTextArea1.getText(posInicioLinea, posFinalLinea-posInicioLinea);
                System.out.println(">>>>>>"+lineaTextoIngresada);
                
                ProcesarCLI procesarCLI = new ProcesarCLI(lineaTextoIngresada);
                String textoSalida = procesarCLI.ejecutar();
                        
                String salidaDelComando = textoSalida;

                jTextArea1.setText(jTextArea1.getText()+salidaDelComando+"\n"+this.getPrompt());
            } catch (BadLocationException ex) {
                Logger.getLogger(Konsole1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jTextArea1KeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Konsole1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Konsole1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Konsole1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Konsole1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Konsole1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the chroot
     */
    public String getChroot() {
        return chroot;
    }

    /**
     * @param chroot the chroot to set
     */
    public void setChroot(String chroot) {
        this.chroot = chroot;
    }

    /**
     * @return the pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * @param pwd the pwd to set
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * @return the prompt
     */
    private String getPrompt() {
        this.prompt = this.usuario+"@"+this.hostname+":"+this.pwd+this.promptSep;        
        return this.prompt;
    }
   
    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

  }
