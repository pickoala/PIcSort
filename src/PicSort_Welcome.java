import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Version 0.01.2.A
 * created on 18th January 2016
 * by Konstantin A. M. (pickoala) Walter
 *
 * made in Germany
 */
public class PicSort_Welcome extends JFrame {
    int pd = 16;
    int useW = 300;
    int finalW = useW + 2 * pd;
    int currentY = 0;
    Color hd = new Color(0xBF360C);
    Color bg = new Color(0x263238);
    Color cClick = new Color(0x69F0AE);
    Container cp = getContentPane();
    public PicSort_Welcome(String title) {
        super(title);
        addHeaderPanel("PicSort", hd, Color.WHITE, 30);
        addPadding(pd);
        addClickPanel("Start PicSort", cClick, Color.BLACK, 40, 0);
        addPadding(pd);
        addClickPanel("Settings", cClick, Color.BLACK, 30, 2);
        addPadding(pd);
        addClickPanel("About", cClick, Color.BLACK, 30, 1);
        addPadding(pd);
        createWindow();
    }
    public void addHeaderPanel(String text, Color back, Color fore, int fontSize) {
        JLabel l = new JLabel(text, SwingConstants.CENTER);
        l.setForeground(fore);
        l.setFont(new Font("Header", Font.PLAIN, fontSize));
        JPanel headerPanel = new JPanel(new GridLayout());
        headerPanel.setBounds(0, currentY, finalW, 60);
        headerPanel.setBackground(back);
        headerPanel.add(l);
        a(headerPanel, 0);
    }
    public void addClickPanel(String text, Color back, Color fore, int height, int method) {
        JLabel l = new JLabel(text, SwingConstants.CENTER);
        l.setForeground(fore);
        l.setFont(new Font("label", Font.PLAIN, 12));
        JPanel panel = new JPanel(new GridLayout());
        panel.setBounds(0, currentY, finalW, height);
        panel.setBackground(back);
        panel.add(l);
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switch (method) {
                    case 0:
                        startPicSort();
                        break;
                    case 1:
                        openAbout();
                        break;
                    case 2:
                        openSettings();
                        break;
                    default:
                        break;
                }
            }
        });
        a(panel, 0);
    }
    public void addPadding(int height) {
        JPanel padding = new JPanel();
        padding.setBounds(0, currentY, finalW, height);
        padding.setBackground(bg);
        a(padding, 0);
    }
    public void startPicSort() {
        dispose();
        new PicSort("PicSort ALPHA");
    }
    public void openAbout() {
        dispose();
        new PicSort_About("About");
    }
    public void openSettings() {
        dispose();
        new PicSort_Settings();
    }
    public void a(Component c, int pd) {
        cp.add(c);
        plus(c.getHeight() + pd);
    }
    public void plus(int add) { currentY += add;}
    public void createWindow() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(finalW, currentY + 22);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation( (d.width - getWidth()) / 2, (d.height - getHeight()) / 2);
        setResizable(false);
        cp.setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) { new PicSort_Welcome("PicSort ALPHA");}
}
