package com.ip_b1.fii.admission;

import com.ip_b1.fii.admission.DTO.AuthEntity;
import com.ip_b1.fii.admission.Utils.AuthUtils;
import org.junit.Assert;
import org.junit.Test;

public class AuthTests {
    @Test
    public void checkAuthInvalidTests() {
        Assert.assertEquals(AuthUtils.checkAuth(new AuthEntity("admin@info.uaic.ro", null)), false);
        Assert.assertEquals(AuthUtils.checkAuth(new AuthEntity("admin@info.uaic.ro", "token_invalid")), false);
        Assert.assertEquals(AuthUtils.checkAuth(new AuthEntity("", "token_invalid")), false);
    }

    @Test
    public void claimsAuthenticatedTests() {
        Assert.assertEquals(AuthUtils.claimsAuthenticated(new AuthEntity(null, "")), false);
        Assert.assertEquals(AuthUtils.claimsAuthenticated(new AuthEntity("", null)), false);
        Assert.assertEquals(AuthUtils.claimsAuthenticated(new AuthEntity("", "")), true);
        Assert.assertEquals(AuthUtils.claimsAuthenticated(new AuthEntity("admin@info.uaic.ro", null)), false);
        Assert.assertEquals(AuthUtils.claimsAuthenticated(new AuthEntity("admin@info.uaic.ro", "token")), true);
    }

    @Test
    public void checkAuthIsAdminTests() {
        Assert.assertEquals(AuthUtils.checkAuthIsAdmin(new AuthEntity("admin@info.uaic.ro", null)), false);
        Assert.assertEquals(AuthUtils.checkAuthIsAdmin(new AuthEntity("admin@info.uaic.ro", "token_invalid")), false);
        Assert.assertEquals(AuthUtils.checkAuthIsAdmin(new AuthEntity("", "token_invalid")), false);
    }


}
