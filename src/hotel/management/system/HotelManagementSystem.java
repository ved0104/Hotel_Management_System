package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {

        private JLabel titleLabel;
        private JButton nextButton;

        public HotelManagementSystem() {
                // Frame setup
                setTitle("Hotel Management System");
                setSize(1366, 768); // Full HD resolution
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setLocationRelativeTo(null);
                setLayout(new BorderLayout());

                // Background Image
                ImageIcon backgroundIcon = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/zero.jpg"));
                Image scaledImage = backgroundIcon.getImage().getScaledInstance(1366, 768, Image.SCALE_DEFAULT);
                JLabel backgroundLabel = new JLabel(new ImageIcon(scaledImage));
                backgroundLabel.setLayout(new BorderLayout());
                add(backgroundLabel);

                // Title Label
                titleLabel = new JLabel("HOTEL MANAGEMENT SYSTEM", SwingConstants.CENTER);
                titleLabel.setFont(new Font("Serif", Font.BOLD, 60));
                titleLabel.setForeground(Color.RED);
                titleLabel.setOpaque(false);
                backgroundLabel.add(titleLabel, BorderLayout.NORTH);

                // Button Panel
                JPanel buttonPanel = new JPanel();
                buttonPanel.setOpaque(false);
                nextButton = new JButton("Next");
                nextButton.setBackground(Color.WHITE);
                nextButton.setForeground(Color.BLACK);
                nextButton.setFont(new Font("Arial", Font.PLAIN, 20));
                nextButton.addActionListener(this);
                nextButton.setFocusable(false);
                buttonPanel.add(nextButton);
                backgroundLabel.add(buttonPanel, BorderLayout.SOUTH);

                // Title Blinking Effect
                Timer blinkTimer = new Timer(500, e -> titleLabel.setVisible(!titleLabel.isVisible()));
                blinkTimer.start();
                setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
                // Proceed to Login
                new Login().setVisible(true);
                this.dispose(); // Close current window
        }

        public static void main(String[] args) {
                SwingUtilities.invokeLater(HotelManagementSystem::new);
        }
}
