package ua.artem.tsyferov.joinoperation.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ua.artem.tsyferov.dataholder.DataRow;
import ua.artem.tsyferov.dataholder.JoinedDataRow;
import util.DataRowCollectionFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class LeftJoinOperationTest {

    private final LeftJoinOperation<Integer, String, String> leftJoinOperation = new LeftJoinOperation<>();

    @Test
    void join_shouldPerformInnerJoinCorrectly_whenTwoCollectionsContainSameKey() {

        Collection<DataRow<Integer, String>> leftCollection =
                DataRowCollectionFactory.createDataRowSingleElementCollection(0, "Hello");
        Collection<DataRow<Integer, String>> rightCollection =
                DataRowCollectionFactory.createDataRowSingleElementCollection(0, "World");

        Collection<JoinedDataRow<Integer, String, String>> expected =
                List.of(new JoinedDataRow<>(0, "Hello", "World"));

        Assertions.assertEquals(expected.toString(), leftJoinOperation.join(leftCollection, rightCollection).toString());
    }

    @Test
    void join_shouldReturnJoinedCollectionCorrectly_WhenTwoCollectionsDoNotContainSameKeys() {

        Collection<DataRow<Integer, String>> leftCollection =
                DataRowCollectionFactory.createDataRowSingleElementCollection(1, "Hello");
        Collection<DataRow<Integer, String>> rightCollection =
                DataRowCollectionFactory.createDataRowSingleElementCollection(0, "World");

        Collection<JoinedDataRow<Integer, String, String>> expected =
                List.of(new JoinedDataRow<>(1, "Hello", null));

        Assertions.assertEquals(expected.toString(), leftJoinOperation.join(leftCollection, rightCollection).toString());
    }

    @Test
    void join_shouldReturnJoinedCollectionCorrectly_WhenLeftCollectionContainsNullKey() {

        Collection<DataRow<Integer, String>> leftCollection =
                DataRowCollectionFactory.createDataRowSingleElementCollection(null, "Hello");
        Collection<DataRow<Integer, String>> rightCollection =
                DataRowCollectionFactory.createDataRowSingleElementCollection(0, "World");

        Collection<JoinedDataRow<Integer, String, String>> expected =
                List.of(new JoinedDataRow<>(null, "Hello", null));

        Assertions.assertEquals(expected.toString(), leftJoinOperation.join(leftCollection, rightCollection).toString());
    }

    @Test
    void join_shouldReturnEmptyCollection_WhenLeftCollectionIsEmpty() {

        Collection<DataRow<Integer, String>> leftCollection = new ArrayList<>();
        Collection<DataRow<Integer, String>> rightCollection =
                DataRowCollectionFactory.createDataRowSingleElementCollection(0, "World");

        Collection<JoinedDataRow<Integer, String, String>> expected =
                List.of();

        Assertions.assertEquals(expected.toString(), leftJoinOperation.join(leftCollection, rightCollection).toString());
    }

}