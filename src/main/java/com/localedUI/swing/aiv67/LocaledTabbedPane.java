package com.localedUI.swing.aiv67;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.plaf.UIResource;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Локализованная панель вкладок.
 *
 * @author Igor Akimov. 07.12.2015.
 */
@SuppressWarnings("unused")
public class LocaledTabbedPane extends JTabbedPane implements LocaledTabPane {
    private final java.util.List<Page> pages;

    /******************************************************************************
     * Конструкторы
     */

    /**
     * Конструктор по умолчанию.
     */
    public LocaledTabbedPane() {
        super();
        pages = new ArrayList<>(1);
    }

    /**
     * @param tabPlacement расположение вкладок в зависимости от контента
     */
    public LocaledTabbedPane(int tabPlacement) {
        super(tabPlacement);
        pages = new ArrayList<>(1);
    }

    /**
     * @param tabPlacement    расположение вкладок в зависимости от контента
     * @param tabLayoutPolicy политика менеджера раскладки
     */
    public LocaledTabbedPane(int tabPlacement, int tabLayoutPolicy) {
        super(tabPlacement, tabLayoutPolicy);
        pages = new ArrayList<>(1);
    }

    /******************************************************************************
     * Переопределенные методы родительских классов
     */

    @Override
    public void setTitleAt(int index, @Nullable LocaledString title) {
        pages.get(index).title = title;
        super.setTitleAt(index, LocaledString.valueOf(title));
    }

    @Override
    public void setTitleAt(int index, @Nullable String titleKey) {
        LocaledString pageTitle = pages.get(index).title;
        if (LocaleUtils.isEmpty(titleKey)) {
            pageTitle = null;
        } else {
            pageTitle = pageTitle == null ? new LocaledString(titleKey) : pageTitle.setKey(titleKey);
        }
        setTitleAt(index, pageTitle);
    }

    @Override
    public void setToolTipTextAt(int index, @Nullable LocaledString toolTipText) {
        pages.get(index).toolTipText = toolTipText;
        super.setToolTipTextAt(index, LocaledString.valueOf(toolTipText));
    }

    @Override
    public void setToolTipTextAt(int index, @Nullable String toolTipTextKey) {
        LocaledString pageToolTipText = pages.get(index).toolTipText;
        if (LocaleUtils.isEmpty(toolTipTextKey)) {
            pageToolTipText = null;
        } else {
            pageToolTipText = pageToolTipText == null ? new LocaledString(toolTipTextKey) : pageToolTipText.setKey(toolTipTextKey);
        }
        setToolTipTextAt(index, pageToolTipText);
    }

    @Override
    public void insertTab(@Nullable LocaledString title, Icon icon, Component component, @Nullable LocaledString toolTipText, int index) {
        int newIndex = index;

        int removeIndex = indexOfComponent(component);
        if (component != null && removeIndex != -1) {
            checkIndex(index);
            pages.remove(index);
            if (newIndex > removeIndex) {
                newIndex--;
            }
        }

        pages.add(newIndex, new Page(title, toolTipText));

        super.insertTab(LocaledString.valueOf(title), icon, component, LocaledString.valueOf(toolTipText), index);
    }

    @Override
    public void insertTab(@Nullable String titleKey, Icon icon, Component component, @Nullable String toolTipTextKey, int index) {
        LocaledString title = null;
        if (!LocaleUtils.isEmpty(titleKey)) {
            title = new LocaledString(titleKey);
        }
        LocaledString toolTipText = null;
        if (!LocaleUtils.isEmpty(toolTipTextKey)) {
            toolTipText = new LocaledString(toolTipTextKey);
        }
        insertTab(title, icon, component, toolTipText, index);
    }

    @Override
    public void addTab(@Nullable LocaledString title, Icon icon, Component component, @Nullable LocaledString toolTipText) {
        insertTab(title, icon, component, toolTipText, pages.size());
    }

    @Override
    public void addTab(@Nullable String titleKey, Icon icon, Component component, @Nullable String toolTipTextKey) {
        insertTab(titleKey, icon, component, toolTipTextKey, pages.size());
    }

    @Override
    public void addTab(@Nullable LocaledString title, Icon icon, Component component) {
        addTab(title, icon, component, null);
    }

    @Override
    public void addTab(@Nullable String titleKey, Icon icon, Component component) {
        addTab(titleKey, icon, component, null);
    }

    @Override
    public void addTab(@Nullable LocaledString title, Component component) {
        addTab(title, null, component);
    }

    @Override
    public void addTab(@Nullable String titleKey, Component component) {
        addTab(titleKey, null, component);
    }

    @Override
    public Component add(@Nullable LocaledString title, Component component) {
        if (!(component instanceof UIResource)) {
            addTab(title, component);
        } else {
            super.add(LocaledString.valueOf(title), component);
        }
        return component;
    }

    @Override
    public Component add(@Nullable String titleKey, Component component) {
        LocaledString title = null;
        if (!LocaleUtils.isEmpty(titleKey)) {
            title = new LocaledString(titleKey);
        }
        return add(title, component);
    }

    @Override
    public int indexOfTab(@Nullable LocaledString title) {
        for (int i = 0; i < getTabCount(); i++) {
            if (title != null && title.equals(pages.get(i).title)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int indexOfTab(@NotNull String titleKey) {
        return indexOfTab(new LocaledString(titleKey));
    }

    @Override
    public void removeTabAt(int index) {
        checkIndex(index);
        pages.remove(index);
        super.removeTabAt(index);
    }

    @Override
    public void changeLocale() {
        for (int i = 0; i < pages.size(); i++) {
            setTitleAt(i, pages.get(i).title);
            setToolTipTextAt(i, pages.get(i).toolTipText);
            Component component = getComponentAt(i);
            if (component instanceof LocaledComponent) {
                ((LocaledComponent) component).changeLocale();
            }
        }

        LocaleUtils.localeInnerComponents(this);
    }

    /******************************************************************************
     * Локальные методы
     */

    private void checkIndex(int index) {
        if (index < 0 || index >= pages.size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Tab count: " + pages.size());
        }
    }

    /**
     * Класс для хранения дополнительных параметров вкладок.
     */
    private class Page implements Serializable {
        LocaledString title;
        LocaledString toolTipText;

        public Page(@Nullable LocaledString title, @Nullable LocaledString toolTipText) {
            this.title = title;
            this.toolTipText = toolTipText;
        }
    }
}
