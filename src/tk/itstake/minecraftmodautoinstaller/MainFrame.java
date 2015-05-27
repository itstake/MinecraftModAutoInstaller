/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.itstake.minecraftmodautoinstaller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JScrollBar;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import net.lingala.zip4j.exception.ZipException;

/**
 *
 * @author itstake
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    Properties settings = new Properties();
    String path = null;
    String title = null;
    String description = null;
    String unzippath = null;
    ColoredComponents cc = new ColoredComponents();
    Color colorCom = cc.getComponentColor();
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
    Dimension panelSize = this.getSize();
    public static Font font;
    private final ImageIcon wicon = new ImageIcon(getClass().getResource("/img/logoback.png"));
    private static String OS = System.getProperty("os.name").toLowerCase();
    public MainFrame() throws IOException, FontFormatException {
        MainFrame.font = Font.createFont(Font.TRUETYPE_FONT, this.getClass().getResourceAsStream("/fonts/NanumBarunGothic.ttf")).deriveFont(Font.PLAIN, 0);
        SettingHandling sh = new SettingHandling();
        settings = sh.getSettingFile();
        path = new String(System.getenv("APPDATA").getBytes("ISO-8859-1"), "UTF-8");
        title = new String(settings.getProperty("title").getBytes("ISO-8859-1"), "UTF-8");
        description = new String(settings.getProperty("description").getBytes("ISO-8859-1"), "UTF-8");
        unzippath = new String(settings.getProperty("unzippath").getBytes("ISO-8859-1"), "UTF-8");
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(title);
        setIconImage(wicon.getImage());
        setLocation(screenSize.width/2-200,screenSize.height/2-85);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(400, 150));
        jPanel1.setLayout(null);

        jLabel1.setBackground(colorCom);
        jLabel1.setFont(font.deriveFont(Font.PLAIN, 24));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText(title);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 6, 380, 30);

        jTextField1.setText(path);
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(colorCom));
        jTextField1.setDisabledTextColor(colorCom);
        jTextField1.setEnabled(false);
        jTextField1.setSelectionColor(new java.awt.Color(0, 0, 0));
        jPanel1.add(jTextField1);
        jTextField1.setBounds(10, 90, 300, 17);
        if(isWindows()) {
            path = System.getenv("APPDATA") + "\\.minecraft\\" +  unzippath;
        } else if(isMac()) {
            path = System.getenv("APPDATA") + "\\minecraft\\" + unzippath;
        } else {
            path = "이 OS 에서 사용하는 마인크래프트의 기본 경로를 찾을 수 없습니다! 왼쪽 버튼을 클릭하여 수동선택 해주세요.";
        }
        jTextField1.setText(path);

        jButton1.setBackground(colorCom);
        jButton1.setFont(font.deriveFont(Font.PLAIN, 12));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("경로 선택");
        jButton1.setBorder(null);
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(310, 90, 80, 17);

        jButton2.setBackground(colorCom);
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("설치하기");
        jButton2.setBorder(null);
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(240, 113, 150, 30);

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(font.deriveFont(Font.PLAIN, 12));
        jTextArea1.setText(description);
        jTextArea1.setAutoscrolls(false);
        jTextArea1.setBorder(null);
        jTextArea1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 45, 380, 45);
        JScrollBar vertical = jScrollPane1.getVerticalScrollBar();
        vertical.setPreferredSize( new Dimension(0,0) );

        jPanel2.setBackground(colorCom);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 400, 40);

        jLabel2.setFont(font.deriveFont(Font.PLAIN, 14));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("MMAI v1.0.2 by ITSTAKE, itstake.tk");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(130, 150, 260, 15);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        UnZipper unzip = new UnZipper();
        try {
            unzip.unzip(path);
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ZipException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(!settings.getProperty("profilename").equals("")) {
        ProfileCreator pc = new ProfileCreator();
        try {
            pc.addProfile();
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        EndDialog dialog;
        try {
            dialog = new EndDialog();
            dialog.main();
        } catch (FontFormatException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser chooser;
        LookAndFeel preLF = UIManager.getLookAndFeel();
        try {
        if(!"com.apple.laf.AquaLookAndFeel".equals(UIManager.getSystemLookAndFeelClassName())) {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            chooser = new JFileChooser();
            UIManager.setLookAndFeel(preLF);
        } else {
            chooser = new JFileChooser();
        }
    } catch (IllegalAccessException | UnsupportedLookAndFeelException | InstantiationException | ClassNotFoundException e) {
        chooser = new JFileChooser();
    }
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("설치할 폴더 선택..");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            path = chooser.getSelectedFile().toString();
            jTextField1.setText(chooser.getSelectedFile().toString());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainFrame().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public static boolean isWindows() {
 
	return (OS.indexOf("win") >= 0);
 
	}
 
    public static boolean isMac() {
 
	return (OS.indexOf("mac") >= 0);
 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
