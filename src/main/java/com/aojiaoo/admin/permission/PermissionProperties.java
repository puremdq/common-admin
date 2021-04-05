package com.aojiaoo.admin.permission;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author pure
 */
@Data
@ConfigurationProperties(prefix = "permission")
public class PermissionProperties {
    private String loginPath;
    private String logoutPath;
    private String staticPath;
}
