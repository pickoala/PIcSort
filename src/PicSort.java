import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by konstantin on 18/01/16.
 */
public class PicSort extends JFrame {

    int pd = 8;
    int currentX = pd;
    int currentY = pd;
    int counter = 0;

    String prefs[] = new PreferencesReader().read();
    String loc = prefs[0];
    String active = "0";

    Container cp = getContentPane();
    ArrayList<JPanel> folders = new ArrayList<>();
    JPanel picontainer = new JPanel();

    public PicSort(String title) {

        super(title);

        search(loc);

        createWindow();
    }

    public void a(Component c, int pd) {
        cp.add(c);
        plus(c.getHeight() + pd);
    }

    public void search(String loc) {
        File[] files = new File(loc).listFiles();
        getFiles(files);
    }

    public void getFiles(File[] files) {

        for (File file : files) {

            if (file.isDirectory()) {

                addFolder(file.getName());
                //getFiles(file.listFiles());
            } else {

                //area.append(spacer + file.getName()+"\n");
            }
        }
    }

    void addFolder(String name) {

        JPanel folder = new JPanel();
        folder.setLayout(null);
        folder.setBounds(0, currentY, 200, 24);
        folder.setBackground(new Color(0x5caf50));
        folder.setName(""+counter);
        folders.add(counter, folder);
        counter++;

        JLabel folderName = new JLabel();
        folderName.setBounds(5, 1, 190, 22);
        folderName.setText(name);
        folder.add(folderName);

        folder.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                //Make the old folder normal painted
                folders.get(Integer.parseInt(active)).setBackground(new Color(0x5caf50));
                //active folder selected
                folder.setBackground(new Color(0x222222));
                //active folder saved
                active = folder.getName();
            }
        });
        cp.add(folder);
        currentY += folder.getHeight() + 4;
        currentX = 190;
        System.out.println("Folder: " + name);
    }

    public void plus(int add) { currentY += add;}

    public void createWindow() {

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(currentX + 500, currentY + 22);
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
