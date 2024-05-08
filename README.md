# Child Names in Java Example 

The user interface allows the user to display boy and girl baby names from a long list of names in a text file. In the first row, the user selects the first letter using a combo box. In the second row, the user selects one of the two radio buttons to display either boy or girl baby names. In the third row, the user checks one or more of the three checkboxes for short, medium, or long names. A scrolling text area is provided to display the results.

The layout of the interface is as follows: a panel containing the radio buttons, a panel containing the checkboxes, and a panel containing the combo box (maintaining proportions). These three panels are stacked in a grid layout (3x1), and the text area is placed in a border layout.

All components trigger the same event: the results are re-displayed whenever there is a change. Therefore, the same event listener is added to all components. This structure allows the user to select the desired names and view the appropriate ones.

Short Length for a name: 5

Long Length for a name: 9 middle Length should be any value in between

Your program should read in names from babynames.txt and store them into arrayLists called boys and girls. (The file contains names in the order boy- girl, boy-girl and so on)

Necessary imports:
import java.awt.BorderLayout; 
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File; import javax.swing.JTextArea;
import java.io.FileNotFoundException; import java.util.ArrayList;
import java.util.Scanner; import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox; import javax.swing.JComboBox:
import javax.swing.JFrame; import javax.swingJLabel;
import javax.swing.JOptionPane; import javax.swingJPanel;
import javax.swing.JRadioButton; import javax.swing JScrollPane:
import javax.swing.JTextField;
