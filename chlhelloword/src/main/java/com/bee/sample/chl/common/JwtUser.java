package  com.bee.sample.chl.common;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import java.io.Serializable;



/**
 * JWT登录用户对象
 *
 * @author yangdx
 */
@Data
public class JwtUser implements Serializable {
    public JwtUser() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    /**
     * 用户ID
     */
    private String username;

    /**
     * 显示名称
     */
    private String displayName;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 组织机构id
     */
    private String orgId;


}
