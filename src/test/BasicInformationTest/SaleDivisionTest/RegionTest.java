package test.BasicInformationTest.SaleDivisionTest;
import org.openqa.selenium.WebElement;
import test.BaseTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static test.Menu.BASIC_INFORMATION_SALEDIVISION_REGION;

public class RegionTest extends BaseTest {


    private static final String FARSI_NAME_CREATE = "منطقه شرق خاورمیانه";
    private static final String FARSI_NAME_EDIT = "منطقه ویرایش شده";
    public static final String NAME = "name";
    public static final String NEW_ITEM = "newItem";
    public static final String SUBMIT_Region = "submitRegion";
    public static final String EDIT_0 = "edit-0";
    public static final String REMOVE_0 = "remove-0";
    public static final String SWAL_BTN_CONFIRM = "SwalBtnConfirm";
    public static final String COUNTRY = "country";
    public static final String COUNTRY_OPTION_5 = "country-option-5";


    @Override
    public void internalTest() {
        login();
        saveRegion();
        searchRegion(FARSI_NAME_CREATE, false);
        editRegion();
        searchRegion(FARSI_NAME_EDIT, false);
        deleteRegion();
        searchRegion(FARSI_NAME_EDIT, true);

    }

    public void searchRegion(String farsiName, boolean isForDelete) {
        List<WebElement> childElementByClass = getSearchTableHeaderElements();
        if (childElementByClass != null && childElementByClass.size() > 0) {
            type(childElementByClass.get(2), farsiName);
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

    public void saveRegion() {

        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Company
        clickMenu(BASIC_INFORMATION_SALEDIVISION_REGION);

        waitForPageToLoad();

        // Creating new Company
        click(NEW_ITEM);

        // Filling the boxes
        type(NAME, FARSI_NAME_CREATE);

        click(COUNTRY);
        waitForPresenceOfElement(COUNTRY);
        click(COUNTRY_OPTION_5);

        // Saving company
        click(SUBMIT_Region);
    }


    public void editRegion() {
// Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Company
        clickMenu(BASIC_INFORMATION_SALEDIVISION_REGION);
        waitForPageToLoad();

//        // Editing Company
        click(EDIT_0);

        // Clearing the box
        clear(NAME);

        // Filling the boxes
        type(NAME, FARSI_NAME_EDIT);
        click(COUNTRY);
        waitForPresenceOfElement(COUNTRY);
        click(COUNTRY_OPTION_5);

        // Saving edited company
        click(SUBMIT_Region);
    }


    public void deleteRegion() {
        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Company
        clickMenu(BASIC_INFORMATION_SALEDIVISION_REGION);

        waitForPageToLoad();

        // Deleting Company
        click(REMOVE_0);

        click(SWAL_BTN_CONFIRM);

        click(SWAL_BTN_CONFIRM);
    }
}


