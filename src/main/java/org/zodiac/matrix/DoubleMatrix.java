package org.zodiac.matrix;

public class DoubleMatrix implements Matrix<Double> {

    private int rowCount;
    private int columnCount;

    Double[][] value;

    public DoubleMatrix(int rowCount, int columnCount) {
        assert rowCount >= 0 && columnCount >= 0;
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        this.value = new Double[rowCount][columnCount];
    }

    public Double[][] getValue() {
        return value;
    }

    public int getColumnCount() {
        return this.columnCount;
    }

    public int getRowCount() {
        return this.rowCount;
    }

    public Double[] getRow(int rowNumber) {
        return value[rowNumber];
    }

    public Double[] getColumn(int columnCount) {
        Double[] temp = new Double[rowCount];
        for (int i = 0; i < rowCount; i++) {
            temp[i] = value[i][0];
        }
        return temp;
    }

    public void set(int row, int column, Double d) {
        assert row < rowCount && column < columnCount;
        value[row][column] = d;
    }

    public Double get(int row, int col) {
        return value[row][col];
    }

    public void setColumn(int columnNumber, Double[] column) {
        assert column.length == value.length;
        for (int i = 0; i < value.length; i++) {
            value[i][columnNumber] = column[i];
        }
    }

    public void setRow(int rowNumber, Double[] row) {
        assert row.length == value[0].length;
        value[rowNumber] = row;
    }

    public void addRow(int index, Double[] row) {
        //todo 比较麻烦

    }

    public void addColumn(int index, Double[] column) {
        //todo 比较麻烦
    }

    public void deleteColumn(int columnNumber) {
        //todo
    }

    public void deleteRow(int rowNumber) {
        //todo
    }

    public double sumColumn(int index) {
        assert index < rowCount;
        double sum = 0D;
        for (Double[] doubles : value) {
            sum += doubles[index];
        }
        return sum;
    }

    public double avgColumn(int index) {
        return sumColumn(index) / rowCount;
    }

    public double sumRow(int index) {
        assert index < columnCount;
        double sum = 0D;
        for (Double aDouble : value[index]) {
            sum += aDouble;
        }
        return sum;
    }

    public double avgRow(int index) {
        return sumRow(index) / columnCount;
    }

    public double minRow(int index) {
        assert index < columnCount;
        double min = value[index][0];
        for (Double aDouble : value[index]) {
            if (aDouble < min) {
                min = aDouble;
            }
        }
        return min;
    }

    public double minColumn(int index) {
        assert index < columnCount;
        double min = value[0][index];
        for (Double[] doubles : value) {
            if (doubles[index] < min) {
                min = doubles[index];
            }
        }
        return min;
    }

    public double min() {
        return minMax(true);
    }

    public double max() {
        return minMax(false);
    }

    private double minMax(boolean min) {
        double minMax = value[0][0];
        for (Double[] doubles : value) {
            for (Double aDouble : doubles) {
                if (min) {
                    if (aDouble < minMax) {
                        minMax = aDouble;
                    }
                } else {
                    if (aDouble > minMax) {
                        minMax = aDouble;
                    }
                }
            }
        }
        return minMax;
    }
}
