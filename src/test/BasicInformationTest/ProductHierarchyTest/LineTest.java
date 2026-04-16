package test.BasicInformationTest.ProductHierarchyTest;

import org.openqa.selenium.WebElement;
import test.BaseTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static test.Menu.BASIC_INFORMATION_PRODUCTHIERARCHY_LINE;


public class LineTest extends BaseTest {

    private static final String FARSI_NAME_CREATE = "لاین مو";
    private static final String ENGLISH_NAME_CREATE = "hair Line";
    private static final String FARSI_NAME_EDIT = "لاین ویرایش شده";
    private static final String ENGLISH_NAME_EDIT = "Edited Line";
    public static final String NEW_ITEM = "newItem";
    public static final String ENGLISH_NAME = "englishName";
    public static final String NAME = "name";
    public static final String PARENT = "parent";
    public static final String PARENT_OPTION_0 = "parent-option-0";
    public static final String SUBMIT_LINE = "submitLine";
    public static final String EDIT_0 = "edit-0";
    public static final String REMOVE_0 = "remove-0";
    public static final String SWAL_BTN_CONFIRM = "SwalBtnConfirm";
    public static final String COMPANY_BRAND = "پرگاس طب/لافارر/";
    public static final String PARENT_NAME = "parent.name";
    public static final String PARENT_PARENT_NAME = "parent.parent.name";
    public static final String COMPANY  = "پرگاس طب";
    public static final String BRAND  = "لافارر";




    @Override
    public void internalTest() {
        login();
        saveLine();
        searchLine(COMPANY, BRAND, FARSI_NAME_CREATE, false);
        editLine();
        searchLine(COMPANY, BRAND, FARSI_NAME_EDIT, false);
        deleteLine();
        searchLine(COMPANY, BRAND, FARSI_NAME_EDIT, true);
    }


    public void searchLine(String parentOfParentName, String parentName, String farsiName, boolean isForDelete) {

        List<WebElement> childElementByClass = getSearchTableHeaderElements();
        if (childElementByClass != null && childElementByClass.size() > 0) {
            type(childElementByClass.get(0), parentOfParentName);
            type(childElementByClass.get(1), parentName);
            type(childElementByClass.get(2), farsiName);

        }
        waitForFixedDuration(2000);
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
            clear(PARENT_PARENT_NAME);
            clear(PARENT_NAME);
            clear(NAME);

        }

    }
        public void saveLine() {

            // Applied wait time
            waitForFixedDuration(2000);

            // Clicking on Line
            clickMenu(BASIC_INFORMATION_PRODUCTHIERARCHY_LINE);

            waitForPageToLoad();

            // Creating new Line
            click(NEW_ITEM);

            // Filling the boxes
            type(ENGLISH_NAME, ENGLISH_NAME_CREATE);
            type(NAME, FARSI_NAME_CREATE);
            click(PARENT);
            type(PARENT, COMPANY_BRAND);
            //waitForPageToLoad();
            click(PARENT_OPTION_0);

            click(SUBMIT_LINE);

        }


        public void editLine () {

            // Applied wait time
            waitForFixedDuration(2000);

            // Clicking on Line
            clickMenu(BASIC_INFORMATION_PRODUCTHIERARCHY_LINE);
            waitForPageToLoad();

//        // Editing Line
            click(EDIT_0);

            // Clearing the box
            clear(NAME);
            clear(ENGLISH_NAME);

            // Filling the boxes
            type(NAME, FARSI_NAME_EDIT);
            type(ENGLISH_NAME, ENGLISH_NAME_EDIT);

            // Saving edited Line
            click(SUBMIT_LINE);

        }


        public void deleteLine () {

            // Applied wait time
            waitForFixedDuration(2000);

            // Clicking on Line
            clickMenu(BASIC_INFORMATION_PRODUCTHIERARCHY_LINE);

            waitForPageToLoad();

            // Deleting Line
            click(REMOVE_0);

            click(SWAL_BTN_CONFIRM);

            click(SWAL_BTN_CONFIRM);

        }

    }

    


