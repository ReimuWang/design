package design16;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColleagueButton extends Button implements ActionListener, Colleague {

    private static final long serialVersionUID = 1L;

    private Mediator mediator;

    public ColleagueButton(Mediator mediator, String caption) {
        super(caption);
        this.mediator = mediator;
    }

    @Override
    public void setColleagueEnabled(boolean enabled) {
        this.setEnabled(enabled);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.mediator.colleagueChanged(this);
    }
}