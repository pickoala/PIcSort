import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PicSort_About extends JFrame {
    int pd = 16;
    int useW = 240;
    int finalW = useW + 2 * pd;
    int currentY = 0;
    Container cp = getContentPane();
    public PicSort_About(String title) {
        super(title);
        addHeaderPanel("About", new Color(0x1A237E), Color.WHITE, 30);
        addColorPanel("Made by Konstantin Walter", new Color(0x0D47A1), Color.WHITE);
        addColorPanel("Version 0.01.2.A", new Color(0x263238), Color.WHITE);
        addColorPanel("18th January 2016", new Color(0x263238), Color.WHITE);
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
        a(headerPanel, 0);
    }
    public void addColorPanel(String text, Color bg, Color fg) {
        JLabel l = new JLabel(text, SwingConstants.CENTER);
        l.setForeground(fg);
        l.setFont(new Font("Header", Font.PLAIN, 12));
        JPanel panel = new JPanel(new GridLayout());
        panel.setBounds(0, currentY, finalW, 30);
        panel.setBackground(bg);
        panel.add(l);
        a(panel, 0);
    }
    public void createWindow() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(finalW, currentY + 22);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation( (d.width - getWidth()) / 2, (d.height - getHeight()) / 2);
        setResizable(false);
        cp.setLayout(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                new PicSort_Welcome("PicSort ALPHA");
            }
        });
        setVisible(true);
    }
}
