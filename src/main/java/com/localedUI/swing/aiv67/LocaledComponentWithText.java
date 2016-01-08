package com.localedUI.swing.aiv67;

import org.jetbrains.annotations.Nullable;

/**
 * Интерфейс компонента с текстом.
 *
 * Created on 02.12.2015.
 *
 * @author Igor Akimov.
 */
public interface LocaledComponentWithText extends LocaledComponent {
    /**
     * Получить текст компонента.
     *
     * @return локализованная строка текста компонента
     */
    @Nullable
    LocaledString getLocaledText();

    /**
     * Установить текст компонента.
     *
     * @param text локализованная строка текста компонента
     */
    void setText(@Nullable LocaledString text);
}
