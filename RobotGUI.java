import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class RobotGUI extends JFrame implements ActionListener, KeyListener {

	private JPanel header = new JPanel();
	private JPanel grid = new JPanel();
	private JPanel buttons = new JPanel();
	private JTextField[][] cell = new JTextField[RobotMonitor.GRID_SIZE][RobotMonitor.GRID_SIZE]; // the cells

	// Button size to make all buttons the same size
	Dimension buttonSize = new Dimension(100, 40);

	// these next label provides a border around the cells
	private JLabel move = new JLabel("NO MOVE", JLabel.CENTER);
	private JButton rightBtn = new JButton("RIGHT");
	private JButton leftBtn = new JButton("LEFT");
	private JButton upBtn = new JButton("UP");
	private JButton downBtn = new JButton("DOWN");
	private JButton exitBtn = new JButton("EXIT");
	private LineBorder line = new LineBorder(Color.black, 2);
	private RobotMonitor robot = new RobotMonitor();

	// the constructor
	public RobotGUI() {
		try {

			addKeyListener(this);
			setFocusable(true);
			requestFocus();
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setTitle("RobotMonitor");
			setSize(600, 400);
			setLocation(300, 100);
			getContentPane().setBackground(Color.GREEN);
			grid.setLayout(new GridLayout(RobotMonitor.GRID_SIZE, RobotMonitor.GRID_SIZE));
			// creates and adds nine buttons to the grid
			for (int r = 0; r < RobotMonitor.GRID_SIZE; r++) {
				for (int c = 0; c < RobotMonitor.GRID_SIZE; c++) {
					cell[r][c] = new JTextField(3);
					grid.add(cell[r][c]);
				}
			}
			setUpGrid();
			update("R", Color.GREEN);

			// Set all button sizes to be the same
			leftBtn.setPreferredSize(buttonSize);
			rightBtn.setPreferredSize(buttonSize);
			upBtn.setPreferredSize(buttonSize);
			downBtn.setPreferredSize(buttonSize);
			exitBtn.setPreferredSize(buttonSize);

			// positions the items on the screen
			leftBtn.addActionListener(this);
			rightBtn.addActionListener(this);
			upBtn.addActionListener(this);
			downBtn.addActionListener(this);
			exitBtn.addActionListener(this);
			buttons.add(leftBtn);
			buttons.add(rightBtn);
			buttons.add(upBtn);
			buttons.add(downBtn);
			buttons.add(exitBtn);
			header.add(move);// ADDED!!!!!
			add(header, BorderLayout.NORTH);
			add(grid, BorderLayout.CENTER);
			add(buttons, BorderLayout.SOUTH);
			setVisible(true);
		} catch (VDMException error) {
			JOptionPane.showMessageDialog(null, error.toString(), "VDM INITIALISATION ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void actionPerformed(ActionEvent e) {
		try {

			if (e.getSource() == leftBtn) {
				update("   ", Color.GREEN);
				robot.MoveLeft();
				update("R", Color.GREEN);
				requestFocus();
			}
			if (e.getSource() == rightBtn) {
				update("   ", Color.GREEN);
				robot.MoveRight();
				update(" R ", Color.GREEN);
				requestFocus();
			}
			if (e.getSource() == upBtn) {
				update("   ", Color.GREEN);
				robot.MoveUp();
				update(" R ", Color.GREEN);
				requestFocus();
			}
			if (e.getSource() == downBtn) {
				update("   ", Color.GREEN);
				robot.MoveDown();
				update(" R ", Color.GREEN);
				requestFocus();
			}
			if (e.getSource() == exitBtn) {
				robot.Exit();
				setUpGrid();
				requestFocus();
			}
		} catch (VDMException error) {
			update(" R ", Color.RED);
			requestFocus();
			JOptionPane.showMessageDialog(null, error.toString(), "VDM ERROR", JOptionPane.ERROR_MESSAGE);
		} catch (Exception error) {
			JOptionPane.showMessageDialog(null, error.toString(), "GENERAL ERROR", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}

	private void update(String msg, Color c) {
		try {
			int row = robot.GetRow();
			int col = robot.GetCol();
			cell[row - 1][col - 1].setText(msg);
			cell[row - 1][col - 1].setBackground(c);
			cell[row - 1][col - 1].setHorizontalAlignment(JTextField.CENTER);
			if (cell[RobotMonitor.GRID_SIZE - 1][RobotMonitor.GRID_SIZE - 1].getText().equals("R")) {
				JOptionPane.showMessageDialog(rootPane, "You made it...", "Winner",
						JOptionPane.INFORMATION_MESSAGE);
				robot.Exit();
				setUpGrid();
			}
			if (robot.GetMove() != null) {
				move.setText("LAST MOVE: " + robot.GetMove());
			} else {
				move.setText("");
			}

		} catch (Exception error) {
			JOptionPane.showMessageDialog(null, error.toString(), "GENERAL ERROR", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}

	private void setUpGrid() {

		for (int r = 0; r < RobotMonitor.GRID_SIZE; r++) {
			for (int c = 0; c < RobotMonitor.GRID_SIZE; c++) {
				cell[r][c].setText("   ");
				cell[r][c].setEditable(false);
				cell[r][c].setBorder(line);
				cell[r][c].setBackground(Color.LIGHT_GRAY);
			}
		}
		cell[RobotMonitor.GRID_SIZE - 1][RobotMonitor.GRID_SIZE - 1].setBackground(Color.BLUE);
		update("R", Color.GREEN);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		try {
			switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					update("   ", Color.GREEN);
					robot.MoveLeft();
					update("R", Color.GREEN);
					break;

				case KeyEvent.VK_RIGHT:
					update("   ", Color.GREEN);
					robot.MoveRight();
					update("R", Color.GREEN);
					break;

				case KeyEvent.VK_UP:
					update("   ", Color.GREEN);
					robot.MoveUp();
					update("R", Color.GREEN);
					break;

				case KeyEvent.VK_DOWN:
					update("   ", Color.GREEN);
					robot.MoveDown();
					update("R", Color.GREEN);
					break;

				case KeyEvent.VK_ESCAPE:
					robot.Exit();
					setUpGrid();
					break;
			}
		} catch (VDMException error) {
			update("R", Color.RED);
			JOptionPane.showMessageDialog(null, error.toString(), "VDM ERROR", JOptionPane.ERROR_MESSAGE);
		} catch (Exception error) {
			JOptionPane.showMessageDialog(null, error.toString(), "GENERAL ERROR", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// Not needed but must be implemented
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// Not needed but must be implemented
	}
}
