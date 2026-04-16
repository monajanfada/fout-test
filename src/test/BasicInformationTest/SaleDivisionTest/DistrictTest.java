package test.BasicInformationTest.SaleDivisionTest;
import org.openqa.selenium.WebElement;
import test.BaseTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static test.Menu.BASIC_INFORMATION_SALEDIVISION_DISTRICT;

public class DistrictTest extends BaseTest {


    private static final String FARSI_NAME_CREATE = "ناحیه داخلی";
    private static final String FARSI_NAME_EDIT = "ناحیه ویرایش شده";
    public static final String NAME = "name";
    public static final String NEW_ITEM = "newItem";
    public static final String SUBMIT_BRANNCH = "submitDistrict";
    public static final String EDIT_0 = "edit-0";
    public static final String REMOVE_0 = "remove-0";
    public static final String SWAL_BTN_CONFIRM = "SwalBtnConfirm";
    public static final String PARENT = "parent";
    public static final String PARENT_OPTION_7 = "parent-option-7";


    @Override
    public void internalTest() {
        login();
        saveDistrict();
        searchDistrict(FARSI_NAME_CREATE, false);
        editDistrict();
        searchDistrict(FARSI_NAME_EDIT, false);
        deleteDistrict();
        searchDistrict(FARSI_NAME_EDIT, true);

    }

    public void searchDistrict(String farsiName, boolean isForDelete) {
        List<WebElement> childElementByClass = getSearchTableHeaderElements();
        if (childElementByClass != null && childElementByClass.size() > 0) {
            type(childElementByClass.get(3), farsiName);
        }
        waitForFixedDuration(2000);
        try {
            checkText(NAME, farsiName);
        } catch (Exception e) {
            if (!isForDelete) {
                throw e;
            }
        }

        if (!isForDelete) {
            clear(NAME);

        }    }

    public void saveDistrict() {

        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Company
        clickMenu(BASIC_INFORMATION_SALEDIVISION_DISTRICT);

        waitForPageToLoad();

        // Creating new Company
        click(NEW_ITEM);

        // Filling the boxes
        type(NAME, FARSI_NAME_CREATE);

        click(PARENT);
        waitForPresenceOfElement(PARENT);
        click(PARENT_OPTION_7);

        // Saving company
        click(SUBMIT_BRANNCH);
    }


    public void editDistrict() {
// Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Company
        clickMenu(BASIC_INFORMATION_SALEDIVISION_DISTRICT);
        waitForPageToLoad();

//        // Editing Company
        click(EDIT_0);

        // Clearing the box
        clear(NAME);

        // Filling the boxes
        type(NAME, FARSI_NAME_EDIT);
        click(PARENT);
        waitForPresenceOfElement(PARENT);
        click(PARENT_OPTION_7);

        // Saving edited company
        click(SUBMIT_BRANNCH);
    }


    public void deleteDistrict() {
        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Company
        clickMenu(BASIC_INFORMATION_SALEDIVISION_DISTRICT);

        waitForPageToLoad();

        // Deleting Company
        click(REMOVE_0);

        click(SWAL_BTN_CONFIRM);

        click(SWAL_BTN_CONFIRM);
    }
}


