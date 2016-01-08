package com.localedUI.swing.aiv67;

import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.text.StyledDocument;

/**
 * Локализаванная текстовая область (панель).
 *
 * Created on 03.01.2016.
 *
 * @author Igor Akimov.
 */
@SuppressWarnings("unused")
public class LocaledTextPane extends JTextPane implements LocaledComponentWithToolTipText {
    private LocaledString toolTipText;

    /******************************************************************************
     * Конструкторы
     */

    /**
     * Конструктор по умолчанию.
     */
    public LocaledTextPane() {
    }

    /**
     * Конструктор с заданной моделью документа.
     *
     * @param doc модель документа
     */
    public LocaledTextPane(StyledDocument doc) {
        super(doc);
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
