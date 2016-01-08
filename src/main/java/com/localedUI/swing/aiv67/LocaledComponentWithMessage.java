package com.localedUI.swing.aiv67;

import org.jetbrains.annotations.Nullable;

/**
 * Интерфейс компонента с сообщением.
 *
 * Created on 06.12.2015.
 *
 * @author Igor Akimov.
 */
public interface LocaledComponentWithMessage extends LocaledComponent {
    /**
     * Получить текст сообщения компонента.
     *
     * @return локализованная строка текста сообщения компонента
     */
    @Nullable
    LocaledString getLocaledMessage();

    /**
     * Установить текст сообщения компонента.
     *
     * @param message локализованная строка текста сообщения компонента
     */
    void setLocaledMessage(@Nullable LocaledString message);
}
