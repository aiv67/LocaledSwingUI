package com.localedUI.swing.aiv67;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

/**
 * Локализованное окно.
 *
 * @author Igor Akimov. 02.12.2015.
 */
@SuppressWarnings("unused")
public class LocaledFrame extends JFrame implements LocaledComponentWithTitle {
    private LocaledString title;

    /******************************************************************************
     * Конструкторы
     */

    /**
     * Конструктор по умолчанию.
     *
     * @throws HeadlessException
     */
    public LocaledFrame() throws HeadlessException {
    }

    /**
     * @param titleKey ключ заголовка окна
     * @throws HeadlessException
     */
    public LocaledFrame(@NotNull String titleKey) throws HeadlessException {
        super();
        setTitle(titleKey);
    }

    /**
     * @param title локализованная строка заголовка окна
     * @throws HeadlessException
     */
    public LocaledFrame(@Nullable LocaledString title) throws HeadlessException {
        super();
        setTitle(title);
    }

    /**
     * @param gc графическая конфигурация
     * @see GraphicsConfiguration
     */
    public LocaledFrame(@Nullable GraphicsConfiguration gc) {
        super(gc);
    }

    /**
     * @param titleKey ключ заголовка окна
     * @param gc       графическая конфигурация
     * @see GraphicsConfiguration
     */
    public LocaledFrame(@NotNull String titleKey, @Nullable GraphicsConfiguration gc) {
        super(gc);
        setTitle(titleKey);
    }

    /**
     * @param title локализованная строка заголовка окна
     * @param gc    графическая конфигурация
     * @see GraphicsConfiguration
     */
    public LocaledFrame(@Nullable LocaledString title, @Nullable GraphicsConfiguration gc) {
        super(gc);
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
        LocaleUtils.localeInnerComponents(this);
    }
}
