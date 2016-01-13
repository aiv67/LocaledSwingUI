package com.localedUI.swing.aiv67;

import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.text.Format;

/**
 * Локализованное форматированное поле ввода.
 *
 * @author Igor Akimov. 06.12.2015.
 */
@SuppressWarnings("unused")
public class LocaledFormattedTextField extends JFormattedTextField implements LocaledComponentWithToolTipText {
    private LocaledString toolTipText;

    /******************************************************************************
     * Конструкторы
     */

    /**
     * Конструктор по умолчанию.
     */
    public LocaledFormattedTextField() {
    }

    /**
     * @param value начальное значение текстового поля
     */
    public LocaledFormattedTextField(Object value) {
        super(value);
    }

    /**
     * @param format формат вывода
     */
    public LocaledFormattedTextField(Format format) {
        super(format);
    }

    /**
     * @param formatter объект, используемый для форматирования
     */
    public LocaledFormattedTextField(AbstractFormatter formatter) {
        super(formatter);
    }

    /**
     * @param factory фабрика, используемая для форматирования
     */
    public LocaledFormattedTextField(AbstractFormatterFactory factory) {
        super(factory);
    }

    /**
     * @param factory      фабрика, используемая для форматирования
     * @param currentValue начальное значение текстового поля
     */
    public LocaledFormattedTextField(AbstractFormatterFactory factory, Object currentValue) {
        super(factory, currentValue);
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
