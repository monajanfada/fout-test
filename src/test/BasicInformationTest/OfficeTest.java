package test.BasicInformationTest;

import org.openqa.selenium.WebElement;
import test.BaseTest;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static test.Menu.BASIC_INFORMATION_OFFICES;

public class OfficeTest extends BaseTest {

    private static final String FARSI_NAME_CREATE = "دفتر جردن";
    private static final String FARSI_NAME_EDIT = "دفتر ویرایش شده";
    public static final String NAME = "name";
    public static final String NEW_ITEM = "newItem";
    public static final String SUBMIT_Office = "submitOffice";
    public static final String EDIT_0 = "edit-0";
    public static final String REMOVE_0 = "remove-0";
    public static final String SWAL_BTN_CONFIRM = "SwalBtnConfirm";
    public static final String OFFICE_TYPE = "officeType";
    public static final String OFFICE_TYPE_OPTION_0 = "officeType-option-0";
    public static final String OFFICE_MANAGER = "officeManager";
    public static final String OFFICE_MANAGER_OPTION_0 = "officeManager-option-0";
    public static final String PHONE = "phone";
    public static final String VALUE = "02177777777";
    public static final String CITY_REGION = "cityRegion";
    public static final String CITY_REGION_OPTION_3 = "cityRegion-option-3";
    public static final String POSTAL_CODE = "postalCode";
    public static final String VALUE1 = "1655857348";
    public static final String ADDRESS = "address";
    public static final String VALUE2 = "جردن";
    public static final String OFFICE_MANAGER_PERSON_FULL_NAME = "officeManager.person.fullName";
    public static final String VALUE3 = "firstname lastname";



    @Override
    public void internalTest() {
        login();
        saveOffice();
        searchOffice(FARSI_NAME_CREATE, VALUE3, VALUE, false);
        editOffice();
        searchOffice(FARSI_NAME_EDIT, VALUE3, VALUE, false);
        deleteOffice();
        searchOffice(FARSI_NAME_EDIT, VALUE3, VALUE, true);
    }


    public void searchOffice(String farsiName, String managementName, String phoneNumber, boolean isForDelete) {

        List<WebElement> childElementByClass = getSearchTableHeaderElements();
        if (childElementByClass != null && childElementByClass.size() > 0) {
            type(childElementByClass.get(1), farsiName);
            type(childElementByClass.get(2), managementName);
            type(childElementByClass.get(3), phoneNumber);

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
            checkText(OFFICE_MANAGER_PERSON_FULL_NAME, managementName);
        } catch (Exception e) {
            if (!isForDelete) {
                throw e;
            }
        }

        try {
            checkText(PHONE, phoneNumber);
        } catch (Exception e) {
            if (!isForDelete) {
                throw e;
            }
        }

        if (!isForDelete) {
            clear(NAME);
            clear(OFFICE_MANAGER_PERSON_FULL_NAME);
            clear(PHONE);
        }

    }


    public void saveOffice() {

        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Office
        clickMenu(BASIC_INFORMATION_OFFICES);

        waitForPageToLoad();

        // Creating new Office
        click(NEW_ITEM);

        // Filling the boxes
        type(NAME, FARSI_NAME_CREATE);

        click(OFFICE_TYPE);
        waitForPresenceOfElement(OFFICE_TYPE);
        click(OFFICE_TYPE_OPTION_0);

       // waitForPageToLoad();

        click(OFFICE_MANAGER);
        waitForPresenceOfElement(OFFICE_MANAGER);
        click(OFFICE_MANAGER_OPTION_0);

        type(PHONE, VALUE);

        click(CITY_REGION);
        waitForPresenceOfElement(CITY_REGION);
        click(CITY_REGION_OPTION_3);

        type(POSTAL_CODE, VALUE1);

        type(ADDRESS, VALUE2);

        // Saving Office
        click(SUBMIT_Office);

    }


    public void editOffice() {

        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Office
        clickMenu(BASIC_INFORMATION_OFFICES);
        waitForPageToLoad();

//        // Editing Office
        click(EDIT_0);

        // Clearing the box
        clear(NAME);

        // Filling the boxes
        type(NAME, FARSI_NAME_EDIT);

        // Saving edited Office
        click(SUBMIT_Office);

    }


    public void deleteOffice() {

        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Office
        clickMenu(BASIC_INFORMATION_OFFICES);

        waitForPageToLoad();

        // Deleting Office
        click(REMOVE_0);

        click(SWAL_BTN_CONFIRM);

        click(SWAL_BTN_CONFIRM);

    }

}
