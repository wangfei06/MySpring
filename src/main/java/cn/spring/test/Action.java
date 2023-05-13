package cn.spring.test;

public class Action implements IAction {
    @Override
    public void doAction() {
        System.out.println("really do action");
    }
}
