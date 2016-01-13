package com.localedUI.swing.aiv67;

import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Утилиты локализации.
 *
 * @author Igor Akimov. 29.11.2015.
 */
public class LocaleUtils {
    /**
     * Локализовать внутренние компоненты переданного контейнера.
     *
     * @param container контейнер компонентов
     */
    static void localeInnerComponents(Container container) {
        // Локализуем рамку компонента.
        if (container instanceof JComponent) {
            localeBorder(((JComponent) container).getBorder());
        }

        // Локализуем внутренние компоненты.
        for (Component component : container.getComponents()) {
            processComponent(component);
        }

        // Локализуем внутренние компоненты RootPaneContainer.
        if (container instanceof RootPaneContainer) {
            Container innerContainer = ((RootPaneContainer) container).getContentPane();
            for (Component component : innerContainer.getComponents()) {
                processComponent(component);
            }
        }

        container.repaint();
    }

    /**
     * Локализовать внутренние компоненты переданного пункта меню.
     *
     * @param menuItem пункт меню
     */
    static void localeInnerMenus(JMenu menuItem) {
        localeInnerComponents(menuItem);

        for (Component component : menuItem.getMenuComponents()) {
            processComponent(component);
        }
    }

    /**
     * Локализовать рамку.
     *
     * @param border рамка для локализации
     */
    static void localeBorder(Border border) {
        if (border == null) {
            return;
        }

        // Если рамка содержит локализуемые поля, меняем их язык.
        if (border instanceof LocaledBorder) {
            ((LocaledBorder) border).changeLocale();
            return;
        }

        // У рамок, содержащих внутренние рамки, локализуем их.
        // ==>
        if (border instanceof TitledBorder) {
            localeBorder(((TitledBorder) border).getBorder());
        }

        if (border instanceof CompoundBorder) {
            localeBorder(((CompoundBorder) border).getInsideBorder());
            localeBorder(((CompoundBorder) border).getOutsideBorder());
        }
        // <==
    }

    private static void processComponent(Component component) {
        if (component instanceof LocaledComponent) {
            ((LocaledComponent) component).changeLocale();
        } else if (component instanceof Container) {
            localeInnerComponents((Container) component);
        }
    }

    /**
     * Проверить строку на пустоту.
     * null safe.
     *
     * @param s проверяемая строка
     * @return true, если строка пустая или null
     */
    public static boolean isEmpty(String s) {
        return s == null || "".equals(s.trim());
    }

    /**
     * Преобразовать строку для отображения в многострочных компонентах по шаблону.
     * Шаблон представляет собой html страницу, отформатированную в нужном стиле. Строка для
     * отображения вставляется в шаблон в месте, обозначенном в шаблоне как <originText/>. Этот
     * тег будет замещен на переданную строку. Символы "\n" в строке будут заменены на "<br/>"
     * null safe.
     *
     * @param orig         оригинальная строка
     * @param htmlTemplate html шаблон разметки вывода
     * @return измененная строка
     */
    static String convertToMultiline(@Nullable String orig, @Nullable String htmlTemplate) {
        if (orig == null) {
            return "";
        }

        if (htmlTemplate == null) {
            htmlTemplate = LocaleContext.HTML_DEFAULT_TEMPLATE;
        }

        return htmlTemplate.replaceAll("<originText/>", orig.replaceAll("\n", "<br/>"));
    }
}
