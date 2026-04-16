package test.BasicInformationTest.ProductHierarchyTest;

import org.openqa.selenium.WebElement;
import test.BaseTest;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static test.Menu.BASIC_INFORMATION_PRODUCTHIERARCHY_COMPANY;

public class CompanyTest extends BaseTest {

    private static final String FARSI_NAME_CREATE = "شرکت پرگاسسس طب";
    private static final String ENGLISH_NAME_CREATE = "pergasss teb company";
    private static final String FARSI_NAME_EDIT = "شرکت ویرایش شده";
    private static final String ENGLISH_NAME_EDIT = "Edited company";
    public static final String NAME = "name";
    public static final String NEW_ITEM = "newItem";
    public static final String ENGLISH_NAME = "englishName";
    public static final String SUBMIT_COMPANY = "submitCompany";
    public static final String PARENT_NAME = "parent.name";
    public static final String EDIT_0 = "edit-0";
    public static final String REMOVE_0 = "remove-0";
    public static final String SWAL_BTN_CONFIRM = "SwalBtnConfirm";


    @Override
    public void internalTest() {
        login();
        saveCompany();
        searchCompany(FARSI_NAME_CREATE, ENGLISH_NAME_CREATE, false);
        editCompany();
        searchCompany(FARSI_NAME_EDIT, ENGLISH_NAME_EDIT, false);
        deleteCompany();
        searchCompany(FARSI_NAME_EDIT, ENGLISH_NAME_EDIT, true);
    }


    public void searchCompany(String farsiName, String englishName, boolean isForDelete) {

        List<WebElement> childElementByClass = getSearchTableHeaderElements();
        if (childElementByClass != null && childElementByClass.size() > 0) {
            type(childElementByClass.get(0), farsiName);
            type(childElementByClass.get(1), englishName);
        }
        waitForFixedDuration(2000);
        try {
            checkText(NAME, farsiName);
        } catch (Exception e) {
            if (!isForDelete) {
                throw e;
            }
        }
        try {
            checkText(ENGLISH_NAME, englishName);
        } catch (Exception e) {
            if (!isForDelete) {
                throw e;
            }
        }

        if (!isForDelete) {
            clear(NAME);
            clear(ENGLISH_NAME);
        }
    }


    public void saveCompany() {

        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Company
        clickMenu(BASIC_INFORMATION_PRODUCTHIERARCHY_COMPANY);

        waitForPageToLoad();

        // Creating new Company
        click(NEW_ITEM);

        // Filling the boxes
        type(ENGLISH_NAME, ENGLISH_NAME_CREATE);
        type(NAME, FARSI_NAME_CREATE);

        // Saving company
        click(SUBMIT_COMPANY);

    }


    public void editCompany() {

        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Company
        clickMenu(BASIC_INFORMATION_PRODUCTHIERARCHY_COMPANY);
        waitForPageToLoad();

//        // Editing Company
        click(EDIT_0);

        // Clearing the box
        clear(NAME);
        clear(ENGLISH_NAME);

        // Filling the boxes
        type(NAME, FARSI_NAME_EDIT);
        type(ENGLISH_NAME, ENGLISH_NAME_EDIT);

        // Saving edited company
        click(SUBMIT_COMPANY);

    }


    public void deleteCompany() {

        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Company
        clickMenu(BASIC_INFORMATION_PRODUCTHIERARCHY_COMPANY);

        waitForPageToLoad();

        // Deleting Company
        click(REMOVE_0);

        click(SWAL_BTN_CONFIRM);

        click(SWAL_BTN_CONFIRM);

    }

}
