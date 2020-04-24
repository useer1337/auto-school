package Formatters;

import javafx.scene.control.TextFormatter;

import java.util.function.UnaryOperator;

public class FirstFormatter  extends TextFormatter<String> {
    public FirstFormatter(){
        super(applyFilter());
    }

    private static UnaryOperator<Change> applyFilter() {
        return change ->{
            String text = change.getText();
            if (text.matches("^[0-9]*$")){
                return change;
            }
            return null;
        };
    }
}
