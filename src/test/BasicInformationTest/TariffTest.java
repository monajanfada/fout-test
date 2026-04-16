package test.BasicInformationTest;

import org.openqa.selenium.WebElement;
import test.BaseTest;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static test.Menu.BASIC_INFORMATION_TARIFF;

public class TariffTest extends BaseTest {

    private static final String FARSI_NAME_CREATE = "نرخنامه دولتی ";
    private static final String ENGLISH_NAME_CREATE = "Test Tariff";
    private static final String FARSI_NAME_EDIT = "نرخنامه ویرایش شده";
    private static final String ENGLISH_NAME_EDIT = "Edited Tariff";
    public static final String NAME = "name";
    public static final String NEW_ITEM = "newItem";
    public static final String ENGLISH_NAME = "englishName";
    public static final String SUBMIT_Tariff = "submitTariff";
    public static final String EDIT_0 = "edit-0";
    public static final String REMOVE_0 = "remove-0";
    public static final String SWAL_BTN_CONFIRM = "SwalBtnConfirm";
    public static final String GUILD = "guild";
    public static final String GUILD_OPTION_0 = "guild-option-0";
    public static final String VALUE2 = "1";
    public static final String NEXT = "next";
    public static final String SAVE_AND_FINAL_SUBMIT = "saveAndFinalSubmit";
    public static final String PRODUCT_HIERARCHY = "productHierarchy";
    public static final String PRODUCT_HIERARCHY_OPTION_0 = "productHierarchy-option-0";


    @Override
    public void internalTest() {
        login();
        saveTariff();
        searchTariff(FARSI_NAME_CREATE, ENGLISH_NAME_CREATE, false);
        editTariff();
        searchTariff(FARSI_NAME_EDIT, ENGLISH_NAME_EDIT, false);
        deleteTariff();
        searchTariff(FARSI_NAME_EDIT, ENGLISH_NAME_EDIT, true);
    }


    public void searchTariff(String farsiName, String englishName, boolean isForDelete) {

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
        }
    }


    public void saveTariff() {

        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Tariff
        clickMenu(BASIC_INFORMATION_TARIFF);

        waitForPageToLoad();

        // Creating new Tariff
        click(NEW_ITEM);

        // Filling the boxes
        type(NAME, FARSI_NAME_CREATE);


        click(GUILD);
        waitForPresenceOfElement(GUILD);
        click(GUILD_OPTION_0);

        click(PRODUCT_HIERARCHY);
        waitForPresenceOfElement(PRODUCT_HIERARCHY);
        click(PRODUCT_HIERARCHY_OPTION_0);

        click(NEXT);
        click(NEXT);
        click(NEXT);

        // Saving Tariff
        click(SAVE_AND_FINAL_SUBMIT);

    }


    public void editTariff() {

        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Tariff
        clickMenu(BASIC_INFORMATION_TARIFF);
        waitForPageToLoad();

//        // Editing Tariff
        click(EDIT_0);

        // Clearing the box
        clear(NAME);
        clear(ENGLISH_NAME);

        // Filling the boxes
        type(NAME, FARSI_NAME_EDIT);
        type(ENGLISH_NAME, ENGLISH_NAME_EDIT);

        // Saving edited Tariff
        click(SUBMIT_Tariff);

    }


    public void deleteTariff() {

        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Tariff
        clickMenu(BASIC_INFORMATION_TARIFF);

        waitForPageToLoad();

        // Deleting Tariff
        click(REMOVE_0);

        click(SWAL_BTN_CONFIRM);

        click(SWAL_BTN_CONFIRM);

    }

}
