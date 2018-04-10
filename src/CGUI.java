import javax.swing.*;
import java.awt.*;
import java.util.*;

public class CGUI extends JFrame {

    private CDrawPanel drawPanel;

    public CGUI() {

        setSize(500, 200);

        initComponents();

        setVisible(true);
    }

    private void initComponents() {
        drawPanel = new CDrawPanel();




        add(drawPanel);
    }
}
