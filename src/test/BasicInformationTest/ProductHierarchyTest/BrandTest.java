package test.BasicInformationTest.ProductHierarchyTest;

import org.openqa.selenium.WebElement;
import test.BaseTest;

import java.util.List;

import static test.Menu.BASIC_INFORMATION_PRODUCTHIERARCHY_BRAND;

public class BrandTest extends BaseTest {

    private static final String FARSI_NAME_CREATE = "برند لافاررر";
    private static final String ENGLISH_NAME_CREATE = "Lafarrerrr Brand";
    private static final String FARSI_NAME_EDIT = "برند ویرایش شده";
    private static final String ENGLISH_NAME_EDIT = "Edited Brand";
    public static final String ENGLISH_NAME = "englishName";
    public static final String NAME = "name";
    public static final String NEW_ITEM = "newItem";
    public static final String PARENT = "parent";
    public static final String PARENT_OPTION_0 = "parent-option-0";
    public static final String SUBMIT_BRAND = "submitBrand";
    public static final String EDIT_0 = "edit-0";
    public static final String REMOVE_0 = "remove-0";
    public static final String SWAL_BTN_CONFIRM = "SwalBtnConfirm";
    public static final String SWAL_BTN_CONFIRM1 = "SwalBtnConfirm";
    public static final String PARENT_NAME = "parent.name";
    public static final String COMPANY  = "مام میهن";


    @Override
    public void internalTest() {
        login();
        saveBrand();
        searchBrand(COMPANY, FARSI_NAME_CREATE, false);
        editBrand();
        searchBrand(COMPANY, FARSI_NAME_EDIT, false);
        deleteBrand();
        searchBrand(COMPANY, FARSI_NAME_EDIT, true);
    }


    public void searchBrand(String parentName, String farsiName, boolean isForDelete) {

        List<WebElement> childElementByClass = getSearchTableHeaderElements();
        if (childElementByClass != null && childElementByClass.size() > 0) {
            type(childElementByClass.get(0), parentName);
            type(childElementByClass.get(1), farsiName);
        }
        waitForFixedDuration(2000);
        try {
            checkText(PARENT_NAME, parentName);
        } catch (Exception e) {
            if (!isForDelete) {
                throw e;
            }
        }
        try {
            checkText(NAME, farsiName);
        } catch (Exception e) {
            if (!isForDelete) {
                throw e;
            }
        }

        if (!isForDelete) {
            clear(PARENT_NAME);
            clear(NAME);
        }
    }


    public void saveBrand() {

        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Brand
        clickMenu(BASIC_INFORMATION_PRODUCTHIERARCHY_BRAND);

        waitForPageToLoad();

        // Creating new Brand
        click(NEW_ITEM);

        // Filling the boxes
        type(ENGLISH_NAME, ENGLISH_NAME_CREATE);
        type(NAME, FARSI_NAME_CREATE);

        click(PARENT);
        type(PARENT, COMPANY);
        waitForPageToLoad();
        click(PARENT_OPTION_0);


        // Applied wait time
        waitForFixedDuration(2000);

        // Saving Brand
        click(SUBMIT_BRAND);

    }


    public void editBrand() {

        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Brand
        clickMenu(BASIC_INFORMATION_PRODUCTHIERARCHY_BRAND);
        waitForPageToLoad();

//        // Editing Brand
        click(EDIT_0);

        // Clearing the box
        clear(NAME);
        clear(ENGLISH_NAME);

        // Filling the boxes
        type(NAME, FARSI_NAME_EDIT);
        type(ENGLISH_NAME, ENGLISH_NAME_EDIT);

        // Saving edited Brand
        click(SUBMIT_BRAND);

    }


    public void deleteBrand() {

        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Brand
        clickMenu(BASIC_INFORMATION_PRODUCTHIERARCHY_BRAND);

        waitForPageToLoad();

        // Deleting Brand
        click(REMOVE_0);

        click(SWAL_BTN_CONFIRM);

        click(SWAL_BTN_CONFIRM1);

    }

}
