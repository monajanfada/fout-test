package test.BasicInformationTest.CountryDivisionTest;

import org.openqa.selenium.WebElement;
import test.BaseTest;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static test.Menu.BASIC_INFORMATION_COUNTRYDIVISION_COUNTRY;

public class CountryTest extends BaseTest {

    private static final String FARSI_NAME_CREATE = "کشور سوییس";
    private static final String FARSI_NAME_EDIT = "کشور ویرایش شده";
    public static final String NAME = "name";
    public static final String NEW_ITEM = "newItem";
    public static final String ENGLISH_NAME = "englishName";
    public static final String SUBMIT_Country = "submitCountry";
    public static final String EDIT_0 = "edit-0";
    public static final String REMOVE_0 = "remove-0";
    public static final String SWAL_BTN_CONFIRM = "SwalBtnConfirm";
    public static final String INTERNATIONAL_TERRITORY = "internationalTerritory";
    public static final String INTERNATIONAL_TERRITORY_OPTION_1 = "internationalTerritory-option-1";


    @Override
    public void internalTest() {
        login();
        saveCountry();
        searchCountry(FARSI_NAME_CREATE, false);
        editCountry();
        searchCountry(FARSI_NAME_EDIT, false);
        deleteCountry();
        searchCountry(FARSI_NAME_EDIT, true);
    }


    public void searchCountry(String farsiName, boolean isForDelete) {

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


    public void saveCountry() {

        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Country
        clickMenu(BASIC_INFORMATION_COUNTRYDIVISION_COUNTRY);

        waitForPageToLoad();

        // Creating new Country
        click(NEW_ITEM);

        // Filling the boxes
        type(NAME, FARSI_NAME_CREATE);
        click(INTERNATIONAL_TERRITORY);
        waitForPresenceOfElement(INTERNATIONAL_TERRITORY);
        click(INTERNATIONAL_TERRITORY_OPTION_1);

        // Saving Country
        click(SUBMIT_Country);

    }


    public void editCountry() {

        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Country
        clickMenu(BASIC_INFORMATION_COUNTRYDIVISION_COUNTRY);
        waitForPageToLoad();

//        // Editing Country
        click(EDIT_0);

        // Clearing the box
        clear(NAME);

        // Filling the boxes
        type(NAME, FARSI_NAME_EDIT);

        // Saving edited Country
        click(SUBMIT_Country);

    }


    public void deleteCountry() {

        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Country
        clickMenu(BASIC_INFORMATION_COUNTRYDIVISION_COUNTRY);

        waitForPageToLoad();

        // Deleting Country
        click(REMOVE_0);

        click(SWAL_BTN_CONFIRM);

        click(SWAL_BTN_CONFIRM);

    }

}
