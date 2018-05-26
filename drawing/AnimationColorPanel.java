package drawing;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AnimationColorPanel extends JPanel {
    JSlider SpeedSlider;
    JCheckBox EnableCheck;
    JPanel SpacePanel;
    JLabel SpeedLabel;

    Shape shape;

    PaintPanel paintPanel;
    boolean flag = false;

    AnimationColorPanel(PaintPanel paintPanel){
        super();

        this.paintPanel = paintPanel;
        this.setPreferredSize(new Dimension(200 , 340));
        setLayout(new BoxLayout(this , BoxLayout.Y_AXIS));

        SpeedSlider = new JSlider(1 , 10 , 5);
        SpeedSlider.setPreferredSize(new Dimension(200 , 50));

        SpacePanel = new JPanel();
        SpacePanel.setPreferredSize(new Dimension(200 , 500));

        SpeedLabel = new JLabel("Speed :");

        EnableCheck = new JCheckBox("Enable Animation");
        EnableCheck.setPreferredSize(new Dimension(100 , 20));


        addListeners();

        this.add(EnableCheck);
        this.add(SpeedLabel);
        this.add(SpeedSlider);
        this.add(SpacePanel);

    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        SpeedSlider.setEnabled(enabled);
        EnableCheck.setEnabled(enabled);
    }

    public void load (){
        flag = true;
        for (Animation anim:paintPanel.selectedShape.animations){
            if (anim instanceof AnimationColor){
                EnableCheck.setSelected(true);
                SpeedSlider.setEnabled(true);
                SpeedSlider.setValue((1000 - anim.getStepDelay()) / 100);
                flag = false;
                return;

            }
        }

        EnableCheck.setSelected(false);
        SpeedSlider.setEnabled(false);
        flag = false;
    }


    public void addListeners(){
        EnableCheck.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (!flag) {
                    if (EnableCheck.isSelected()) {
                        Shape shape =  paintPanel.selectedShape;
                        shape.addAnimation(new AnimationColor(100, shape));
                        load();
                    } else {
                        for (Animation anim : paintPanel.selectedShape.animations) {
                            if (anim instanceof AnimationColor) {
                                paintPanel.selectedShape.animations.remove(anim);
                            }
                        }
                    }
                }
            }
        });

        SpeedSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                AnimationColor animationColor = null;
                for (Animation anim:paintPanel.selectedShape.animations){
                    if (anim instanceof AnimationColor){
                        animationColor = (AnimationColor) anim;
                        break;

                    }
                }

                animationColor.setStepDelay(1000 - SpeedSlider.getValue()*100);
            }
        });
    }
}
