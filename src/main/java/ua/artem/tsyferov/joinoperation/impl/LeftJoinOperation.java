package ua.artem.tsyferov.joinoperation.impl;

import ua.artem.tsyferov.dataholder.DataRow;
import ua.artem.tsyferov.dataholder.JoinedDataRow;
import ua.artem.tsyferov.joinoperation.JoinOperation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class LeftJoinOperation<K extends Comparable<K>, V1, V2>
        implements JoinOperation<DataRow<K, V1>, DataRow<K, V2>, JoinedDataRow<K, V1, V2>> {

    @Override
    public Collection<JoinedDataRow<K, V1, V2>> join(final Collection<DataRow<K, V1>> leftCollection,
                                                     final Collection<DataRow<K, V2>> rightCollection) {

        final Collection<JoinedDataRow<K, V1, V2>> joinedDataRowCollection = new ArrayList<>();

        leftCollection.forEach(leftElement -> {
            rightCollection.stream()
                    .filter(rightElement -> Objects.equals(leftElement.getKey(), rightElement.getKey()))
                    .map(rightElement -> new JoinedDataRow<>(
                            leftElement.getKey(),
                            leftElement.getValue(),
                            rightElement.getValue()))
                    .forEach(joinedDataRowCollection::add);

            if (joinedDataRowCollection.stream().noneMatch(s -> Objects.equals(s.getKey(), leftElement.getKey()))) {
                joinedDataRowCollection.add(new JoinedDataRow<>(
                        leftElement.getKey(),
                        leftElement.getValue(),
                        null));
            }
        });
        return joinedDataRowCollection;
    }
}
