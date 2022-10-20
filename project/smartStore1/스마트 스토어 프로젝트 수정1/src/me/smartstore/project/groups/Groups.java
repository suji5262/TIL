package me.smartstore.project.groups;

public class Groups {

    private Group[] groups;
    private static Groups allGroups;
    private static final int DEFAULT_SIZE = GroupType.values().length; // values() > 해당 열거체의 모든 상수를 저장한 배열을 생성해 반환
    private int count = 0; // 그룹타입과 파라미터까지 들어올 때 증가

    public static Groups getInstance() {
        if (allGroups == null) {
            allGroups = new Groups();
        }
        return allGroups; // null이 아니면 기존것으로 리턴하겠음
    }
    //  객체가 무조건 한개만 생길 수 있도록 > 싱글톤 패턴
    // getInstance 로 접근해서  static 으로 한개만 만들 수 있게
    // 갖고있는 자기자신에 리턴
    private Groups() {
        groups = new Group[DEFAULT_SIZE];

        int i = 0;
        for (GroupType groupType: GroupType.values()) {
            groups[i] = new Group(groupType, null);
            i++;
        }
    }

    public boolean isEmpty() {return count == 0;}

    public void add(Group group) {
        if (group == null) return;

        if (count < DEFAULT_SIZE) {
            groups[count] = group;
            count++;
        }
    }

    public Group get(int i) {
        if (!(i >= 0 && i < count)) return  null;
        return groups[i];
    }

    public void set(int i, Group group) {
        if (!(i >= 0 && i < count)) return;
        if (groups == null) return;
        groups[i] = group;
    }

    public Group pop(int i) {
        if (!(i >= 0 && i < count)) return null;
        if (isEmpty()) return null;
        if (groups[i] == null) return null;

        Group popNode = groups[i];
        groups[i] = null;

        return popNode;
    }

    public Group pop() {return pop(count - 1);}

    public void print() {
        for (int i = 0; i < count; i++) {
            if (groups[i] != null) {
                System.out.println(groups[i]);
            }
        }
    }

    @Override
    public  String toString() {
        String str = "";

        for (int i = 0; i < count; i++) {
            str += groups[i] + "\n";
        }
        return str;
    }

}
