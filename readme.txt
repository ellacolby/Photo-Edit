*
* Please replace each <text> block with the answers. Do not add any other lines or modify anything else
* For the <multiline text> block you can write multiple lines between the two '---' separators
*
* Netids and names of the two project members, leave the second ones blank if you worked alone
netid1: bm0015
name1: Brooke McCarthy
netid2: ec9834
name2: Ella Colby
* Your project advisor
advisor: Maya Gupta
* Your project title
title: Ella and Brooke's Awesome Photoshop
* The link to the youtube video with your video presentation
youtube_link: https://youtu.be/w1fYW9ZwweI
* A list of comma separated tags that describe your project
* The list of possible tags is: game, data analysis/visualization, library, algorithms, assignment extension, application, misc
* An example would be 'tags: data analysis/visualization, application'
tags: images, filters, photoshop, editing, drawing,
* A summary of your project
abstract:
---
We made a basic version of photoshop. The application takes image files as an
input and can apply filters, warp them, and draw on them using various colors.
The filters will come in the form of altering the RGB colors. The warped images
will use mapping of RGB values to change the original image with a
mirroring/reflection effect. We present these filters and our drawing feature
on a GUI that allows users to input images based on text file names, clicking
buttons, and selecting items from JMenu/JMenuLists.
---
BIBLIOGRAPHY:
GUI.java
34-111 JPanel API (Used to understand the different methods for this data type)
       https://docs.oracle.com/javase/7/docs/api/javax/swing/JPanel.html
       JFrame API (Used to understand the different methods for this data type)
       https://docs.oracle.com/javase/7/docs/api/javax/swing/JFrame.html
       JButton API (Used to understand the different methods for this data type)
       https://docs.oracle.com/javase/7/docs/api/javax/swing/JButton.html
       JLabel API (Used to understand the different methods for this data type)
       https://docs.oracle.com/javase/7/docs/api/javax/swing/JLabel.html
       GUI setup (Used to understand the basics of how to implement a GUI)
       https://www.guru99.com/java-swing-gui.html
       JMenu API (Used to understand the different methods for this data type)
       https://docs.oracle.com/javase/7/docs/api/javax/swing/JMenu.html
       JTextField API (Used to understand the different methods for this data type)
       https://docs.oracle.com/javase/7/docs/api/javax/swing/JTextArea.html#:~:
       text=A%20JTextArea%20is%20a%20multi,it%20can%20reasonably%20do%20so
115-145 MouseAdapter API (Used to understand the different methods for this data type)
        https://docs.oracle.com/javase/7/docs/api/java/awt/event/MouseAdapter.html
        MouseListener API (Used to understand the different methods for this data type)
        https://docs.oracle.com/javase/7/docs/api/java/awt/event/MouseListener.html
        Paint structure (Used to model the basic structure of our draw feature. We then
        modified this code to turn on and off depending on whether the draw button
        was clicked and to change color depending on what was selected.)
        https://stackoverflow.com/questions/9711938/java-draw-line-as-the-mouse-is-moved
169-599 ActionListener API (Used to understand the different methods for this data type)
        https://docs.oracle.com/javase/7/docs/api/java/awt/event/ActionListener.html
        JFrame API (Used to understand the different methods for this data type)
        https://docs.oracle.com/javase/7/docs/api/javax/swing/JFrame.html
        JLabel API (Used to understand the different methods for this data type)
        https://docs.oracle.com/javase/7/docs/api/javax/swing/JLabel.html
        BufferedImage API (Used to understand the different methods for this data type)
        https://docs.oracle.com/javase/7/docs/api/java/awt/image/BufferedImage.html
604-606 JFrame API (Used to understand the different methods for this data type)
        https://docs.oracle.com/javase/7/docs/api/javax/swing/JFrame.html

Filter.java
14-20 Picture.java (we modelled our code that converts a filename to a buffered
      image off of the code for the picture data type)
      https://introcs.cs.princeton.edu/java/stdlib/Picture.java.html
28-37 Lecture 10 (We modeled our code for the grayscale filter off of the code shown
in lecture, but we modified it to use the buffered image data type, so we could add
it to our GUI)
46-241 Sepia RGB values
       https://dyclassroom.com/image-processing-project/how-to-convert-a-color-image-into-sepia-image
       BufferedImage API (Used to understand the different methods for this data type)
       https://docs.oracle.com/javase/7/docs/api/java/awt/image/BufferedImage.html
       Color API (Used to understand the different methods for this data type)
       https://docs.oracle.com/javase/7/docs/api/java/awt/Color.html

Warp.java
14-20 Picture.java (we modelled our code that converts a filename to a buffered
      image off of the code for the picture data type)
27-112 Precept 11 Activity 2
      BufferedImage API (Used to understand the different methods for this data type)
      https://docs.oracle.com/javase/7/docs/api/java/awt/image/BufferedImage.html
      Color API (Used to understand the different methods for this data type)
      https://docs.oracle.com/javase/7/docs/api/java/awt/Color.html

