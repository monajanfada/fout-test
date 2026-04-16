package test.BasicInformationTest.CountryDivisionTest;

import org.openqa.selenium.WebElement;
import test.BaseTest;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static test.Menu.BASIC_INFORMATION_COUNTRYDIVISION_CITYREGION;

public class CityRegionTest extends BaseTest {

    private static final String FARSI_NAME_CREATE = "منطقه شهری شرق تهران";
    private static final String FARSI_NAME_EDIT = "منطقه شهری ویرایش شده";
    public static final String NAME = "name";
    public static final String NEW_ITEM = "newItem";
    public static final String ENGLISH_NAME = "englishName";
    public static final String SUBMIT_CityRegion = "submitCityRegion";
    public static final String EDIT_0 = "edit-0";
    public static final String REMOVE_0 = "remove-0";
    public static final String SWAL_BTN_CONFIRM = "SwalBtnConfirm";
    public static final String PARENT_OPTION_0 = "parent-option-9";
    public static final String PARENT = "parent";


    @Override
    public void internalTest() {
        login();
        saveCityRegion();
        searchCityRegion(FARSI_NAME_CREATE, false);
        editCityRegion();
        searchCityRegion(FARSI_NAME_EDIT, false);
        deleteCityRegion();
        searchCityRegion(FARSI_NAME_EDIT, true);
    }


    public void searchCityRegion(String farsiName, boolean isForDelete) {

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
        }
    }


    public void saveCityRegion() {

        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on CityRegion
        clickMenu(BASIC_INFORMATION_COUNTRYDIVISION_CITYREGION);

        waitForPageToLoad();

        // Creating new CityRegion
        click(NEW_ITEM);

        // Filling the boxes
        type(NAME, FARSI_NAME_CREATE);

        click(PARENT);
        waitForPresenceOfElement(PARENT);
        click(PARENT_OPTION_0);

        // Saving CityRegion
        click(SUBMIT_CityRegion);

    }


    public void editCityRegion() {

        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on CityRegion
        clickMenu(BASIC_INFORMATION_COUNTRYDIVISION_CITYREGION);
        waitForPageToLoad();

//        // Editing CityRegion
        click(EDIT_0);

        // Clearing the box
        clear(NAME);

        // Filling the boxes
        type(NAME, FARSI_NAME_EDIT);

        // Saving edited CityRegion
        click(SUBMIT_CityRegion);

    }


    public void deleteCityRegion() {

        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on CityRegion
        clickMenu(BASIC_INFORMATION_COUNTRYDIVISION_CITYREGION);

        waitForPageToLoad();

        // Deleting CityRegion
        click(REMOVE_0);

        click(SWAL_BTN_CONFIRM);

        click(SWAL_BTN_CONFIRM);

    }

}
