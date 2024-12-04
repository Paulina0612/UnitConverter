package unitconverter;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel extends JPanel {
    //private JLabel chooseUnitTypeLabel = new JLabel("Choose unit type");

    public Panel(){
        System.out.println(Unit.Convert(0, Unit.KELVIN, Unit.CELSIUS));
    }
}
