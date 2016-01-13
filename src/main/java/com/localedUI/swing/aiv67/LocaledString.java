package com.localedUI.swing.aiv67;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Локализованная строка.
 * Содержит пару "ключ"-"параметры".
 *
 * По ключу ищется строка в файле ресурсов, параметры подставляются вместо {0}, {1} ... {n}.
 * Файл ресурсов имеет название "locale.properties", где locale - значение языка,
 * например, "ru.properties", "en.properties".
 * Пакет, в котором производится поиск ресурсов, по умолчанию имеет путь LocaleContext.getDefaultStringResourcePackage(),
 * при необходимости его можно изменить.
 *
 * Если задано использование вложенных пакетов (<code>useSubPackage = true</code>), то пакет, в котором будет производиться поиск ключа,
 * будет определяться конкатенацией используемого пакета и части ключа до первой точки. При этом ключ не обрезается.
 * Например:
 * - пакет: "src/main/resources/strings"
 * - ключ: "test.error.message"
 * Пакет, в котором будет производиться поиск ключа: "src/main/resources/strings/test"
 *
 * @author Igor Akimov. 29.11.2015.
 */
@SuppressWarnings("unused")
public class LocaledString {
    private String key;
    private Object[] args = null;
    private String resourcePackage;
    private boolean useSubPackage;

    /******************************************************************************
     * Конструкторы
     */

    /**
     * @param key             ключ строки
     * @param args            аргументы строки
     * @param resourcePackage пакет, в котором располагаются файлы строковых ресурсов
     * @param useSubPackage   использовать вложенные пакеты для файлов ресурсов
     */
    public LocaledString(@NotNull String key, @NotNull String resourcePackage, boolean useSubPackage, @Nullable Object... args) {
        this.key = key;
        this.args = args;
        this.resourcePackage = resourcePackage;
        this.useSubPackage = useSubPackage;
    }

    /**
     * @param key           ключ строки
     * @param args          аргументы строки
     * @param useSubPackage использовать вложенные пакеты для файлов ресурсов
     */
    public LocaledString(@NotNull String key, boolean useSubPackage, @Nullable Object... args) {
        this(key, LocaleContext.getDefaultStringResourcePackage(), useSubPackage, args);
    }

    /**
     * @param key  ключ строки
     * @param args аргументы строки
     */
    public LocaledString(@NotNull String key, @Nullable Object... args) {
        this(key, LocaleContext.getDefaultStringResourcePackage(), LocaleContext.isUseResourcesSubPackage(), args);
    }

    /**
     * @param key ключ строки
     */
    public LocaledString(@NotNull String key) {
        this(key, (Object[]) null);
    }

    /******************************************************************************
     * Собственные статические методы
     */

    /**
     * Получить строку из локализованной строки, nullsafe.
     *
     * @param string локализованная строка
     * @return значение из файла ресурсов. Если передано значение null, возвращается пустая строка
     */
    @NotNull
    public static String valueOf(@Nullable LocaledString string) {
        return string == null ? "" : string.toString();
    }

    /******************************************************************************
     * Методы доступа к локальным переменным
     */

    /**
     * Получить ключ строки.
     *
     * @return ключ строки
     */
    @NotNull
    public String getKey() {
        return key;
    }

    /**
     * Установить ключ строки.
     *
     * @param key ключ строки
     * @return измененная локализованная строка
     */
    @NotNull
    public LocaledString setKey(@NotNull String key) {
        this.key = key;
        return this;
    }

    /**
     * Получить параметры строки.
     *
     * @return параметры строки
     */
    @Nullable
    public Object[] getArgs() {
        return args;
    }

    /**
     * Установить параметры строки.
     *
     * @param args параметры строки
     * @return измененная локализованная строка
     */
    @NotNull
    public LocaledString setArgs(@Nullable Object[] args) {
        this.args = args;
        return this;
    }

    /**
     * Получить пакет, в котором располагаются файлы строковых ресурсов.
     *
     * @return пакет, в котором располагаются файлы строковых ресурсов
     */
    @NotNull
    public String getResourcePackage() {
        return resourcePackage;
    }

    /**
     * Установить пакет, в котором располагаются файлы строковых ресурсов.
     *
     * @param resourcePackage пакет, в котором располагаются файлы строковых ресурсов
     * @return измененная локализованная строка
     */
    @NotNull
    public LocaledString setResourcePackage(@NotNull String resourcePackage) {
        this.resourcePackage = resourcePackage;
        return this;
    }

    /**
     * Проверить, нужно ли использовать поиск ресурсов в вложенных пакетах.
     *
     * @return true, если используется поиск в вложенных пакетах, false, если используется поиск только в указанном пакете.
     */
    public boolean isUseSubPackage() {
        return useSubPackage;
    }

    /**
     * Задать использование вложенных пакетов для поиска ресурсов.
     *
     * @return измененная локализованная строка
     */
    @NotNull
    public LocaledString setUseResourcesSubpackage() {
        this.useSubPackage = true;
        return this;
    }

    /**
     * Отменить использование вложенных пакетов для поиска ресурсов.
     *
     * @return измененная локализованная строка
     */
    @NotNull
    public LocaledString resetUseResourcesSubPackage() {
        this.useSubPackage = false;
        return this;
    }

    /******************************************************************************
     * Переопределенные методы родительских классов
     */
    @Override
    @NotNull
    public String toString() {
        return R.getString(this);
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof LocaledString)) {
            return false;
        }

        LocaledString string = (LocaledString) obj;

        return toString().equals(string.toString());
    }

    /******************************************************************************
     * Собственные методы
     */

    /**
     * Проверить строку на пустоту.
     * Пустой считается строка, в которой пустой ключ.
     *
     * @return true, если ключ строки null или не содержит символов
     */
    public boolean isEmpty() {
        return LocaleUtils.isEmpty(key);
    }
}