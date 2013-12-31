package WorkTimerGUI;

import javax.swing.*;

/**
 * Created by Johan on 12/26/13.
 */
public class TaskComponentForm {
    private JButton startButton;
    private JButton pauseButton;
    private JButton resumeButton;
    private JButton stopButton;
    private JTextArea descriptionTextArea;
    private JButton button5;
    private JFormattedTextField nameFormattedTextField;
    private JFormattedTextField wordsFormattedTextField;
    private JPanel taskComponent;


    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (UnsupportedLookAndFeelException e) {
            // handle exception
        } catch (ClassNotFoundException e) {
            // handle exception
        } catch (InstantiationException e) {
            // handle exception
        } catch (IllegalAccessException e) {
            // handle exception
        }

        JFrame frame = new JFrame("TaskComponentForm");
        frame.setContentPane(new TaskComponentForm().taskComponent);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
