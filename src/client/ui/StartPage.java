package client.ui; /**
 * Created by mma on 5/19/17.
 */

import client.Constants;
import client.GraphicHandler;
import client.customView.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class shows start page for signing in or up! For this class supposed a imaginary layout rather than
 * a layout manager for working easier with this.Magnitude of this imaginary layouts is records as final integer
 * Created by mma on 6/8/2016.
 */
public class StartPage extends JFrame {

    private int width = GraphicHandler.getInstance().getWidthScreen()*2 / 3;
    private int height = GraphicHandler.getInstance().getHeightScreen()*3 / 4;
    private MyLabel titleLbl;
    private MyTextField idField;
    private MyTextField passwordField;
    private JButton signInBtn;
    private JToolBar toolBar;

    /**
     * Magnitude of imaginary layouts
     */
    private final int heightOfTitleBar = height / 15;
    private final int widthOfTitleBar = width;
    private final int titleBarX = 0;
    private final int titleBarY = height / 75;
    private final int titleFontSize = 35;
    private final int mainPanelX = 0;
    private final int mainPanelY = heightOfTitleBar;
    private final int heightOfMainPanel = height * 9 / 10;
    private final int widthOfMainPanel = width;
    private final int toolBarX = 0;
    private final int toolBarY = heightOfTitleBar + heightOfMainPanel * 95/100 ;
    private final int heightOfToolBar = height - (heightOfMainPanel + heightOfTitleBar)*95/100;
    private final int widthOfToolBar = width;

    public StartPage() {
        super();

        initialize();

        setTitle();

        setMainPanel();

        setToolBar();

        AddComponentsToFrame();

        setVisible(true);
    }

    private void setMainPanel() {
        idField = new MyTextField("Command", Constants.buttonJPGPath);
        idField.setSize(width * 5/ 6, height / 10);
        idField.setLocation(widthOfMainPanel / 2 - idField.getWidth() / 2, mainPanelY + heightOfMainPanel / 14);

        passwordField = new MyTextField("", Constants.buttonJPGPath);
        passwordField.setEditable(false);
        passwordField.setSize(width * 5 / 6, height * 3 / 4);
        passwordField.setLocation(widthOfMainPanel / 2 - idField.getWidth() / 2, mainPanelY + heightOfMainPanel / 8);

        signInBtn = new MyButton("execute", Constants.buttonJPGPath);
        signInBtn.setSize(passwordField.getWidth() / 5, heightOfMainPanel / 12);
        signInBtn.setLocation(widthOfMainPanel / 2 - signInBtn.getWidth() / 2, mainPanelY + heightOfMainPanel * 20 / 21);
    }

    private void initialize() {
        GraphicHandler graphicHandler = GraphicHandler.getInstance();

        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        graphicHandler.placeInCenter(this);
        this.setResizable(false);
        this.setLayout(null);
        this.setUndecorated(true);

        try {
            UIManager
                    .setLookAndFeel(Constants.nimbusLookAndFeel);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void setTitle() {
        titleLbl = new MyLabel(Constants.appName, Constants.labelJPGPath, JLabel.CENTER);
        titleLbl.setLocation(titleBarX, titleBarY);
        titleLbl.setSize(widthOfTitleBar, heightOfTitleBar);
        titleLbl.setForeground(Color.WHITE);
        titleLbl.setFont(new Font(Constants.arilFont, Font.CENTER_BASELINE, titleFontSize));
    }

    private void setToolBar() {
        JButton exit = new MyButton(Constants.exitJPGPath);
        exit.setLocation(0, 0);
        exit.setSize(Constants.sizeOfExitButton, Constants.sizeOfExitButton);
        exit.setIcon(new ImageIcon(getClass().getResource(Constants.exitPNGPath)));
        exit.setBorder(BorderFactory.createEmptyBorder());
        //exit.setBackground(Color.decode("#01aaeb"));
        exit.setToolTipText("Exit");
        exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                dispose();
            }
        });

        toolBar = new JToolBar();
        toolBar.setLocation(toolBarX, toolBarY);
        toolBar.setSize(widthOfToolBar, heightOfToolBar);
        toolBar.setBorder(BorderFactory.createEmptyBorder());
        toolBar.setFloatable(false);
        toolBar.add(exit);
    }

    private void AddComponentsToFrame() {
        getContentPane().add(titleLbl);
        getContentPane().add(toolBar);
        getContentPane().add(idField);
        getContentPane().add(passwordField);
        getContentPane().add(signInBtn);
    }

    /**
     * This method draws a blue image background of this frame
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Image image = new ImageIcon(getClass().getResource(Constants.blueBackJPGPath)).getImage();
        g.drawImage(image, 0, 0, width, height, null);

        componentRepaint();
    }

    private void componentRepaint() {
        titleLbl.repaint();
        toolBar.getComponent(0).repaint();
        signInBtn.repaint();
        idField.repaint();
        passwordField.repaint();
    }
}
