package com.localedUI.swing.aiv67;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

/**
 * Локализованное диалоговое окно.
 *
 * Created on 06.12.2015.
 *
 * @author Igor Akimov.
 */
@SuppressWarnings("unused")
public class LocaledDialog extends JDialog implements LocaledComponentWithTitle {
    private LocaledString title;

    /******************************************************************************
     * Конструкторы
     */

    /**
     * Конструктор по умолчанию
     */
    public LocaledDialog() {
    }

    /**
     * @param owner родитель, из которого вызван диалог
     */
    public LocaledDialog(Frame owner) {
        super(owner);
    }

    /**
     * @param owner родитель, из которого вызван диалог
     * @param modal тип диалога, модальное окно или нет
     */
    public LocaledDialog(Frame owner, boolean modal) {
        super(owner, modal);
    }

    /**
     * @param owner    родитель, из которого вызван диалог
     * @param titleKey ключ заголовка диалога
     */
    public LocaledDialog(Frame owner, @NotNull String titleKey) {
        this(owner, titleKey, false, null);
    }

    /**
     * @param owner родитель, из которого вызван диалог
     * @param title локализованная строка заголовка диалога
     */
    public LocaledDialog(Frame owner, @Nullable LocaledString title) {
        this(owner, title, false, null);
    }

    /**
     * @param owner    родитель, из которого вызван диалог
     * @param titleKey ключ заголовка диалога
     * @param modal    тип диалога, модальное окно или нет
     */
    public LocaledDialog(Frame owner, @NotNull String titleKey, boolean modal) {
        this(owner, titleKey, modal, null);
    }

    /**
     * @param owner родитель, из которого вызван диалог
     * @param title локализованная строка заголовка диалога
     * @param modal тип диалога, модальное окно или нет
     */
    public LocaledDialog(Frame owner, @Nullable LocaledString title, boolean modal) {
        this(owner, title, modal, null);
    }

    /**
     * @param owner    родитель, из которого вызван диалог
     * @param titleKey ключ заголовка диалога
     * @param modal    тип диалога, модальное окно или нет
     * @param gc       графическая конфигурация
     */
    public LocaledDialog(Frame owner, @NotNull String titleKey, boolean modal, GraphicsConfiguration gc) {
        super(owner, "", modal, gc);
        setTitle(titleKey);
    }

    /**
     * @param owner родитель, из которого вызван диалог
     * @param title локализованная строка заголовка диалога
     * @param modal тип диалога, модальное окно или нет
     * @param gc    графическая конфигурация
     */
    public LocaledDialog(Frame owner, @Nullable LocaledString title, boolean modal, GraphicsConfiguration gc) {
        super(owner, "", modal, gc);
        setTitle(title);
    }

    /**
     * @param owner родитель, из которого вызван диалог
     */
    public LocaledDialog(Dialog owner) {
        super(owner);
    }

    /**
     * @param owner родитель, из которого вызван диалог
     * @param modal тип диалога, модальное окно или нет
     */
    public LocaledDialog(Dialog owner, boolean modal) {
        super(owner, modal);
    }

    /**
     * @param owner    родитель, из которого вызван диалог
     * @param titleKey ключ заголовка диалога
     */
    public LocaledDialog(Dialog owner, @NotNull String titleKey) {
        this(owner, titleKey, false, null);
    }

    /**
     * @param owner родитель, из которого вызван диалог
     * @param title локализованная строка заголовка диалога
     */
    public LocaledDialog(Dialog owner, @Nullable LocaledString title) {
        this(owner, title, false, null);
    }

    /**
     * @param owner    родитель, из которого вызван диалог
     * @param titleKey ключ заголовка диалога
     * @param modal    тип диалога, модальное окно или нет
     */
    public LocaledDialog(Dialog owner, @NotNull String titleKey, boolean modal) {
        this(owner, titleKey, modal, null);
    }

    /**
     * @param owner родитель, из которого вызван диалог
     * @param title локализованная строка заголовка диалога
     * @param modal тип диалога, модальное окно или нет
     */
    public LocaledDialog(Dialog owner, @Nullable LocaledString title, boolean modal) {
        this(owner, title, modal, null);
    }

    /**
     * @param owner    родитель, из которого вызван диалог
     * @param titleKey ключ заголовка диалога
     * @param modal    тип диалога, модальное окно или нет
     * @param gc       графическая конфигурация
     */
    public LocaledDialog(Dialog owner, @NotNull String titleKey, boolean modal, GraphicsConfiguration gc) {
        super(owner, "", modal, gc);
        setTitle(titleKey);
    }

    /**
     * @param owner родитель, из которого вызван диалог
     * @param title локализованная строка заголовка диалога
     * @param modal тип диалога, модальное окно или нет
     * @param gc    графическая конфигурация
     */
    public LocaledDialog(Dialog owner, @Nullable LocaledString title, boolean modal, GraphicsConfiguration gc) {
        super(owner, "", modal, gc);
        setTitle(title);
    }

    /**
     * @param owner родитель, из которого вызван диалог
     */
    public LocaledDialog(Window owner) {
        super(owner);
    }

    /**
     * @param owner        родитель, из которого вызван диалог
     * @param modalityType тип диалога, модальное окно или нет
     */
    public LocaledDialog(Window owner, ModalityType modalityType) {
        super(owner, modalityType);
    }

    /**
     * @param owner    родитель, из которого вызван диалог
     * @param titleKey ключ заголовка диалога
     */
    public LocaledDialog(Window owner, @NotNull String titleKey) {
        this(owner, titleKey, ModalityType.MODELESS, null);
    }

    /**
     * @param owner родитель, из которого вызван диалог
     * @param title локализованная строка заголовка диалога
     */
    public LocaledDialog(Window owner, @Nullable LocaledString title) {
        this(owner, title, ModalityType.MODELESS, null);
    }

    /**
     * @param owner        родитель, из которого вызван диалог
     * @param titleKey     ключ заголовка диалога
     * @param modalityType тип диалога, модальное окно или нет
     */
    public LocaledDialog(Window owner, @NotNull String titleKey, ModalityType modalityType) {
        this(owner, titleKey, modalityType, null);
    }

    /**
     * @param owner        родитель, из которого вызван диалог
     * @param title        локализованная строка заголовка диалога
     * @param modalityType тип диалога, модальное окно или нет
     */
    public LocaledDialog(Window owner, @Nullable LocaledString title, ModalityType modalityType) {
        this(owner, title, modalityType, null);
    }

    /**
     * @param owner        родитель, из которого вызван диалог
     * @param titleKey     ключ заголовка диалога
     * @param modalityType тип диалога, модальное окно или нет
     * @param gc           графическая конфигурация
     */
    public LocaledDialog(Window owner, @NotNull String titleKey, ModalityType modalityType, GraphicsConfiguration gc) {
        super(owner, "", modalityType, gc);
        setTitle(titleKey);
    }

    /**
     * @param owner        родитель, из которого вызван диалог
     * @param title        локализованная строка заголовка диалога
     * @param modalityType тип диалога, модальное окно или нет
     * @param gc           графическая конфигурация
     */
    public LocaledDialog(Window owner, @Nullable LocaledString title, ModalityType modalityType, GraphicsConfiguration gc) {
        super(owner, "", modalityType, gc);
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
