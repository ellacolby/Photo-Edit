import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;

public class GUI {
    static boolean drawMode = false;
    static Color drawColor = Color.BLACK;

    public static void main(String args[]) {

        // Creating the Frame
        JFrame frame = new JFrame("Ella and Brooke's Awesome Photoshop");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // Creating the MenuBar
        JMenuBar mb = new JMenuBar();
        JMenu mColor = new JMenu("Color Filters");
        JMenu mWarp = new JMenu("Warp Filters");
        JMenu mDraw = new JMenu("Draw");

        JMenuItem mColorSepia = new JMenuItem("Sepia");
        JMenuItem mColorBAW = new JMenuItem("Black and White");
        JMenuItem mColorElla = new JMenuItem("Ella");
        JMenuItem mColorBrooke = new JMenuItem("Brooke");
        JMenuItem mColorHigh = new JMenuItem("High");
        JMenuItem mColorKevin = new JMenuItem("Kevin");
        JMenuItem mColorLow = new JMenuItem("Low");

        JMenuItem mWarpMirrorH = new JMenuItem("Mirror Horizontally");
        JMenuItem mWarpMirrorV = new JMenuItem("Mirror Vertically");
        JMenuItem mWarpFlipHalf = new JMenuItem("Flip Half");
        JMenuItem mWarpFlipSome = new JMenuItem("Flip Some");

        JMenuItem mGreen = new JMenuItem("Green");
        JMenuItem mRed = new JMenuItem("Red");
        JMenuItem mBlue = new JMenuItem("Blue");
        JMenuItem mWhite = new JMenuItem("White");
        JMenuItem mBlack = new JMenuItem("Black");
        JMenuItem mPink = new JMenuItem("Pink");

        // Creating the panel at bottom and adding components
        JPanel bottomPanel = new JPanel();

        JLabel label = new JLabel("Enter Text");
        JTextField tf = new JTextField(10); // accepts upto 10 characters
        tf.setBackground(Color.LIGHT_GRAY);
        bottomPanel.setBackground(Color.PINK);

        JButton load = new JButton("Load");
        JButton reset = new JButton("Reset");
        bottomPanel.add(label); // Components Added using Flow Layout
        bottomPanel.add(tf);
        bottomPanel.add(load);
        bottomPanel.add(reset);

        // adding MenuBar components
        mb.add(mColor);
        mb.add(mWarp);
        mb.add(mDraw);

        mColor.add(mColorSepia);
        mColor.add(mColorBAW);
        mColor.add(mColorElla);
        mColor.add(mColorKevin);
        mColor.add(mColorBrooke);
        mColor.add(mColorHigh);
        mColor.add(mColorLow);

        mWarp.add(mWarpMirrorH);
        mWarp.add(mWarpMirrorV);
        mWarp.add(mWarpFlipHalf);
        mWarp.add(mWarpFlipSome);

        mDraw.add(mGreen);
        mDraw.add(mRed);
        mDraw.add(mBlue);
        mDraw.add(mWhite);
        mDraw.add(mBlack);
        mDraw.add(mPink);

        // CREATE BUTTON FUNCTIONALITY FOR KEVIN IMAGE
        JFrame frame2 = new JFrame();
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(400, 400);

        JFrame frame3 = new JFrame();
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setSize(400, 400);

        JPanel imagePanel = new JPanel() {
            Point pointStart = null;
            Point pointEnd = null;

            {
                addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        pointStart = e.getPoint();
                    }

                    public void mouseReleased(MouseEvent e) {
                        pointStart = null;
                    }
                });
                addMouseMotionListener(new MouseMotionAdapter() {
                    public void mouseMoved(MouseEvent e) {
                        pointEnd = e.getPoint();
                    }

                    public void mouseDragged(MouseEvent e) {
                        if (drawMode) {
                            pointEnd = e.getPoint();
                            Graphics g = getGraphics();
                            g.setColor(drawColor);
                            g.fillOval(e.getX(), e.getY(), 10, 10);
                        }
                    }
                });
            }

            public void paint(Graphics g) {
                super.paint(g);
                if (drawMode && pointStart != null) {
                    g.setColor(drawColor);
                    g.drawLine(pointStart.x, pointStart.y, pointEnd.x, pointEnd.y);
                }
            }
        };
        imagePanel.setSize(400, 400);

        Container contentPane = frame.getContentPane();
        // Container layeredPane = frame2.getLayeredPane();
        contentPane.add(imagePanel);

        contentPane.setBackground(Color.LIGHT_GRAY);
        imagePanel.setBackground(Color.LIGHT_GRAY);

        load.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                imagePanel.removeAll();

                String filename = tf.getText();
                JLabel label1 = new JLabel();
                label1.setIcon(
                        new ImageIcon(filename)); // sets the image to be displayed as icon
                Dimension size = label1.getPreferredSize(); // Gets the size of the image
                label1.setBounds(100, 100, size.width, size.height); // sets location of the image
                imagePanel.add(label1);
                contentPane.add(imagePanel);
                frame.pack();
            }
        });

        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tf.setText("");
                imagePanel.removeAll();
                drawMode = false;
                frame.pack();
            }
        });


        mColorBAW.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tf.getText().isEmpty()) throw new IllegalArgumentException(
                        "No Image File Chosen");
                else {
                    imagePanel.removeAll();
                    String filename = tf.getText();

                    JLabel label1 = new JLabel();
                    Filters filters = new Filters(filename);
                    BufferedImage bufferedKevin = filters.grayscale();
                    label1.setIcon(
                            new ImageIcon(bufferedKevin)); // sets the image to be displayed as icon
                    Dimension size = label1.getPreferredSize(); // Gets the size of the image
                    label1.setBounds(100, 100, size.width,
                                     size.height); // sets location of the image
                    imagePanel.add(label1);
                    contentPane.add(imagePanel);
                    frame.pack();
                }
            }
        });

        mColorSepia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tf.getText().isEmpty()) throw new IllegalArgumentException(
                        "No Image File Chosen");
                else {
                    imagePanel.removeAll();
                    String filename = tf.getText();

                    JLabel label1 = new JLabel();
                    Filters filters = new Filters(filename);
                    BufferedImage bufferedKevin = filters.sepia();
                    label1.setIcon(
                            new ImageIcon(bufferedKevin)); // sets the image to be displayed as icon
                    Dimension size = label1.getPreferredSize(); // Gets the size of the image
                    label1.setBounds(100, 100, size.width,
                                     size.height); // sets location of the image
                    imagePanel.add(label1);
                    contentPane.add(imagePanel);
                    frame.pack();
                }
            }
        });

        mColorElla.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tf.getText().isEmpty()) throw new IllegalArgumentException(
                        "No Image File Chosen");
                else {
                    imagePanel.removeAll();
                    String filename = tf.getText();

                    JLabel label1 = new JLabel();
                    Filters filters = new Filters(filename);
                    BufferedImage bufferedKevin = filters.ella();
                    label1.setIcon(
                            new ImageIcon(bufferedKevin)); // sets the image to be displayed as icon
                    Dimension size = label1.getPreferredSize(); // Gets the size of the image
                    label1.setBounds(100, 100, size.width,
                                     size.height); // sets location of the image
                    imagePanel.add(label1);
                    contentPane.add(imagePanel);
                    frame.pack();
                }
            }
        });

        mColorKevin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tf.getText().isEmpty()) throw new IllegalArgumentException(
                        "No Image File Chosen");
                else {
                    imagePanel.removeAll();
                    String filename = tf.getText();

                    JLabel label1 = new JLabel();
                    Filters filters = new Filters(filename);
                    BufferedImage bufferedKevin = filters.kevin();
                    label1.setIcon(
                            new ImageIcon(bufferedKevin)); // sets the image to be displayed as icon
                    Dimension size = label1.getPreferredSize(); // Gets the size of the image
                    label1.setBounds(100, 100, size.width,
                                     size.height); // sets location of the image
                    imagePanel.add(label1);
                    contentPane.add(imagePanel);
                    frame.pack();
                }
            }
        });

        mColorBrooke.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tf.getText().isEmpty()) throw new IllegalArgumentException(
                        "No Image File Chosen");
                else {
                    imagePanel.removeAll();
                    String filename = tf.getText();

                    JLabel label1 = new JLabel();
                    Filters filters = new Filters(filename);
                    BufferedImage bufferedKevin = filters.brooke();
                    label1.setIcon(
                            new ImageIcon(bufferedKevin)); // sets the image to be displayed as icon
                    Dimension size = label1.getPreferredSize(); // Gets the size of the image
                    label1.setBounds(100, 100, size.width,
                                     size.height); // sets location of the image
                    imagePanel.add(label1);
                    contentPane.add(imagePanel);
                    frame.pack();
                }
            }
        });

        mColorHigh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tf.getText().isEmpty()) throw new IllegalArgumentException(
                        "No Image File Chosen");
                else {
                    imagePanel.removeAll();
                    String filename = tf.getText();

                    JLabel label1 = new JLabel();
                    Filters filters = new Filters(filename);
                    BufferedImage bufferedKevin = filters.high();
                    label1.setIcon(
                            new ImageIcon(bufferedKevin)); // sets the image to be displayed as icon
                    Dimension size = label1.getPreferredSize(); // Gets the size of the image
                    label1.setBounds(100, 100, size.width,
                                     size.height); // sets location of the image
                    imagePanel.add(label1);
                    contentPane.add(imagePanel);
                    frame.pack();
                }
            }
        });

        mColorLow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tf.getText().isEmpty()) throw new IllegalArgumentException(
                        "No Image File Chosen");
                else {
                    imagePanel.removeAll();
                    String filename = tf.getText();

                    JLabel label1 = new JLabel();
                    Filters filters = new Filters(filename);
                    BufferedImage bufferedKevin = filters.low();
                    label1.setIcon(
                            new ImageIcon(bufferedKevin)); // sets the image to be displayed as icon
                    Dimension size = label1.getPreferredSize(); // Gets the size of the image
                    label1.setBounds(100, 100, size.width,
                                     size.height); // sets location of the image
                    imagePanel.add(label1);
                    contentPane.add(imagePanel);
                    frame.pack();
                }
            }
        });

        mWarpMirrorH.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tf.getText().isEmpty()) throw new IllegalArgumentException(
                        "No Image File Chosen");
                else {
                    imagePanel.removeAll();
                    String filename = tf.getText();

                    JLabel label1 = new JLabel();
                    Warp warp = new Warp(filename);
                    BufferedImage bufferedKevin = warp.flipH();
                    label1.setIcon(
                            new ImageIcon(bufferedKevin)); // sets the image to be displayed as icon
                    Dimension size = label1.getPreferredSize(); // Gets the size of the image
                    label1.setBounds(100, 100, size.width,
                                     size.height); // sets location of the image
                    imagePanel.add(label1);
                    contentPane.add(imagePanel);
                    frame.pack();
                }
            }
        });

        mWarpMirrorV.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tf.getText().isEmpty()) throw new IllegalArgumentException(
                        "No Image File Chosen");
                else {
                    imagePanel.removeAll();
                    String filename = tf.getText();

                    JLabel label1 = new JLabel();
                    Warp warp = new Warp(filename);
                    BufferedImage bufferedKevin = warp.flipV();
                    label1.setIcon(
                            new ImageIcon(bufferedKevin)); // sets the image to be displayed as icon
                    Dimension size = label1.getPreferredSize(); // Gets the size of the image
                    label1.setBounds(100, 100, size.width,
                                     size.height); // sets location of the image
                    imagePanel.add(label1);
                    contentPane.add(imagePanel);
                    frame.pack();
                }
            }
        });

        mWarpFlipHalf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tf.getText().isEmpty()) throw new IllegalArgumentException(
                        "No Image File Chosen");
                else {
                    imagePanel.removeAll();
                    String filename = tf.getText();

                    JLabel label1 = new JLabel();
                    Warp warp = new Warp(filename);
                    BufferedImage bufferedKevin = warp.flipHalf();
                    label1.setIcon(
                            new ImageIcon(bufferedKevin)); // sets the image to be displayed as icon
                    Dimension size = label1.getPreferredSize(); // Gets the size of the image
                    label1.setBounds(100, 100, size.width,
                                     size.height); // sets location of the image
                    imagePanel.add(label1);
                    contentPane.add(imagePanel);
                    frame.pack();
                }
            }
        });

        mWarpFlipSome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tf.getText().isEmpty()) throw new IllegalArgumentException(
                        "No Image File Chosen");
                else {
                    imagePanel.removeAll();
                    String filename = tf.getText();

                    JLabel label1 = new JLabel();
                    Warp warp = new Warp(filename);
                    BufferedImage bufferedKevin = warp.flipSome();
                    label1.setIcon(
                            new ImageIcon(bufferedKevin)); // sets the image to be displayed as icon
                    Dimension size = label1.getPreferredSize(); // Gets the size of the image
                    label1.setBounds(100, 100, size.width,
                                     size.height); // sets location of the image
                    imagePanel.add(label1);
                    contentPane.add(imagePanel);
                    frame.pack();
                }
            }
        });

        mGreen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawColor = Color.green;
                drawMode = true;
                frame.pack();
            }
        });

        mRed.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawColor = Color.red;
                drawMode = true;
                frame.pack();
            }
        });

        mBlue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawColor = Color.blue;
                drawMode = true;
                frame.pack();
            }
        });

        mWhite.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawColor = Color.white;
                drawMode = true;
                frame.pack();
            }
        });

        mBlack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawColor = Color.black;
                drawMode = true;
                frame.pack();
            }
        });

        mPink.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawColor = Color.pink;
                drawMode = true;
                frame.pack();
            }
        });

        // Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, bottomPanel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.setVisible(true);
    }
}
