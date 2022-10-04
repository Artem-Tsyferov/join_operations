package ua.artem.tsyferov.joinoperation.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ua.artem.tsyferov.dataholder.DataRow;
import ua.artem.tsyferov.dataholder.JoinedDataRow;
import util.DataRowCollectionFactory;

import java.util.Collection;
import java.util.List;

class InnerJoinOperationTest {

    private final InnerJoinOperation<Integer, String, String> innerJoinOperation = new InnerJoinOperation<>();

    @Test
    void join_shouldPerformInnerJoinCorrectly_whenTwoCollectionsContainSameKey() {

        Collection<DataRow<Integer, String>> leftCollection =
                DataRowCollectionFactory.createDataRowSingleElementCollection(0, "Hello");
        Collection<DataRow<Integer, String>> rightCollection =
                DataRowCollectionFactory.createDataRowSingleElementCollection(0, "World");

        Collection<JoinedDataRow<Integer, String, String>> expected =
                List.of(new JoinedDataRow<>(0, "Hello", "World"));

        Assertions.assertEquals(expected.toString(), innerJoinOperation.join(leftCollection, rightCollection).toString());
    }

    @Test
    void join_shouldReturnEmptyCollection_WhenTwoCollectionsDoNotContainSameKeys() {

        Collection<DataRow<Integer, String>> leftCollection =
                DataRowCollectionFactory.createDataRowSingleElementCollection(1, "Hello");
        Collection<DataRow<Integer, String>> rightCollection =
                DataRowCollectionFactory.createDataRowSingleElementCollection(0, "World");

        Collection<JoinedDataRow<Integer, String, String>> expected = List.of();

        Assertions.assertEquals(expected.toString(), innerJoinOperation.join(leftCollection, rightCollection).toString());
    }

    @Test
    void join_shouldPerformInnerJoinCorrectly_WhenCollectionsContainNullKey() {

        Collection<DataRow<Integer, String>> leftCollection =
                DataRowCollectionFactory.createDataRowSingleElementCollection(null, "Hello");
        Collection<DataRow<Integer, String>> rightCollection =
                DataRowCollectionFactory.createDataRowSingleElementCollection(null, "World");

        Collection<JoinedDataRow<Integer, String, String>> expected =
                List.of(new JoinedDataRow<>(null, "Hello", "World"));

        Assertions.assertEquals(expected.toString(), innerJoinOperation.join(leftCollection, rightCollection).toString());
    }
}