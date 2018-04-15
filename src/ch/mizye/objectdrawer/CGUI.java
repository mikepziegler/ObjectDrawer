package ch.mizye.objectdrawer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLOutput;

public class CGUI extends JFrame {

    private CDrawPanel drawPanel;
    private CDatabase db;

    private JToolBar toolbar;
    private JMenuBar mb;
    private JMenu mfile, medit, mview, mlayout;

    private JPanel toolPanel;


    public CGUI() {

        db = new CDatabase();

        initComponents();

        setSize(1000, 600);
        setMinimumSize(new Dimension(700, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComponents() {

        mb = new JMenuBar();

        mfile = new JMenu("File");

        JMenuItem mfOpen = new JMenuItem("Open");
        mfOpen.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        mfOpen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                System.out.println("Open");
            }
        });

        JMenuItem mfImport = new JMenuItem("Import");
        mfImport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                System.out.println("Import");
            }
        });

        JMenuItem mfExport = new JMenuItem("Export");
        mfExport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                System.out.println("Export");
            }
        });

        JMenuItem mfQuit = new JMenuItem("Quit");
        mfQuit.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        mfQuit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(3);
            }
        });

        mfile.add(mfOpen);
        mfile.addSeparator();
        mfile.add(mfImport);
        mfile.add(mfExport);
        mfile.addSeparator();
        mfile.add(mfQuit);

        mb.add(mfile);

        medit = new JMenu("Edit");





        mb.add(medit);

        mlayout = new JMenu("Layout");



        mb.add(mlayout);

        mview = new JMenu("View");



        mb.add(mview);



        drawPanel = new CDrawPanel();
        drawPanel.setBackground(Color.CYAN);

        toolPanel = new JPanel();
        toolPanel.setSize(250, getHeight());
        toolPanel.setBackground(Color.BLUE);

        setJMenuBar(mb);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addComponent(drawPanel)
                .addComponent(toolPanel, 250, GroupLayout.DEFAULT_SIZE,
                        GroupLayout.PREFERRED_SIZE)
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(drawPanel)
                        .addComponent(toolPanel)
                )
        );
    }

    private void mouseclicked() {

    }
}
