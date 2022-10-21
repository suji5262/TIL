package smartStore2.src.me.smartstore.project.customers;

import me.smartstore.project.groups.Group;

import java.util.Objects;

public class Customer implements Comparable<Customer> {
    protected String serialNo;
    protected String name;
    protected String userID;
    protected int spentTime;
    protected int totalPay;

    protected Group group;

    private static int AUTO_GENERATOR = 0;

    public Customer() {
        AUTO_GENERATOR ++; //고객 일련번호 자동생성
        serialNo = String.format("%04d", AUTO_GENERATOR);
    }

    public Customer(String name, String userID, int spentTime,int totalPay) {
        ++AUTO_GENERATOR;
        this.serialNo = String.format("%04d", AUTO_GENERATOR);
        this.name = name;
        this.userID = userID;
        this.spentTime = spentTime;
        this.totalPay = totalPay;
    }

    public String getSerialNo() {return this.serialNo;}
    private void setSerialNo(String serialNo) {this.serialNo = serialNo;}

    public String getName() {return this.name;}
    public void setName(String name) {this.name = name;}

    public String getUserID() {return this.userID;}
    public void setUserID(String userID) {this.userID = userID;}

    public int getSpentTime() {return this.spentTime;}
    public void setSpentTime(int spentTime) {this.spentTime = spentTime;}

    public int getTotalPay() {return this.totalPay;}
    public void setTotalPay(int totalPay) {this.totalPay = totalPay;}

    public Group getGroup() {return this.group;}

    public void setGroup(Group group) {this.group = group;}


    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Customer customer = (Customer) o;
            return this.spentTime == customer.spentTime
                    && this.totalPay == customer.totalPay
                    && Objects.equals(this.serialNo, customer.serialNo)
                    && Objects.equals(this.name, customer.name)
                    && Objects.equals(this.userID, customer.userID)
                    && Objects.equals(this.group, customer.group);
        } else {
            return false;
        }
    }
    //object 클래스에서 가져온 함수
    // o = 파라미터로 받은 object
    // if(this == o) > this와 인자로 받은 o와 같으면 true
    // o == null > 인자로 받은 오브젝트가 null 이거나 getClass()랑, o.getClass()가 같지않으면 false
    //getClass() > 현재 참조하고 있는 클래스 확인하는 함수
    // int ==, String  equals 오브젝트의 변수들과 같은지 비교


    public int hashCode() {
        return Objects.hash(this.serialNo, this.name, this.userID, this.spentTime, this.totalPay, this.group);
    }

    public String toString() {
        return "Customer {serialNo= '" + this.serialNo +
                "', name = " + this.name +
                "', userID = " + this.userID +
                "', spentTime = " + this.spentTime +
                "', totalPay = " + this.totalPay + "}";
    }

    public int compareTo(Customer o) {
        if (this.name.compareTo(o.name) < 0) return -1;
        else if (this.name.compareTo(o.name) == 0) return this.userID.compareTo(o.userID);
        else return 1;
    }

}








