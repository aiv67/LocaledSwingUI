package com.localedUI.swing.aiv67;


import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Класс получения строки по ключу.
 *
 * @author Igor Akimov. 29.11.2015.
 */
public class R {
    private static final String RESOURCE_FILE_NAME_SUFFIX = ".properties";
    private static Map<String, String> stringCache = new HashMap<>();

    /**
     * Получить строку из локализованной строки (пара "ключ"-"аргументы").
     *
     * @param string локализованная строка
     * @return строка
     */
    @NotNull
    public static String getString(@Nullable LocaledString string) {
        if (string == null) {
            return "";
        }

        String value = getString(string, LocaleContext.getUserLocale());

        if (value == null && !(LocaleContext.getUserLocale().equals(LocaleContext.getDefaultLocale()))) {
            value = getString(string, LocaleContext.getDefaultLocale());
        }

        if (value == null) {
            String resourcePackage = getResourcePackage(string);
            String errorMessage = "Key \"" + string.getKey() + "\" in the package \"" + resourcePackage + "\" not found";
            LocaleContext.getLogger().error(errorMessage);
            return string.getKey();
        }

        return substituteArguments(value, string);
    }

    /**
     * Получить строку по ключу с аргументами.
     *
     * @param key  ключ строки
     * @param args аргументы строки, подставляются вместо {0}, {1}, {2}...
     * @return строка
     */
    @SuppressWarnings("unused")
    @NotNull
    public static String getString(@NotNull String key, @Nullable Object... args) {
        return getString(new LocaledString(key, args));
    }

    /**
     * Получить строку по ключу
     *
     * @param key ключ строки
     * @return строка
     */
    @SuppressWarnings("unused")
    @NotNull
    public static String getString(@NotNull String key) {
        return getString(key, (Object[]) null);
    }

    // Заменить параметры в строке аргументами.
    @NotNull
    private static String substituteArguments(@NotNull String template, @NotNull LocaledString string) {
        int i = 0;

        String target = "{" + i + "}";
        while (template.contains(target)) {
            if (string.getArgs() == null || i >= string.getArgs().length) {
                String resourcePackage = getResourcePackage(string);
                String logMessage = "String by key \"" + string.getKey() + "\" in the package \"" + resourcePackage + "\" must have arguments.";
                String errorMessage = "Too few arguments: found " + (string.getArgs() == null ? 0 : string.getArgs().length);
                LocaleContext.getLogger().error(logMessage, new ArrayIndexOutOfBoundsException(errorMessage));
                return string.getKey();
            }

            template = template.replace(target, string.getArgs()[i].toString());

            i++;
            target = "{" + i + "}";
        }

        return template;
    }

    // Получить ресурсы для языка.
    @Nullable
    private static String getString(@Nullable LocaledString localedString, @NotNull String locale) {
        if (localedString == null) {
            return null;
        }

        String resourcePackage = getResourcePackage(localedString);

        String cacheKey = locale + "|" + resourcePackage + "|" + localedString.getKey();
        String string = stringCache.get(cacheKey);

        if (string == null) {
            Properties properties = new Properties();
            String resourcesFileName = resourcePackage + locale + RESOURCE_FILE_NAME_SUFFIX;
            try (InputStreamReader reader = new InputStreamReader(new FileInputStream(resourcesFileName), LocaleContext.getFileEncoding())) {
                properties.load(reader);
            } catch (Exception e) {
                String errorMessage = "String resources file (\"" + resourcesFileName + "\") not found";
                LocaleContext.getLogger().error(errorMessage);
                return null;
            }

            Enumeration propertyNames = properties.propertyNames();
            while (propertyNames.hasMoreElements()) {
                String elementName = (String) propertyNames.nextElement();
                String key = locale + "|" + resourcePackage + "|" + elementName;
                stringCache.put(key, properties.getProperty(elementName));
            }

            string = stringCache.get(cacheKey);
        }

        return string;
    }

    // Получить путь к пакету ресурсов.
    @NotNull
    private static String getResourcePackage(@NotNull LocaledString string) {
        StringBuilder resourcePackage = new StringBuilder(string.getResourcePackage().replace('\\', '/'));
        resourcePackage.append(string.getResourcePackage().endsWith("/") ? "" : "/");

        int pointPosition = string.getKey().indexOf('.');
        if (string.isUseSubPackage() && pointPosition > 0) {
            resourcePackage.append(string.getKey().substring(0, pointPosition));
            resourcePackage.append("/");
        }
        return resourcePackage.toString();
    }
}
