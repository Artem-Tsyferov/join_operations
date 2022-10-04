package ua.artem.tsyferov.facade.impl;

import ua.artem.tsyferov.dataholder.DataRow;
import ua.artem.tsyferov.dataholder.JoinedDataRow;
import ua.artem.tsyferov.facade.JoinOperationsFacade;
import ua.artem.tsyferov.joinoperation.impl.InnerJoinOperation;
import ua.artem.tsyferov.joinoperation.impl.LeftJoinOperation;
import ua.artem.tsyferov.joinoperation.impl.RightJoinOperation;

import java.util.Collection;
import java.util.List;

public class JoinOperationsFacadeImpl implements JoinOperationsFacade {

    private final InnerJoinOperation<Integer, String, String> innerJoinOperation = new InnerJoinOperation<>();
    private final LeftJoinOperation<Integer, String, String> leftJoinOperation = new LeftJoinOperation<>();
    private final RightJoinOperation<Integer, String, String> rightJoinOperation = new RightJoinOperation<>();

    final Collection<DataRow<Integer, String>> leftCollection = List.of(
            new DataRow<>(0, "Ukraine"),
            new DataRow<>(1, "Germany"),
            new DataRow<>(2, "France")
    );

    final Collection<DataRow<Integer, String>> rightCollection = List.of(
            new DataRow<>(0, "Kyiv"),
            new DataRow<>(1, "Berlin"),
            new DataRow<>(3, "Budapest")
    );

    @Override
    public void performInnerJoin() {
        final Collection<JoinedDataRow<Integer, String, String>> joinedDataRow =
                innerJoinOperation.join(leftCollection, rightCollection);
        System.out.println(joinedDataRow);
    }

    @Override
    public void performLeftJoin() {
        final Collection<JoinedDataRow<Integer, String, String>> joinedDataRow =
                leftJoinOperation.join(leftCollection, rightCollection);
        System.out.println(joinedDataRow);
    }

    @Override
    public void performRightJoin() {
        final Collection<JoinedDataRow<Integer, String, String>> joinedDataRow =
                rightJoinOperation.join(leftCollection, rightCollection);
        System.out.println(joinedDataRow);
    }

}

