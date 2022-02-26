import javax.swing.*;

class Window {
    JFrame window;

    Window() {
        window = new JFrame();
    }

    void setVisible() {
        window.setSize(400, 800); 
        window.setLayout(null); 
        window.setVisible(true);
    }
}

class Components {
    void attachStudent(int i, String name, String age, String address, Window window) {
        // Name
        JLabel labelName = new JLabel("Name: ");
        labelName.setBounds(50, 50 + i * 300, 100, 20);

        JTextField textFieldName = new JTextField(name);
        textFieldName.setBounds(100, 50 + i * 300, 200, 20);
        textFieldName.setEditable(false);

        // Age
        JLabel labelAge = new JLabel("Age: ");
        labelAge.setBounds(50, 100 + i * 300, 100, 20);

        JTextField textFieldAge = new JTextField(age);
        textFieldAge.setBounds(100, 100 + i * 300, 200, 20);
        textFieldAge.setEditable(false);

        // Address
        JLabel labelAddress = new JLabel("Adress: ");
        labelAddress.setBounds(50, 150 + i * 300, 100, 20);

        JTextField textFieldAddress = new JTextField(address);
        textFieldAddress.setBounds(100, 150 + i * 300, 200, 120);

        window.window.add(labelName);
        window.window.add(textFieldName);
        window.window.add(labelAge);
        window.window.add(textFieldAge);
        window.window.add(labelAddress);
        window.window.add(textFieldAddress);    
    }
}

public class Assignment2 {
    public static void main(String[] args) {
        Window window = new Window();
        Components components[] = new Components[2];

        for (int i = 0; i < 2; i++) {
            components[i] = new Components();
            components[i].attachStudent(i, "Vivek", "20", "Changanacherry Kaviyoor Rd", window);
        }

        window.setVisible();
    }
}
