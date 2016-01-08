package com.localedUI.swing.aiv67;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Локализованная кнопка.
 *
 * Created on 06.12.2015.
 *
 * @author Igor Akimov.
 */
@SuppressWarnings("unused")
public class LocaledButton extends JButton implements LocaledComponentWithText, LocaledComponentWithToolTipText {
    private LocaledString text;
    private LocaledString toolTipText;

    /******************************************************************************
     * Конструкторы
     */

    /**
     * Конструктор по умолчанию
     */
    public LocaledButton() {
    }

    /**
     * @param icon картинка на кнопке
     */
    public LocaledButton(Icon icon) {
        super(icon);
    }

    /**
     * @param textKey ключ текста кнопки
     */
    public LocaledButton(@NotNull String textKey) {
        this(new LocaledString(textKey));
    }

    /**
     * @param text локализованная строка текста кнопки
     */
    public LocaledButton(@Nullable LocaledString text) {
        super();
        setText(text);
    }

    /**
     * @param a действие кнопки
     */
    public LocaledButton(Action a) {
        super(a);
    }

    /**
     * @param textKey ключ текста кнопки
     * @param icon    картинка на кнопке
     */
    public LocaledButton(@NotNull String textKey, Icon icon) {
        this(new LocaledString(textKey), icon);
    }

    /**
     * @param text локализованная строка текста кнопки
     * @param icon картинка на кнопке
     */
    public LocaledButton(@Nullable LocaledString text, Icon icon) {
        super(icon);
        setText(text);
    }

    /******************************************************************************
     * Переопределенные методы родительских классов
     */

    @Override
    @Nullable
    public LocaledString getLocaledText() {
        return text;
    }

    @Override
    @Nullable
    public String getText() {
        return super.getText();
    }

    @Override
    public void setText(@Nullable LocaledString text) {
        this.text = text;
        super.setText(LocaledString.valueOf(text));
    }

    @Override
    public void setText(@Nullable String textKey) {
        if (LocaleUtils.isEmpty(textKey)) {
            super.setText("");
        } else {
            text = text == null ? new LocaledString(textKey) : text.setKey(textKey);
            super.setText(LocaledString.valueOf(text));
        }
    }

    @Override
    @Nullable
    public LocaledString getLocaledToolTipText() {
        return toolTipText;
    }

    @Override
    @Nullable
    public String getToolTipText() {
        return super.getToolTipText();
    }

    @Override
    public void setToolTipText(String toolTipTextKey) {
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
        setText(text);
        setToolTipText(toolTipText);
        LocaleUtils.localeInnerComponents(this);
    }
}
