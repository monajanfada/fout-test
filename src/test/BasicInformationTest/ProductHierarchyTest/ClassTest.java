package test.BasicInformationTest.ProductHierarchyTest;

import org.openqa.selenium.WebElement;
import test.BaseTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static test.Menu.BASIC_INFORMATION_PRODUCTHIERARCHY_CLASS;


public class ClassTest extends BaseTest {

    private static final String FARSI_NAME_CREATE = "رده شامپو روزانه";
    private static final String ENGLISH_NAME_CREATE = "daily shampoo class";
    private static final String FARSI_NAME_EDIT = "رده ویرایش شده";
    private static final String ENGLISH_NAME_EDIT = "Edited Class";
    public static final String NEW_ITEM = "newItem";
    public static final String ENGLISH_NAME = "englishName";
    public static final String NAME = "name";
    public static final String PARENT = "parent";
    public static final String PARENT_OPTION_0 = "parent-option-0";
    public static final String SUBMIT_Class = "submitClass";
    public static final String EDIT_0 = "edit-0";
    public static final String REMOVE_0 = "remove-0";
    public static final String SWAL_BTN_CONFIRM = "SwalBtnConfirm";
    public static final String COMPANY_BRAND_LINE = "پرگاس طب/لافارر/پوست و مو";
    public static final String PARENT_NAME = "parent.name";
    public static final String PARENT_PARENT_NAME = "parent.parent.name";
    public static final String PARENT_PARENT_PARENT_NAME = "parent.parent.parent.name";
    public static final String COMPANY  = "پرگاس طب";
    public static final String BRAND  = "لافارر";
    public static final String LINE = "پوست و مو";





    @Override
    public void internalTest() {
        login();
        saveClass();
        searchClass(COMPANY, BRAND, LINE, FARSI_NAME_CREATE, false);
        editClass();
        searchClass(COMPANY, BRAND, LINE, FARSI_NAME_EDIT, false);
        deleteClass();
        searchClass(COMPANY, BRAND, LINE, FARSI_NAME_EDIT, true);
    }


    public void searchClass(String parentOfParentOfParentName,String parentOfParentName, String parentName, String farsiName, boolean isForDelete) {

        List<WebElement> childElementByClass = getSearchTableHeaderElements();
        if (childElementByClass != null && childElementByClass.size() > 0) {
            type(childElementByClass.get(0), parentOfParentOfParentName);
            type(childElementByClass.get(1), parentOfParentName);
            type(childElementByClass.get(2), parentName);
            type(childElementByClass.get(3), farsiName);


        }
        waitForFixedDuration(2000);
        try {
            checkText(PARENT_PARENT_PARENT_NAME, parentOfParentOfParentName);
        } catch (Exception e) {
            if (!isForDelete) {
                throw e;
            }
        }
        try {
            checkText(PARENT_PARENT_NAME, parentOfParentName);
        } catch (Exception e) {
            if (!isForDelete) {
                throw e;
            }
        }
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
            clear(PARENT_PARENT_PARENT_NAME);
            clear(PARENT_PARENT_NAME);
            clear(PARENT_NAME);
            clear(NAME);

        }

    }
    public void saveClass() {

        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Class
        clickMenu(BASIC_INFORMATION_PRODUCTHIERARCHY_CLASS);

        waitForPageToLoad();

        // Creating new Class
        click(NEW_ITEM);

        // Filling the boxes
        type(ENGLISH_NAME, ENGLISH_NAME_CREATE);
        type(NAME, FARSI_NAME_CREATE);
        click(PARENT);
        type(PARENT, COMPANY_BRAND_LINE);
        //waitForPageToLoad();
        click(PARENT_OPTION_0);

        click(SUBMIT_Class);

    }


    public void editClass () {

        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Class
        clickMenu(BASIC_INFORMATION_PRODUCTHIERARCHY_CLASS);
        waitForPageToLoad();

//        // Editing Class
        click(EDIT_0);

        // Clearing the box
        clear(NAME);
        clear(ENGLISH_NAME);

        // Filling the boxes
        type(NAME, FARSI_NAME_EDIT);
        type(ENGLISH_NAME, ENGLISH_NAME_EDIT);

        // Saving edited Class
        click(SUBMIT_Class);

    }


    public void deleteClass () {

        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Class
        clickMenu(BASIC_INFORMATION_PRODUCTHIERARCHY_CLASS);

        waitForPageToLoad();

        // Deleting Class
        click(REMOVE_0);

        click(SWAL_BTN_CONFIRM);

        click(SWAL_BTN_CONFIRM);

    }

}

    


