package unitconverter;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel extends JPanel {
    private JLabel chooseUnitTypeLabel = new JLabel("Choose unit type");

    public Panel(){
        chooseUnitTypeLabel.setBounds(10, 10, 10, 10);
        //chooseUnitTypeLabel.setAlignmentY(10);
        this.add(chooseUnitTypeLabel);
    }
}
