package smartStore2.src.me.smartstore.project.customers;

import me.smartstore.project.groups.Group;

import java.util.Arrays;
import java.util.Objects;

public class ClassifiedCustomers extends Customers {
    private Group group;

    public ClassifiedCustomers() {}

    public ClassifiedCustomers(Group group) {this.group = group;}

    public Group getGroup() {return group; }

    public void setGroup(Group group) {this.group = group; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassifiedCustomers that = (ClassifiedCustomers) o;
        return group.equals(that.group);
    }

    @Override
    public int hashCode() {return Objects.hash(group);}

    @Override
    public String toString() {
        return "ClassifiedCustomers {" +
                "group = " + group +
                "allGroups = " + allGroups +
                "count = " + count +
                ", customers = " + Arrays.toString(customers) +
                '}';
    }
}
// new 를 해서 총 4명이 생길수 있음 각 그룹마다
// 배열보다는 extends 로 하는것이
// 분류된 고객
// 각 그룹마다 4명이 생길 수 있음
