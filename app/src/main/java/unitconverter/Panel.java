package unitconverter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panel extends JPanel implements ItemListener, ActionListener {
    private final int XYAllignment = 30, ComponentHeight = 30, DistanceBetweenComponents = 10;
    private JComboBox<String> unitType, inUnit = new JComboBox<>(), outUnit = new JComboBox<>();
    private JTextField inValue, outValue;
    private JButton button;
    private JLabel unitTypeLabel, inValueLabel, outValueLabel;

    public Panel(){
        this.setLayout(null);
        GenerateUnitTypeComboBox();
        GenerateUnitComboBoxes();
        GenerateTextFields();
        GenerateLabels();

        button = new JButton("Convert");
        button.addActionListener(this);

        AddComponents();
    }

    private void GenerateUnitTypeComboBox(){
        int amountOfUnitTypes = UnitType.values().length;
        String types [] = new String[amountOfUnitTypes];

        for (int i=0; i<amountOfUnitTypes; i++) 
            types[i] = UnitType.values()[i].GetName();

        unitType = new JComboBox<>(types);
        unitType.addItemListener(this);
    }

    private void GenerateUnitComboBoxes(){
        UnitType currentUnitType = UnitType.GetUnitType(unitType.getSelectedItem().toString());
        int amountOfUnits = Unit.GetAmountOfUnits(currentUnitType);
        String units [] = new String[amountOfUnits];
        int counter = 0;

        for(int i=0; i<Unit.values().length; i++){
            if(Unit.values()[i].GetUnitType().equals(currentUnitType)){
                units[counter] = Unit.values()[i].GetShortage();
                counter++;
            }
        }

        inUnit.removeAllItems();
        outUnit.removeAllItems();
        for(int i=0; i<amountOfUnits; i++){
            inUnit.addItem(units[i]);
            outUnit.addItem(units[i]);
        }
    }

    private void GenerateTextFields(){
        inValue = new JTextField();
        outValue = new JTextField();
    }

    private void GenerateLabels(){
        unitTypeLabel = new JLabel("Choose unit type");
        inValueLabel = new JLabel("Input");
        outValueLabel = new JLabel("Output");
    }

    private void AddComponents(){
        // Adding Combo Boxes
        unitType.setBounds(XYAllignment+120, XYAllignment, 
            150, ComponentHeight);
        inUnit.setBounds(XYAllignment+280, XYAllignment+ComponentHeight+DistanceBetweenComponents, 
            100, ComponentHeight);
        outUnit.setBounds(XYAllignment+280, XYAllignment+ComponentHeight*2+DistanceBetweenComponents*2, 
            100, ComponentHeight);
        this.add(unitType);
        this.add(inUnit);
        this.add(outUnit);
        
        // Adding Text Fields
        inValue.setBounds(XYAllignment+120, XYAllignment+ComponentHeight+DistanceBetweenComponents, 
            150, ComponentHeight);
        outValue.setBounds(XYAllignment+120, XYAllignment+ComponentHeight*2+DistanceBetweenComponents*2, 
            150, ComponentHeight);
        this.add(inValue);
        this.add(outValue);
        
        // Adding Labels
        unitTypeLabel.setBounds(XYAllignment, XYAllignment, 
            200, ComponentHeight);
        inValueLabel.setBounds(XYAllignment+70, XYAllignment+ComponentHeight+DistanceBetweenComponents, 
            200, ComponentHeight);
        outValueLabel.setBounds(XYAllignment+60, XYAllignment+ComponentHeight*2+DistanceBetweenComponents*2, 
            200, ComponentHeight);
        this.add(unitTypeLabel);
        this.add(inValueLabel);
        this.add(outValueLabel);

        // Adding Button
        button.setBounds(XYAllignment, XYAllignment+ComponentHeight*3+DistanceBetweenComponents*3, 
            380, ComponentHeight);
        this.add(button);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        GenerateUnitComboBoxes();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
    }
}
