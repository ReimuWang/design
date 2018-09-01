package design16;

import java.awt.Color;
import java.awt.TextField;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class ColleagueTextField extends TextField implements TextListener, Colleague {

    private static final long serialVersionUID = 1L;

    private Mediator mediator;

    public ColleagueTextField(Mediator mediator, String text, int columns) {
        super(text, columns);
        this.mediator = mediator;
    }

    @Override
    public void textValueChanged(TextEvent e) {
        this.mediator.colleagueChanged(this);
    }

    @Override
    public void setColleagueEnabled(boolean enabled) {
        this.setEnabled(enabled);
        this.setBackground(enabled ? Color.WHITE : Color.LIGHT_GRAY);
    }
}