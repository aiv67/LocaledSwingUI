package com.localedUI.swing.aiv67;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Локализованная многострочная текстовая метка.
 * Текст в метке форматируется html разметкой, которая задается в html шаблоне.
 * В шаблоне должен присутствовать тег <originText/>, который при выводе
 * замещается строкой, найденной по ключу.
 *
 * Created on 06.12.2015.
 *
 * @author Igor Akimov.
 */
@SuppressWarnings("unused")
public class LocaledMultilineLabel extends LocaledLabel {
    private String htmlTemplate;

    /******************************************************************************
     * Конструкторы
     */

    /**
     * Конструктор по умолчанию
     */
    public LocaledMultilineLabel() {
    }

    /**
     * @param textKey ключ текста на метке
     */
    public LocaledMultilineLabel(@NotNull String textKey) {
        this(textKey, LocaleContext.HTML_DEFAULT_TEMPLATE, null, LEADING);
    }

    /**
     * @param textKey      ключ текста на метке
     * @param htmlTemplate html шаблон разметки многострочного вывода
     */
    public LocaledMultilineLabel(@NotNull String textKey, @Nullable String htmlTemplate) {
        this(textKey, htmlTemplate, null, LEADING);
    }

    /**
     * @param text локализованная строка текста на метке
     */
    public LocaledMultilineLabel(@Nullable LocaledString text) {
        this(text, LocaleContext.HTML_DEFAULT_TEMPLATE, null, LEADING);
    }

    /**
     * @param text         локализованная строка текста на метке
     * @param htmlTemplate html шаблон разметки многострочного вывода
     */
    public LocaledMultilineLabel(@Nullable LocaledString text, @Nullable String htmlTemplate) {
        this(text, htmlTemplate, null, LEADING);
    }

    /**
     * @param image картинка на метке
     */
    public LocaledMultilineLabel(Icon image) {
        super(image);
    }

    /**
     * @param textKey             ключ текста на метке
     * @param horizontalAlignment горизонтальное выравнивание
     */
    public LocaledMultilineLabel(@NotNull String textKey, int horizontalAlignment) {
        this(textKey, LocaleContext.HTML_DEFAULT_TEMPLATE, null, horizontalAlignment);
    }

    /**
     * @param textKey             ключ текста на метке
     * @param htmlTemplate        html шаблон разметки многострочного вывода
     * @param horizontalAlignment горизонтальное выравнивание
     */
    public LocaledMultilineLabel(@NotNull String textKey, @Nullable String htmlTemplate, int horizontalAlignment) {
        this(textKey, htmlTemplate, null, horizontalAlignment);
    }

    /**
     * @param text                локализованная строка текста на метке
     * @param horizontalAlignment горизонтальное выравнивание
     */
    public LocaledMultilineLabel(@Nullable LocaledString text, int horizontalAlignment) {
        this(text, LocaleContext.HTML_DEFAULT_TEMPLATE, null, horizontalAlignment);
    }

    /**
     * @param text                локализованная строка текста на метке
     * @param htmlTemplate        html шаблон разметки многострочного вывода
     * @param horizontalAlignment горизонтальное выравнивание
     */
    public LocaledMultilineLabel(@Nullable LocaledString text, @Nullable String htmlTemplate, int horizontalAlignment) {
        this(text, htmlTemplate, null, horizontalAlignment);
    }

    /**
     * @param image               картинка на метке
     * @param horizontalAlignment горизонтальное выравнивание
     */
    public LocaledMultilineLabel(Icon image, int horizontalAlignment) {
        super(image, horizontalAlignment);
    }

    /**
     * @param textKey             ключ текста на метке
     * @param icon                картинка на метке
     * @param horizontalAlignment горизонтальное выравнивание
     */
    public LocaledMultilineLabel(@NotNull String textKey, Icon icon, int horizontalAlignment) {
        this(textKey, LocaleContext.HTML_DEFAULT_TEMPLATE, icon, horizontalAlignment);
    }

    /**
     * @param textKey             ключ текста на метке
     * @param htmlTemplate        html шаблон разметки многострочного вывода
     * @param icon                картинка на метке
     * @param horizontalAlignment горизонтальное выравнивание
     */
    public LocaledMultilineLabel(@NotNull String textKey, @Nullable String htmlTemplate, Icon icon, int horizontalAlignment) {
        super("", icon, horizontalAlignment);
        setText(textKey, htmlTemplate);
    }

    /**
     * @param text                локализованная строка текста на метке
     * @param icon                картинка на метке
     * @param horizontalAlignment горизонтальное выравнивание
     */
    public LocaledMultilineLabel(@Nullable LocaledString text, Icon icon, int horizontalAlignment) {
        this(text, LocaleContext.HTML_DEFAULT_TEMPLATE, icon, horizontalAlignment);
    }

    /**
     * @param text                локализованная строка текста на метке
     * @param htmlTemplate        html шаблон разметки многострочного вывода
     * @param icon                картинка на метке
     * @param horizontalAlignment горизонтальное выравнивание
     */
    public LocaledMultilineLabel(@Nullable LocaledString text, @Nullable String htmlTemplate, Icon icon, int horizontalAlignment) {
        super((LocaledString) null, icon, horizontalAlignment);
        setText(text, htmlTemplate);
    }

    /******************************************************************************
     * Методы доступа к локальным переменным
     */

    /**
     * Получить шаблон разметки.
     *
     * @return шаблон разметки
     */
    @Nullable
    public String getHtmlTemplate() {
        return htmlTemplate;
    }

    /**
     * Установить шаблон разметки.
     *
     * @param htmlTemplate шаблон разметки
     */
    public void setHtmlTemplate(@Nullable String htmlTemplate) {
        this.htmlTemplate = htmlTemplate;
    }

    /******************************************************************************
     * Переопределенные методы родительских классов
     */

    @Override
    public void setText(@Nullable String textKey) {
        setText(textKey, LocaleContext.HTML_DEFAULT_TEMPLATE);
    }

    @Override
    public void setText(@Nullable LocaledString text) {
        setText(text, LocaleContext.HTML_DEFAULT_TEMPLATE);
    }

    /******************************************************************************
     * Локальные методы класса
     */

    /**
     * Установить в метку текст по ключу, отформатированный по html шаблону.
     *
     * @param textKey      ключ текста на метке
     * @param htmlTemplate html шаблон разметки многострочного вывода
     */
    public void setText(@Nullable String textKey, @Nullable String htmlTemplate) {
        super.setText(textKey);
        this.htmlTemplate = htmlTemplate;
        super.setMultilineText(LocaleUtils.convertToMultiline(LocaledString.valueOf(getLocaledText()), this.htmlTemplate));
    }

    /**
     * Установить в метку текст локализованной строки, отформатированный по html шаблону.
     *
     * @param text         локализованная строка текста на метке
     * @param htmlTemplate html шаблон разметки многострочного вывода
     */
    public void setText(@Nullable LocaledString text, @Nullable String htmlTemplate) {
        super.setText(text);
        this.htmlTemplate = htmlTemplate;
        super.setMultilineText(LocaleUtils.convertToMultiline(LocaledString.valueOf(text), this.htmlTemplate));
    }
}
