package org.ga4gh.drs.utils;

import org.ga4gh.drs.App;
import org.ga4gh.drs.AppConfig;
import org.ga4gh.drs.utils.objectloader.DrsObjectLoader;
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
public class DataSourceLookupTest extends AbstractTestNGSpringContextTests {

    @Autowired
    DataSourceLookup dataSourceLookup;

    @DataProvider(name = "cases")
    public Object[][] getData() {
        return new Object[][]{
            {
                "unregisteredid.id00001",
                false,
                null,
                null
            },
            {
                "test.htsjdk.samtools.compressed.bam",
                true,
                "FileDrsObjectLoader",
                "./src/test/resources/data/htsjdk/samtools/compressed.bam"
            },
            {
                "test.htsjdk.samtools.BAMFileIndexTest.index_test.bam",
                true,
                "FileDrsObjectLoader",
                "./src/test/resources/data/htsjdk/samtools/BAMFileIndexTest/index_test.bam"
            },
            {
                "test.phenopackets.Volpi.2",
                true,
                "FileDrsObjectLoader",
                "./src/test/resources/data/phenopackets/Volpi/Volpi-Patient-2.json"
            },
            {
                "test.phenopackets.Tamhankar.1",
                true,
                "FileDrsObjectLoader",
                "./src/test/resources/data/phenopackets/Tamhankar/Tamhankar-Patient-1.json"
            },
            {
                "test.phenopackets.Zapata",
                true,
                "FileDrsObjectLoader",
                "./src/test/resources/data/phenopackets/Zapata"
            }
        };
    }

    @Test(dataProvider = "cases")
    public void testDataSourceLookup(String objectId, boolean expLoaded, String expClassName, String expObjectPath) {
        DrsObjectLoader drsObjectLoader = dataSourceLookup.getDrsObjectLoaderFromId(objectId);
        if (expLoaded) {
            Assert.assertNotNull(drsObjectLoader);
            Assert.assertEquals(drsObjectLoader.getClass().getSimpleName(), expClassName);
            Assert.assertEquals(drsObjectLoader.getObjectPath(), expObjectPath);
        } else {
            Assert.assertNull(drsObjectLoader);
        }
    }
}
