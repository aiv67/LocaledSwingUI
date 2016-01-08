package com.localedUI.swing.aiv67;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Локализованная рамка с заголовком.
 *
 * Created on 03.12.2015.
 *
 * @author Igor Akimov.
 */
@SuppressWarnings("unused")
public class LocaledTitledBorder extends TitledBorder implements LocaledBorder, LocaledComponentWithTitle {
    private LocaledString title;

    /******************************************************************************
     * Конструкторы
     */

    /**
     * @param titleKey ключ строки заголовка
     */
    public LocaledTitledBorder(@NotNull String titleKey) {
        this(null, titleKey, LEADING, DEFAULT_POSITION, null, null);
    }

    /**
     * @param title локализованная строка заголовка
     */
    public LocaledTitledBorder(@Nullable LocaledString title) {
        this(null, title, LEADING, DEFAULT_POSITION, null, null);
    }

    /**
     * @param border рамка, на основе которой создается эта рамка
     */
    public LocaledTitledBorder(Border border) {
        super(border);
    }

    /**
     * @param border   рамка, на основе которой создается эта рамка
     * @param titleKey ключ строки заголовка
     */
    public LocaledTitledBorder(Border border, @NotNull String titleKey) {
        this(border, titleKey, LEADING, DEFAULT_POSITION, null, null);
    }

    /**
     * @param border рамка, на основе которой создается эта рамка
     * @param title  локализованная строка заголовка
     */
    public LocaledTitledBorder(Border border, @Nullable LocaledString title) {
        this(border, title, LEADING, DEFAULT_POSITION, null, null);
    }

    /**
     * @param border             рамка, на основе которой создается эта рамка
     * @param titleKey           ключ строки заголовка
     * @param titleJustification выравнивание заголовка
     * @param titlePosition      позиция заголовка
     */
    public LocaledTitledBorder(Border border, @NotNull String titleKey, int titleJustification, int titlePosition) {
        this(border, titleKey, titleJustification, titlePosition, null, null);
    }

    /**
     * @param border             рамка, на основе которой создается эта рамка
     * @param title              локализованная строка заголовка
     * @param titleJustification выравнивание заголовка
     * @param titlePosition      позиция заголовка
     */
    public LocaledTitledBorder(Border border, @Nullable LocaledString title, int titleJustification, int titlePosition) {
        this(border, title, titleJustification, titlePosition, null, null);
    }

    /**
     * @param border             рамка, на основе которой создается эта рамка
     * @param titleKey           ключ строки заголовка
     * @param titleJustification выравнивание заголовка
     * @param titlePosition      позиция заголовка
     * @param titleFont          шрифт заголовка
     */
    public LocaledTitledBorder(Border border, @NotNull String titleKey, int titleJustification, int titlePosition, @Nullable Font titleFont) {
        this(border, titleKey, titleJustification, titlePosition, titleFont, null);
    }

    /**
     * @param border             рамка, на основе которой создается эта рамка
     * @param title              локализованная строка заголовка
     * @param titleJustification выравнивание заголовка
     * @param titlePosition      позиция заголовка
     * @param titleFont          шрифт заголовка
     */
    public LocaledTitledBorder(Border border, @Nullable LocaledString title, int titleJustification, int titlePosition, @Nullable Font titleFont) {
        this(border, title, titleJustification, titlePosition, titleFont, null);
    }

    /**
     * @param border             рамка, на основе которой создается эта рамка
     * @param titleKey           ключ строки заголовка
     * @param titleJustification выравнивание заголовка
     * @param titlePosition      позиция заголовка
     * @param titleFont          шрифт заголовка
     * @param titleColor         цвет заголовка
     */
    public LocaledTitledBorder(Border border, @NotNull String titleKey, int titleJustification, int titlePosition, @Nullable Font titleFont,
                               @Nullable Color titleColor) {
        super(border, "", titleJustification, titlePosition, titleFont, titleColor);
        setTitle(titleKey);
    }

    /**
     * @param border             рамка, на основе которой создается эта рамка
     * @param title              локализованная строка заголовка
     * @param titleJustification выравнивание заголовка
     * @param titlePosition      позиция заголовка
     * @param titleFont          шрифт заголовка
     * @param titleColor         цвет заголовка
     */
    public LocaledTitledBorder(Border border, @Nullable LocaledString title, int titleJustification, int titlePosition, @Nullable Font titleFont,
                               @Nullable Color titleColor) {
        super(border, "", titleJustification, titlePosition, titleFont, titleColor);
        setTitle(title);
    }

    /******************************************************************************
     * Переопределенные методы родительских классов
     */

    @Override
    @Nullable
    public LocaledString getLocaledTitle() {
        return title;
    }

    @Override
    @Nullable
    public String getTitle() {
        return super.getTitle();
    }

    @Override
    public void setTitle(@Nullable String titleKey) {
        if (LocaleUtils.isEmpty(titleKey)) {
            title = null;
            super.setTitle("");
        } else {
            title = title == null ? new LocaledString(titleKey) : title.setKey(titleKey);
            super.setTitle(LocaledString.valueOf(title));
        }
    }

    @Override
    public void setTitle(@Nullable LocaledString title) {
        this.title = title;
        super.setTitle(LocaledString.valueOf(title));
    }

    @Override
    public void changeLocale() {
        setTitle(title);
        LocaleUtils.localeBorder(this.getBorder());
    }
}
