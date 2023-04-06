package Fourthlab;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class MovingCircle extends JApplet implements ActionListener {

    private int x = 100;   // начальная координата центра круга по оси x
    private int y = 100;   // начальная координата центра круга по оси y
    private int r = 50;    // радиус круга
    private int dx = 5;    // скорость движения по оси x
    private int dy = 5;    // скорость движения по оси y
    private Timer timer;   // таймер для обновления экрана

    public void init() {
        setBackground(Color.WHITE);
        try {
            String inputX = JOptionPane.showInputDialog("Введите скорость по x:");
            String inputY = JOptionPane.showInputDialog("Введите скорость по y:");
            dx = Integer.parseInt(inputX);
            dy = Integer.parseInt(inputY);
            if (dx < 0 || dy < 0) {
                throw new IllegalArgumentException("Скорость не может быть отрицательной");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Скорость должна быть числом");
            System.exit(1);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(1);
        }
        timer = new Timer(50, this);   // таймер с периодом 50 миллисекунд
        timer.start();                 // запустить таймер
    }

    public void actionPerformed(ActionEvent e) {
        // обработка события таймера
        x += dx;   // изменить координату x
        y += dy;   // изменить координату y
        if (x + r > getWidth()) {
            // если круг достиг правой границы, изменить направление движения по x
            dx = -dx;
        }
        if (x - r < 0) {
            // если круг достиг левой границы, изменить направление движения по x
            dx = -dx;
        }
        if (y + r > getHeight()) {
            // если круг достиг нижней границы, изменить направление движения по y
            dy = -dy;
        }
        if (y - r < 0) {
            // если круг достиг верхней границы, изменить направление движения по y
            dy = -dy;
        }
        repaint();   // обновить экран
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLUE);
        g.fillOval(x - r, y - r, 2 * r, 2 * r);   // нарисовать круг
    }
}
