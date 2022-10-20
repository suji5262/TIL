package me.smartstore.project.customers;

import me.smartstore.project.groups.Group;

public class ClassifiedCustomers extends Customers {
    private Group group;
}
// new 를 해서 총 4명이 생길수 있음 각 그룹마다
// 배열보다는 extends 로 하는것이
// 고객분류
// 각 그룹마다 4명이 생길 수 있음