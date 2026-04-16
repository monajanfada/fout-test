package test.BasicInformationTest.SaleDivisionTest;
import org.openqa.selenium.WebElement;
import test.BaseTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static test.Menu.BASIC_INFORMATION_PRODUCTHIERARCHY_COMPANY;
import static test.Menu.BASIC_INFORMATION_SALEDIVISION_INTERNATIONALTERRITORY;

public class InternationalTerritoryTest extends BaseTest {


    private static final String FARSI_NAME_CREATE = "منطقه بین المللی خاورمیانه";
    private static final String FARSI_NAME_EDIT = "منطقه بین المللی ویرایش شده";
    public static final String NAME = "name";
    public static final String NEW_ITEM = "newItem";
    public static final String SUBMIT_INTERNATIONALTERRITORY = "submitInternationalTerritoryPage";
    public static final String EDIT_0 = "edit-0";
    public static final String REMOVE_1 = "remove-1";
    public static final String SWAL_BTN_CONFIRM = "SwalBtnConfirm";


    @Override
    public void internalTest() {
        login();
        saveInternationalTerritory();
        searchInternationalTerritory(FARSI_NAME_CREATE, false);
        editInternationalTerritory();
        searchInternationalTerritory(FARSI_NAME_EDIT, false);
        deleteInternationalTerritory();
        searchInternationalTerritory(FARSI_NAME_EDIT, true);

    }

    public void searchInternationalTerritory(String farsiName, boolean isForDelete) {

        List<WebElement> childElementByClass = getSearchTableHeaderElements();
        if (childElementByClass != null && childElementByClass.size() > 0) {
            type(childElementByClass.get(0), farsiName);
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
        }
    }

    public void saveInternationalTerritory() {

        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Company
        clickMenu(BASIC_INFORMATION_SALEDIVISION_INTERNATIONALTERRITORY);

        waitForPageToLoad();

        // Creating new Company
        click(NEW_ITEM);

        // Filling the boxes
        type(NAME, FARSI_NAME_CREATE);

        // Saving company
        click(SUBMIT_INTERNATIONALTERRITORY);
    }


    public void editInternationalTerritory() {
// Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Company
        clickMenu(BASIC_INFORMATION_SALEDIVISION_INTERNATIONALTERRITORY);
        waitForPageToLoad();

//        // Editing Company
        click(EDIT_0);

        // Clearing the box
        clear(NAME);

        // Filling the boxes
        type(NAME, FARSI_NAME_EDIT);

        // Saving edited company
        click(SUBMIT_INTERNATIONALTERRITORY);
    }


    public void deleteInternationalTerritory() {
        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Company
        clickMenu(BASIC_INFORMATION_SALEDIVISION_INTERNATIONALTERRITORY);

        waitForPageToLoad();

        // Deleting Company
        click(REMOVE_1);

        click(SWAL_BTN_CONFIRM);

        click(SWAL_BTN_CONFIRM);
    }
}


