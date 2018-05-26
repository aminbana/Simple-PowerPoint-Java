package drawing;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class MainFrame extends JFrame {

    JPanel contentPane;
    JPanel BackgroundPanel;
    JPanel ShapesManagerPanel;


    JPanel ShapesPanel;
    JPanel SelectedShapePanel;

    CirclePanel circlePanel;
    RectanglePanel rectanglePanel;
    NoShapePanel noShapePanel;

    AnimationColorPanel animationColorPanel;
    AnimationMovePanel animationMovePanel;

    JPanel AnimationPanel;
    JPanel SelectedAnimanionPanel;
    JPanel ControlPanel;
    JPanel ToolsPanel;
    PaintPanel paintPanel;

    JLabel PlayButton;

    JLabel CircleBtn;
    JLabel SquareBtn;


    JPanel spacePanel;
    JPanel spacePanel0;
    JPanel spacePanel1;

    JPanel ControlPanelSpacePanel0;
    JPanel ControlPanelSpacePanel;


    JComboBox<String> AnimationChooserCombo;

    JComboBox<String> ShapeChooserCombo;

    ImageIcon circleIcon = new ImageIcon("./Images/circle.png");
    ImageIcon rectangleIcon = new ImageIcon("./Images/Square.png");


    boolean flag = false;


    MainFrame() {
        initialize();
    }

    void initialize() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable (false);

        setTitle("Paint Application");
        setSize(new Dimension(1400,800));

        contentPane=(JPanel) getContentPane();
        contentPane.setLayout(new BorderLayout());
        paintPanel=new PaintPanel();
        paintPanel.mainFrame = this;

        BackgroundPanel = new JPanel();
        BackgroundPanel.setLayout(new BorderLayout());

        ToolsPanel = new JPanel();
        ToolsPanel.setLayout(new BoxLayout(ToolsPanel , BoxLayout.Y_AXIS));
        ToolsPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));

        ShapesManagerPanel = new JPanel();
        ShapesManagerPanel.setLayout(new BoxLayout(ShapesManagerPanel , BoxLayout.Y_AXIS));
        ShapesManagerPanel.setPreferredSize(new Dimension(250 , 400));
        ShapesManagerPanel.setBorder(BorderFactory.createTitledBorder("Shapes Manager"));
        ShapeChooserCombo = new JComboBox<>();
        ShapeChooserCombo.setPreferredSize(new Dimension(200 , 30));
        SelectedShapePanel = new JPanel();
        SelectedShapePanel.setPreferredSize(new Dimension(200 , 400 - 30));

        ShapesManagerPanel.add(ShapeChooserCombo);
        ShapesManagerPanel.add(SelectedShapePanel);

        circlePanel = new CirclePanel(paintPanel);
        rectanglePanel = new RectanglePanel(paintPanel);
        noShapePanel = new NoShapePanel();

        SelectedShapePanel.add(noShapePanel);



        AnimationPanel = new JPanel();
        AnimationPanel.setLayout(new BoxLayout(AnimationPanel , BoxLayout.Y_AXIS));
        AnimationPanel.setPreferredSize(new Dimension(250 , 1000 - 380 - 20));
        AnimationPanel.setBorder(BorderFactory.createTitledBorder("Animation Manager"));
        AnimationChooserCombo = new JComboBox<>();
        AnimationChooserCombo .addItem("Move");
        AnimationChooserCombo .addItem("Random Color");
        AnimationChooserCombo .addItem("Resize");
        AnimationChooserCombo .addItem("Border Size");
        AnimationChooserCombo .setEnabled(false);
        AnimationChooserCombo.setPreferredSize(new Dimension(200 , 30));
        SelectedAnimanionPanel = new JPanel();
        SelectedAnimanionPanel.setPreferredSize(new Dimension(200 , 500));
        SelectedAnimanionPanel.setLayout(new BoxLayout(SelectedAnimanionPanel , BoxLayout.Y_AXIS));

        AnimationPanel.add(AnimationChooserCombo);
        AnimationPanel.add(SelectedAnimanionPanel);

        animationColorPanel = new AnimationColorPanel(paintPanel);
        animationMovePanel = new AnimationMovePanel(paintPanel);
        animationMovePanel .setEnabled(false);
        SelectedAnimanionPanel.add(animationMovePanel);


        ControlPanel = new JPanel();
        ControlPanel.setPreferredSize(new Dimension(800 , 100));
        ControlPanel.setLayout(new BoxLayout(ControlPanel , BoxLayout.X_AXIS));
        ControlPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        ControlPanelSpacePanel0 = new JPanel();
        ControlPanelSpacePanel0.setPreferredSize(new Dimension(300 , 200));
        ControlPanelSpacePanel = new JPanel();
        ControlPanelSpacePanel.setPreferredSize(new Dimension(400 , 200));

        PlayButton = new JLabel(resizeIcon(new ImageIcon("./Images/play.png") , 50 , 50));
        PlayButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        PlayButton.setPreferredSize(new Dimension(50 , 50));

        PlayButton.setAlignmentY(Component.CENTER_ALIGNMENT);
        ControlPanelSpacePanel.setAlignmentY(Component.CENTER_ALIGNMENT);
        ControlPanelSpacePanel0.setAlignmentY(Component.CENTER_ALIGNMENT);

        ControlPanel.add(ControlPanelSpacePanel0);
        ControlPanel.add(PlayButton);
        ControlPanel.add(ControlPanelSpacePanel);

        ShapesPanel = new JPanel();
        ShapesPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        ShapesPanel.setLayout(new BoxLayout(ShapesPanel , BoxLayout.Y_AXIS));
        ShapesPanel.setPreferredSize(new Dimension(60 , 700));
        spacePanel0 = new JPanel();
        spacePanel0.setPreferredSize(new Dimension(100 , 10));
        spacePanel0.setAlignmentX(Component.CENTER_ALIGNMENT);
        ShapesPanel.add(spacePanel0);
        CircleBtn = new JLabel(resizeIcon(circleIcon , 40 , 40));
        CircleBtn.setPreferredSize(new Dimension(40 , 40));
        CircleBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        CircleBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ShapesPanel.add(CircleBtn);
        spacePanel1 = new JPanel();
        spacePanel1.setPreferredSize(new Dimension(100 , 10));
        spacePanel1.setAlignmentX(Component.CENTER_ALIGNMENT);
        ShapesPanel.add(spacePanel1);
        SquareBtn = new JLabel(resizeIcon(rectangleIcon , 40 , 40)); //"circle");
        SquareBtn.setPreferredSize(new Dimension(40 , 40));
        SquareBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        SquareBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ShapesPanel.add(SquareBtn);
        spacePanel = new JPanel();
        spacePanel.setPreferredSize(new Dimension(100 , 1000));
        spacePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        ShapesPanel.add(spacePanel);



        contentPane.add(BackgroundPanel);
        BackgroundPanel.add(ToolsPanel , BorderLayout.EAST);

        ToolsPanel.add(ShapesManagerPanel);
        ToolsPanel.add(AnimationPanel);


        BackgroundPanel.add(ShapesPanel , BorderLayout.WEST);
        BackgroundPanel.add(paintPanel , BorderLayout.CENTER);
        BackgroundPanel.add(ControlPanel , BorderLayout.SOUTH);

        setButtonActions();
        setVisible(true);
    }



    public void setButtonActions (){
        CircleBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!paintPanel.changeEnable){
                    return;
                }

                Random rand = new Random();
                float r = rand.nextFloat();
                float g = rand.nextFloat();
                float b = rand.nextFloat();

                float rb = rand.nextFloat();
                float gb = rand.nextFloat();
                float bb = rand.nextFloat();

                Circle circle = new Circle(new Point(rand.nextInt(paintPanel.getWidth() - 100 ) + 50 , rand.nextInt(paintPanel.getHeight() - 100 ) + 50) , 50 + 50 *
                        rand.nextDouble() , new Color(r , g, b) , new Color(rb , gb, bb));
                paintPanel.addShape(circle);
                paintPanel.selectedShape = circle;
                updateShapeChooserCombobox();
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
        SquareBtn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!paintPanel.changeEnable){
                    return;
                }
                Random rand = new Random();
                float r = rand.nextFloat();
                float g = rand.nextFloat();
                float b = rand.nextFloat();

                float rb = rand.nextFloat();
                float gb = rand.nextFloat();
                float bb = rand.nextFloat();

                Rectangle rectangle = new Rectangle(new Point(rand.nextInt(paintPanel.getWidth() - 100) , rand.nextInt(paintPanel.getHeight() - 100)) , 50 + 50 *
                        rand.nextDouble() , 50 + 50 * rand.nextDouble() , new Color(r , g, b) , new Color(rb , gb, bb));
                paintPanel.addShape(rectangle);
                paintPanel.selectedShape = rectangle;
                rectangle.addAnimation(new AnimationColor(100 , rectangle));
                rectangle.addAnimation(new AnimationMove(100 , 30.0 , new Point(10 , 10) , rectangle));
                paintPanel.repaint();
                updateShapeChooserCombobox();
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


        PlayButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (paintPanel.getAnimating()){
                    paintPanel.changeEnable = true;

                    for (Shape shape:paintPanel.shapes){
                        shape.setBorderColor(shape.getInitBorderColor());
                        shape.setSolidColor(shape.getInitSolidColor());
                        System.out.println(shape.getInitLocation().x + " " + shape.getInitLocation().y);
                        shape.setLocation(shape.getInitLocation());
                        shape.setThickness(shape.getInitThickness());
                    }

                    paintPanel.setAnimating(false);
                    PlayButton.setIcon(resizeIcon(new ImageIcon("./Images/play.png") , 50 , 50));

                } else {
                    paintPanel.changeEnable = false;
                    for (Shape shape:paintPanel.shapes){
                        shape.setInitArea(shape.getArea());
                        shape.setInitBorderColor(shape.getBorderColor());
                        shape.setInitSolidColor(shape.getSolidColor());
                        System.out.println("1:" + shape.getLocation().x + " " + shape.getLocation().y);
                        shape.setInitLocation(shape.getLocation());
                        System.out.println("2:" + shape.getInitLocation().x + " " + shape.getInitLocation().y);
                        shape.setInitThickness(shape.getThickness());

                        for (Animation animation:shape.animations){
                            if (animation instanceof AnimationMove){
                                ((AnimationMove) animation).GoingOrComing = true;
                            }
                        }
                    }

                    paintPanel.setAnimating(true);
                    PlayButton.setIcon(resizeIcon(new ImageIcon("./Images/pause.png") , 50 , 50));
                }

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


        ShapeChooserCombo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int id = ShapeChooserCombo.getSelectedIndex();
                if (!flag) {
                    paintPanel.selectedShape = paintPanel.shapes.get(id);
                    UpdateShapeEditor();
                }
            }
        });


        AnimationChooserCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                int idx = cb.getSelectedIndex();
                updateAnimationPanel(idx);
            }
        });
    }


    public void refreshCombobox (){
        ShapeChooserCombo.removeAllItems();
        for (Shape shape:paintPanel.shapes){
            ShapeChooserCombo.addItem(shape.type.toString() + " " + shape.ID);
        }
    }

    public void updateShapeChooserCombobox (){
        flag = true;
        refreshCombobox();
        if (paintPanel.selectedShape != null){
            ShapeChooserCombo.setSelectedIndex(paintPanel.shapes.indexOf(paintPanel.selectedShape));
            UpdateShapeEditor();
            updateAnimationPanel(0);
        } else {
            updateAnimationPanel(0);
            UpdateShapeEditor();
        }
        flag = false;

    }

    public void UpdateShapeEditor (){
        SelectedShapePanel.removeAll();
        if (paintPanel.selectedShape == null){
            SelectedShapePanel.add(noShapePanel);
        } else if (paintPanel.selectedShape.type == drawing.Type.Circle){
            circlePanel.loadShape(paintPanel.selectedShape);
            SelectedShapePanel.add(circlePanel);
            AnimationChooserCombo.setEnabled(true);
            AnimationChooserCombo.setSelectedIndex(0);


        } else if (paintPanel.selectedShape.type == drawing.Type.Rectangle) {
            rectanglePanel.loadShape(paintPanel.selectedShape);
            SelectedShapePanel.add(rectanglePanel);
            AnimationChooserCombo.setEnabled(true);
            AnimationChooserCombo.setSelectedIndex(0);
        }
        repaint();
    }

    public void updateAnimationPanel(int idx){
        animationMovePanel.setEnabled(true);
        animationColorPanel.setEnabled(true);
//        System.out.println(AnimationChooserCombo.getSelectedIndex());

        if (paintPanel.selectedShape == null) return;
        if (idx == 0){
            SelectedAnimanionPanel.removeAll();
//            SelectedAnimanionPanel.add(animationColorPanel);
//            animationColorPanel.load();
            SelectedAnimanionPanel.add(animationMovePanel);
            animationMovePanel.load();
            System.out.println(idx);
        } else if (idx == 1){
            SelectedAnimanionPanel.removeAll();
            //???????????????????????????????????
//            SelectedAnimanionPanel.add(animationColorPanel);
//            animationColorPanel.load();
            SelectedAnimanionPanel.add(animationMovePanel);
            animationMovePanel.load();
            System.out.println(idx);
        } else if (idx == 2){
            SelectedAnimanionPanel.removeAll();
//            SelectedAnimanionPanel.add(animationMovePanel);
//            animationMovePanel.load();
            System.out.println(idx);
        }

        repaint();
    }

    public ImageIcon resizeIcon (ImageIcon icon , int width , int height){
        Image i = icon.getImage();
        return new ImageIcon(i.getScaledInstance(width , height , Image.SCALE_SMOOTH));
    }
}
