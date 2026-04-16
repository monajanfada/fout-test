package test;

import test.BasicInformationTest.ProductHierarchyTest.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({CompanyTest.class, BrandTest.class, LineTest.class, ClassTest.class, CategoryTest.class, GroupTest.class})
public class FoutTest {
}

