package Controllers;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class ManufacturerChanged implements ChangeListener {


    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
        System.out.printf("New value: %s%n", newValue);
    }
}
