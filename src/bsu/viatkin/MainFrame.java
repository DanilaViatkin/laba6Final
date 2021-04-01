package bsu.viatkin;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
    // Константы, задающие размер окна приложения, если оно
// не распахнуто на весь экран
    private static final int WIDTH = 700;
    private static final int HEIGHT = 500;
    private JMenuItem pauseMenuItem;
    private JMenuItem resumeMenuItem;
    private JMenuItem pauseSmallMenuItem;
    private JMenuItem resumeSmallMenuItem;
    private JMenuItem pauseLargeMenuItem;
    private JMenuItem resumeLargeMenuItem;
    private JMenuItem pauseFastMenuItem;
    private JMenuItem resumeFastMenuItem;
    private JMenuItem pauseSlowMenuItem;
    private JMenuItem resumeSlowMenuItem;
    private JMenuItem pauseTrajectory1MenuItem;
    private JMenuItem resumeTrajectory1MenuItem;
    private JMenuItem pauseTrajectory2MenuItem;
    private JMenuItem resumeTrajectory2MenuItem;
    private JMenuItem pauseTrajectory3MenuItem;
    private JMenuItem resumeTrajectory3MenuItem;
    private JMenuItem pauseTrajectory4MenuItem;
    private JMenuItem resumeTrajectory4MenuItem;
    private JMenuItem pauseRedMenuItem;
    private JMenuItem resumeRedMenuItem;
    private JMenuItem pauseGreenMenuItem;
    private JMenuItem resumeGreenMenuItem;
    private JMenuItem pauseBlueMenuItem;
    private JMenuItem resumeBlueMenuItem;
    // Поле, по которому прыгают мячи
    private Field field = new Field();

    // Конструктор главного окна приложения
    public MainFrame() {
        super("Программирование и синхронизация потоков");
        setSize(WIDTH, HEIGHT);
        Toolkit kit = Toolkit.getDefaultToolkit();
        // Отцентрировать окно приложения на экране
        setLocation((kit.getScreenSize().width - WIDTH) / 2,
                (kit.getScreenSize().height - HEIGHT) / 2);

        // Создать меню
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu ballMenu = new JMenu("Мячи");
        Action addBallAction = new AbstractAction("Добавить мяч") {
            public void actionPerformed(ActionEvent event) {
                field.addBall();
                if (!pauseMenuItem.isEnabled() &&
                        !resumeMenuItem.isEnabled()) {
                    // Ни один из пунктов меню не являются
                    // доступными - сделать доступным "Паузу"
                    pauseMenuItem.setEnabled(true);
                    pauseSmallMenuItem.setEnabled(true);
                    pauseLargeMenuItem.setEnabled(true);
                    pauseFastMenuItem.setEnabled(true);
                    pauseSlowMenuItem.setEnabled(true);
                    pauseTrajectory1MenuItem.setEnabled(true);
                    pauseTrajectory2MenuItem.setEnabled(true);
                    pauseTrajectory3MenuItem.setEnabled(true);
                    pauseTrajectory4MenuItem.setEnabled(true);
                    pauseRedMenuItem.setEnabled(true);
                    pauseGreenMenuItem.setEnabled(true);
                    pauseBlueMenuItem.setEnabled(true);
                }
            }
        };
        menuBar.add(ballMenu);
        ballMenu.add(addBallAction);

        JMenu controlMenu = new JMenu("Управление");
        menuBar.add(controlMenu);
        JMenu control2Menu = new JMenu("Управление 2");
        menuBar.add(control2Menu);
        JMenu control3Menu = new JMenu("Управление 3");
        menuBar.add(control3Menu);
        Action pauseAction = new AbstractAction("Приостановить движение всех мячей") {
            public void actionPerformed(ActionEvent event) {
                field.pause();
                pauseMenuItem.setEnabled(false);
                resumeMenuItem.setEnabled(true);
                pauseSmallMenuItem.setEnabled(false);
                resumeSmallMenuItem.setEnabled(false);
                pauseLargeMenuItem.setEnabled(false);
                resumeLargeMenuItem.setEnabled(false);
                pauseFastMenuItem.setEnabled(false);
                resumeFastMenuItem.setEnabled(false);
                pauseSlowMenuItem.setEnabled(false);
                resumeSlowMenuItem.setEnabled(false);
            }
        };
        pauseMenuItem = controlMenu.add(pauseAction);
        pauseMenuItem.setEnabled(false);

        Action pauseSmallAction = new AbstractAction("Приостановить движение мячей малых размеров (<10)") {
            public void actionPerformed(ActionEvent event) {
                field.pauseSmall();
                pauseSmallMenuItem.setEnabled(false);
                resumeSmallMenuItem.setEnabled(true);
            }
        };
        pauseSmallMenuItem = controlMenu.add(pauseSmallAction);
        pauseSmallMenuItem.setEnabled(false);

        Action pauseLargeAction = new AbstractAction("Приостановить движение мячей больших размеров (>30)") {
            public void actionPerformed(ActionEvent event) {
                field.pauseLarge();
                pauseLargeMenuItem.setEnabled(false);
                resumeLargeMenuItem.setEnabled(true);
            }
        };
        pauseLargeMenuItem = controlMenu.add(pauseLargeAction);
        pauseLargeMenuItem.setEnabled(false);

        Action resumeAction = new AbstractAction("Возобновить движение всех мячей") {
            public void actionPerformed(ActionEvent event) {
                field.resume();
                pauseMenuItem.setEnabled(true);
                resumeMenuItem.setEnabled(false);
                pauseSmallMenuItem.setEnabled(true);
                resumeSmallMenuItem.setEnabled(false);
                pauseLargeMenuItem.setEnabled(true);
                resumeLargeMenuItem.setEnabled(false);
            }
        };
        resumeMenuItem = controlMenu.add(resumeAction);
        resumeMenuItem.setEnabled(false);

        Action resumeSmallAction = new AbstractAction("Возобновить движение мячей малых размеров (<10)") {
            public void actionPerformed(ActionEvent event) {
                field.resumeSmall();
                pauseSmallMenuItem.setEnabled(true);
                resumeSmallMenuItem.setEnabled(false);
            }
        };
        resumeSmallMenuItem = controlMenu.add(resumeSmallAction);
        resumeSmallMenuItem.setEnabled(false);

        Action resumeLargeAction = new AbstractAction("Возобновить движение мячей больших размеров (>30)") {
            public void actionPerformed(ActionEvent event) {
                field.resumeLarge();
                pauseLargeMenuItem.setEnabled(true);
                resumeLargeMenuItem.setEnabled(false);
            }
        };
        resumeLargeMenuItem = controlMenu.add(resumeLargeAction);
        resumeLargeMenuItem.setEnabled(false);

        Action pauseFastAction = new AbstractAction("Приостановить движение быстрых мячей") {
            public void actionPerformed(ActionEvent event) {
                field.pauseFast();
                pauseFastMenuItem.setEnabled(false);
                resumeFastMenuItem.setEnabled(true);
            }
        };
        pauseFastMenuItem = controlMenu.add(pauseFastAction);
        pauseFastMenuItem.setEnabled(false);

        Action resumeFastAction = new AbstractAction("Возобнавить движение быстрых мячей") {
            public void actionPerformed(ActionEvent event) {
                field.resumeFast();
                pauseFastMenuItem.setEnabled(true);
                resumeFastMenuItem.setEnabled(false);
            }
        };
        resumeFastMenuItem = controlMenu.add(resumeFastAction);
        resumeFastMenuItem.setEnabled(false);

        Action pauseSlowAction = new AbstractAction("Приостановить движение медленных мячей") {
            public void actionPerformed(ActionEvent event) {
                field.pauseSlow();
                pauseSlowMenuItem.setEnabled(false);
                resumeSlowMenuItem.setEnabled(true);
            }
        };
        pauseSlowMenuItem = controlMenu.add(pauseSlowAction);
        pauseSlowMenuItem.setEnabled(false);

        Action resumeSlowAction = new AbstractAction("Возобнавить движение медленных мячей") {
            public void actionPerformed(ActionEvent event) {
                field.resumeSlow();
                pauseSlowMenuItem.setEnabled(true);
                resumeSlowMenuItem.setEnabled(false);
            }
        };
        resumeSlowMenuItem = controlMenu.add(resumeSlowAction);
        resumeSlowMenuItem.setEnabled(false);

        Action pauseTrajectory1Action = new AbstractAction("Остановить мячики двигающиеся в направлении 1 четверти") {
            public void actionPerformed(ActionEvent e) {
                field.pauseTrajectory1();
                pauseTrajectory1MenuItem.setEnabled(false);
                resumeTrajectory1MenuItem.setEnabled(true);
            }
        };
        pauseTrajectory1MenuItem = control2Menu.add(pauseTrajectory1Action);
        pauseTrajectory1MenuItem.setEnabled(false);

        Action pauseTrajectory2Action = new AbstractAction("Остановить мячики двигающиеся в направлении 2 четверти") {
            public void actionPerformed(ActionEvent e) {
                field.pauseTrajectory2();
                pauseTrajectory2MenuItem.setEnabled(false);
                resumeTrajectory2MenuItem.setEnabled(true);
            }
        };
        pauseTrajectory2MenuItem = control2Menu.add(pauseTrajectory2Action);
        pauseTrajectory2MenuItem.setEnabled(false);

        Action pauseTrajectory3Action = new AbstractAction("Остановить мячики двигающиеся в направлении 3 четверти") {
            public void actionPerformed(ActionEvent e) {
                field.pauseTrajectory3();
                pauseTrajectory3MenuItem.setEnabled(false);
                resumeTrajectory3MenuItem.setEnabled(true);
            }
        };
        pauseTrajectory3MenuItem = control2Menu.add(pauseTrajectory3Action);
        pauseTrajectory3MenuItem.setEnabled(false);

        Action pauseTrajectory4Action = new AbstractAction("Остановить мячики двигающиеся в направлении 4 четверти") {
            public void actionPerformed(ActionEvent e) {
                field.pauseTrajectory4();
                pauseTrajectory4MenuItem.setEnabled(false);
                resumeTrajectory4MenuItem.setEnabled(true);
            }
        };
        pauseTrajectory4MenuItem = control2Menu.add(pauseTrajectory4Action);
        pauseTrajectory4MenuItem.setEnabled(false);

        Action resumeTrajectory1Action = new AbstractAction("Запустить мячики двигающиеся в направлении 1 четверти") {
            public void actionPerformed(ActionEvent e) {
                field.resumeTrajectory1();
                pauseTrajectory1MenuItem.setEnabled(true);
                resumeTrajectory1MenuItem.setEnabled(false);
            }
        };
        resumeTrajectory1MenuItem = control2Menu.add(resumeTrajectory1Action);
        resumeTrajectory1MenuItem.setEnabled(false);

        Action resumeTrajectory2Action = new AbstractAction("Запустить мячики двигающиеся в направлении 2 четверти") {
            public void actionPerformed(ActionEvent e) {
                field.resumeTrajectory2();
                pauseTrajectory2MenuItem.setEnabled(true);
                resumeTrajectory2MenuItem.setEnabled(false);
            }
        };
        resumeTrajectory2MenuItem = control2Menu.add(resumeTrajectory2Action);
        resumeTrajectory2MenuItem.setEnabled(false);

        Action resumeTrajectory3Action = new AbstractAction("Запустить мячики двигающиеся в направлении 3 четверти") {
            public void actionPerformed(ActionEvent e) {
                field.resumeTrajectory3();
                pauseTrajectory3MenuItem.setEnabled(true);
                resumeTrajectory3MenuItem.setEnabled(false);
            }
        };
        resumeTrajectory3MenuItem = control2Menu.add(resumeTrajectory3Action);
        resumeTrajectory3MenuItem.setEnabled(false);

        Action resumeTrajectory4Action = new AbstractAction("Запустить мячики двигающиеся в направлении 4 четверти") {
            public void actionPerformed(ActionEvent e) {
                field.resumeTrajectory4();
                pauseTrajectory4MenuItem.setEnabled(true);
                resumeTrajectory4MenuItem.setEnabled(false);
            }
        };
        resumeTrajectory4MenuItem = control2Menu.add(resumeTrajectory4Action);
        resumeTrajectory4MenuItem.setEnabled(false);

        Action pauseRedAction = new AbstractAction("Остановить мячики доминирующего красного цвета") {
            public void actionPerformed(ActionEvent e) {
                field.pauseRed();
                pauseRedMenuItem.setEnabled(false);
                resumeRedMenuItem.setEnabled(true);
            }
        };
        pauseRedMenuItem = control3Menu.add(pauseRedAction);
        pauseRedMenuItem.setEnabled(false);

        Action pauseGreenAction = new AbstractAction("Остановить мячики доминирующего зеленого цвета") {
            public void actionPerformed(ActionEvent e) {
                field.pauseGreen();
                pauseGreenMenuItem.setEnabled(false);
                resumeGreenMenuItem.setEnabled(true);
            }
        };
        pauseGreenMenuItem = control3Menu.add(pauseGreenAction);
        pauseGreenMenuItem.setEnabled(false);

        Action pauseBlueAction = new AbstractAction("Остановить мячики доминирующего cинего цвета") {
            public void actionPerformed(ActionEvent e) {
                field.pauseBlue();
                pauseBlueMenuItem.setEnabled(false);
                resumeBlueMenuItem.setEnabled(true);
            }
        };
        pauseBlueMenuItem = control3Menu.add(pauseBlueAction);
        pauseBlueMenuItem.setEnabled(false);

        Action resumeRedAction = new AbstractAction("Запустить мячики доминирующего красного цвета") {
            public void actionPerformed(ActionEvent e) {
                field.resumeRed();
                pauseRedMenuItem.setEnabled(true);
                resumeRedMenuItem.setEnabled(false);
            }
        };
        resumeRedMenuItem = control3Menu.add(resumeRedAction);
        resumeRedMenuItem.setEnabled(false);

        Action resumeBlueAction = new AbstractAction("Запустить мячики доминирующего синего цвета") {
            public void actionPerformed(ActionEvent e) {
                field.resumeBlue();
                pauseBlueMenuItem.setEnabled(true);
                resumeBlueMenuItem.setEnabled(false);
            }
        };
        resumeBlueMenuItem = control3Menu.add(resumeBlueAction);
        resumeBlueMenuItem.setEnabled(false);

        Action resumeGreenAction = new AbstractAction("Запустить мячики доминирующего зеленого цвета") {
            public void actionPerformed(ActionEvent e) {
                field.resumeGreen();
                pauseGreenMenuItem.setEnabled(true);
                resumeGreenMenuItem.setEnabled(false);
            }
        };
        resumeGreenMenuItem = control3Menu.add(resumeGreenAction);
        resumeGreenMenuItem.setEnabled(false);
        // Добавить в центр граничной компоновки поле Field
        getContentPane().add(field, BorderLayout.CENTER);
    }

    // Главный метод приложения
    public static void main(String[] args) {
        // Создать и сделать видимым главное окно приложения
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}