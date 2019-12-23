package cn.wtyoha.company_background_system.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Permission {
    String id;
    String permissionName;
    String url;
    List<Role> roleList;

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permission that = (Permission) o;
        return Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url);
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id='" + id + '\'' +
                ", permissionName='" + permissionName + '\'' +
                ", url='" + url + '\'' +
                ", roleList=" + roleList +
                '}';
    }

    public static void main(String[] args) {
        Permission p1 = new Permission();
        Permission p2 = new Permission();
        p1.setUrl("user/new");
        p2.setUrl("user/new");
        HashSet<Permission> s = new HashSet<>();
        s.add(p1);
        boolean contains = s.contains(p2);
        System.out.println(p1.equals(p2));
    }
}
