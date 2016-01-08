package com.localedUI.swing.aiv67;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Локализованное исключение.
 *
 * Created on 04.12.2015.
 *
 * @author Igor Akimov.
 */
@SuppressWarnings("unused")
public class LocaledException extends Exception {
    private LocaledString message;

    /******************************************************************************
     * Конструкторы
     */

    /**
     * Конструктор по умолчанию.
     */
    public LocaledException() {
    }

    /**
     * @param messageKey ключ сообщения
     */
    public LocaledException(@NotNull String messageKey) {
        this(new LocaledString(messageKey));
    }

    /**
     * @param message локализованное сообщение
     */
    public LocaledException(@Nullable LocaledString message) {
        super(LocaledString.valueOf(message));
        this.message = message;
    }

    /**
     * @param messageKey ключ сообщения
     * @param cause      исключение, породившее данное исключение
     */
    public LocaledException(@NotNull String messageKey, @NotNull Throwable cause) {
        this(new LocaledString(messageKey), cause);
    }

    /**
     * @param message локализованное сообщение
     * @param cause   исключение, породившее данное исключение
     */
    public LocaledException(@Nullable LocaledString message, @NotNull Throwable cause) {
        super(LocaledString.valueOf(message), cause);
        this.message = message;
    }

    /**
     * @param cause исключение, породившее данное исключение
     */
    public LocaledException(@NotNull Throwable cause) {
        super(cause);
    }

    /**
     * @param messageKey         ключ сообщения
     * @param cause              исключение, породившее данное исключение
     * @param enableSuppression  доступно ли скрытие исключения
     * @param writableStackTrace доступна ли печать трассировки стека
     */
    public LocaledException(@NotNull String messageKey, @NotNull Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        this(new LocaledString(messageKey), cause, enableSuppression, writableStackTrace);
    }

    /**
     * @param message            локализованное сообщение
     * @param cause              исключение, породившее данное исключение
     * @param enableSuppression  доступно ли скрытие исключения
     * @param writableStackTrace доступна ли печать трассировки стека
     */
    public LocaledException(@Nullable LocaledString message, @NotNull Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(LocaledString.valueOf(message), cause, enableSuppression, writableStackTrace);
        this.message = message;
    }

    /******************************************************************************
     * Методы доступа к локальным переменным
     */

    /**
     * Получить сообщение исключения.
     *
     * @return локализованное сообщение исключения
     */
    @Nullable
    public LocaledString getLocaledMessage() {
        return message;
    }
}
