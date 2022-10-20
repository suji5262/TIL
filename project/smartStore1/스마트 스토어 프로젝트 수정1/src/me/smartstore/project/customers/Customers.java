package me.smartstore.project.customers;

import me.smartstore.project.groups.Groups;

import javax.swing.plaf.PanelUI;
import java.util.Arrays;

public class Customers {

    protected static Customers allCustomers;

    protected final Groups allGroups = Groups.getInstance();

    public static int SIZE = 10;
    protected int count;
    protected Customer[] customers;

    public static Customers getInstance() {
        if (allCustomers == null) {
            allCustomers = new Customers();
        }
        return allCustomers;
    }

    public Customers() { this.customers = new Customer[SIZE]; }

    public Customer[] getCustomers() {
        int realCount = 0;

        for (int i = 0; i < this.customers.length && this.customers[i] != null; i++) {
            ++realCount;
        }
        return Arrays.copyOf(this.customers, realCount);
    }
    public void setCustomers(Customer[] customers) { this.customers = customers; }

    public int getCount() { return count; }

    public void setCount(int count) { this.count = count; }

    public int length() {
        return this.customers.length;
    }

    private boolean isNull() {
        return this.customers == null;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public void add(Customer customer) {
        if (this.count < SIZE) {
            this.customers[this.count] = customer;
            ++this.count;
        } else {
            this.extend(customer);
        }
    }

    public void add(int index, Customer customer) {
        if (index < this.count) {
            Customer var10000 = this.customers[index];

            for (int i = this.customers.length - 1; i >= index; --i) {
                this.customers[i + 1] = this.customers[i];
            }

            this.customers[index]
        }
    }


}











//    protected Customers() {
//        customers = new Customer[DEFAULT_SIZE];
//        size = DEFAULT_SIZE; // 현재 사이즈를 디폴트로
//    }
//    // 아무것도 안들어 올때
//    // 초기값을 안 넣으면 디폴트 사이즈
//
//    protected Customers(int size){
//        customers = new Customer[size];
//        this.size = size;
//    }
//    // 입력값이 들어오면 들어온 값으로 현재 사이즈를 업데이트
//
//    protected Customers(Customer[] customers) {
//        if (customers != null) {
//            this.customers = customers;
//            count = customers.length; // 실제 개수만큼 들어오게
//        }
//    }
//    public Customer[] getCustomers() {
//        return Arrays.copyOf(customers, count);
//    } // 커스토머즈를 카운트 만큼
//
//    public void setCustomers(Customer[] customers) {
//        this.customers = customers;
//    }
//    public boolean isEmpty() {
//        return count == 0;
//    } // 0이 맞으면 empty가 true
//    public void grow() {
//        Customer[] copy = Arrays.copyOf(customers, count); //기존에 가지고 있던것을 카피
//        size *= 2;
//        customers = Arrays.copyOf(copy, size); // 기존 것을 담고 사이즈 만큼 새로운 랭스를 만들어서 반환
//    }
//    // 배열을 성장시켜줘야함 - 2배를
//    //카피를 복사해줘야함
//    public void add(Customer customer) { // 맨뒤에 커스토머를 추가, 배열 끝에 추가
//        if(customer == null) return; // 인자로 들어온게 커스토머면 리턴
//
//        if (count < size) {
//            customers[count] = customer;
//            count++;
//        } else {
//            grow();;
//            add(customer);
//        }
//    }
//// add 인자로 커스토머 1명이 들어옮
//
//    public void add(int i, Customer customer) { // i로 뭐가 들어오고 중간에 추가
//        if (!(i >=0 && i <= count)) return;
//        if (customer == null) return;
//
//        if (count < size) {
//            Customer[] copy = Arrays.copyOfRange(customers, i, count);
//            customers[i] = customer;
//            count++;
//
//            System.arraycopy(customer, i+1, copy, 0, copy.length);
//            // 카피를 하는데 소스포지션에서 카운트 부터 ~ 0번 부터 카피를 하겠다. 카피 랭스까지
//
////            if (int j = 0; j< copy.length, j++){
////                customers[j + count] = copy[j];
//        } else {
//            grow();
//            add(i, customer);
//        }
//    }
//
//    public void remove(int i) {
//        if (!(0 <=i && i < count)) return;
//        if (isEmpty()) return;
//
//        customers[i] = null;
//        Customer[] copy = Arrays.copyOfRange(customers, i+1, count);
//    }
//
//    public Customer pop(int i) {
//        if (!(i >= 0 && i < count)) return null;
//        if (isEmpty()) return null;
//
//        Customer[] copy = Arrays.copyOfRange(customers, i+1, count);
//        Customer removeNode = customers[i];
//        customers[i] = null;
//        count--;
//
//        System.arraycopy(customers, i, copy, 0, copy.length);
//        return removeNode;
//    }
//
//    public Customer pop() {
//        if (isEmpty()) return null;
//
//        Customer popNode = customers[count - 1];
//        customers[count - 1 ] = null;
//        count--;
//
//        return popNode;
//    }
//
//    public Customer get(int i) {
//        if (!(i >= 0 && i < count)) return null;
//        return customers[i];
//    }
//
//    public void set(int i, Customer customer) {
//        if (!(i >= 0 && i < count)) return;
//        if (customer == null)return;
//        customers[i] = customer;
//    }
//
//
//    public void print() {
//        for (int i = 0; i < count; i++) {
//            if (customers[i] != null) {
//                System.out.printf("No. %4d => %s\n", (i+1), customers[i]);
//            }
//        }
//    }
//
//    public ClassifiedCustomers classify() {
//        // TODO: ClassifiedCustomers classify()
//        return null;
//    }
//
//    @Override
//    public String toString() {
//        String str = "";
//
//        for (int i = 0; i < count; i++) {
//            str += customers[i] + "\n";
//        }
//        return str;
//    }
//
//}
//// 싱글톤 패턴으로 구현해라
////모든 커스토머들의 정보를 담을 커스토머객체 하나를 생성
//// 그룹 하나만 담을 것
