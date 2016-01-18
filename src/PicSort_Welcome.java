import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
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
    Container cp = getContentPane();
    public PicSort_Welcome(String title) {
        super(title);
        addHeaderPanel("PicSort", new Color(0x5caf50), Color.WHITE, 30);
        addButton("Start PicSort", ae -> startPicSort());
        addButton("About", ae -> openAbout());
        createWindow();
    }
    public void a(Component c, int pd) {
        cp.add(c);
        plus(c.getHeight() + pd);
    }
    public void plus(int add) { currentY += add;}
    public void addHeaderPanel(String text, Color bg, Color fg, int fontSize) {
        JLabel l = new JLabel(text, SwingConstants.CENTER);
        l.setForeground(fg);
        l.setFont(new Font("Header", Font.PLAIN, fontSize));
        JPanel headerPanel = new JPanel(new GridLayout());
        headerPanel.setBounds(0, currentY, finalW, 60);
        headerPanel.setBackground(bg);
        headerPanel.add(l);
        a(headerPanel, 2 * pd);
    }
    public void addButton(String text, ActionListener ae) {
        JButton b = new JButton();
        b.setBounds(pd, currentY, useW, 24);
        b.setText(text);
        b.addActionListener(ae);
        a(b, pd);
    }
    public void startPicSort() {
        dispose();
        //start dat Frame
    }
    public void openAbout() {
        dispose();
        new PicSort_About("About");
    }
    public void createWindow() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(finalW, currentY + 34);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation( (d.width - getWidth()) / 2, (d.height - getHeight()) / 2);
        setResizable(false);
        cp.setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) { new PicSort_Welcome("PicSort ALPHA");}
}
