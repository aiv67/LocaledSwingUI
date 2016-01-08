package com.localedUI.swing.aiv67;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Локализованное меню.
 *
 * Created on 06.12.2015.
 *
 * @author Igor Akimov.
 */
@SuppressWarnings("unused")
public class LocaledMenu extends JMenu implements LocaledComponentWithText, LocaledComponentWithToolTipText {
    private LocaledString text;
    private LocaledString toolTipText;

    /******************************************************************************
     * Конструкторы
     */

    /**
     * Конструктор по умолчанию.
     */
    public LocaledMenu() {
    }

    /**
     * @param textKey ключ текста меню
     */
    public LocaledMenu(@NotNull String textKey) {
        this(new LocaledString(textKey));
    }

    /**
     * @param text локализованная строка текста меню
     */
    public LocaledMenu(@Nullable LocaledString text) {
        super(LocaledString.valueOf(text));
        this.text = text;
    }

    /**
     * @param a the action of the <code>JMenuItem</code>
     */
    public LocaledMenu(Action a) {
        super(a);
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
        LocaleUtils.localeInnerMenus(this);
    }
}
