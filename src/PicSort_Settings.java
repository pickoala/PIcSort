import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

/**
 * Created by konstantin on 14/03/16.
 */
public class PicSort_Settings extends JFrame {

    JLabel lInput = new JLabel();
    JTextField fInput = new JTextField();

    JLabel lSorted = new JLabel();
    JTextField fSorted = new JTextField();

    JLabel lRandom = new JLabel();
    JTextField fRandom = new JTextField();

    JButton bAppend = new JButton();

    Container cp = getContentPane();

    int pd = 16;
    int width = 600;
    int current = pd;

    public PicSort_Settings() {

        super("Settings");

        lInput.setBounds(pd, current, width - 2 * pd, 24);
        lInput.setText("Source:");
        a(lInput);

        fInput.setBounds(pd, current, width - 2 * pd, 24);
        a(fInput);

        lSorted.setBounds(pd, current, width - 2 * pd, 24);
        lSorted.setText("Source:");
        a(lSorted);

        fSorted.setBounds(pd, current, width - 2 * pd, 24);
        a(fSorted);

        lRandom.setBounds(pd, current, width - 2 * pd, 24);
        lRandom.setText("Source:");
        a(lRandom);

        fRandom.setBounds(pd, current, width - 2 * pd, 24);
        a(fRandom);
        current += pd;

        int bw = 150;
        bAppend.setBounds(width - bw - pd, current, bw, 24);
        bAppend.setText("Append");
        bAppend.addActionListener(a -> save());
        a(bAppend);
        current += pd;

        getFolders(new File("folders.txt"));

        createWindow();
    }

    void a(Component c) {
        cp.add(c);
        current += c.getHeight();
    }

    void save() {
        String br = System.getProperty("line.separator");
        String saver =
                fInput.getText() + br +
                fSorted.getText() + br +
                fRandom.getText() + br;

        try {

            FileOutputStream fos = new FileOutputStream("folders.txt");
            fos.write(saver.getBytes());
        } catch (IOException e) {

            System.out.println(e);
        }
    }

    void getFolders(File file) {

        String[] lines = new String[3];
        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {

                lines[i] = line;
                i++;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        fInput.setText(lines[0]);
        fSorted.setText(lines[1]);
        fRandom.setText(lines[2]);
    }

    void createWindow() {

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(width, current + 22);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation( (d.width - getWidth()) / 2, (d.height - getHeight()) / 2);
        setResizable(false);
        cp.setLayout(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                save();
                dispose();
                new PicSort_Welcome("PicSort");
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {new PicSort_Settings();}

}
