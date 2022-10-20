package me.smartstore.project.customers;

import me.smartstore.project.groups.GroupType;
import me.smartstore.project.menu.OrderType;
import me.smartstore.project.menu.comparator.*;

import java.util.Arrays;

public class ClassifiedCustomersGroup {
    private static ClassifiedCustomersGroup classifiedCustomersGroup;
    // 해당 프로그램 안에서 하나만 존재 - 싱글톤 패턴을 구현

    private ClassifiedCustomers[] classifiedCustomers;

    private ClassifiedCustomersGroup() {
        classifiedCustomers = new ClassifiedCustomers[GroupType.values().length];
        for (int i = 0; i < classifiedCustomers.length; i++) {
            classifiedCustomers[i] = new ClassifiedCustomers();
        }
    }

    public static ClassifiedCustomersGroup getInstance() {
        if(classifiedCustomersGroup == null) {
            classifiedCustomersGroup = new ClassifiedCustomersGroup();
        }
        return classifiedCustomersGroup;
    }
// grouptype 에 있는 객체들을 모두 관리하는
// 객체가 무조건 하나 생겨야 함, 하나로만 묶을!, 싱글톤 패턴을 구현하는 > ClassifiedCustomersGroup
// 4이 모두 모여서 해당 프로그램 안에 딱하나만 존재할 수 있게
// 그룹은 하나로 관리가 됨
// 무조건 한곳에 다 담아야 하는 애들 - 커스토머즈
// 그룹 타입에 있는 애들을 한데 관리하는
// ㅋㅓ스토머 들이 다 한데 묶여서 관리가 될것
// 커스토머 > 커스토머즈로 묶어서 > 익스텐드 받아서 그룹을 만들고 > 커스모터즈에서 그룹만 추가한것
// 4명이 한데 모여 있음

    public static ClassifiedCustomersGroup getClassifiedCustomersGroup() {return classifiedCustomersGroup;}

    public static void setClassifiedCustomersGroup(ClassifiedCustomersGroup classifiedCustomersGroup) {
        ClassifiedCustomersGroup.classifiedCustomersGroup = classifiedCustomersGroup;}

    public ClassifiedCustomers[] getClassifiedCustomers() {return classifiedCustomers;}

    public void setClassifiedCustomers(ClassifiedCustomers[] classifiedCustomers) {
        this.classifiedCustomers = classifiedCustomers;
    }

    public ClassifiedCustomers get(int i) {return classifiedCustomers[i];}
    public void set(int i, ClassifiedCustomers customers) {classifiedCustomers[i] = customers;}

    public int length() {return GroupType.values().length;}

    public void print() {
        for (int i = 0; i < classifiedCustomers.length; i++) {
            System.out.println("==============================");
            System.out.println("Group : " + classifiedCustomers[i].getGroup(),getType());
            System.out.println("==============================");

            if (classifiedCustomers[i] == null || classifiedCustomers[i].isEmpty()) {
                System.out.println("Null.");
                continue;
            }
            classifiedCustomers[i].print();
            System.out.println("==============================\n");
        }
    }


    public void sortByName(OrderType orderType) {
        if (orderType != null && !orderType.equals("")) {
            for (int i = 0; i < classifiedCustomersGroup.length(); ++i) {
                Customer[] customers = classifiedCustomersGroup.get(i).getCustomers();
                if (orderType == OrderType.ASCENDING) { //  오름차순
                    Arrays.sort(customers);
                } else {
                    Arrays.sort(customers, new CompByNameDesc());
                }
                classifiedCustomersGroup.get(i).setCustomers(customers);
            }
        }
    }

    public void sortedBySpentTime(OrderType orderType) {
        if (orderType != null && !orderType.equals("")) {
            for (int i = 0; i < classifiedCustomersGroup.length(); ++i) {
                Customer[] customers = classifiedCustomersGroup.get(i).getCustomers();
                if (orderType == OrderType.ASCENDING) {
                    Arrays.sort(customers, new CompByTimeAsc());
                } else {
                    Arrays.sort(customers, new CompByTimeDesc());
                }
                classifiedCustomersGroup.get(i).setCustomers(customers);
            }
        }
    }

    public void sortedByTotalPay(OrderType orderType) {
        if (orderType != null && !orderType.equals("")) {
            for (int i = 0; i < classifiedCustomersGroup.length(); ++i) {
                Customer[] customers = classifiedCustomersGroup.get(i).getCustomers();
                if (orderType == OrderType.ASCENDING) {
                    Arrays.sort(customers, new CompByPayAsc());
                } else {
                    Arrays.sort(customers, new CompByPayDesc());
                }
                classifiedCustomersGroup.get(i).setCustomers(customers);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassifiedCustomersGroup that = (ClassifiedCustomersGroup) o;
        return Arrays.equals(classifiedCustomers, that.classifiedCustomers);
    }

    @Override
    public int hashCode() {return Arrays.hashCode(classifiedCustomers);}

    @Override
    public String toString() {
        return "ClassifiedCustomersGroup { " +
                "classifiedCustomers = " +
                Arrays.toString(classifiedCustomers) + '}';
    }
}