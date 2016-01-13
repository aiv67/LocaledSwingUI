package com.localedUI.swing.aiv67;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Локализованная текстовая метка.
 *
 * @author Igor Akimov. 06.12.2015.
 */
@SuppressWarnings("unused")
public class LocaledLabel extends JLabel implements LocaledComponentWithText, LocaledComponentWithToolTipText {
    private LocaledString text;
    private LocaledString toolTipText;

    /******************************************************************************
     * Конструкторы
     */

    /**
     * Конструктор по умолчанию.
     */
    public LocaledLabel() {
    }

    /**
     * @param textKey ключ текста на метке
     */
    public LocaledLabel(@NotNull String textKey) {
        this(textKey, null, LEADING);
    }

    /**
     * @param text локализованная строка текста метки
     */
    public LocaledLabel(@Nullable LocaledString text) {
        this(text, null, LEADING);
    }

    /**
     * @param image картинка на метке
     */
    public LocaledLabel(Icon image) {
        super(image);
    }

    /**
     * @param textKey             ключ текста на метке
     * @param horizontalAlignment горизонтальное выравнивание
     */
    public LocaledLabel(@NotNull String textKey, int horizontalAlignment) {
        this(textKey, null, horizontalAlignment);
    }

    /**
     * @param text                локализованная строка текста метки
     * @param horizontalAlignment горизонтальное выравнивание
     */
    public LocaledLabel(@Nullable LocaledString text, int horizontalAlignment) {
        this(text, null, horizontalAlignment);
    }

    /**
     * @param image               картинка на метке
     * @param horizontalAlignment горизонтальное выравнивание
     */
    public LocaledLabel(Icon image, int horizontalAlignment) {
        super(image, horizontalAlignment);
    }

    /**
     * @param textKey             ключ текста на метке
     * @param icon                картинка на метке
     * @param horizontalAlignment горизонтальное выравнивание
     */
    public LocaledLabel(@NotNull String textKey, Icon icon, int horizontalAlignment) {
        super(null, icon, horizontalAlignment);
        setText(textKey);
    }

    /**
     * @param text                локализованная строка текста метки
     * @param icon                картинка на метке
     * @param horizontalAlignment горизонтальное выравнивание
     */
    public LocaledLabel(@Nullable LocaledString text, Icon icon, int horizontalAlignment) {
        super(null, icon, horizontalAlignment);
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

    @Nullable
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

    @Override
    @Nullable
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
            super.setToolTipText("");
        } else {
            toolTipText = toolTipText == null ? new LocaledString(toolTipTextKey) : text.setKey(toolTipTextKey);
            super.setToolTipText(LocaledString.valueOf(toolTipText));
        }
    }

    @Override
    public void changeLocale() {
        setText(text);
        setToolTipText(toolTipText);
        LocaleUtils.localeInnerComponents(this);
    }

    /**
     * Отобразить многострочную метку.
     * Многострочная метка отображает текст, содержащий теги <html></html> и <br/> для переноса строк.
     *
     * @param multilineText многострочный текст
     */
    protected void setMultilineText(@Nullable String multilineText) {
        super.setText(multilineText);
    }
}
