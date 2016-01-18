import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by konstantin on 18/01/16.
 */
public class PicSort extends JFrame {
    int pd = 8;
    int currentX = pd;
    int currentY = pd;
    Container cp = getContentPane();
    public PicSort(String title) {
        super(title);
        createWindow();
    }
    public void a(Component c, int pd) {
        cp.add(c);
        plus(c.getHeight() + pd);
    }
    public void plus(int add) { currentY += add;}
    public void createWindow() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(currentX, currentY + 22);
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
