package com.localedUI.swing.aiv67;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

/**
 * Локализованное всплывающее стандартное диалоговое окно.
 * Если в message, options или initialValue передана строка, считается, что это ключ
 * для поиска в строковых ресурсах. Иначе значение не изменяется.
 *
 * @author Igor Akimov. 07.12.2015.
 */
@SuppressWarnings("unused")
public class LocaledOptionPane extends JOptionPane {
    /******************************************************************************
     * Статические методы класса
     */

    /**
     * Получить сообщение по ключу, если message - строка.
     * @param message ключ сообщения
     * @return сообщение
     */
    private static Object convertMessage(Object message) {
        Object result;
        if (message instanceof String) {
            result = R.getString((String) message);
        } else {
            result = message;
        }
        return result;
    }

    /**
     * Получить пункты выбора по ключу, если пункт - строка.
     * @param options массив ключей пунктов
     * @return массив пунктов
     */
    private static Object[] convertOptions(Object[] options) {
        Object[] result = new Object[options.length];
        for (int i = 0; i < options.length; i++) {
            if (options[i] instanceof String) {
                result[i] = R.getString((String) options[i]);
            } else {
                result[i] = options[i];
            }
        }
        return result;
    }

    /**
     * Получить начальное значение по ключу, если начальное значение - строка.
     * @param initialValue ключ начального значения
     * @return начальное значение
     */
    private static Object convertInitialValue(Object initialValue) {
        Object result;
        if (initialValue instanceof String) {
            result = R.getString((String) initialValue);
        } else {
            result = initialValue;
        }
        return result;
    }

// todo доделать статические методы отображения различных окон
// todo showInputDialog, showInternalMessageDialog, showInternalConfirmDialog
// todo showInternalOptionDialog, showInternalInputDialog


    /******************************************************************************
     * Статические методы родительского класса
     */

    /**
     * Отобразить диалоговое окно.
     *
     * @param parentComponent родительский компонент, в котором будет отображено диалоговое окно
     * @param message         сообщение
     * @param titleKey        ключ заголовка окна
     * @param optionType      варианты кнопок, отображаемых в окне
     * @param messageType     тип сообщения
     * @param icon            иконка
     * @param options         массив объектов, которые будут отображаться в кнопках
     * @param initialValue    кнопка, выделенная по умолчанию
     * @return выбранный элемент
     * @throws HeadlessException
     * @see JOptionPane
     */
    public static int showOptionDialog(Component parentComponent, Object message, @NotNull String titleKey, int optionType, int messageType,
                                       Icon icon, Object[] options, Object initialValue) throws HeadlessException {
        return JOptionPane.showOptionDialog(parentComponent, convertMessage(message), R.getString(titleKey), optionType, messageType, icon,
                convertOptions(options), convertInitialValue(initialValue));
    }

    /**
     * Отобразить диалоговое окно.
     *
     * @param parentComponent родительский компонент, в котором будет отображено диалоговое окно
     * @param message         сообщение
     * @param title           локализованная строка заголовка окна
     * @param optionType      варианты кнопок, отображаемых в окне
     * @param messageType     тип сообщения
     * @param icon            иконка
     * @param options         массив объектов, которые будут отображаться в кнопках
     * @param initialValue    кнопка, выделенная по умолчанию
     * @return выбранный элемент
     * @throws HeadlessException
     * @see JOptionPane
     */
    public static int showOptionDialog(Component parentComponent, Object message, @Nullable LocaledString title, int optionType, int messageType,
                                       Icon icon, Object[] options, Object initialValue) throws HeadlessException {
        return JOptionPane.showOptionDialog(parentComponent, convertMessage(message), LocaledString.valueOf(title), optionType, messageType, icon,
                convertOptions(options), convertInitialValue(initialValue));
    }

    ////////////////////////////////
    // Диалоговое окно с сообщением

    /**
     * Отобразить диалоговое окно с заданными сообщением, заголовком и иконкой.
     *
     * @param parentComponent родительский компонент, в котором будет отображено диалоговое окно
     * @param message         сообщение
     * @param titleKey        ключ заголовка окна
     * @param messageType     тип сообщения:
     * @param icon            иконка
     * @throws HeadlessException
     * @see JOptionPane
     */
    public static void showMessageDialog(Component parentComponent, Object message, @NotNull String titleKey, int messageType, Icon icon)
            throws HeadlessException {
        JOptionPane.showMessageDialog(parentComponent, convertMessage(message), R.getString(titleKey), messageType, icon);
    }

    /**
     * Отобразить диалоговое окно с заданными сообщением, заголовком и иконкой.
     *
     * @param parentComponent родительский компонент, в котором будет отображено диалоговое окно
     * @param message         сообщение
     * @param title           локализованная строка заголовка окна
     * @param messageType     тип сообщения:
     * @param icon            иконка
     * @throws HeadlessException
     * @see JOptionPane
     */
    public static void showMessageDialog(Component parentComponent, Object message, @Nullable LocaledString title, int messageType, Icon icon)
            throws HeadlessException {
        JOptionPane.showMessageDialog(parentComponent, convertMessage(message), LocaledString.valueOf(title), messageType, icon);
    }

    /**
     * Отобразить диалоговое окно с иконкой по умолчанию и заданными сообщением и заголовком.
     *
     * @param parentComponent родительский компонент, в котором будет отображено диалоговое окно
     * @param message         сообщение
     * @param titleKey        ключ заголовка окна
     * @param messageType     тип сообщения:
     * @throws HeadlessException
     * @see JOptionPane
     */
    public static void showMessageDialog(Component parentComponent, Object message, @NotNull String titleKey, int messageType)
            throws HeadlessException {
        JOptionPane.showMessageDialog(parentComponent, convertMessage(message), R.getString(titleKey), messageType);
    }

    /**
     * Отобразить диалоговое окно с иконкой по умолчанию и заданными сообщением и заголовком.
     *
     * @param parentComponent родительский компонент, в котором будет отображено диалоговое окно
     * @param message         сообщение
     * @param title           локализованная строка заголовка окна
     * @param messageType     тип сообщения:
     * @throws HeadlessException
     * @see JOptionPane
     */
    public static void showMessageDialog(Component parentComponent, Object message, @Nullable LocaledString title, int messageType)
            throws HeadlessException {
        JOptionPane.showMessageDialog(parentComponent, convertMessage(message), LocaledString.valueOf(title), messageType);
    }

    /**
     * Отобразить диалоговое окно с иконкой по умолчанию и заданными сообщением и заголовком.
     *
     * @param parentComponent родительский компонент, в котором будет отображено диалоговое окно
     * @param message         сообщение
     * @throws HeadlessException
     * @see JOptionPane
     */
    public static void showMessageDialog(Component parentComponent, Object message) throws HeadlessException {
        JOptionPane.showMessageDialog(parentComponent, convertMessage(message));
    }

    ////////////////////////////////
    // Диалоговое окно подтверждения

    /**
     * Отобразить диалоговое окно подтверждения с заданными сообщением, заголовком и иконкой.
     *
     * @param parentComponent родительский компонент, в котором будет отображено диалоговое окно
     * @param message         сообщение
     * @param titleKey        ключ заголовка окна
     * @param optionType      варианты кнопок, отображаемых в окне
     * @param messageType     тип сообщения:
     * @param icon            иконка
     * @throws HeadlessException
     * @see JOptionPane
     */
    public static int showConfirmDialog(Component parentComponent, Object message, @NotNull String titleKey, int optionType, int messageType,
                                        Icon icon) throws HeadlessException {
        return JOptionPane.showConfirmDialog(parentComponent, convertMessage(message), R.getString(titleKey), optionType, messageType, icon);
    }

    /**
     * Отобразить диалоговое окно подтверждения с заданными сообщением, заголовком и иконкой.
     *
     * @param parentComponent родительский компонент, в котором будет отображено диалоговое окно
     * @param message         сообщение
     * @param title           локализованная строка заголовка окна
     * @param optionType      варианты кнопок, отображаемых в окне
     * @param messageType     тип сообщения:
     * @param icon            иконка
     * @throws HeadlessException
     * @see JOptionPane
     */
    public static int showConfirmDialog(Component parentComponent, Object message, @Nullable LocaledString title, int optionType, int messageType,
                                        Icon icon) throws HeadlessException {
        return JOptionPane.showConfirmDialog(parentComponent, convertMessage(message), LocaledString.valueOf(title), optionType, messageType, icon);
    }

    /**
     * Отобразить диалоговое окно подтверждения с иконкой по умолчанию и заданными сообщением и заголовком.
     *
     * @param parentComponent родительский компонент, в котором будет отображено диалоговое окно
     * @param message         сообщение
     * @param titleKey        ключ заголовка окна
     * @param optionType      варианты кнопок, отображаемых в окне
     * @param messageType     тип сообщения:
     * @throws HeadlessException
     * @see JOptionPane
     */
    public static int showConfirmDialog(Component parentComponent, Object message, @NotNull String titleKey, int optionType, int messageType)
            throws HeadlessException {
        return JOptionPane.showConfirmDialog(parentComponent, convertMessage(message), R.getString(titleKey), optionType, messageType);
    }

    /**
     * Отобразить диалоговое окно подтверждения с иконкой по умолчанию и заданными сообщением и заголовком.
     *
     * @param parentComponent родительский компонент, в котором будет отображено диалоговое окно
     * @param message         сообщение
     * @param title           локализованная строка заголовка окна
     * @param optionType      варианты кнопок, отображаемых в окне
     * @param messageType     тип сообщения:
     * @throws HeadlessException
     * @see JOptionPane
     */
    public static int showConfirmDialog(Component parentComponent, Object message, @Nullable LocaledString title, int optionType, int messageType)
            throws HeadlessException {
        return JOptionPane.showConfirmDialog(parentComponent, convertMessage(message), LocaledString.valueOf(title), optionType, messageType);
    }

    /**
     * Отобразить диалоговое окно подтверждения с иконкой по умолчанию и заданными сообщением и заголовком.
     *
     * @param parentComponent родительский компонент, в котором будет отображено диалоговое окно
     * @param message         сообщение
     * @param titleKey        ключ заголовка окна
     * @param optionType      варианты кнопок, отображаемых в окне
     * @throws HeadlessException
     * @see JOptionPane
     */
    public static int showConfirmDialog(Component parentComponent, Object message, @NotNull String titleKey, int optionType)
            throws HeadlessException {
        return JOptionPane.showConfirmDialog(parentComponent, convertMessage(message), R.getString(titleKey), optionType);
    }

    /**
     * Отобразить диалоговое окно подтверждения с иконкой по умолчанию и заданными сообщением и заголовком.
     *
     * @param parentComponent родительский компонент, в котором будет отображено диалоговое окно
     * @param message         сообщение
     * @param title           локализованная строка заголовка окна
     * @param optionType      варианты кнопок, отображаемых в окне
     * @throws HeadlessException
     * @see JOptionPane
     */
    public static int showConfirmDialog(Component parentComponent, Object message, @Nullable LocaledString title, int optionType)
            throws HeadlessException {
        return JOptionPane.showConfirmDialog(parentComponent, convertMessage(message), LocaledString.valueOf(title), optionType);
    }

    /**
     * Отобразить диалоговое окно подтверждения с иконкой и заголовком по умолчанию и заданным сообщением.
     *
     * @param parentComponent родительский компонент, в котором будет отображено диалоговое окно
     * @param message         сообщение
     * @throws HeadlessException
     * @see JOptionPane
     */
    public static int showConfirmDialog(Component parentComponent, Object message) throws HeadlessException {
        return JOptionPane.showConfirmDialog(parentComponent, convertMessage(message));
    }
}
