# 🤖 RobotGUI - Navigate Your Robot with Fun & Colors!

## 🌟 Overview
RobotGUI is a Java-based Swing application that simulates a robot moving inside a grid. The robot can be controlled using both GUI buttons and keyboard arrow keys. The goal is to navigate the robot to the exit point on the grid while enjoying a fun, interactive experience!

## 🚀 Features
- 🎨 **Graphical User Interface (GUI):** User-friendly interface to control the robot.
- 🖥️ **Text-Based Console Mode:** Interactive terminal-based movement.
- 🎮 **Keyboard Controls:** Use arrow keys to move the robot within the grid.
- 🔘 **Button Controls:** Move the robot using UP, DOWN, LEFT, and RIGHT buttons.
- 🛑 **Boundary Restrictions:** The robot cannot move outside the grid.
- 🎯 **Exit Condition:** Reach the exit position to complete the game.
- ⚠️ **Error Handling:** Displays friendly error messages when attempting an invalid move.

## 🛠 Technologies Used
- **Java** ☕
- **Swing (JFrame, JPanel, JButton, JTextField, JLabel)**
- **Event Handling (ActionListener, KeyListener)**
- **Exception Handling** 🚨

## 🔧 Installation
1. 📥 Clone the repository:
   ```sh
   git clone https://github.com/iamkristen/RobotMonitor.git
   ```
2. 📂 Navigate to the project directory:
   ```sh
   cd RobotMonitor
   ```
3. ⚙️ Compile the Java files:
   ```sh
   javac *.java
   ```
4. 🖥️ Run the GUI version:
   ```sh
   java RobotGUI
   ```
5. 🔲 Run the text-based version:
   ```sh
   java RunRobotText
   ```

## 🎮 How to Play
### GUI Mode 🖥️
- Click the **RIGHT, LEFT, UP, or DOWN** buttons to move the robot.
- Use **arrow keys** on the keyboard for movement.
- The robot starts at (1,1) and must reach (6,6) to exit successfully.
- If an invalid move is attempted, an error message is shown.

### Console Mode (With Colors & Emojis 🎨🤖)
- The robot's position and movement are displayed.
- Select a move by entering a number (1-6) in the terminal.

#### 🖥 Example Console Output:
```sh
[32mCURRENT ROBOT POSITION: 🤖 (Row: 2, Col: 3)[0m
[1] Move RIGHT
[2] Move LEFT
[3] Move UP
[4] Move DOWN
[5] Robot EXIT
[6] END
ENTER CHOICE: 1
Robot moved RIGHT!
```

#### 🎮 Keyboard Shortcuts (Console Mode)
- **Arrow Keys:** Move the robot in the respective direction.
- **ESC Key:** Reset the grid and restart the game.
- **6:** Exit the game.

## 🗺️ Example Grid Representation
- **Starting Grid:**
  ```
  🤖 [ ] [ ] [ ] [ ] [ ]
  [ ] [ ] [ ] [ ] [ ] [ ]
  [ ] [ ] [ ] [ ] [ ] [ ]
  [ ] [ ] [ ] [ ] [ ] [ ]
  [ ] [ ] [ ] [ ] [ ] [ ]
  [ ] [ ] [ ] [ ] [ ] 🚪
  ```
- **Win Message:**
  ```
  🎉 "You made it..." (Popup Message)
  ```
- **Error Message:**
  ```
  ❌ "MoveLeft() failed: Robot cannot move left."
  ```

## 🤝 Contributing
Want to improve the game? Feel free to fork this repository and submit pull requests for enhancements. Feature suggestions are always welcome!

## 📜 License
This project is licensed under the MIT License. See the LICENSE file for details.

## ✨ Author
**Ravi Kushwaha** - [GitHub Profile](https://github.com/iamkristen) 🚀

