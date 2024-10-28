package Assignment5.View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {
    private final JTextField firstNumber = new JTextField(10); // Поле ввода для первого числа
    private final JTextField secondNumber = new JTextField(10); // Поле ввода для второго числа
    private final JLabel resultLabel = new JLabel("Результат:"); // Метка для отображения результата
    private final JButton addButton = new JButton("+"); // Кнопка сложения
    private final JButton subtractButton = new JButton("-"); // Кнопка вычитания
    private final JButton multiplyButton = new JButton("*"); // Кнопка умножения
    private final JButton divideButton = new JButton("/"); // Кнопка деления


    // Конструктор для создания интерфейса
    public CalculatorView() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2)); // Сетка 3x2 для полей и меток
        panel.add(new JLabel("Первое число:"));
        panel.add(firstNumber);
        panel.add(new JLabel("Второе число:"));
        panel.add(secondNumber);
        panel.add(resultLabel); // Панель с полями и метками

        JPanel buttonPanel = new JPanel(); // Панель для кнопок
        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Закрытие программы при выходе
        this.setSize(400, 150); // Установка размера окна
        this.add(panel, BorderLayout.CENTER); // Добавление основной панели
        this.add(buttonPanel, BorderLayout.SOUTH); // Добавление панели кнопок
    }

    // Получение первого числа из текстового поля
    public double getFirstNumber() {
        return Double.parseDouble(firstNumber.getText());
    }

    // Получение второго числа из текстового поля
    public double getSecondNumber() {
        return Double.parseDouble(secondNumber.getText());
    }

    // Метод для отображения результата в метке
    public void setResult(String result) {
        resultLabel.setText("Результат: " + result);
    }

    // Регистрация слушателя событий для всех кнопок операций
    public void addOperationListener(ActionListener listener) {
        addButton.addActionListener(listener);
        subtractButton.addActionListener(listener);
        multiplyButton.addActionListener(listener);
        divideButton.addActionListener(listener);
    }

    // Методы для получения кнопок, чтобы контроллер мог идентифицировать нажатие
    public JButton getAddButton() { return addButton; }
    public JButton getSubtractButton() { return subtractButton; }
    public JButton getMultiplyButton() { return multiplyButton; }
    public JButton getDivideButton() { return divideButton; }
}