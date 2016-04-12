import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class PicSort_About extends JFrame {
    int pd = 16;
    int finalW = 240;
    int currentY = 0;

    /** Colors */
    Color hd = new Color(0xBF360C);
    Color bg = new Color(0x263238);
    Color fg = new Color(0x455A64);
    Color cClick = new Color(0x69F0AE);

    Container cp = getContentPane();

    public PicSort_About(String title) {

        super(title);
        addHeaderPanel("About", hd, Color.WHITE, 30);
        addPadding(pd);
        addColorPanel("Made by Konstantin Walter", new Color(0x455A64), Color.WHITE);
        addClickPanel("Open GitHub Page", cClick, Color.BLACK, 30, 0);
        addPadding(pd);
        addColorPanel("Version 0.01.2.A", fg, Color.WHITE);
        addColorPanel("18th January 2016", fg, Color.WHITE);
        addClickPanel("Open Project's GitHub Page", cClick, Color.BLACK, 30, 1);
        addPadding(pd);
        createWindow();
    }
    public void addHeaderPanel(String text, Color back, Color fg, int fontSize) {
        JLabel l = new JLabel(text, SwingConstants.CENTER);
        l.setForeground(fg);
        l.setFont(new Font("Header", Font.PLAIN, fontSize));
        JPanel headerPanel = new JPanel(new GridLayout());
        headerPanel.setBounds(0, currentY, finalW, 80);
        headerPanel.setBackground(back);
        headerPanel.add(l);
        a(headerPanel, 0);
    }

    public void addColorPanel(String text, Color back, Color fore) {
        JLabel l = new JLabel(text, SwingConstants.CENTER);
        l.setForeground(fore);
        l.setFont(new Font("Header", Font.PLAIN, 12));
        JPanel panel = new JPanel(new GridLayout());
        panel.setBounds(0, currentY, finalW, 30);
        panel.setBackground(back);
        panel.add(l);
        a(panel, 0);
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
                        openWebsite("https://github.com/pickoala");
                        break;
                    case 1:
                        openWebsite("https://github.com/pickoala/PicSort");
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

    public void openWebsite(String url) {
        switch (System.getProperty("os.name").toLowerCase()) {
            case "mac os x":
                Runtime rt = Runtime.getRuntime();
                try {
                    rt.exec( "open " + url);
                } catch(IOException e) {
                    System.out.println("Runtime: " + e);
                }
                break;
            default:
                break;

        }
        System.out.println(System.getProperty("os.name").toLowerCase());
    }

    public void a(Component c, int padding) {
        cp.add(c);
        plus(c.getHeight() + padding);
    }

    public void plus(int add) { currentY += add;}

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
