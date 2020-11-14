package waterworld.actions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
public class Update implements ActionListener {

    private JPanel content;

    public Update(JPanel content) {
        this.content = content;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        content.repaint();
    }

    public final JPanel getContent() {
        return content;
    }
}
