package test.BasicInformationTest.SaleDivisionTest;
import org.openqa.selenium.WebElement;
import test.BaseTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static test.Menu.BASIC_INFORMATION_SALEDIVISION_TERRITORY;

public class TerritoryTest extends BaseTest {


    private static final String FARSI_NAME_CREATE = "حوزه داخلی";
    private static final String FARSI_NAME_EDIT = "حوزه ویرایش شده";
    public static final String NAME = "name";
    public static final String NEW_ITEM = "newItem";
    public static final String SUBMIT_BRANNCH = "submitTerritory";
    public static final String EDIT_0 = "edit-0";
    public static final String REMOVE_0 = "remove-0";
    public static final String SWAL_BTN_CONFIRM = "SwalBtnConfirm";
    public static final String PARENT = "parent";
    public static final String PARENT_OPTION_7 = "parent-option-7";


    @Override
    public void internalTest() {
        login();
        saveTerritory();
        searchTerritory(FARSI_NAME_CREATE, false);
        editTerritory();
        searchTerritory(FARSI_NAME_EDIT, false);
        deleteTerritory();
        searchTerritory(FARSI_NAME_EDIT, true);

    }

    public void searchTerritory(String farsiName, boolean isForDelete) {
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

    public void saveTerritory() {

        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Company
        clickMenu(BASIC_INFORMATION_SALEDIVISION_TERRITORY);

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


    public void editTerritory() {
// Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Company
        clickMenu(BASIC_INFORMATION_SALEDIVISION_TERRITORY);
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


    public void deleteTerritory() {
        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Company
        clickMenu(BASIC_INFORMATION_SALEDIVISION_TERRITORY);

        waitForPageToLoad();

        // Deleting Company
        click(REMOVE_0);

        click(SWAL_BTN_CONFIRM);

        click(SWAL_BTN_CONFIRM);
    }
}


