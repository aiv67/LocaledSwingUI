package com.localedUI.swing.aiv67;

import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

/**
 * Локализованная панель.
 *
 * @author Igor Akimov. 06.12.2015.
 */
@SuppressWarnings("unused")
public class LocaledPanel extends JPanel implements LocaledComponentWithToolTipText {
    private LocaledString toolTipText;

    /******************************************************************************
     * Конструкторы
     */

    /**
     * Конструктор по умолчанию.
     */
    public LocaledPanel() {
    }

    /**
     * @param layout           используемый менеджер раскладки
     * @param isDoubleBuffered true, если используется двойная буферизация для ускорения работы
     */
    public LocaledPanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    /**
     * @param layout используемый менеджер раскладки
     */
    public LocaledPanel(LayoutManager layout) {
        super(layout);
    }

    /**
     * @param isDoubleBuffered true, если используется двойная буферизация для ускорения работы
     */
    public LocaledPanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
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
