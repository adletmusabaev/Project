package Assignment5.Controller;

import Assignment5.Model.CalculatorModel;
import Assignment5.View.CalculatorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public  class CalculatorController {
    private final CalculatorModel model; // Объект модели для выполнения вычислений
    private final CalculatorView view; // Объект представления для взаимодействия с интерфейсом

    // Конструктор для связи модели и представления и добавления слушателя событий
    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
        view.addOperationListener(new OperationHandler()); // Добавление слушателя для операций
    }

    // Внутренний класс для обработки событий от кнопок
    private class OperationHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Получение чисел из представления
                double num1 = view.getFirstNumber();
                double num2 = view.getSecondNumber();
                double result = 0;

                // Проверка, какая кнопка нажата, и выполнение соответствующей операции
                if (e.getSource() == view.getAddButton()) {
                    result = model.add(num1, num2);
                } else if (e.getSource() == view.getSubtractButton()) {
                    result = model.subtract(num1, num2);
                } else if (e.getSource() == view.getMultiplyButton()) {
                    result = model.multiply(num1, num2);
                } else if (e.getSource() == view.getDivideButton()) {
                    result = model.divide(num1, num2);
                }

                // Отправка результата на отображение
                view.setResult(String.valueOf(result));
            } catch (ArithmeticException ex) {
                // Обработка ошибки деления на ноль
                view.setResult(ex.getMessage());
            } catch (NumberFormatException ex) {
                // Обработка ошибки некорректного ввода числа
                view.setResult("Ошибка: неверный ввод числа");
            }
        }
    }
}