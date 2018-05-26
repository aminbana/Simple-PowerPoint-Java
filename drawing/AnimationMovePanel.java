package drawing;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class AnimationMovePanel extends JPanel {
    JSlider SpeedSlider;
    JSlider XSlider;
    JSlider YSlider;
    JSlider LimitsSlider;

    JCheckBox EnableCheck;

    JPanel SpacePanel;
    JLabel SpeedLabel;
    JLabel XLabel;
    JLabel YLabel;
    JLabel LimitsLabel;

    PaintPanel paintPanel;

    boolean flag = false;

    AnimationMovePanel(PaintPanel paintPanel){
        super();
//        this.setBackground(Color.RED);
        this.paintPanel = paintPanel;
        this.setPreferredSize(new Dimension(200 , 340));
        setLayout(new BoxLayout(this , BoxLayout.Y_AXIS));

        SpeedSlider = new JSlider(1 , 10 , 5);
        SpeedSlider.setPreferredSize(new Dimension(200 , 50));

        XSlider = new JSlider(-100 , 100 , 0);
        XSlider .setPreferredSize(new Dimension(200 , 50));

        YSlider = new JSlider(-100 , 100 , 0);
        YSlider .setPreferredSize(new Dimension(200 , 50));

        LimitsSlider = new JSlider(1 , 100 , 5);
        LimitsSlider.setPreferredSize(new Dimension(200 , 50));

        SpacePanel = new JPanel();
        SpacePanel.setPreferredSize(new Dimension(200 , 100));

        SpeedLabel = new JLabel("Move Speed :");
        XLabel = new JLabel("Horizontal Steps:");
        YLabel = new JLabel("Vertical Steps:");
        LimitsLabel = new JLabel("Move Limits :");


        EnableCheck = new JCheckBox("Enable Animation");
        EnableCheck.setPreferredSize(new Dimension(100 , 20));

        addListeners();

        this.add(EnableCheck);
        this.add(SpeedLabel);
        this.add(SpeedSlider);
        this.add(XLabel);
        this.add(XSlider);
        this.add(YLabel);
        this.add(YSlider);
        this.add(LimitsLabel);
        this.add(LimitsSlider);
        this.add(SpacePanel);

    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        SpeedSlider.setEnabled(enabled);
        YSlider.setEnabled(enabled);
        XSlider.setEnabled(enabled);
        LimitsSlider.setEnabled(enabled);
        EnableCheck.setEnabled(enabled);
    }

    public void load (){
        System.out.println("loading ...");
        flag = true;
        for (Animation anim:paintPanel.selectedShape.animations){
            if (anim instanceof AnimationMove){
                AnimationMove animationMove = (AnimationMove) anim;
                EnableCheck.setSelected(true);
                SpeedSlider.setEnabled(true);
                YSlider.setEnabled(true);
                XSlider.setEnabled(true);
                LimitsSlider.setEnabled(true);
                SpeedSlider.setValue((1000 - anim.getStepDelay()) / 100);
                XSlider.setValue((int) (animationMove.getMoveStep().getX() * 100));
                YSlider.setValue((int) (animationMove.getMoveStep().getY() * 100));
                LimitsSlider.setValue((int) (animationMove.MoveLimits / 10));
                flag = false;
                return;

            }
        }

        EnableCheck.setSelected(false);
        SpeedSlider.setEnabled(false);
        XSlider.setEnabled(false);
        YSlider.setEnabled(false);
        LimitsSlider.setEnabled(false);
        flag = false;
    }


    public void addListeners(){
        EnableCheck.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (!flag) {
                    if (EnableCheck.isSelected()) {
                        paintPanel.selectedShape.addAnimation(new AnimationMove(100, 5 ,
                                new Point(10 , 10) , paintPanel.selectedShape));
                        System.out.println(paintPanel.selectedShape);
                        System.out.println("Added");
                        load();
                    } else {
                        for (Animation anim : paintPanel.selectedShape.animations) {
                            if (anim instanceof AnimationMove) {
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
                AnimationMove animationMove = null;
                for (Animation anim:paintPanel.selectedShape.animations){
                    if (anim instanceof AnimationMove){
                        animationMove = (AnimationMove) anim;
                        break;

                    }
                }

                animationMove.setStepDelay(1000 - SpeedSlider.getValue()*100);
            }
        });

        XSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                AnimationMove animationMove = null;
                for (Animation anim : paintPanel.selectedShape.animations) {
                    if (anim instanceof AnimationMove) {
                        animationMove = (AnimationMove) anim;
                        break;

                    }
                }
                animationMove.setMoveStep(new Point(XSlider.getValue() /100.0 , animationMove.getMoveStep().getY()));
            }

        });


        YSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                AnimationMove animationMove = null;
                for (Animation anim : paintPanel.selectedShape.animations) {
                    if (anim instanceof AnimationMove) {
                        animationMove = (AnimationMove) anim;
                        break;

                    }
                }

                animationMove.setMoveStep(new Point(animationMove.getMoveStep().getX() , YSlider.getValue() /100.0 ));

            }
        });


        LimitsSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                AnimationMove animationMove = null;
                for (Animation anim : paintPanel.selectedShape.animations) {
                    if (anim instanceof AnimationMove) {
                        animationMove = (AnimationMove) anim;
                        break;

                    }
                }

                animationMove.MoveLimits = LimitsSlider.getValue() * 10;
                System.out.println(animationMove.MoveLimits);

            }
        });


    }
}