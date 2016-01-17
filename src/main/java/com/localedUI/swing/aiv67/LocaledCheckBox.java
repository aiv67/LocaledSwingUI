package com.localedUI.swing.aiv67;

import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Локализованный флажок.
 *
 * @author Igor Akimov. 17.01.2016.
 */
@SuppressWarnings("unused")
public class LocaledCheckBox extends JCheckBox implements LocaledComponentWithText, LocaledComponentWithToolTipText {
    private LocaledString text;
    private LocaledString toolTipText;

    /******************************************************************************
     * Конструкторы
     */

    /**
     * Конструктор по умолчанию
     */
    public LocaledCheckBox() {
    }

    /**
     * @param icon картинка на флажке
     */
    public LocaledCheckBox(Icon icon) {
        super(icon);
    }

    /**
     * @param icon картинка на флажке
     * @param selected true - флажок установлен, false - снят
     */
    public LocaledCheckBox(Icon icon, boolean selected) {
        super(icon, selected);
    }

    /**
     * @param textKey ключ текста флажка
     */
    public LocaledCheckBox(String textKey) {
        this(new LocaledString(textKey));
    }

    /**
     * @param text локализованная строка текста флажка
     */
    public LocaledCheckBox(LocaledString text) {
        super();
        setText(text);
    }

    /**
     * @param a действие флажка
     */
    public LocaledCheckBox(Action a) {
        super(a);
    }

    /**
     * @param textKey ключ текста флажка
     * @param selected true - флажок установлен, false - снят
     */
    public LocaledCheckBox(String textKey, boolean selected) {
        this(new LocaledString(textKey), selected);
    }

    /**
     * @param text локализованная строка текста флажка
     * @param selected true - флажок установлен, false - снят
     */
    public LocaledCheckBox(LocaledString text, boolean selected) {
        super("", selected);
        setText(text);
    }

    /**
     * @param textKey ключ текста флажка
     * @param icon картинка на флажке
     */
    public LocaledCheckBox(String textKey, Icon icon) {
        this(new LocaledString(textKey), icon);
    }

    /**
     * @param text локализованная строка текста флажка
     * @param icon картинка на флажке
     */
    public LocaledCheckBox(LocaledString text, Icon icon) {
        super(icon);
        setText(text);
    }

    /**
     * @param textKey ключ текста флажка
     * @param icon картинка на флажке
     * @param selected true - флажок установлен, false - снят
     */
    public LocaledCheckBox(String textKey, Icon icon, boolean selected) {
        this(new LocaledString(textKey), icon, selected);
    }

    /**
     * @param text локализованная строка текста флажка
     * @param icon картинка на флажке
     * @param selected true - флажок установлен, false - снят
     */
    public LocaledCheckBox(LocaledString text, Icon icon, boolean selected) {
        super(icon, selected);
        setText(text);
    }

    /******************************************************************************
     * Переопределенные методы родительских классов
     */

    @Nullable
    @Override
    public LocaledString getLocaledText() {
        return text;
    }

    @Override
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

    @Nullable
    @Override
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
