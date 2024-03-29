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
public class Konsole extends javax.swing.JFrame {

    private String hostname = "localhost";
    private String chroot = "~";
    private String pwd = "~";
    private String usuario = "root";
    private String promptSep = " # ";
    private String prompt;

    public Konsole() {
        inicializar();
    }

    public Konsole(String hostname) {
        this.hostname = hostname;
        this.pwd = "~";
        inicializar();
    }

    public Konsole(String hostname, String usuario) {
        this.hostname = hostname;
        this.usuario = usuario;
        this.pwd = "/home/" + usuario;
        inicializar();

    }

    private void inicializar() {
        initComponents();
        jTextArea1.setText(this.getPrompt());
        jTextArea1.setCaretPosition(this.getPrompt().length());
        System.out.println("** Iniciando Terminal **");
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
        jTextArea1.setFont(new java.awt.Font("Courier 10 Pitch", 0, 14)); // NOI18N
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
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                evt.consume();
                int longPrompt = this.getPrompt().length();
                int posCursor = jTextArea1.getCaretPosition();
                int lineaNro = jTextArea1.getLineOfOffset(posCursor);
                int posInicioLinea = jTextArea1.getLineStartOffset(lineaNro) + longPrompt;
                int posFinalLinea = jTextArea1.getLineEndOffset(lineaNro);
                String lineaTextoIngresada = jTextArea1.getText(posInicioLinea, posFinalLinea - posInicioLinea);
                System.out.println("* textoCLI -> [" + lineaTextoIngresada + "]");
                // *****************************************
                // se envia a procesar la linea se comandos
                // *****************************************                
                ProcesarCLI procesarCLI = new ProcesarCLI(lineaTextoIngresada);
                String salidaDelComando = procesarCLI.ejecutar();
                //String salidaDelComando = "prueba de salida";
                salidaATerminal(salidaDelComando);

            } catch (BadLocationException ex) {
                Logger.getLogger(Konsole.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jTextArea1KeyPressed

    private void salidaATerminal(String textoSalida) {
        jTextArea1.setText(jTextArea1.getText() + "\n" + textoSalida + "\n" + this.getPrompt());
        jTextArea1.repaint();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the prompt
     */
    private String getPrompt() {
        this.prompt = this.usuario + "@" + this.hostname + ":" + this.pwd + this.promptSep;
        return this.prompt;
    }
}
