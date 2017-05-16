/*
 * Copyright (C) 2016 Ernesto Serrano <info at ernesto.es>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package practica12;

/**
 * Esta clase representa a la ventana de defincion de tamaño de nuevas ventanas de imagen
 * @author Adri
 */
public class SizeWindow extends javax.swing.JFrame
{

    private MainWindow parent;

    /**
     * Constructor que crea una ventana size
     * @param parent la ventana padre
     * @param height la altura
     * @param width la anchura
     */
    public SizeWindow(MainWindow parent, int height, int width)
    {
        super();
        this.initComponents();
        this.parent = parent;
        this.jTextFieldHeight.setText(String.valueOf(height));
        this.jTextFieldWidth.setText(String.valueOf(width));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel3 = new javax.swing.JLabel();
        jTextFieldHeight = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldWidth = new javax.swing.JFormattedTextField();
        jButtonCrop = new javax.swing.JButton();
        jButtonResize = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(3, 3));

        jLabel3.setText("Alto");
        getContentPane().add(jLabel3);

        jTextFieldHeight.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jTextFieldHeight.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextFieldHeightActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldHeight);

        jLabel2.setText("Ancho");
        getContentPane().add(jLabel2);

        jTextFieldWidth.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        getContentPane().add(jTextFieldWidth);

        jButtonCrop.setText("Recortar");
        jButtonCrop.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonCropActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCrop);

        jButtonResize.setText("Redimensionar");
        jButtonResize.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonResizeActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonResize);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonResizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResizeActionPerformed
        this.parent.imageHeight = Integer.parseInt(this.jTextFieldHeight.getText());
        this.parent.imageWidth = Integer.parseInt(this.jTextFieldWidth.getText());
        this.setVisible(false);
    }//GEN-LAST:event_jButtonResizeActionPerformed

    private void jButtonCropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCropActionPerformed
        this.parent.imageHeight = Integer.parseInt(this.jTextFieldHeight.getText());
        this.parent.imageWidth = Integer.parseInt(this.jTextFieldWidth.getText());
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCropActionPerformed

    private void jTextFieldHeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHeightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHeightActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCrop;
    private javax.swing.JButton jButtonResize;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JFormattedTextField jTextFieldHeight;
    private javax.swing.JFormattedTextField jTextFieldWidth;
    // End of variables declaration//GEN-END:variables
}