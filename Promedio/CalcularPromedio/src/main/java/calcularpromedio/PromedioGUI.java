package calcularpromedio;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PromedioGUI extends JFrame implements ActionListener {
    
    private JPanel mainPanel;
    private JLabel titleLabel, subjectLabel, studentLabel, note1Label, note2Label, note3Label;
    private JTextField studentField, subjectField, note1Field, note2Field, note3Field;
    private JButton calculateBtn, exitBtn, clearBtn;
    private JTextArea resultArea;
    private int width, height;
    
    public PromedioGUI() {
        width = 600;
        height = 400;
        initComponents();
        setTitle("Promedio de Estudiante");
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }
    
    private void initComponents() {
        mainPanel = new JPanel();
        titleLabel = new JLabel("Cálculo de Promedio", SwingConstants.CENTER);
        studentLabel = new JLabel("Nombre del Estudiante:");
        subjectLabel = new JLabel("Materia:");
        note1Label = new JLabel("Nota 1:");
        note2Label = new JLabel("Nota 2:");
        note3Label = new JLabel("Nota 3:");
        studentField = new JTextField();
        subjectField = new JTextField();
        note1Field = new JTextField();
        note2Field = new JTextField();
        note3Field = new JTextField();
        calculateBtn = new JButton("Calcular");
        clearBtn = new JButton("Limpiar");
        exitBtn = new JButton("Salir");
        resultArea = new JTextArea();

        
        titleLabel.setBounds(0, 20, width, 20);
        studentLabel.setBounds(60, 60, 150, 25);
        subjectLabel.setBounds(60, 100, 150, 25);
        note1Label.setBounds(60, 140, 100, 25);
        note2Label.setBounds(240, 140, 100, 25);
        note3Label.setBounds(420, 140, 100, 25);
        studentField.setBounds(200, 60, 300, 25);
        subjectField.setBounds(200, 100, 300, 25);
        note1Field.setBounds(60, 170, 100, 25);
        note2Field.setBounds(240, 170, 100, 25);
        note3Field.setBounds(420, 170, 100, 25);
        calculateBtn.setBounds(60, 220, 100, 30);
        clearBtn.setBounds(240, 220, 100, 30);
        exitBtn.setBounds(420, 220, 100, 30);
        resultArea.setBounds(60, 270, 460, 80);
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);

        
        calculateBtn.addActionListener(this);
        clearBtn.addActionListener(this);
        exitBtn.addActionListener(this);

        
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(173, 216, 230));
        mainPanel.add(titleLabel);
        mainPanel.add(studentLabel);
        mainPanel.add(subjectLabel);
        mainPanel.add(note1Label);
        mainPanel.add(note2Label);
        mainPanel.add(note3Label);
        mainPanel.add(studentField);
        mainPanel.add(subjectField);
        mainPanel.add(note1Field);
        mainPanel.add(note2Field);
        mainPanel.add(note3Field);
        mainPanel.add(calculateBtn);
        mainPanel.add(clearBtn);
        mainPanel.add(exitBtn);
        mainPanel.add(resultArea);
        
        add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Salir":
                System.exit(0);
                break;
            case "Calcular":
                calculateAverage();
                break;
            case "Limpiar":
                clearFields();
                break;
        }
    }
    
    private void clearFields() {
        resultArea.setText("");
        note1Field.setText("");
        note2Field.setText("");
        note3Field.setText("");
        studentField.setText("");
        subjectField.setText("");
    }
    
    private void calculateAverage() {
        try {
            double average = (Double.parseDouble(note1Field.getText()) + 
                              Double.parseDouble(note2Field.getText()) + 
                              Double.parseDouble(note3Field.getText())) / 3;
            String result = String.format("Estudiante: %s\nMateria: %s\nPromedio: %.2f",
                                          studentField.getText(),
                                          subjectField.getText(),
                                          average);
            resultArea.setText(result);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese valores numéricos válidos en las notas.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

