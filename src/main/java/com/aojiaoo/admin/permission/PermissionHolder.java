package com.aojiaoo.admin.permission;

import org.springframework.core.NamedInheritableThreadLocal;

/**
 * @author pure
 */
public class PermissionHolder {
    private static final ThreadLocal<CurrentUser> currentUserHolder =
            new NamedInheritableThreadLocal<>("currentUserHolder");

    public static CurrentUser getCurrentUser() {
        return currentUserHolder.get();
    }

    public static void setCurrentUser(CurrentUser currentUser) {
        currentUserHolder.set(currentUser);
    }
}
