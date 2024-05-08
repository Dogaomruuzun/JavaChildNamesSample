import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class BabyNamesFrame extends JFrame
{
   private ArrayList<String> boys;
   private ArrayList<String> girls;

   private JPanel choicesPanel;
   private JComboBox firstLetter;
   private JRadioButton boy;
   private JRadioButton girl;
   private JCheckBox isShort;
   private JCheckBox isMedium;
   private JCheckBox isLong;
   private JTextArea result;
   private ActionListener listener;

   private static final int SHORT_LENGTH = 5;
   private static final int LONG_LENGTH = 9;
   private static final int FRAME_WIDTH = 200;
   private static final int FRAME_HEIGHT = 500;

   public class UpdateListener implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         ArrayList<String> names;
         if (boy.isSelected()) { names = boys; } else { names = girls; }
         result.setText("");
         for (String name : names)
         {
            if (matches(name))
            {
               result.append(name + "\n");
            }
         }         
      }

      private boolean matches(String name)
      {
         String first = (String) firstLetter.getSelectedItem();
         int length = name.length();
         return name.startsWith(first)
            && (length <= SHORT_LENGTH && isShort.isSelected()
               || SHORT_LENGTH < length && length < LONG_LENGTH 
                  && isMedium.isSelected()
               || name.length() >= LONG_LENGTH && isLong.isSelected());
      }
   }

   public BabyNamesFrame()
   {
      choicesPanel = new JPanel();
      choicesPanel.setLayout(new GridLayout(3, 1));
      add(choicesPanel, BorderLayout.NORTH);

      listener = new UpdateListener();
      createFirstLetter();
      createBoyGirl();
      createLengths();

      result = new JTextArea();
      add(new JScrollPane(result), BorderLayout.CENTER);

      setSize(FRAME_WIDTH, FRAME_HEIGHT);
      
      readNames();
   }

   private void createFirstLetter()
   {
      JPanel row = new JPanel();
      choicesPanel.add(row);
      firstLetter = new JComboBox();
      for (char c = 'A'; c <= 'Z'; c++)
      {
         firstLetter.addItem("" + c);
      }
      firstLetter.addActionListener(listener);
      row.add(firstLetter);
   }

   private void createBoyGirl()
   {
      JPanel row = new JPanel();
      choicesPanel.add(row);
      boy = new JRadioButton("Boy");
      boy.addActionListener(listener);
      girl = new JRadioButton("Girl");
      girl.addActionListener(listener);
      boy.setSelected(true);
      row.add(boy);
      row.add(girl);
      ButtonGroup group = new ButtonGroup();
      group.add(boy);
      group.add(girl);
   }

   private void createLengths()
   {
      JPanel row = new JPanel();
      choicesPanel.add(row);
      isShort = new JCheckBox("Short");
      isShort.addActionListener(listener);
      row.add(isShort);
      isMedium = new JCheckBox("Medium");
      isMedium.addActionListener(listener);
      row.add(isMedium);
      isLong = new JCheckBox("Long");
      isLong.addActionListener(listener);
      row.add(isLong);      
   }

   private void readNames()
   {
      try
      {
         boys = new ArrayList<String>();
         girls = new ArrayList<String>();
         Scanner in = new Scanner(new File("babynames.txt"));
         while (in.hasNext()) 
         { 
            boys.add(in.next()); 
            girls.add(in.next()); 
         }
         in.close();
      }
      catch (FileNotFoundException ex)
      {
         JOptionPane.showMessageDialog(null, "babynames.txt file not found");
      }     
   }
}
