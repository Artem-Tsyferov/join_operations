package ua.artem.tsyferov;

import ua.artem.tsyferov.facade.JoinOperationsFacade;
import ua.artem.tsyferov.facade.impl.JoinOperationsFacadeImpl;

public class Main {
    public static void main(String[] args) {

        final JoinOperationsFacade facade = new JoinOperationsFacadeImpl();
        facade.performInnerJoin();
        facade.performLeftJoin();
        facade.performRightJoin();
    }
}