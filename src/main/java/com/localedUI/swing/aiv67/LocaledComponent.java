package com.localedUI.swing.aiv67;

/**
 * Интерфейс для локализованных компонентов графического интерфейса.
 *
 * @author Igor Akimov. 02.12.2015.
 */
public interface LocaledComponent {
    /**
     * Изменить язык интерфейса.
     * Компонент, реализующий данный интерфейс должен уметь менять текстовые значения,
     * отображаемые пользователю на локализованные.
     */
    void changeLocale();
}
