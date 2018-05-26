package drawing;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CirclePanel extends JPanel{
    JSlider CircleRadiusSlider;

    JPanel SpacePanel;
    JLabel RadiusLabel;
    JLabel ColorLabel;
    JLabel BorderColorLabel;

    Circle circle;

    ColorPanel colorPanel;
    ColorPanel bordercolorPanel;

    PaintPanel paintPanel;

    CirclePanel(PaintPanel paintPanel){
         super();

        this.paintPanel = paintPanel;
        this.setPreferredSize(new Dimension(200 , 340));
        setLayout(new BoxLayout(this , BoxLayout.Y_AXIS));
        Circle circle = (Circle) paintPanel.selectedShape;


        CircleRadiusSlider = new JSlider(10 , 500 , 20);
        CircleRadiusSlider.setPreferredSize(new Dimension(200 , 50));

        SpacePanel = new JPanel();
        SpacePanel.setPreferredSize(new Dimension(200 , 500));

        RadiusLabel = new JLabel("Radius :");

        ColorLabel = new JLabel("Color :");
        BorderColorLabel = new JLabel("Border Color :");

        colorPanel = new ColorPanel(null , new Dimension(20 , 40));
        bordercolorPanel = new ColorPanel(null , new Dimension(20 , 40));





        addListeners();

        this.add(RadiusLabel);
        this.add(CircleRadiusSlider);
        this.add(ColorLabel);
        this.add(colorPanel);
        this.add(BorderColorLabel);
        this.add(bordercolorPanel);
        this.add(SpacePanel);


        }

    public void addListeners(){
        CircleRadiusSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                circle.radius = CircleRadiusSlider.getValue();
                paintPanel.repaint ();
            }
        });


        colorPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Color color = JColorChooser.showDialog(paintPanel , "Select a color : ", circle.solidColor);
                circle.setSolidColor(color);
                colorPanel.setColor(color);
                paintPanel.repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        bordercolorPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Color color = JColorChooser.showDialog(paintPanel , "Select a color : ", circle.borderColor);
                circle.setBorderColor(color);
                bordercolorPanel.setColor(color);
                paintPanel.repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public void loadShape(Shape shape) {
        circle = (Circle) shape;
        CircleRadiusSlider.setValue((int) circle.radius);
        colorPanel.setColor(circle.solidColor);
        bordercolorPanel.setColor(circle.borderColor);

    }


}
