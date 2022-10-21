package smartStore2.src.me.smartstore.project.menu;

import me.smartstore.project.customers.ClassifiedCustomersGroup;
import me.smartstore.project.customers.Customers;
import me.smartstore.project.exception.InputEmptyException;
import me.smartstore.project.exception.InputRangeException;
import me.smartstore.project.groups.Groups;
import me.smartstore.project.util.ErrorMessage;

public class SummarizedMenu extends smartStore2.src.me.smartstore.project.menu.Menu {

    private static SummarizedMenu classifiedMenu;
    private final Groups allGroups = Groups.getInstance();
    private final Customers allCustomers = Customers.getInstance();

    private ClassifiedCustomersGroup classifiedCustomersGroup = ClassifiedCustomersGroup.getInstance();

    public static SummarizedMenu getInstance() {
        if (classifiedMenu == null) {
            classifiedMenu = new SummarizedMenu();
        }
        return classifiedMenu;
    }

    public int dispSummaryMenu() {
        while (true) {
            try {
                System.out.println();
                System.out.println("==============================");
                System.out.println(" 1. Summary");
                System.out.println(" 2. Summary (Sorted By Name)");
                System.out.println(" 3. Summary (Sorted By Spent Time)");
                System.out.println(" 4. Summary (Sorted By Total Payment)");
                System.out.println(" 5. Back");
                System.out.println("==============================");
                System.out.print("Choose One: ");
                int choice = Integer.parseInt(smartStore2.src.me.smartstore.project.menu.Menu.sc.next());
                if (choice >= 1 && choice <= 5) {
                    return choice;
                }
                throw new InputRangeException();
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.ERR_MSG_INVALID_INPUT_FORMAT);
            } catch (InputRangeException e) {
                System.out.println(ErrorMessage.ERR_MSG_INVALID_INPUT_RANGE);
            }
        }
    }
    //고객분류 이름, 시간, 금액 순으로 정렬

    public void manageSummaryMenu() {
        classifiedCustomersGroup = allCustomers.classify();
        //System.out.println("Arrays.toString(classifiedCustomersGroup.getClassifiedCustomers()) = " + Arrays.toString(classifiedCustomersGroup.getClassifiedCustomers()));

        while (true) {
            int choice = dispSummaryMenu();
            if (choice == 1) {
                dispSummary();
            } else if (choice == 2) {
                manageSortedByName();
            } else if (choice == 3) {
                manageSortedBySpentTime();
            } else if (choice == 4) {
                manageSortedByTotalPay();
            } else if (choice == 5) {
                return;
            } else {
                System.out.println("\n" + ErrorMessage.ERR_MSG_INVALID_INPUT_RANGE);
            }
        }
    }
    // 관리 요약 메뉴

    public void dispSummary() {

        if (classifiedCustomersGroup == null) {
            System.out.println(ErrorMessage.ERR_MSG_INVALID_INPUT_NULL);
            return;
        }
        classifiedCustomersGroup.print();
    }

    public void manageSortedByName() {
        while (true) {
            String strOrder = chooseSortOrder().toUpperCase();
            if (strOrder.equals(ErrorMessage.END_MSG)) {
                return;
            }

            try {
                smartStore2.src.me.smartstore.project.menu.OrderType orderType = smartStore2.src.me.smartstore.project.menu.OrderType.valueOf(strOrder);
                if (orderType == smartStore2.src.me.smartstore.project.menu.OrderType.ASCENDING) {
                    classifiedCustomersGroup.sortByName(smartStore2.src.me.smartstore.project.menu.OrderType.ASCENDING);
                } else {
                    classifiedCustomersGroup.sortByName(smartStore2.src.me.smartstore.project.menu.OrderType.DESCENDING);
                }
            } catch (IllegalArgumentException e) {
                System.out.println("\n" + ErrorMessage.ERR_MSG_INVALID_INPUT_TYPE);
            }

            dispSummary();
        }
    }

    public void manageSortedBySpentTime() {
        while (true) {
            String strOrder = chooseSortOrder().toUpperCase();
            if (strOrder.equals(ErrorMessage.END_MSG)) {
                return;
            }

            try {
                smartStore2.src.me.smartstore.project.menu.OrderType orderType = smartStore2.src.me.smartstore.project.menu.OrderType.valueOf(strOrder);
                if (orderType == smartStore2.src.me.smartstore.project.menu.OrderType.ASCENDING) {
                    classifiedCustomersGroup.sortedBySpentTime(smartStore2.src.me.smartstore.project.menu.OrderType.ASCENDING);
                } else {
                    classifiedCustomersGroup.sortedBySpentTime(smartStore2.src.me.smartstore.project.menu.OrderType.DESCENDING);
                }
            } catch (IllegalArgumentException e) {
                System.out.println("\n" + ErrorMessage.ERR_MSG_INVALID_INPUT_TYPE);
            }

            dispSummary();
        }
    }

    public void manageSortedByTotalPay() {
        while (true) {
            String strOrder = chooseSortOrder().toUpperCase();
            if (strOrder.equals(ErrorMessage.END_MSG)) {
                return;
            }

            try {
                smartStore2.src.me.smartstore.project.menu.OrderType orderType = smartStore2.src.me.smartstore.project.menu.OrderType.valueOf(strOrder);
                if (orderType == smartStore2.src.me.smartstore.project.menu.OrderType.ASCENDING) {
                    classifiedCustomersGroup.sortedByTotalPay(smartStore2.src.me.smartstore.project.menu.OrderType.ASCENDING);
                } else {
                    classifiedCustomersGroup.sortedByTotalPay(smartStore2.src.me.smartstore.project.menu.OrderType.DESCENDING);
                }
            } catch (IllegalArgumentException e) {
                System.out.println("\n" + ErrorMessage.ERR_MSG_INVALID_INPUT_TYPE);
            }
            dispSummary();
        }

    }
    public String chooseSortOrder() {
        while (true) {
            try {
                System.out.println();
                System.out.println("** Press 'end', if you want to exit! **");
                System.out.print("Which order (ASCENDING, DESCENDING)? ");
                String choice = smartStore2.src.me.smartstore.project.menu.Menu.sc.next().toUpperCase();
                if (choice == null) {
                    throw new NullPointerException();
                }

                if (choice.equals("")) {
                    throw new InputEmptyException();
                }

                if (choice.equals(ErrorMessage.END_MSG)) {
                    return choice;
                }

                try {
                    smartStore2.src.me.smartstore.project.menu.OrderType orderType = smartStore2.src.me.smartstore.project.menu.OrderType.valueOf(choice);

                    for (int i = 0; i < smartStore2.src.me.smartstore.project.menu.OrderType.values().length; ++i) {
                        if (orderType == smartStore2.src.me.smartstore.project.menu.OrderType.values()[i]) {
                            return choice;
                        }
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(ErrorMessage.ERR_MSG_INVALID_INPUT_TYPE);
                }
            } catch (NullPointerException e) {
                System.out.println(ErrorMessage.ERR_MSG_INVALID_INPUT_NULL);
            } catch (InputEmptyException e) {
                System.out.println(ErrorMessage.ERR_MSG_INVALID_INPUT_EMPTY);
            } catch (InputRangeException e) {
                System.out.println(ErrorMessage.ERR_MSG_INVALID_INPUT_RANGE);
            }
        }
    }
}




