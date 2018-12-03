package org.zodiac.matrix;

public interface Matrix<T> {

    int getColumnCount();

    int getRowCount();

    T[] getRow(int rouNumber);

    T[] getColumn(int columnNumber);

    void set(int row, int column, T t);

    T get(int row, int col);

    void setColumn(int columnNumber, T[] column);

    void setRow(int rowNumber, T[] row);

    void addRow(int index, T[] row);

    void addColumn(int index, T[] column);

    void deleteColumn(int columnNumber);

    void deleteRow(int rowNumber);

}
