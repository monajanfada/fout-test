package test.BasicInformationTest.CountryDivisionTest;

import org.openqa.selenium.WebElement;
import test.BaseTest;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static test.Menu.BASIC_INFORMATION_COUNTRYDIVISION_PROVINCE;

public class ProvinceTest extends BaseTest {

    private static final String FARSI_NAME_CREATE = "کشور سوییس";
    private static final String FARSI_NAME_EDIT = "کشور ویرایش شده";
    public static final String NAME = "name";
    public static final String NEW_ITEM = "newItem";
    public static final String ENGLISH_NAME = "englishName";
    public static final String SUBMIT_Province = "submitProvince";
    public static final String EDIT_0 = "edit-0";
    public static final String REMOVE_0 = "remove-0";
    public static final String SWAL_BTN_CONFIRM = "SwalBtnConfirm";
    public static final String INTERNATIONAL_TERRITORY = "internationalTerritory";
    public static final String INTERNATIONAL_TERRITORY_OPTION_1 = "internationalTerritory-option-1";


    @Override
    public void internalTest() {
        login();
        saveProvince();
        searchProvince(FARSI_NAME_CREATE, false);
        editProvince();
        searchProvince(FARSI_NAME_EDIT, false);
        deleteProvince();
        searchProvince(FARSI_NAME_EDIT, true);
    }


    public void searchProvince(String farsiName, boolean isForDelete) {

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


    public void saveProvince() {

        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Province
        clickMenu(BASIC_INFORMATION_COUNTRYDIVISION_PROVINCE);

        waitForPageToLoad();

        // Creating new Province
        click(NEW_ITEM);

        // Filling the boxes
        type(NAME, FARSI_NAME_CREATE);
        click(INTERNATIONAL_TERRITORY);
        waitForPresenceOfElement(INTERNATIONAL_TERRITORY);
        click(INTERNATIONAL_TERRITORY_OPTION_1);

        // Saving Province
        click(SUBMIT_Province);

    }


    public void editProvince() {

        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Province
        clickMenu(BASIC_INFORMATION_COUNTRYDIVISION_PROVINCE);
        waitForPageToLoad();

//        // Editing Province
        click(EDIT_0);

        // Clearing the box
        clear(NAME);

        // Filling the boxes
        type(NAME, FARSI_NAME_EDIT);

        // Saving edited Province
        click(SUBMIT_Province);

    }


    public void deleteProvince() {

        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Province
        clickMenu(BASIC_INFORMATION_COUNTRYDIVISION_PROVINCE);

        waitForPageToLoad();

        // Deleting Province
        click(REMOVE_0);

        click(SWAL_BTN_CONFIRM);

        click(SWAL_BTN_CONFIRM);

    }

}
