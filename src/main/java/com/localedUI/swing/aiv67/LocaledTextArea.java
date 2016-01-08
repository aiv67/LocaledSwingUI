package com.localedUI.swing.aiv67;

import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.text.Document;

/**
 * Локализованная текстовая область.
 *
 * Created on 06.12.2015.
 *
 * @author Igor Akimov.
 */
@SuppressWarnings("unused")
public class LocaledTextArea extends JTextArea implements LocaledComponentWithToolTipText {
    private LocaledString toolTipText;

    /******************************************************************************
     * Конструкторы
     */

    /**
     * Конструктор по умолчанию.
     */
    public LocaledTextArea() {
    }

    /**
     * @param text текст поля
     */
    public LocaledTextArea(@Nullable String text) {
        super(text);
    }

    /**
     * @param text локализованная строка текста поля
     */
    public LocaledTextArea(@Nullable LocaledString text) {
        super(LocaledString.valueOf(text));
    }

    /**
     * @param rows    количество строк в поле
     * @param columns количество колонок в поле
     */
    public LocaledTextArea(int rows, int columns) {
        super(rows, columns);
    }

    /**
     * @param text    текст поля
     * @param rows    количество строк в поле
     * @param columns количество колонок в поле
     */
    public LocaledTextArea(@Nullable String text, int rows, int columns) {
        super(text, rows, columns);
    }

    /**
     * @param text    локализованная строка текста поля
     * @param rows    количество строк в поле
     * @param columns количество колонок в поле
     */
    public LocaledTextArea(@Nullable LocaledString text, int rows, int columns) {
        super(LocaledString.valueOf(text), rows, columns);
    }

    /**
     * @param doc текстовый документ для использования
     */
    public LocaledTextArea(Document doc) {
        super(doc);
    }

    /**
     * @param doc     текстовый документ для использования
     * @param text    текст поля
     * @param rows    количество строк в поле
     * @param columns количество колонок в поле
     */
    public LocaledTextArea(Document doc, @Nullable String text, int rows, int columns) {
        super(doc, text, rows, columns);
    }

    /**
     * @param doc     текстовый документ для использования
     * @param text    локализованная строка текста поля
     * @param rows    количество строк в поле
     * @param columns количество колонок в поле
     */
    public LocaledTextArea(Document doc, @Nullable LocaledString text, int rows, int columns) {
        super(doc, LocaledString.valueOf(text), rows, columns);
    }

    /******************************************************************************
     * Переопределенные методы родительских классов
     */

    @Nullable
    @Override
    public LocaledString getLocaledToolTipText() {
        return toolTipText;
    }

    @Nullable
    @Override
    public String getToolTipText() {
        return super.getToolTipText();
    }

    @Override
    public void setToolTipText(@Nullable String toolTipTextKey) {
        if (LocaleUtils.isEmpty(toolTipTextKey)) {
            toolTipText = null;
            super.setToolTipText("");
        } else {
            toolTipText = toolTipText == null ? new LocaledString(toolTipTextKey) : toolTipText.setKey(toolTipTextKey);
            super.setToolTipText(LocaledString.valueOf(toolTipText));
        }
    }

    @Override
    public void setToolTipText(@Nullable LocaledString toolTipText) {
        this.toolTipText = toolTipText;
        super.setToolTipText(LocaledString.valueOf(toolTipText));
    }

    @Override
    public void changeLocale() {
        setToolTipText(toolTipText);
        LocaleUtils.localeInnerComponents(this);
    }
}
