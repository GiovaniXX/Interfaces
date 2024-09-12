package interfaces;

import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;
import raven.toast.Notifications;

public class Login extends JPanel {

    public Login() {
        init();
    }

    // Método init
    private void init() {
        setLayout(new MigLayout("fill, insets 20", "[center]", "[center]"));
        txtUsername = new JTextField();
        jpfPassword = new JPasswordField();
        jcRememberMe = new JCheckBox("Remember me");
        jbLogin = new JButton("Login");
        jbTemas = new JButton("Change Mode");
        jbChangePanelColor = new JButton("Change Panel Color");
        jbChangeComponentColor = new JButton("Change Component Color");

        // Estilização do JPanel - painel principal
        JPanel panel = new JPanel(new MigLayout("wrap, fillx, insets 35 45 35 45", "fill, 250:280"));
        panel.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc:20;"
                + "[light]background:darken(@background, 3%);"
                + "[dark]background:lighten(@background, 3%)");
        jpfPassword.putClientProperty(FlatClientProperties.STYLE, "showRevealButton:true");
        jbLogin.putClientProperty(FlatClientProperties.STYLE, ""
                + "[light]background:darken(@background, 10%);"
                + "[dark]background:lighten(@background, 10%);"
                + "margin:4,6,4,6;"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0");

        // Ação para trocar cor do painel
        jbChangePanelColor.addActionListener(e -> {
            Color selectedColor = JColorChooser.showDialog(this, "Choose Panel Color", panel.getBackground());
            if (selectedColor != null) {
                panel.setBackground(selectedColor);
            }
        });

        // Ação para trocar cor dos componentes
        jbChangeComponentColor.addActionListener(e -> {
            Color selectedColor = JColorChooser.showDialog(this, "Choose Component Color", txtUsername.getForeground());
            if (selectedColor != null) {
                for (Component comp : panel.getComponents()) {
                    if (comp instanceof JTextField || comp instanceof JLabel || comp instanceof JButton || comp instanceof JCheckBox) {
                        comp.setForeground(selectedColor);
                    }
                }
            }
        });

        // Ação do botão
        jbLogin.addActionListener((e) -> {
            Notifications.getInstance().show(Notifications.Type.WARNING, "Login realizado com sucesso..!");
        });

        // Estilização do botão
        jbTemas.putClientProperty(FlatClientProperties.STYLE, ""
                + "[light]background:darken(@background,10%);"
                + "[dark]background:lighten(@background,10%);"
                + "margin:4,6,4,6;"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0");

        // Ação do botão
        jbTemas.addActionListener((e) -> {
            //  Do action Change Mode here
            if (!FlatLaf.isLafDark()) {
                EventQueue.invokeLater(() -> {
                    FlatAnimatedLafChange.showSnapshot();
                    FlatMacDarkLaf.setup();
                    FlatLaf.updateUI();
                    FlatAnimatedLafChange.hideSnapshotWithAnimation();
                });
            } else {
                EventQueue.invokeLater(() -> {
                    FlatAnimatedLafChange.showSnapshot();
                    FlatMacLightLaf.setup();
                    FlatLaf.updateUI();
                    FlatAnimatedLafChange.hideSnapshotWithAnimation();
                });
            }
        });

        // Estilização do botão panel
        jbChangePanelColor.putClientProperty(FlatClientProperties.STYLE, ""
                + "[light]background:darken(@background,10%);"
                + "[dark]background:lighten(@background,10%);"
                + "margin:4,6,4,6;"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0");

        // Estilização do botão componente
        jbChangeComponentColor.putClientProperty(FlatClientProperties.STYLE, ""
                + "[light]background:darken(@background,10%);"
                + "[dark]background:lighten(@background,10%);"
                + "margin:4,6,4,6;"
                + "borderWidth:0;"
                + "focusWidth:0;"
                + "innerFocusWidth:0");

        txtUsername.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter your username or email");
        jpfPassword.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter your password");

        JLabel lbTitle = new JLabel("Welcome back!");
        JLabel description = new JLabel("Please sign in to access your account");
        lbTitle.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:bold +10");
        description.putClientProperty(FlatClientProperties.STYLE, ""
                + "[light]foreground:lighten(@foreground,30%);"
                + "[dark]foreground:darken(@foreground,30%)");

        panel.add(lbTitle);
        panel.add(description);
        panel.add(new JLabel("Username"), "gapy 8");
        panel.add(txtUsername);
        panel.add(new JLabel("Password"), "gapy 8");
        panel.add(jpfPassword);
        panel.add(jcRememberMe, "grow 0");
        panel.add(jbLogin, "gapy 10");
        panel.add(jbTemas, "gapy 10");
        panel.add(jbChangePanelColor, "gapy 10");
        panel.add(jbChangeComponentColor, "gapy 10");
        panel.add(createSignupLabel(), "gapy 10");
        add(panel);
    }

    private Component createSignupLabel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panel.putClientProperty(FlatClientProperties.STYLE, ""
                + "background:null");

        // Estilização do botão
        JButton cmdRegister = new JButton("<html><a href=\"#\">Sign up</a></html>");
        cmdRegister.putClientProperty(FlatClientProperties.STYLE, ""
                + "border:3,3,3,3");
        cmdRegister.setContentAreaFilled(false);
        cmdRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Acão do botão
        cmdRegister.addActionListener(e -> {
            Notifications.getInstance().show(Notifications.Type.WARNING, "Sign up chamado com sucesso..!");
        });
        JLabel label = new JLabel("Don't have an account ?");

        // Estilização da label
        label.putClientProperty(FlatClientProperties.STYLE, ""
                + "[light]foreground:lighten(@foreground,30%);"
                + "[dark]foreground:darken(@foreground,30%)");
        panel.add(label);
        panel.add(cmdRegister);
        return panel;
    }

    private JTextField txtUsername;
    private JPasswordField jpfPassword;
    private JCheckBox jcRememberMe;
    private JButton jbLogin;
    private JButton jbTemas;
    private JButton jbChangePanelColor;
    private JButton jbChangeComponentColor;

    public static void main(String[] args) {
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("interfaces");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacDarkLaf.setup();

        // Inicia a interface gráfica
        EventQueue.invokeLater(() -> {
            // Criação do JFrame
            JFrame frame = new JFrame("Dev.: Giovanni MigLayout - Interface Gráfica");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(826, 600);
            frame.setLocationRelativeTo(null);

            // Adiciona o painel Login ao JFrame
            frame.add(new Login());

            // Exibe a janela
            frame.setVisible(true);
        });
    }
}
