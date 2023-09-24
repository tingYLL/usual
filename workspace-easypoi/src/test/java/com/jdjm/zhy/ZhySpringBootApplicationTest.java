package com.jdjm.zhy;

import com.jdjm.zhy.service.SysRoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class ZhySpringBootApplicationTest {

    @Autowired
    private SysRoleService sysRoleService;

    @Test
    public void testExport() throws IOException {
        sysRoleService.export();
    }
}
