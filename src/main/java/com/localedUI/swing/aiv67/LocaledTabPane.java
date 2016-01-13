package com.localedUI.swing.aiv67;

import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

/**
 * Интерфейс локализованной панели вкладок.
 *
 * @author Igor Akimov. 07.12.2015.
 */
public interface LocaledTabPane extends LocaledComponent {
    /**
     * Установить заголовок во вкладке по ключу с параметрами.
     *
     * @param index индекс вкладки
     * @param title локализованная строка заголовка
     */
    void setTitleAt(int index, @Nullable LocaledString title);

    /**
     * Установить подсказку во вкладке по ключу с параметрами.
     *
     * @param index       индекс вкладки
     * @param toolTipText локализованная строка подсказки
     */
    void setToolTipTextAt(int index, @Nullable LocaledString toolTipText);

    /**
     * Вставить вкладку в позицию.
     *
     * @param title       локализованная строка заголовка
     * @param icon        иконка
     * @param component   компонент во вкладке
     * @param toolTipText локализованная строка посказки
     * @param index       позиция вставки
     */
    void insertTab(@Nullable LocaledString title, Icon icon, Component component, @Nullable LocaledString toolTipText, int index);

    /**
     * Добавить вкладку в конце.
     *
     * @param title       локализованная строка заголовка
     * @param icon        иконка
     * @param component   компонент во вкладке
     * @param toolTipText локализованная строка посказки
     */
    void addTab(@Nullable LocaledString title, Icon icon, Component component, @Nullable LocaledString toolTipText);

    /**
     * Добавить вкладку в конце.
     *
     * @param title     локализованная строка заголовка
     * @param icon      иконка
     * @param component компонент во вкладке
     */
    void addTab(@Nullable LocaledString title, Icon icon, Component component);

    /**
     * Добавить вкладку в конце.
     *
     * @param title     локализованная строка заголовка
     * @param component компонент во вкладке
     */
    void addTab(@Nullable LocaledString title, Component component);

    /**
     * Добавить компонент.
     *
     * @param title     локализованная строка заголовка
     * @param component компонент во вкладке
     * @return компонент
     */
    Component add(@Nullable LocaledString title, Component component);

    /**
     * Позиция вкладки по заголовку.
     *
     * @param title локализованная строка заголовка
     * @return позиция вкладки
     */
    int indexOfTab(@Nullable LocaledString title);
}
