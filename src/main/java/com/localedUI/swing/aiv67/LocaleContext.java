package com.localedUI.swing.aiv67;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;

/**
 * Контекст локализованных компонентов.
 *
 * Created on 09.12.2015.
 *
 * @author Igor Akimov.
 */
@SuppressWarnings("unused")
public class LocaleContext {
    static final String HTML_DEFAULT_TEMPLATE = "<html><originText/></html>";

    private static String userLocale = null;
    private static String defaultLocale;
    private static String defaultStringResourcePackage = "src/main/resources/strings";
    private static String fileEncoding = "UTF-8";
    private static boolean useResourcesSubPackage = false; // По умолчанию задано использование единого пакета для поиска ресурсов.
    private static Logger logger = LoggerFactory.getLogger(R.class);

    /**
     * Получить язык пользователя.
     *
     * @return язык пользователя
     */
    public static String getUserLocale() {
        if (userLocale == null) {
            userLocale = getDefaultLocale();
        }

        return userLocale;
    }

    /**
     * Установить язык пользователя.
     *
     * @param userLocale язык пользователя
     */
    public static void setUserLocale(String userLocale) {
        LocaleContext.userLocale = userLocale;
    }

    /**
     * Получить язык по умолчанию.
     *
     * @return язык по умолчанию
     */
    public static String getDefaultLocale() {
        if (defaultLocale == null) {
            Locale locale = Locale.getDefault();
            defaultLocale = locale.getLanguage();
        }

        return defaultLocale;
    }

    /**
     * Установить язык по умолчанию.
     *
     * @param defaultLocale язык по умолчанию
     */
    public static void setDefaultLocale(String defaultLocale) {
        LocaleContext.defaultLocale = defaultLocale;
    }

    /**
     * Получить пакет по умолчанию, в котором будет производиться поиск ключа.
     *
     * @return пакет по умолчанию, в котором будет производиться поиск ключа
     */
    public static String getDefaultStringResourcePackage() {
        return defaultStringResourcePackage;
    }

    /**
     * Установить пакет по умолчанию, в котором будет производиться поиск ключа.
     *
     * @param defaultStringResourcePackage пакет по умолчанию, в котором будет производиться поиск ключа
     */
    public static void setDefaultStringResourcePackage(String defaultStringResourcePackage) {
        LocaleContext.defaultStringResourcePackage = defaultStringResourcePackage;
    }

    /**
     * Получить кодировку файлов ресурсов.
     *
     * @return кодировка файлов ресурсов
     */
    public static String getFileEncoding() {
        return fileEncoding;
    }

    /**
     * Установить кодировку файлов ресурсов
     *
     * @param fileEncoding кодировка файлов ресурсов
     */
    public static void setFileEncoding(String fileEncoding) {
        LocaleContext.fileEncoding = fileEncoding;
    }

    /**
     * Проверить, нужно ли использовать поиск ресурсов в вложенных пакетах.
     *
     * @return true, если используется поиск в вложенных пакетах, false, если используется поиск только в указанном пакете.
     */
    public static boolean isUseResourcesSubPackage() {
        return useResourcesSubPackage;
    }

    /**
     * Задать использование вложенных пакетов для поиска ресурсов.
     */
    public static void setUseResourcesSubpackage() {
        LocaleContext.useResourcesSubPackage = true;
    }

    /**
     * Отменить использование вложенных пакетов для поиска ресурсов.
     */
    public static void resetUseResourcesSubPackage() {
        LocaleContext.useResourcesSubPackage = false;
    }

    /**
     * Получить логгер.
     *
     * @return логгер
     */
    public static Logger getLogger() {
        return logger;
    }

    /**
     * Установить логгер.
     *
     * @param logger логгер
     */
    public static void setLogger(Logger logger) {
        LocaleContext.logger = logger;
    }
}
