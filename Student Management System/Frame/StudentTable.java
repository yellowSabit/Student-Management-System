package Frame;

import Entity.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import javax.swing.*;

public class StudentTable extends JFrame implements ActionListener {

    private JTable table;
    private JScrollPane scroll;
    private DefaultTableModel model;
    private Container c;
    private JLabel titleLabel, nLabel, idLabel, dprtmntLabel, smstrLabel, cgpaLabel;
    private JTextField nTf, idTf, dprtmntTf, smstrTf, cgpaTf;
    private JButton addButton, updateButton, deleteButton, clearButton, searchButton;

    private String[] columns = {"Name", "ID", "Department", "Semester", "CGPA"};
    private String[] rows = new String[5];

    public StudentTable() {
        initComponents();
    }

    public void initComponents() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(780, 690);
        this.setLocationRelativeTo(null);
        this.setTitle("Student Management System");

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(new Color(26,26,46));
		

        Font font = new Font("Arial", Font.BOLD, 16);

       
        titleLabel = new JLabel("S T U D E N T  M A N A G E M E N T");
        titleLabel.setFont(new Font("Segoe UI",Font.BOLD,26));
		titleLabel.setForeground(new Color(240,240,245));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(0, 10, 800, 50);
        c.add(titleLabel);


        nLabel = new JLabel("Name");
        nLabel.setBounds(10, 80, 140, 30);
        nLabel.setFont(font);
        nLabel.setForeground(Color.WHITE);
        c.add(nLabel);
		
        nTf = new JTextField();
        nTf.setBounds(110, 80, 200, 30);
        nTf.setFont(font);
        c.add(nTf);
		
		
        addButton = new JButton("Add");
        addButton.setBounds(400, 80, 100, 30);
        addButton.setFont(font);
        addButton.setBackground(new Color(34,197,94));
        addButton.setForeground(Color.WHITE);
		addButton.setBorderPainted(false); 
        addButton.addActionListener(this);
        c.add(addButton);

        idLabel = new JLabel("ID");
        idLabel.setBounds(10, 130, 150, 30);
        idLabel.setFont(font);
        idLabel.setForeground(Color.WHITE);
        c.add(idLabel);

        idTf = new JTextField();
        idTf.setBounds(110, 130, 200, 30);
        idTf.setFont(font);
        c.add(idTf);
		
        updateButton = new JButton("Update");
        updateButton.setBounds(400, 130, 100, 30);
        updateButton.setFont(font);
        updateButton.setBackground(new Color(59,130,246));
        updateButton.setForeground(Color.WHITE);
		updateButton.setBorderPainted(false); 
        updateButton.addActionListener(this);
        c.add(updateButton);

       
        dprtmntLabel = new JLabel("Department");
        dprtmntLabel.setBounds(10, 180, 150, 30);
        dprtmntLabel.setFont(font);
        dprtmntLabel.setForeground(Color.WHITE);
        c.add(dprtmntLabel);

        dprtmntTf = new JTextField();
        dprtmntTf.setBounds(110, 180, 200, 30);
        dprtmntTf.setFont(font);
        c.add(dprtmntTf);
		
	
        deleteButton = new JButton("Delete");
        deleteButton.setBounds(400, 180, 100, 30);
        deleteButton.setFont(font);
        deleteButton.setBackground(new Color(239,68,68));
        deleteButton.setForeground(Color.WHITE);
		deleteButton.setBorderPainted(false); 
        deleteButton.addActionListener(this);
        c.add(deleteButton);

        smstrLabel = new JLabel("Semester");
        smstrLabel.setBounds(10, 230, 150, 30);
        smstrLabel.setFont(font);
        smstrLabel.setForeground(Color.WHITE);
        c.add(smstrLabel);

        smstrTf = new JTextField();
        smstrTf.setBounds(110, 230, 200, 30);
        smstrTf.setFont(font);
        c.add(smstrTf);
	
        clearButton = new JButton("Clear");
        clearButton.setBounds(400, 230, 100, 30);
        clearButton.setFont(font);
        clearButton.setBackground(new Color(55,65,81));
        clearButton.setForeground(Color.WHITE);
		clearButton.setBorderPainted(false); 
        clearButton.addActionListener(this);
        c.add(clearButton);

       
        cgpaLabel = new JLabel("CGPA");
        cgpaLabel.setBounds(10, 280, 150, 30);
        cgpaLabel.setFont(font);
        cgpaLabel.setForeground(Color.WHITE);
        c.add(cgpaLabel);

        cgpaTf = new JTextField();
        cgpaTf.setBounds(110, 280, 200, 30);
        cgpaTf.setFont(font);
        c.add(cgpaTf);
		
        searchButton = new JButton("Search");
        searchButton.setBounds(400, 280, 100, 30);
        searchButton.setFont(font);
		searchButton.setBackground(new Color(59,130,246));
        searchButton.setForeground(Color.WHITE);
		searchButton.setBorderPainted(false); 
        searchButton.addActionListener(this);
        c.add(searchButton);

       
        table  = new JTable();
        model  = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.setFont(font);
        table.setSelectionBackground(Color.YELLOW);
		table.setBackground(new Color(26,26,46));
		table.setForeground(Color.WHITE);
		table.setGridColor(new Color(52, 73, 94));
		table.getTableHeader().setBackground(new Color(15, 52, 96));
		table.getTableHeader().setForeground(Color.WHITE);
        table.setRowHeight(30);

        
        scroll = new JScrollPane(table);
		scroll.setBorder(null);
		scroll.getViewport().setBackground(new Color(26,26,46));
        scroll.setBounds(10, 360, 740, 265);
        c.add(scroll);

        table.addMouseListener(new MouseAdapter() {
			
            public void mouseClicked(MouseEvent me) {
				
                int row = table.getSelectedRow();
				
				
                nTf.setText(model.getValueAt(row, 0).toString());
				
                idTf.setText(model.getValueAt(row, 1).toString());
				
                dprtmntTf.setText(model.getValueAt(row, 2).toString());
				
                smstrTf.setText(model.getValueAt(row, 3).toString());
				
                cgpaTf.setText(model.getValueAt(row, 4).toString());
            }
        });
    }


    public void actionPerformed(ActionEvent e) {

       
        if (e.getSource() == addButton) {
			

            Student s = new Student(
                nTf.getText(),
                idTf.getText(),
                dprtmntTf.getText(),
                smstrTf.getText(),
                cgpaTf.getText()
            );

            rows[0] = s.getName();
            rows[1] = s.getId();
            rows[2] = s.getDepartment();
            rows[3] = s.getSemester();
            rows[4] = s.getCgpa();

            model.addRow(rows);
            s.insertInfo(); 
        }

      
        else if (e.getSource() == clearButton) {
            
			nTf.setText("");
            idTf.setText("");
            dprtmntTf.setText("");
            smstrTf.setText("");
            cgpaTf.setText("");
        }


        else if (e.getSource() == deleteButton) {
            int row = table.getSelectedRow();
           
		   if (row >= 0) {
                model.removeRow(row);
            } 
			
			else {
                JOptionPane.showMessageDialog(null, "No row has been selected!");
            }
        }

     
        else if (e.getSource() == updateButton) {
            
			int row = table.getSelectedRow();
            
			if (row >= 0) {
				
                model.setValueAt(nTf.getText(),      row, 0);
                model.setValueAt(idTf.getText(),     row, 1);
                model.setValueAt(dprtmntTf.getText(),row, 2);
                model.setValueAt(smstrTf.getText(),  row, 3);
                model.setValueAt(cgpaTf.getText(),   row, 4);
            } 
			
			else {
                JOptionPane.showMessageDialog(null, "No row has been selected!");
            }
        }

     
        else if (e.getSource() == searchButton) {
            
			String searchText = idTf.getText().trim();
            String searchName = nTf.getText().trim();
			
            if (searchText.isEmpty() && searchName.isEmpty()) {
                
				JOptionPane.showMessageDialog(null, "Please enter a Name or ID to search!");
                
				return;
            }

           
		   for (int i = 0; i < model.getRowCount(); i++) {
               
			   String name = model.getValueAt(i, 0).toString();
                String id   = model.getValueAt(i, 1).toString();

                if (name.equalsIgnoreCase(searchName) || id.equals(searchText)) {
                   
				   table.setRowSelectionInterval(i, i);
                   
				   nTf.setText(model.getValueAt(i, 0).toString());
                   idTf.setText(model.getValueAt(i, 1).toString());
                   dprtmntTf.setText(model.getValueAt(i, 2).toString());
                   smstrTf.setText(model.getValueAt(i, 3).toString());
                   cgpaTf.setText(model.getValueAt(i, 4).toString());
                   
				   JOptionPane.showMessageDialog(null, "Student found!");
                    
					return;
                }
            }
            JOptionPane.showMessageDialog(null, "Student not found!");
        }
    }
}