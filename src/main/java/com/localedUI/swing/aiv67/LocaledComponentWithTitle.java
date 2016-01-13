package com.localedUI.swing.aiv67;

import org.jetbrains.annotations.Nullable;

/**
 * Интерфейс компонента с заголовком.
 *
 * @author Igor Akimov. 02.12.2015.
 */
public interface LocaledComponentWithTitle extends LocaledComponent {
    /**
     * Получить заголовок компонента.
     *
     * @return локализованная строка заголовка компонента
     */
    @Nullable
    LocaledString getLocaledTitle();

    /**
     * Установить заголовок компонента.
     *
     * @param title локализованная строка заголовка компонента
     */
    void setTitle(@Nullable LocaledString title);
}
