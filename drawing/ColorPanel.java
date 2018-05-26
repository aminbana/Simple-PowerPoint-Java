package drawing;

import javax.swing.*;
import java.awt.*;

public class ColorPanel extends JPanel {
    Color color = null;
    ColorPanel(Color color , Dimension d){
        super();
        setColor(color);
        this.setPreferredSize(d);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (color != null)
            g.setColor(this.color);
        else
            g.setColor(Color.gray);
        g.fillRect(0 , 0 , 500 , 500);
    }
}
