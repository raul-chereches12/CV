import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.geom.*;

class Success extends JFrame implements ChangeListener {
    private final int WINDOWS_HEIGHT = 768;
    private final int WINDOWS_WIDTH = 1024;
    private final int MIDDLE_X = WINDOWS_WIDTH / 2;
    private final int MIDDLE_Y = WINDOWS_HEIGHT / 2;

    private final int SPEED_METER_RADIUS = 250;

    private JFrame frame;
    private JPanel panel;
    static final int ACCELERATION_MIN = 0;
    static final int ACCELERATION_MAX = 7;
    static final int ACCELERAION_INIT = 0;    //initial acceleration
    JSlider acceleration_slider = new JSlider(JSlider.HORIZONTAL,
            ACCELERATION_MIN, ACCELERATION_MAX, ACCELERAION_INIT);

    JSlider gear_slider = new JSlider(JSlider.VERTICAL,
            -1, 4, 0);
    
    JTextArea acceleration_display;
    JTextArea distance_traveled_display;
    JTextArea speed_display;
    JTextArea gear_display;


    public static JButton turration_bulb;

    JTextArea cursor_90,cursor_45,cursor_135,cursor_0,cursor_180;


    public Success() {

        panel = new JPanel();
        getContentPane().add(panel);
        setSize(10, 10);
        setVisible(true);


        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(WINDOWS_WIDTH, WINDOWS_HEIGHT);
        setTitle("Car simulator");


        initSlider();
        initHUD();
        //drawLine();

        repaint();
    }

    public void initSlider() {
        acceleration_slider.setBounds(MIDDLE_X - 200, MIDDLE_Y + 200, 400, 200);

        acceleration_slider.setFont(new Font("Calibri", Font.BOLD, 10));
        acceleration_slider.setMajorTickSpacing(10);
        acceleration_slider.setMinorTickSpacing(1);
        acceleration_slider.setPaintLabels(true);
        acceleration_slider.setPaintTicks(true);
        acceleration_slider.setPaintTrack(true);
        acceleration_slider.setAutoscrolls(true);
        // acceleration_slider.setBackground(Color.WHITE);

        acceleration_slider.addChangeListener(this);
        getContentPane().add(acceleration_slider);


        gear_slider.setBounds(MIDDLE_X +350, MIDDLE_Y -200, 200, 400);

        gear_slider.setFont(new Font("Calibri", Font.BOLD, 10));
        gear_slider.setMajorTickSpacing(10);
        gear_slider.setMinorTickSpacing(1);
        gear_slider.setPaintLabels(true);
        gear_slider.setPaintTicks(true);
        gear_slider.setPaintTrack(true);
        gear_slider.setAutoscrolls(true);
        // gear_slider.setBackground(Color.WHITE);

        gear_slider.addChangeListener(this);
        getContentPane().add(gear_slider);





    }

    public void initHUD() {
        acceleration_display = new JTextArea();
        acceleration_display.setBounds(MIDDLE_X - 200, MIDDLE_Y + 175, 150, 25);
        acceleration_display.setText("Acceleratie: " + Car.acceleration + " m/s^2");
        acceleration_display.setForeground(Color.white);
        acceleration_display.setBackground(Color.BLUE);

        speed_display = new JTextArea();
        speed_display.setBounds(MIDDLE_X - 200 + 150 + 150+20, MIDDLE_Y + 175, 150, 25);
        speed_display.setText("Viteza: " +String.format("%.3f", Car.speed * 3.6 ) + " km/h");
        speed_display.setForeground(Color.white);
        speed_display.setBackground(Color.BLUE);

        distance_traveled_display = new JTextArea();
        distance_traveled_display.setBounds(MIDDLE_X - 200 + 150+10, MIDDLE_Y + 175, 150, 25);
        distance_traveled_display.setText("Distanta parcursa: " +  String.format("%.3f", Car.distance / 1000) + " km");
        distance_traveled_display.setForeground(Color.white);
        distance_traveled_display.setBackground(Color.BLACK);

///////////

        cursor_0 = new JTextArea();
        cursor_90 = new JTextArea();
        cursor_45 = new JTextArea();
        cursor_135 = new JTextArea();
        cursor_180 = new JTextArea();

        cursor_0.setBounds(MIDDLE_X-300,MIDDLE_Y-35,40,20);
        cursor_0.setText("0 KMH");
        cursor_0.setForeground(Color.white);
        cursor_0.setBackground(Color.BLACK);


        cursor_180.setBounds(MIDDLE_X+300,MIDDLE_Y-35,50,20);
        cursor_180.setText("180 KMH");
        cursor_180.setForeground(Color.white);
        cursor_180.setBackground(Color.BLACK);

        cursor_90.setBounds(MIDDLE_X,MIDDLE_Y-300,50,20);
        cursor_90.setText("90 KMH");
        cursor_90.setForeground(Color.white);
        cursor_90.setBackground(Color.BLACK);

        cursor_45.setBounds(MIDDLE_X-SPEED_METER_RADIUS+30,MIDDLE_Y-SPEED_METER_RADIUS+30,50,20);
        cursor_45.setText("45 KMH");
        cursor_45.setForeground(Color.white);
        cursor_45.setBackground(Color.BLACK);

        cursor_135.setBounds(MIDDLE_X+SPEED_METER_RADIUS-30,MIDDLE_Y-SPEED_METER_RADIUS+30,50,20);
        cursor_135.setText("135 KMH");
        cursor_135.setForeground(Color.white);
        cursor_135.setBackground(Color.BLACK);

        turration_bulb = new JButton("T");
        turration_bulb.setBorder(BorderFactory.createEmptyBorder());
        turration_bulb.setBackground(Color.BLACK);
        turration_bulb.setBounds(MIDDLE_X -300, MIDDLE_Y + 150, 25, 25);

        gear_display=new JTextArea();
        gear_display.setBounds(MIDDLE_X +250, MIDDLE_Y + 140, 125, 25);
        gear_display.setText("NEUTRAL_GEAR");
        gear_display.setForeground(Color.white);
        gear_display.setBackground(Color.BLACK);

        getContentPane().add(gear_display);
        getContentPane().add(cursor_0);
        getContentPane().add(cursor_180);
        getContentPane().add(cursor_90);
        getContentPane().add(cursor_45);
        getContentPane().add(cursor_135);
        getContentPane().add(turration_bulb);
        getContentPane().add(acceleration_display);
        getContentPane().add(speed_display);
        getContentPane().add(distance_traveled_display);

    }

    @Override
    public void stateChanged(ChangeEvent e) {

        JSlider source = (JSlider) e.getSource();
        if(e.getSource()==acceleration_slider) {
            if (!source.getValueIsAdjusting()) {
                Car.acceleration = (int) source.getValue();
                acceleration_display.setText("Acceleratie: " + Car.acceleration + " m/s^2");
                repaint();
            }
        }

        if(e.getSource()==gear_slider) {
            if (!source.getValueIsAdjusting()) {
                switch (source.getValue()) {
                    case -1:
                        Car.gear=Gears.REVERSE_GEAR;
                        break;

                    case 0:
                        Car.gear=Gears.NEUTRAL_GEAR;
                    break;

                    case 1:
                    Car.gear = Gears.FIRST_GEAR;
                    break;

                    case 2:
                        Car.gear = Gears.SECOND_GEAR;
                        break;

                    case 3:
                        Car.gear = Gears.THIRD_GEAR;
                        break;


                }
                repaint();
                gear_display.setText(""+Car.gear);
                turration_bulb.setBackground(Color.BLACK);
            }
        }


    }

    public void paint(Graphics g) {
        float y2=0;
        float x2=0;
        super.paint(g);  // fixes the immediate problem.
        Graphics2D g2 = (Graphics2D) g;
        Line2D lin=null;
        y2 = (float) Math.sin(0.0174532925*(Car.speed * 3.6)) * SPEED_METER_RADIUS;
        x2=(float) Math.sqrt(SPEED_METER_RADIUS * SPEED_METER_RADIUS - y2 * y2);
        if(Car.speed * 3.6>180) {
            lin = new Line2D.Float(MIDDLE_X, MIDDLE_Y, MIDDLE_X + SPEED_METER_RADIUS,
                    MIDDLE_Y);
        }
        else if(Car.speed * 3.6<90) {
            lin = new Line2D.Float(MIDDLE_X, MIDDLE_Y, MIDDLE_X - x2,
                    MIDDLE_Y - y2);

//            cursor_display.setBounds(MIDDLE_X - (int)x2-50, MIDDLE_Y - (int)y2-50, 15, 15);
//            cursor_display.setText(""+Car.speed * 3.6);
       }
        else if(Car.speed * 3.6>=90) {
//            cursor_display.setBounds(MIDDLE_X + (int)x2-50,MIDDLE_Y - (int)y2-50 , 15, 15);
//            cursor_display.setText(""+Car.speed * 3.6);
            lin = new Line2D.Float(MIDDLE_X, MIDDLE_Y, MIDDLE_X + x2,
                    MIDDLE_Y - y2);
        }
        g2.setColor(Color.BLUE);
        g2.setStroke(new BasicStroke(6f));
        g2.draw(lin);
    }


    public void update(){

        distance_traveled_display.setText("Distanta parcursa: "+String.format("%.3f", Car.distance / 1000)+" km");
        speed_display.setText("Viteza: " +String.format("%.3f", Car.speed * 3.6 ) + " km/h");
        repaint();
    }

    public void turration_light_switch(){
        if(turration_bulb.getBackground()==Color.red)
        turration_bulb.setBackground(Color.BLACK);
        else
            turration_bulb.setBackground(Color.RED);

    }





}
