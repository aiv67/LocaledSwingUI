package com.localedUI.swing.aiv67;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Локализованная панель инструментов.
 *
 * @author Igor Akimov. 06.12.2015.
 */
@SuppressWarnings("unused")
public class LocaledToolBar extends JToolBar implements LocaledComponentWithName {
    private LocaledString name;

    /******************************************************************************
     * Конструкторы
     */

    /**
     * Конструктор по умолчанию.
     */
    public LocaledToolBar() {
    }

    /**
     * @param orientation направление панели
     */
    public LocaledToolBar(int orientation) {
        super(orientation);
    }

    /**
     * @param nameKey ключ названия панели инструментов
     */
    public LocaledToolBar(@NotNull String nameKey) {
        this(nameKey, HORIZONTAL);
    }

    /**
     * @param name локализованная строка названия панели инструментов
     */
    public LocaledToolBar(@Nullable LocaledString name) {
        this(name, HORIZONTAL);
    }

    /**
     * @param nameKey     ключ названия панели инструментов
     * @param orientation направление панели
     */
    public LocaledToolBar(@NotNull String nameKey, int orientation) {
        super(null, orientation);
        setName(nameKey);
    }

    /**
     * @param name        локализованная строка названия панели инструментов
     * @param orientation направление панели
     */
    public LocaledToolBar(@Nullable LocaledString name, int orientation) {
        super(null, orientation);
        setName(name);
    }

    /******************************************************************************
     * Переопределенные методы родительских классов
     */

    @Nullable
    @Override
    public LocaledString getLocaledName() {
        return name;
    }

    @Nullable
    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(@Nullable LocaledString name) {
        this.name = name;
        super.setName(LocaledString.valueOf(name));
    }

    @Override
    public void setName(@Nullable String nameKey) {
        if (LocaleUtils.isEmpty(nameKey)) {
            name = null;
            super.setName("");
        } else {
            name = name == null ? new LocaledString(nameKey) : name.setKey(nameKey);
            super.setName(LocaledString.valueOf(name));
        }
    }

    @Override
    public void changeLocale() {
        setName(name);
        LocaleUtils.localeInnerComponents(this);
    }
}
