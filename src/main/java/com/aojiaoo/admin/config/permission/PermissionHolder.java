package com.aojiaoo.admin.config.permission;

import org.springframework.core.NamedInheritableThreadLocal;

/**
 * @author pure
 */
public class PermissionHolder {
    private static final ThreadLocal<CurrentUser> CURRENT_USER_HOLDER =
            new NamedInheritableThreadLocal<>("currentUserHolder");

    public static CurrentUser getCurrentUser() {
        return CURRENT_USER_HOLDER.get();
    }

    public static void setCurrentUser(CurrentUser currentUser) {
        CURRENT_USER_HOLDER.set(currentUser);
    }
}
