package Assignment5.Main;

import Assignment5.Controller.CalculatorController;
import Assignment5.Model.CalculatorModel;
import Assignment5.View.CalculatorView;
import javax.swing.SwingUtilities;

public class CalculatorApp {
    public static void main(String[] args) {
        // Создание и запуск приложения в потоке диспетчеризации событий Swing
        SwingUtilities.invokeLater(() -> {
            CalculatorModel model = new CalculatorModel(); // Инициализация модели
            CalculatorView view = new CalculatorView(); // Инициализация представления
            new CalculatorController(model, view); // Связывание контроллера с моделью и представлением
            view.setVisible(true); // Отображение интерфейса
        });
    }
}