package ch.mizye.objectdrawer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class CGUI extends JFrame {

    private CDrawPanel drawPanel;
    private CDatabase db;


    private JToolBar toolbar;
    private JMenuBar mb;
    private JMenu mfile, medit, mview, mlayout;
    private JMenuItem mfExport, mfImport;



    public CGUI() {

        db = new CDatabase();

        initComponents();

        setSize(500, 200);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComponents() {

        mb = new JMenuBar();

        mfile = new JMenu("File");
        mfile.setMnemonic(KeyEvent.VK_F);

        mfExport = new JMenuItem("Export", KeyEvent.VK_F);
        mfExport.setMnemonic(KeyEvent.VK_F);
        mfExport.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_F, ActionEvent.ALT_MASK
        ));

        mfile.add(mfExport);

        mb.add(mfile);


        medit = new JMenu("Edit");

        mview = new JMenu("View");

        mlayout = new JMenu("Layout");


        drawPanel = new CDrawPanel();



        setJMenuBar(mb);
        add(drawPanel);
    }
}
