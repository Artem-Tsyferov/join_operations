package ua.artem.tsyferov.joinoperation.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ua.artem.tsyferov.dataholder.DataRow;
import ua.artem.tsyferov.dataholder.JoinedDataRow;
import util.DataRowCollectionFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class RightJoinOperationTest {

    private final RightJoinOperation<Integer, String, String> rightJoinOperation = new RightJoinOperation<>();

    @Test
    void join_shouldPerformInnerJoinCorrectly_whenTwoCollectionsContainSameKey() {

        Collection<DataRow<Integer, String>> leftCollection =
                DataRowCollectionFactory.createDataRowSingleElementCollection(0, "Hello");
        Collection<DataRow<Integer, String>> rightCollection =
                DataRowCollectionFactory.createDataRowSingleElementCollection(0, "World");

        Collection<JoinedDataRow<Integer, String, String>> expected =
                List.of(new JoinedDataRow<>(0, "Hello", "World"));

        Assertions.assertEquals(expected.toString(), rightJoinOperation.join(leftCollection, rightCollection).toString());
    }

    @Test
    void join_shouldReturnJoinedCollectionCorrectly_WhenTwoCollectionsDoNotContainSameKeys() {

        Collection<DataRow<Integer, String>> leftCollection =
                DataRowCollectionFactory.createDataRowSingleElementCollection(1, "Hello");
        Collection<DataRow<Integer, String>> rightCollection =
                DataRowCollectionFactory.createDataRowSingleElementCollection(0, "World");

        Collection<JoinedDataRow<Integer, String, String>> expected =
                List.of(new JoinedDataRow<>(0, null, "World"));

        Assertions.assertEquals(expected.toString(), rightJoinOperation.join(leftCollection, rightCollection).toString());
    }

    @Test
    void join_shouldReturnJoinedCollectionCorrectly_WhenRightCollectionContainsNullKey() {

        Collection<DataRow<Integer, String>> leftCollection =
                DataRowCollectionFactory.createDataRowSingleElementCollection(1, "Hello");
        Collection<DataRow<Integer, String>> rightCollection =
                DataRowCollectionFactory.createDataRowSingleElementCollection(null, "World");

        Collection<JoinedDataRow<Integer, String, String>> expected =
                List.of(new JoinedDataRow<>(null, null, "World"));

        Assertions.assertEquals(expected.toString(), rightJoinOperation.join(leftCollection, rightCollection).toString());
    }

    @Test
    void join_shouldReturnEmptyCollection_WhenRightCollectionIsEmpty() {

        Collection<DataRow<Integer, String>> leftCollection =
                DataRowCollectionFactory.createDataRowSingleElementCollection(1, "Hello");
        Collection<DataRow<Integer, String>> rightCollection = new ArrayList<>();

        Collection<JoinedDataRow<Integer, String, String>> expected =
                List.of();

        Assertions.assertEquals(expected.toString(), rightJoinOperation.join(leftCollection, rightCollection).toString());
    }
}