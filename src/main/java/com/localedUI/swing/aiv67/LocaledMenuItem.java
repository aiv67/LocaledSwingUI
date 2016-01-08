package com.localedUI.swing.aiv67;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Локализованный пункт меню.
 *
 * Created on 06.12.2015.
 *
 * @author Igor Akimov.
 */
@SuppressWarnings("unused")
public class LocaledMenuItem extends JMenuItem implements LocaledComponentWithText, LocaledComponentWithToolTipText {
    private LocaledString text;
    private LocaledString toolTipText;

    /******************************************************************************
     * Конструкторы
     */

    /**
     * Конструктор по умолчанию
     */
    public LocaledMenuItem() {
    }

    /**
     * @param icon картинка меню
     */
    public LocaledMenuItem(Icon icon) {
        super(icon);
    }

    /**
     * @param textKey ключ текста меню
     */
    public LocaledMenuItem(@NotNull String textKey) {
        this(new LocaledString(textKey));
    }

    /**
     * @param text локализованная строка текста меню
     */
    public LocaledMenuItem(@Nullable LocaledString text) {
        super(LocaledString.valueOf(text));
        this.text = text;
    }

    /**
     * @param a the action of the <code>JMenuItem</code>
     */
    public LocaledMenuItem(Action a) {
        super(a);
    }

    /**
     * @param textKey ключ текста меню
     * @param icon    картинка меню
     */
    public LocaledMenuItem(@NotNull String textKey, Icon icon) {
        this(new LocaledString(textKey), icon);
    }

    /**
     * @param text локализованная строка текста меню
     * @param icon картинка меню
     */
    public LocaledMenuItem(@Nullable LocaledString text, Icon icon) {
        super(LocaledString.valueOf(text), icon);
        this.text = text;
    }

    /**
     * @param textKey  ключ текста меню
     * @param mnemonic the keyboard mnemonic for the <code>JMenuItem</code>
     */
    public LocaledMenuItem(@NotNull String textKey, int mnemonic) {
        this(new LocaledString(textKey), mnemonic);
    }

    /**
     * @param text     локализованная строка текста меню
     * @param mnemonic the keyboard mnemonic for the <code>JMenuItem</code>
     */
    public LocaledMenuItem(@Nullable LocaledString text, int mnemonic) {
        super(LocaledString.valueOf(text), mnemonic);
        this.text = text;
    }

    /******************************************************************************
     * Переопределенные методы родительских классов
     */

    @Nullable
    @Override
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
        setText(text);
        setToolTipText(toolTipText);
        LocaleUtils.localeInnerComponents(this);
    }
}
