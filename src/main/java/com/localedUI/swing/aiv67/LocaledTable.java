package com.localedUI.swing.aiv67;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import java.util.Vector;

/**
 * Локализованная таблица.
 *
 * Created on 06.12.2015.
 *
 * @author Igor Akimov.
 */
@SuppressWarnings("unused")
public class LocaledTable extends JTable implements LocaledComponent {
    /******************************************************************************
     * Конструкторы
     */

    /**
     * Конструктор по умолчанию.
     */
    public LocaledTable() {
    }

    /**
     * @param dm модель таблицы
     */
    public LocaledTable(TableModel dm) {
        super(dm);
    }

    /**
     * @param dm модель таблицы
     * @param cm модель столбцов
     */
    public LocaledTable(TableModel dm, TableColumnModel cm) {
        super(dm, cm);
    }

    /**
     * @param dm модель таблицы
     * @param cm модель столбцов
     * @param sm модель выбора
     */
    public LocaledTable(TableModel dm, TableColumnModel cm, ListSelectionModel sm) {
        super(dm, cm, sm);
    }

    /**
     * @param numRows    количество строк
     * @param numColumns количество столбцов
     */
    public LocaledTable(int numRows, int numColumns) {
        super(numRows, numColumns);
    }

    /**
     * @param rowData     данные строки
     * @param columnNames массив имен столбцов
     */
    public LocaledTable(Vector rowData, Vector columnNames) {
        super(rowData, columnNames);
    }

    /**
     * @param rowData     данные таблицы
     * @param columnNames массив имен столбцов
     */
    public LocaledTable(Object[][] rowData, Object[] columnNames) {
        super(rowData, columnNames);
    }

    /******************************************************************************
     * Переопределенные методы родительских классов
     */

    @Override
    public void changeLocale() {
        createDefaultColumnsFromModel();
        LocaleUtils.localeInnerComponents(this);
    }
}
