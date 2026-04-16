package test.BasicInformationTest.ProductHierarchyTest;

import org.openqa.selenium.WebElement;
import test.BaseTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static test.Menu.BASIC_INFORMATION_PRODUCTHIERARCHY_GROUP;


public class GroupTest extends BaseTest {

    private static final String FARSI_NAME_CREATE = "گروه ضد ریزش";
    private static final String ENGLISH_NAME_CREATE = "hair Group";
    private static final String FARSI_NAME_EDIT = "گروه ویرایش شده";
    private static final String ENGLISH_NAME_EDIT = "Edited Group";
    public static final String NEW_ITEM = "newItem";
    public static final String ENGLISH_NAME = "englishName";
    public static final String NAME = "name";
    public static final String PARENT = "parent";
    public static final String PARENT_OPTION_0 = "parent-option-0";
    public static final String SUBMIT_Group = "submitGroup";
    public static final String EDIT_0 = "edit-0";
    public static final String REMOVE_0 = "remove-0";
    public static final String SWAL_BTN_CONFIRM = "SwalBtnConfirm";
    public static final String COMPANY_BRAND_LINE_CLASS = "پرگاس طب/لافارر/پوست و مو/شامپو روزانه/آنتی باکتریال ها";
    public static final String PARENT_NAME = "parent.name";
    public static final String PARENT_PARENT_NAME = "parent.parent.name";
    public static final String PARENT_PARENT_PARENT_NAME = "parent.parent.parent.name";
    public static final String PARENT_PARENT_PARENT_PARENT_NAME = "parent.parent.parent.parent.name";
    public static final String PARENT_PARENT_PARENT_PARENT_PARENT_NAME = "parent.parent.parent.parent.parent.name";
    public static final String COMPANY  = "پرگاس طب";
    public static final String BRAND  = "لافارر";
    public static final String LINE = "پوست و مو";
    public static final String CLASS = "شامپو روزانه";
    public static final String CATEGORY = "آنتی باکتریال ها";






    @Override
    public void internalTest() {
        login();
        saveGroup();
        searchGroup(COMPANY, BRAND, LINE, CLASS, CATEGORY, FARSI_NAME_CREATE, false);
        editGroup();
        searchGroup(COMPANY, BRAND, LINE, CLASS, CATEGORY, FARSI_NAME_EDIT,false);
        deleteGroup();
        searchGroup(COMPANY, BRAND, LINE, CLASS, CATEGORY, FARSI_NAME_EDIT, true);
    }


    public void searchGroup(String parentOfParentOfParentOfParentOfParent, String parentOfParentOfParentOfParentName, String parentOfParentOfParentName, String parentOfParentName, String parentName, String farsiName, boolean isForDelete) {

        List<WebElement> childElementByClass = getSearchTableHeaderElements();
        if (childElementByClass != null && childElementByClass.size() > 0) {
            type(childElementByClass.get(0), parentOfParentOfParentOfParentOfParent);
            type(childElementByClass.get(1), parentOfParentOfParentOfParentName);
            type(childElementByClass.get(2), parentOfParentOfParentName);
            type(childElementByClass.get(3), parentOfParentName);
            type(childElementByClass.get(4), parentName);
            type(childElementByClass.get(5), farsiName);
        }
        waitForFixedDuration(2000);
        try {
            checkText(PARENT_PARENT_PARENT_PARENT_PARENT_NAME, parentOfParentOfParentOfParentOfParent);
        } catch (Exception e) {
            if (!isForDelete) {
                throw e;
            }
        }
        try {
            checkText(PARENT_PARENT_PARENT_PARENT_NAME, parentOfParentOfParentOfParentName);
        } catch (Exception e) {
            if (!isForDelete) {
                throw e;
            }
        }
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
            clear(PARENT_PARENT_PARENT_PARENT_PARENT_NAME);
            clear(PARENT_PARENT_PARENT_PARENT_NAME);
            clear(PARENT_PARENT_PARENT_NAME);
            clear(PARENT_PARENT_NAME);
            clear(PARENT_NAME);
            clear(NAME);

        }

    }
    public void saveGroup() {

        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Group
        clickMenu(BASIC_INFORMATION_PRODUCTHIERARCHY_GROUP);

        waitForPageToLoad();

        // Creating new Group
        click(NEW_ITEM);

        // Filling the boxes
        type(ENGLISH_NAME, ENGLISH_NAME_CREATE);
        type(NAME, FARSI_NAME_CREATE);
        click(PARENT);
        type(PARENT, COMPANY_BRAND_LINE_CLASS);
        //waitForPageToLoad();
        click(PARENT_OPTION_0);

        click(SUBMIT_Group);

    }


    public void editGroup () {

        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Group
        clickMenu(BASIC_INFORMATION_PRODUCTHIERARCHY_GROUP);
        waitForPageToLoad();

//        // Editing Group
        click(EDIT_0);

        // Clearing the box
        clear(NAME);
        clear(ENGLISH_NAME);

        // Filling the boxes
        type(NAME, FARSI_NAME_EDIT);
        type(ENGLISH_NAME, ENGLISH_NAME_EDIT);

        // Saving edited Group
        click(SUBMIT_Group);

    }


    public void deleteGroup () {

        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Group
        clickMenu(BASIC_INFORMATION_PRODUCTHIERARCHY_GROUP);

        waitForPageToLoad();

        // Deleting Group
        click(REMOVE_0);

        click(SWAL_BTN_CONFIRM);

        click(SWAL_BTN_CONFIRM);

    }

}

    


