package com.localedUI.swing.aiv67;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.border.Border;
import java.awt.*;

/**
 * Фабрика создания локализованных рамок.
 *
 * @author Igor Akimov. 04.12.2015.
 */
@SuppressWarnings("unused")
public class LocaledBorderFactory {
    /**
     * Нельзя создавать объекты класса.
     */
    private LocaledBorderFactory() {
    }

    /**
     * Создать локализованную рамку с заголовком
     *
     * @param title локализованная строка заголовка
     * @return локализованная рамка с заголовком
     */
    @NotNull
    public static LocaledTitledBorder createTitledBorder(@Nullable LocaledString title) {
        return new LocaledTitledBorder(title);
    }

    /**
     * Создать локализованную рамку с заголовком
     *
     * @param titleKey ключ заголовка
     * @return локализованная рамка с заголовком
     */
    @NotNull
    public static LocaledTitledBorder createTitledBorder(@NotNull String titleKey) {
        return new LocaledTitledBorder(titleKey);
    }

    /**
     * Создать локализованную рамку с заголовком
     *
     * @param border рамка, на основе которой создается эта рамка
     * @return локализованная рамка с заголовком
     */
    @NotNull
    public static LocaledTitledBorder createTitledBorder(@Nullable Border border) {
        return new LocaledTitledBorder(border);
    }

    /**
     * Создать локализованную рамку с заголовком
     *
     * @param border рамка, на основе которой создается эта рамка
     * @param title  локализованная строка заголовка
     * @return локализованная рамка с заголовком
     */
    @NotNull
    public static LocaledTitledBorder createTitledBorder(@Nullable Border border,
                                                         @Nullable LocaledString title) {
        return new LocaledTitledBorder(border, title);
    }

    /**
     * Создать локализованную рамку с заголовком
     *
     * @param border   рамка, на основе которой создается эта рамка
     * @param titleKey ключ заголовка
     * @return локализованная рамка с заголовком
     */
    @NotNull
    public static LocaledTitledBorder createTitledBorder(@Nullable Border border,
                                                         @NotNull String titleKey) {
        return new LocaledTitledBorder(border, titleKey);
    }

    /**
     * Создать локализованную рамку с заголовком
     *
     * @param border             рамка, на основе которой создается эта рамка
     * @param title              локализованная строка заголовка
     * @param titleJustification выравнивание заголовка
     * @param titlePosition      позиция заголовка
     * @return локализованная рамка с заголовком
     */
    @NotNull
    public static LocaledTitledBorder createTitledBorder(@Nullable Border border,
                                                         @Nullable LocaledString title,
                                                         int titleJustification,
                                                         int titlePosition) {
        return new LocaledTitledBorder(border, title, titleJustification,
                titlePosition);
    }

    /**
     * Создать локализованную рамку с заголовком
     *
     * @param border             рамка, на основе которой создается эта рамка
     * @param titleKey           ключ заголовка
     * @param titleJustification выравнивание заголовка
     * @param titlePosition      позиция заголовка
     * @return локализованная рамка с заголовком
     */
    @NotNull
    public static LocaledTitledBorder createTitledBorder(@Nullable Border border,
                                                         @NotNull String titleKey,
                                                         int titleJustification,
                                                         int titlePosition) {
        return new LocaledTitledBorder(border, titleKey, titleJustification,
                titlePosition);
    }

    /**
     * Создать локализованную рамку с заголовком
     *
     * @param border             рамка, на основе которой создается эта рамка
     * @param title              локализованная строка заголовка
     * @param titleJustification выравнивание заголовка
     * @param titlePosition      позиция заголовка
     * @param titleFont          шрифт заголовка
     * @return локализованная рамка с заголовком
     */
    @NotNull
    public static LocaledTitledBorder createTitledBorder(@Nullable Border border,
                                                         @Nullable LocaledString title,
                                                         int titleJustification,
                                                         int titlePosition,
                                                         @Nullable Font titleFont) {
        return new LocaledTitledBorder(border, title, titleJustification,
                titlePosition, titleFont);
    }

    /**
     * Создать локализованную рамку с заголовком
     *
     * @param border             рамка, на основе которой создается эта рамка
     * @param titleKey           ключ заголовка
     * @param titleJustification выравнивание заголовка
     * @param titlePosition      позиция заголовка
     * @param titleFont          шрифт заголовка
     * @return локализованная рамка с заголовком
     */
    @NotNull
    public static LocaledTitledBorder createTitledBorder(@Nullable Border border,
                                                         @NotNull String titleKey,
                                                         int titleJustification,
                                                         int titlePosition,
                                                         @Nullable Font titleFont) {
        return new LocaledTitledBorder(border, titleKey, titleJustification,
                titlePosition, titleFont);
    }

    /**
     * Создать локализованную рамку с заголовком
     *
     * @param border             рамка, на основе которой создается эта рамка
     * @param title              локализованная строка заголовка
     * @param titleJustification выравнивание заголовка
     * @param titlePosition      позиция заголовка
     * @param titleFont          шрифт заголовка
     * @param titleColor         цвет заголовка
     * @return локализованная рамка с заголовком
     */
    @NotNull
    public static LocaledTitledBorder createTitledBorder(@Nullable Border border,
                                                         @Nullable LocaledString title,
                                                         int titleJustification,
                                                         int titlePosition,
                                                         @Nullable Font titleFont,
                                                         @Nullable Color titleColor) {
        return new LocaledTitledBorder(border, title, titleJustification,
                titlePosition, titleFont, titleColor);
    }

    /**
     * Создать локализованную рамку с заголовком
     *
     * @param border             рамка, на основе которой создается эта рамка
     * @param titleKey           ключ заголовка
     * @param titleJustification выравнивание заголовка
     * @param titlePosition      позиция заголовка
     * @param titleFont          шрифт заголовка
     * @param titleColor         цвет заголовка
     * @return локализованная рамка с заголовком
     */
    @NotNull
    public static LocaledTitledBorder createTitledBorder(@Nullable Border border,
                                                         @NotNull String titleKey,
                                                         int titleJustification,
                                                         int titlePosition,
                                                         @Nullable Font titleFont,
                                                         @Nullable Color titleColor) {
        return new LocaledTitledBorder(border, titleKey, titleJustification,
                titlePosition, titleFont, titleColor);
    }

}
