package me.smartstore.project;

import me.smartstore.project.customers.Customer; // 여기부터
import me.smartstore.project.customers.Customers;
import me.smartstore.project.groups.Group;
import me.smartstore.project.groups.GroupType;
import me.smartstore.project.groups.Groups;
import me.smartstore.project.groups.Parameter; // 여기까지 왜 다르냐..
import me.smartstore.project.menu.CustomerMenu;
import me.smartstore.project.menu.GroupMenu;
import me.smartstore.project.menu.Menu;
import me.smartstore.project.menu.SummaryMenu;
import me.smartstore.project.util.ErrorMessage;


import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public class SmartStoreApplication {

    private static SmartStoreApplication smartStoreApp;

    /* customers object */

    private Customers allCustomers = Customers.getInstance();
    private Groups allGroups = Groups.getInstance();
    private Menu menu = Menu.getInstance();

    /* menu object */
    private GroupMenu groupMenu = GroupMenu.getInstance();
    private CustomerMenu customerMenu = CustomerMenu.getInstance();
    private SummaryMenu summaryMenu = SummaryMenu.getInstance();

    /* method reflect */
    private Class[] classes =
            {GroupMenu.class, CustomerMenu.class, SummaryMenu.class};
    private Object[] instances =
            {groupMenu, customerMenu, summaryMenu};
    private String[] methods =
            {"manage", "manage", "manage"};

    private SmartStoreApplication() {}

    public static SmartStoreApplication getInstance() {
        if (smartStoreApp == null) {
            smartStoreApp = new SmartStoreApplication();
        }
        return smartStoreApp;
    }

    public void details() {
        System.out.println("=============================================");
        System.out.println("Title : SmartStore Customer Classification");
        System.out.println("=============================================\n");
    }

    public SmartStoreApplication test() {
        allGroups.add(new Group(GroupType.GENERAL, new Parameter(10, 100000)));
        allGroups.add(new Group(GroupType.VIP, new Parameter(20, 200000)));
        allGroups.add(new Group(GroupType.VVIP, new Parameter(30, 300000)));

        for (int i = 0; i < 20; i++) {
            allCustomers.add(new Customer("" + (char) (97 + i), (char) (97 + i) + "12345", i * 10, i * 100000));
        }
        return this;
    }

    //this is method for running application.

    public void run() {

        details();
        while (true) {
            int choice = menu.dispMenu();
            if (!(1 <= choice && choice <= methods.length + 1)) {
                System.out.println("\n" + ErrorMessage.ERR_MSG_INVALID_INPUT_RANGE);
            }
            if (choice == methods.length + 1) {
                break;
            }

            try {
                int i = choice -1;
                classes[i].getMethod(methods[i]).invoke(instances[i]);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
