/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.itstake.minecraftautoinstaller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import net.lingala.zip4j.exception.ZipException;

/**
 *
 * @author itstake
 */
public class MultiMainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MultiMainFrame
     */
    Properties settings = new Properties();
    Properties unzipsettings = new Properties();
    Properties unzipprofile = new Properties();
    String path = null;
    String title = null;
    String description = null;
    String unzippath = null;
    String unzipfile = null;
    ColoredComponents cc = new ColoredComponents();
    Color colorCom = cc.getComponentColor();
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screenSize = tk.getScreenSize();
    Dimension panelSize = this.getSize();
    public static Font font;
    HashMap<String, Boolean> installarray = null;
    DefaultListModel<JCheckBox> model = null;
    private final ImageIcon wicon = new ImageIcon(getClass().getResource("/img/logoback.png"));
    private static String OS = System.getProperty("os.name").toLowerCase();
    public MultiMainFrame() throws UnsupportedEncodingException, FontFormatException, IOException {
        MultiMainFrame.font = Font.createFont(Font.TRUETYPE_FONT, this.getClass().getResourceAsStream("/fonts/NanumBarunGothic.ttf")).deriveFont(Font.PLAIN, 0);
        SettingHandling sh = new SettingHandling();
        settings = sh.getSettingFile();
        unzipsettings = sh.getUnzipProperties();
        installarray = getInstallHashMap();
        model = getCustomModel();
        Enumeration<?> pn = unzipsettings.propertyNames();
        unzipprofile = sh.getUnzipProfileProperties((String) pn.nextElement());
        path = new String(System.getenv("APPDATA").getBytes("ISO-8859-1"), "UTF-8");
        title = new String(settings.getProperty("title").getBytes("ISO-8859-1"), "UTF-8");
        description = new String(settings.getProperty("description").getBytes("ISO-8859-1"), "UTF-8");
        unzippath = new String(unzipprofile.getProperty("unzippath").getBytes("ISO-8859-1"), "UTF-8");
        unzipfile = new String(unzipprofile.getProperty("zippath").getBytes("ISO-8859-1"), "UTF-8");
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
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(title);
        setIconImage(wicon.getImage());
        setLocation(screenSize.width/2-355,screenSize.height/2-200);
        setResizable(false);

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
        jTextField1.setBounds(10, 130, 610, 17);
        if(isWindows()) {
            path = System.getenv("APPDATA") + "\\.minecraft";
        } else if(isMac()) {
            path = System.getenv("APPDATA") + "\\minecraft";
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
        jButton1.setBounds(620, 130, 80, 17);

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
        jButton2.setBounds(550, 330, 150, 30);

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
        jScrollPane1.setBounds(10, 45, 380, 60);
        JScrollBar vertical = jScrollPane1.getVerticalScrollBar();
        vertical.setPreferredSize( new Dimension(0,0) );

        jPanel2.setBackground(colorCom);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 710, 40);

        jLabel2.setFont(font.deriveFont(Font.PLAIN, 14));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("MAI v2.1 by ITSTAKE, itstake.tk");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(440, 370, 260, 15);

        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 110, 700, 15);
        jLabel3.setText("마인크래프트의 경로를 설정해 주세요. 현재 기본 경로는 " + path + "입니다.");

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jList1.setFont(font.deriveFont(Font.PLAIN, 12));
        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.setLayoutOrientation(javax.swing.JList.VERTICAL_WRAP);
        jList1.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(jList1);
        jList1.setModel(model);
        jList1.setCellRenderer(new CheckboxListCellRenderer());
        jList1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int index = jList1.locationToIndex(e.getPoint());
                if (index != -1) {
                    JCheckBox checkbox = (JCheckBox) jList1.getModel().getElementAt(index);
                    if(checkbox.isEnabled()) {
                        checkbox.setSelected(!checkbox.isSelected());
                        installarray.put((String)installarray.keySet().toArray()[index], checkbox.isSelected());
                        jList1.repaint();
                    }
                }
            }
        });

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(10, 160, 690, 170);
        JScrollBar vertical2 = jScrollPane2.getVerticalScrollBar();
        vertical2.setPreferredSize( new Dimension(0,0) );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.out.println(installarray);
        for(String key : installarray.keySet()) {
            try {
                SettingHandling sh = new SettingHandling();
                Properties profile = sh.getUnzipProfileProperties(key);
                InstallHandling ih = new InstallHandling();
                ih.InstallProfile(profile, path);
            } catch (IOException ex) {
                Logger.getLogger(MultiMainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
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
            java.util.logging.Logger.getLogger(MultiMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MultiMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MultiMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MultiMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MultiMainFrame().setVisible(true);
                } catch (FontFormatException ex) {
                    Logger.getLogger(MultiMainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MultiMainFrame.class.getName()).log(Level.SEVERE, null, ex);
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
    public class CheckboxListCellRenderer extends JCheckBox implements ListCellRenderer<JCheckBox> {

    public Component getListCellRendererComponent(JList list, JCheckBox value, int index, 
            boolean isSelected, boolean cellHasFocus) {

        return value;
    }
    
    
    }
    public class CustomJCheckBox extends JCheckBox {
        public CustomJCheckBox(String text, boolean selected, boolean enabled) {
            setText(text);
            setSelected(selected);
            setEnabled(enabled);
            setFont(font.deriveFont(Font.PLAIN, 12));
            setBackground(new Color(255, 255 ,255));
            setBorderPainted(false);
            setFocusPainted(false);
            setRequestFocusEnabled(false);
        }
    }
    
    public DefaultListModel<JCheckBox> getCustomModel() throws IOException {
        SettingHandling sh = new SettingHandling();
        Properties unzipsettings = sh.getUnzipProperties();
        Enumeration<String> properties = (Enumeration<String>) unzipsettings.propertyNames();
        DefaultListModel<JCheckBox> model = new DefaultListModel<JCheckBox>();
        while (properties.hasMoreElements()) {
            String key = properties.nextElement();
            String value = new String(unzipsettings.getProperty(key).getBytes("ISO-8859-1"), "UTF-8");
            Properties profile = sh.getUnzipProfileProperties(key);
            if(profile.getProperty("checked").equals("false") && profile.getProperty("change").equals("true")) {
                model.addElement(new CustomJCheckBox(value, false, true));
            } else if(profile.getProperty("checked").equals("true") && profile.getProperty("change").equals("false")) {
                model.addElement(new CustomJCheckBox(value, true, false));
            } else if(profile.getProperty("checked").equals("false") && profile.getProperty("change").equals("false")) {
                model.addElement(new CustomJCheckBox(value, false, false));
            } else {
                model.addElement(new CustomJCheckBox(value, true, true));
            }
            
         
        }
        return model;
    }
    
    public HashMap<String, Boolean> getInstallHashMap() throws IOException {
        SettingHandling sh = new SettingHandling();
        Properties unzipsettings = sh.getUnzipProperties();
        Enumeration<String> properties = (Enumeration<String>) unzipsettings.propertyNames();
        HashMap<String, Boolean> array;
        array = new HashMap();
        while (properties.hasMoreElements()) {
            String key = properties.nextElement();
            Properties profile = sh.getUnzipProfileProperties(key);
            if(profile.getProperty("checked").equals("false") && profile.getProperty("change").equals("true")) {
                array.put(key, false);
            } else if(profile.getProperty("checked").equals("true") && profile.getProperty("change").equals("false")) {
                array.put(key, true);
            } else if(profile.getProperty("checked").equals("false") && profile.getProperty("change").equals("false")) {
                array.put(key, false);
            } else {
                array.put(key, true);
            }
            
         
        }
        return array;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
