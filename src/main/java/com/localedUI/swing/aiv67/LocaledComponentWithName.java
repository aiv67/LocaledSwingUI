package com.localedUI.swing.aiv67;

import org.jetbrains.annotations.Nullable;

/**
 * Интерфейс компонента с названием.
 *
 * @author Igor Akimov. 06.12.2015.
 */
public interface LocaledComponentWithName extends LocaledComponent {
    /**
     * Получить название компонента.
     *
     * @return локализованная строка названия компонента
     */
    @Nullable
    LocaledString getLocaledName();

    /**
     * Установить название компонента.
     *
     * @param name локализованная строка названия компонента
     */
    void setName(@Nullable LocaledString name);
}
