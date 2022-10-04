package ua.artem.tsyferov.dataholder;

public class JoinedDataRow<K extends Comparable<K>, V1, V2> {

    private K key;

    private V1 firstValue;

    private V2 secondValue;

    public JoinedDataRow(K key, V1 firstValue, V2 secondValue) {
        this.key = key;
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V1 getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(V1 firstValue) {
        this.firstValue = firstValue;
    }

    public V2 getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(V2 secondValue) {
        this.secondValue = secondValue;
    }

    @Override
    public String toString() {
        return "JoinedDataRow{" +
                "key=" + key +
                ", firstValue=" + firstValue +
                ", secondValue=" + secondValue +
                '}';
    }
}
