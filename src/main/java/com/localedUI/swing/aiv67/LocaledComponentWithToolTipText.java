package com.localedUI.swing.aiv67;

import org.jetbrains.annotations.Nullable;

/**
 * Интерфейс компонента с подсказкой.
 *
 * Created on 06.12.2015.
 *
 * @author Igor Akimov.
 */
public interface LocaledComponentWithToolTipText extends LocaledComponent {
    /**
     * Получить текст подсказки компонента.
     *
     * @return локализованная строка текста подсказки компонента
     */
    @Nullable
    LocaledString getLocaledToolTipText();

    /**
     * Установить текст подсказки компонента.
     *
     * @param toolTipText локализованная строка текста подсказки компонента
     */
    void setToolTipText(@Nullable LocaledString toolTipText);
}
