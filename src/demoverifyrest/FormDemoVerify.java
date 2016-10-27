package demoverifyrest;

import java.awt.SystemColor;
import javax.ws.rs.client.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;


 /** 
  * @author StreetMaster
  * Esempio di utilizzo del servizio WS VERIFY per la verifica e la normalizzazione degli indirizzi italiani realizzato da StreetMaster Italia 
  *  
  * L'end point del servizio è 
  *     http://ec2-46-137-97-173.eu-west-1.compute.amazonaws.com/smrest/verify
  *     
  * Per l'utilizzo registrarsi sul sito http://streetmaster.it e richiedere la chiave per il servizio VERIFY 
  * Il protocollo di comunicazione e' in formato JSON
  * 
  *  2016 - Software by StreetMaster (c)
  */

public class FormDemoVerify extends javax.swing.JFrame {

    private int curCand=0;
    private VerifyResponse outVerify;
    /**
     * Creates new form DemoSuggest
     */
    public FormDemoVerify() {
        initComponents();
        this.getContentPane().setBackground(SystemColor.info);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelInput = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTxtComuneIn = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTxtIndirizzoIn = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTxtProvIn = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTxtCAPIn = new javax.swing.JTextField();
        jBtnCallVerify = new javax.swing.JButton();
        jTxtKey = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanelOut = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTxtEsito = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTxtCodErr = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTxtNumCand = new javax.swing.JTextField();
        jBtnPrev = new javax.swing.JButton();
        jPanelCand = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTxtComuneOut = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTxtProvOut = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTxtCAPOut = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTxtFrazioneOut = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTxtIndirizzoOut = new javax.swing.JTextField();
        jBtnNext = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Demo Verify");
        setBackground(java.awt.SystemColor.info);

        jPanelInput.setBackground(java.awt.SystemColor.info);
        jPanelInput.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelInput.setName("Input"); // NOI18N

        jLabel1.setText("Comune:");

        jTxtComuneIn.setName(""); // NOI18N

        jLabel2.setText("Indirizzo:");

        jLabel3.setText("Provincia:");

        jLabel4.setText("CAP:");

        javax.swing.GroupLayout jPanelInputLayout = new javax.swing.GroupLayout(jPanelInput);
        jPanelInput.setLayout(jPanelInputLayout);
        jPanelInputLayout.setHorizontalGroup(
            jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInputLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtComuneIn, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTxtProvIn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtCAPIn, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelInputLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtIndirizzoIn, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanelInputLayout.setVerticalGroup(
            jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInputLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTxtComuneIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTxtCAPIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTxtProvIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanelInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTxtIndirizzoIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jLabel2.getAccessibleContext().setAccessibleDescription("");

        jBtnCallVerify.setActionCommand("jBtnCallVerify");
        jBtnCallVerify.setLabel("Call Verify");
        jBtnCallVerify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCallVerifyActionPerformed(evt);
            }
        });

        jTxtKey.setText("Specificare una chiave per il servizio Verify");

        jLabel5.setText("KEY:");

        jPanelOut.setBackground(java.awt.SystemColor.info);
        jPanelOut.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setText("Esito:");

        jTxtEsito.setName(""); // NOI18N

        jLabel7.setText("Cod Err:");

        jLabel8.setText("Num Cand:");

        jBtnPrev.setText("<<");
        jBtnPrev.setToolTipText("");
        jBtnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPrevActionPerformed(evt);
            }
        });

        jPanelCand.setBackground(java.awt.SystemColor.info);
        jPanelCand.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setText("Comune:");

        jTxtComuneOut.setName(""); // NOI18N

        jLabel10.setText("Provincia:");

        jLabel11.setText("CAP:");

        jLabel12.setText("Frazione:");

        jTxtFrazioneOut.setName(""); // NOI18N

        jLabel13.setText("Indirizzo:");

        javax.swing.GroupLayout jPanelCandLayout = new javax.swing.GroupLayout(jPanelCand);
        jPanelCand.setLayout(jPanelCandLayout);
        jPanelCandLayout.setHorizontalGroup(
            jPanelCandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCandLayout.createSequentialGroup()
                .addGroup(jPanelCandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCandLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanelCandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelCandLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxtFrazioneOut, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelCandLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxtComuneOut, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTxtProvOut, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtCAPOut, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelCandLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtIndirizzoOut, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanelCandLayout.setVerticalGroup(
            jPanelCandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCandLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTxtComuneOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jTxtCAPOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jTxtProvOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtFrazioneOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanelCandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtIndirizzoOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jBtnNext.setText(">>");
        jBtnNext.setToolTipText("");
        jBtnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelOutLayout = new javax.swing.GroupLayout(jPanelOut);
        jPanelOut.setLayout(jPanelOutLayout);
        jPanelOutLayout.setHorizontalGroup(
            jPanelOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOutLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanelOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelOutLayout.createSequentialGroup()
                        .addComponent(jBtnPrev)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnNext))
                    .addGroup(jPanelOutLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtEsito, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTxtCodErr, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtNumCand, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelOutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelCand, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelOutLayout.setVerticalGroup(
            jPanelOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOutLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTxtEsito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jTxtNumCand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTxtCodErr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelOutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnPrev)
                    .addComponent(jBtnNext))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelCand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel14.setBackground(java.awt.SystemColor.info);
        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Sviluppo\\RepositoryDemo\\VerifyFreeRest_ASPNET\\VerifyFreeRest_ASPNET\\images\\logo-street-master.png")); // NOI18N
        jLabel14.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel14)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jBtnCallVerify)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTxtKey))
                        .addComponent(jPanelInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel14))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBtnCallVerify)
                            .addComponent(jLabel5)
                            .addComponent(jTxtKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jPanelOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnCallVerifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCallVerifyActionPerformed
        // oggetto client per l'utilizzo del ws VERIFY
        Client client1 = ClientBuilder.newClient();
        WebTarget target = client1.target("http://ec2-46-137-97-173.eu-west-1.compute.amazonaws.com/smrest/webresources/verify");
        
        JSONObject inputJsonObj = new JSONObject();
        // valorizzazione input
        // per l'esempio viene valorizzato un insieme minimo dei parametri
        target =target.queryParam("Key", jTxtKey.getText());
        target =target.queryParam("Localita", jTxtComuneIn.getText());
        target =target.queryParam("Cap",jTxtCAPIn.getText());
        target =target.queryParam("Provincia", jTxtProvIn.getText());
        target =target.queryParam("Indirizzo", jTxtIndirizzoIn.getText());
        target =target.queryParam("Localita2", "");
        target =target.queryParam("Dug", "");
        target =target.queryParam("Civico", "");
            
        // chiamata al servizio
        outVerify= target.request(MediaType.APPLICATION_JSON).get(VerifyResponse.class);
       
       
        
        // lettura campi generali del risultato
        jTxtEsito.setText(String.valueOf(outVerify.Norm));
        jTxtCodErr.setText(String.valueOf(outVerify.CodErr));
        jTxtNumCand.setText(String.valueOf(outVerify.NumCand));
        curCand=0;
        
        // dettaglio del primo candidato se esiste
        // nella form di output e' riportato solo un sottoinsieme di tutti i valori restituiti 
        if (outVerify.NumCand>0)
        {
            jTxtComuneOut.setText(outVerify.Output.get(curCand).Comune);
            jTxtProvOut.setText(outVerify.Output.get(curCand).Prov);
            jTxtCAPOut.setText(outVerify.Output.get(curCand).Cap);
            jTxtFrazioneOut.setText(outVerify.Output.get(curCand).Frazione);
            jTxtIndirizzoOut.setText(outVerify.Output.get(curCand).Indirizzo);
        }
    }//GEN-LAST:event_jBtnCallVerifyActionPerformed

    private void jBtnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPrevActionPerformed
        // dettaglio del successivo candidato se esiste
       if (outVerify.NumCand>0)
        {
            curCand-=1;
            jTxtComuneOut.setText(outVerify.Output.get(curCand).Comune);
            jTxtProvOut.setText(outVerify.Output.get(curCand).Prov);
            jTxtCAPOut.setText(outVerify.Output.get(curCand).Cap);
            jTxtFrazioneOut.setText(outVerify.Output.get(curCand).Frazione);
            jTxtIndirizzoOut.setText(outVerify.Output.get(curCand).Indirizzo);
        }
    }//GEN-LAST:event_jBtnPrevActionPerformed

    private void jBtnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNextActionPerformed
        // dettagli del precedente candidato se esiste
        if (curCand<outVerify.NumCand-1)
        {
            curCand+=1;
            jTxtComuneOut.setText(outVerify.Output.get(curCand).Comune);
            jTxtProvOut.setText(outVerify.Output.get(curCand).Prov);
            jTxtCAPOut.setText(outVerify.Output.get(curCand).Cap);
            jTxtFrazioneOut.setText(outVerify.Output.get(curCand).Frazione);
            jTxtIndirizzoOut.setText(outVerify.Output.get(curCand).Indirizzo);
        }
    }//GEN-LAST:event_jBtnNextActionPerformed

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
            java.util.logging.Logger.getLogger(FormDemoVerify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDemoVerify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDemoVerify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDemoVerify.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FormDemoVerify().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCallVerify;
    private javax.swing.JButton jBtnNext;
    private javax.swing.JButton jBtnPrev;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelCand;
    private javax.swing.JPanel jPanelInput;
    private javax.swing.JPanel jPanelOut;
    private javax.swing.JTextField jTxtCAPIn;
    private javax.swing.JTextField jTxtCAPOut;
    private javax.swing.JTextField jTxtCodErr;
    private javax.swing.JTextField jTxtComuneIn;
    private javax.swing.JTextField jTxtComuneOut;
    private javax.swing.JTextField jTxtEsito;
    private javax.swing.JTextField jTxtFrazioneOut;
    private javax.swing.JTextField jTxtIndirizzoIn;
    private javax.swing.JTextField jTxtIndirizzoOut;
    private javax.swing.JTextField jTxtKey;
    private javax.swing.JTextField jTxtNumCand;
    private javax.swing.JTextField jTxtProvIn;
    private javax.swing.JTextField jTxtProvOut;
    // End of variables declaration//GEN-END:variables
}
