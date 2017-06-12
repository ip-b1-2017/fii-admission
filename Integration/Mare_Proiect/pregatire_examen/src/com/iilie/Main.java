package com.iilie;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;


public class Main {
    @Override
    public int hashCode() {
        //return super.hashCode();
        return 12312;
    }
    static Main instance;
    Main() {
        instance = this;
    }

    public static void main(String args[]) {
        String d = "a" + "b";
        String[] ceva = new String[] {"ana", "are", "mere"};
        System.out.println(ceva.length);
        JFrame frame = new JFrame("Sizing Samples");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DefaultListModel model = new DefaultListModel();
        model.ensureCapacity(100);
        for (int i = 0; i < 100; i++) {
            model.addElement(Integer.toString(i));
        }
        JList jlist2 = new JList(model);
        ListCellRenderer renderer = new FocusedTitleListCellRenderer();
        jlist2.setCellRenderer(renderer);

        JScrollPane scrollPane2 = new JScrollPane(jlist2);
        frame.add(scrollPane2, BorderLayout.CENTER);

        frame.setSize(300, 350);
        frame.setVisible(true);

        jlist2.ensureIndexIsVisible(50);
    }
}

class FocusedTitleListCellRenderer implements ListCellRenderer {
    protected static Border noFocusBorder = new EmptyBorder(15, 1, 1, 1);

    protected static TitledBorder focusBorder = new TitledBorder(LineBorder.createGrayLineBorder(),
            "title");

    protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();

    public Component getListCellRendererComponent(JList list, Object value, int index,
                                                  boolean isSelected, boolean cellHasFocus) {
        JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index,
                isSelected, cellHasFocus);
        if(index % 2 == 0)
            renderer.setBackground(Color.BLACK);
        renderer.setBorder(cellHasFocus ? focusBorder : noFocusBorder);
        return renderer;
    }
}