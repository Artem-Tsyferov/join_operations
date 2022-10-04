package util;

import ua.artem.tsyferov.dataholder.DataRow;

import java.util.Collection;
import java.util.List;

public final class DataRowCollectionFactory {

    private DataRowCollectionFactory() {
    }

    public static <K extends Comparable<K>, V> Collection<DataRow<K, V>> createDataRowSingleElementCollection(K key, V value) {
        return List.of(new DataRow<>(key, value));
    }

}

