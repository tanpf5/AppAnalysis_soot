package main;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ResultFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JButton cancel;

	public ResultFrame(String[] result) {
		JPanel jPanel = new JPanel();
		jPanel.setLayout(null);


		setBounds(200, 100, 600, 600);
		setTitle("测试");
		JScrollPane scrollPane = new JScrollPane(jPanel);
		scrollPane.setBounds(0, 0, 600, 600);
		jPanel.setPreferredSize(new Dimension(600, 1150));
		add(new JScrollPane(scrollPane));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		if (button == cancel) {
			System.exit(0);
		}
	}
}

