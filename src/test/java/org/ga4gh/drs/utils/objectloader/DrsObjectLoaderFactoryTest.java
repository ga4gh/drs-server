package org.ga4gh.drs.utils.objectloader;

import org.ga4gh.drs.App;
import org.ga4gh.drs.AppConfig;
import org.ga4gh.drs.model.AccessType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
@SpringBootTest
@ContextConfiguration(classes={App.class, AppConfig.class})
public class DrsObjectLoaderFactoryTest extends AbstractTestNGSpringContextTests {

    @Autowired
    DrsObjectLoaderFactory drsObjectLoaderFactory;

    @DataProvider(name = "cases")
    public Object[][] getData() {
        return new Object[][]{
            {AccessType.FILE, "test.id.0", "/path/to/the/file.bam", true, "FileDrsObjectLoader"},
            {AccessType.HTTPS, "test.id.1", "datasite.com/path/to/object.bam", true, "HttpsDrsObjectLoader"},
            {null, null, null, false, null}
        };
    }

    @Test(dataProvider = "cases")
    public void testCreateDrsObjectLoader(AccessType accessType, String objectId, String objectPath, boolean expLoaded, String expClassName) {
        DrsObjectLoader drsObjectLoader = drsObjectLoaderFactory.createDrsObjectLoader(accessType, objectId, objectPath);
        if (expLoaded) {
            Assert.assertNotNull(drsObjectLoader);
            String className = drsObjectLoader.getClass().getSimpleName();
            Assert.assertEquals(className, expClassName);
        } else {
            Assert.assertNull(drsObjectLoader);
        }
    }
}
