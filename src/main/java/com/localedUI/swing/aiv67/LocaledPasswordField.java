package com.localedUI.swing.aiv67;

import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.text.Document;

/**
 * Локализованное поле ввода пароля.
 *
 * Created on 06.12.2015.
 *
 * @author Igor Akimov.
 */
@SuppressWarnings("unused")
public class LocaledPasswordField extends JPasswordField implements LocaledComponentWithToolTipText {
    private LocaledString toolTipText;

    /******************************************************************************
     * Конструкторы
     */

    /**
     * Конструктор по умолчанию.
     */
    public LocaledPasswordField() {
    }

    /**
     * @param text текст поля
     */
    public LocaledPasswordField(@Nullable String text) {
        super(text);
    }

    /**
     * @param text локализованная строка текста поля
     */
    public LocaledPasswordField(@Nullable LocaledString text) {
        super(LocaledString.valueOf(text));
    }

    /**
     * @param columns количество колонок в поле
     */
    public LocaledPasswordField(int columns) {
        super(columns);
    }

    /**
     * @param text    текст поля
     * @param columns количество колонок в поле
     */
    public LocaledPasswordField(@Nullable String text, int columns) {
        super(text, columns);
    }

    /**
     * @param text    локализованная строка текста поля
     * @param columns количество колонок в поле
     */
    public LocaledPasswordField(@Nullable LocaledString text, int columns) {
        super(LocaledString.valueOf(text), columns);
    }

    /**
     * @param doc     текстовый документ для использования
     * @param text    текст поля
     * @param columns количество колонок в поле
     */
    public LocaledPasswordField(Document doc, @Nullable String text, int columns) {
        super(doc, text, columns);
    }

    /**
     * @param doc     текстовый документ для использования
     * @param text    локализованная строка текста поля
     * @param columns количество колонок в поле
     */
    public LocaledPasswordField(Document doc, @Nullable LocaledString text, int columns) {
        super(doc, LocaledString.valueOf(text), columns);
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
    public void setToolTipText(@Nullable LocaledString toolTipText) {
        this.toolTipText = toolTipText;
        super.setToolTipText(LocaledString.valueOf(toolTipText));
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
    public void changeLocale() {
        setToolTipText(toolTipText);
        LocaleUtils.localeInnerComponents(this);
    }
}
