package drawing;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RectanglePanel extends JPanel {
    JSlider WidthSlide;
    JSlider HeightSlide;

    JPanel SpacePanel;

    Rectangle rectangle;

    JLabel Heightlabel;
    JLabel Widthlabel;


    JLabel ColorLabel;
    JLabel BorderColorLabel;
    ColorPanel colorPanel;
    ColorPanel bordercolorPanel;





    PaintPanel paintPanel;

    RectanglePanel(PaintPanel paintPanel){
        super();

        this.paintPanel = paintPanel;
        this.setPreferredSize(new Dimension(200 , 340));
        setLayout(new BoxLayout(this , BoxLayout.Y_AXIS));


        WidthSlide = new JSlider(10 , 500 , 20);
        HeightSlide = new JSlider(10 , 500 , 20);
        WidthSlide.setPreferredSize(new Dimension(200 , 50));
        HeightSlide.setPreferredSize(new Dimension(200 , 50));


        SpacePanel = new JPanel();
        SpacePanel.setPreferredSize(new Dimension(200 , 500));
        Widthlabel = new JLabel("Width :");
        Heightlabel = new JLabel("Height :");
        ColorLabel = new JLabel("Color :");
        BorderColorLabel = new JLabel("Border Color :");

        colorPanel = new ColorPanel(null , new Dimension(20 , 40));
        bordercolorPanel = new ColorPanel(null , new Dimension(20 , 40));

        addListeners();

        this.add(Widthlabel);
        this.add(WidthSlide);
        this.add(Heightlabel);
        this.add(HeightSlide);
        this.add(ColorLabel);
        this.add(colorPanel);
        this.add(BorderColorLabel);
        this.add(bordercolorPanel);
        this.add(SpacePanel);

    }

    public void addListeners(){
        WidthSlide.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                rectangle.width = WidthSlide.getValue();
                paintPanel.repaint ();
            }
        });
        HeightSlide.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                rectangle.height = HeightSlide.getValue();
                paintPanel.repaint ();
            }
        });

        colorPanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Color color = JColorChooser.showDialog(paintPanel , "Select a color : ", rectangle.solidColor);
                rectangle.setSolidColor(color);
                colorPanel.setColor(color);
                colorPanel.repaint();
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
                Color color = JColorChooser.showDialog(paintPanel , "Select a color : ", rectangle.borderColor);
                rectangle.setBorderColor(color);
                bordercolorPanel.setColor(color);
                bordercolorPanel.repaint();
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
        rectangle = (Rectangle) shape;
        WidthSlide.setValue((int) rectangle.width);
        HeightSlide.setValue((int) rectangle.height);
        colorPanel.setColor(rectangle.solidColor);
        bordercolorPanel.setColor(rectangle.borderColor);
    }
}
