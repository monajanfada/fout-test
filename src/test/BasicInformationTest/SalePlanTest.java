package test.BasicInformationTest;

import org.openqa.selenium.WebElement;
import test.BaseTest;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static test.Menu.BASIC_INFORMATION_PLAN;

public class SalePlanTest extends BaseTest {

    private static final String FARSI_NAME_CREATE = "طرح فروش شب یلدا";
    private static final String ENGLISH_NAME_CREATE = "Test SalePlan";
    private static final String FARSI_NAME_EDIT = "طرح فروش ویرایش شده";
    private static final String ENGLISH_NAME_EDIT = "Edited SalePlan";
    public static final String NAME = "name";
    public static final String NEW_ITEM = "newItem";
    public static final String ENGLISH_NAME = "englishName";
    public static final String SUBMIT_SalePlan = "submitSalePlan";
    public static final String EDIT_0 = "edit-0";
    public static final String REMOVE_0 = "remove-0";
    public static final String SWAL_BTN_CONFIRM = "SwalBtnConfirm";
    public static final String NEXT = "next";
    public static final String SAVE_AND_FINAL_SUBMIT = "saveAndFinalSubmit";


    @Override
    public void internalTest() {
        login();
        saveSalePlan();
        searchSalePlan(FARSI_NAME_CREATE, ENGLISH_NAME_CREATE, false);
        editSalePlan();
        searchSalePlan(FARSI_NAME_EDIT, ENGLISH_NAME_EDIT, false);
        deleteSalePlan();
        searchSalePlan(FARSI_NAME_EDIT, ENGLISH_NAME_EDIT, true);
    }


    public void searchSalePlan(String farsiName, String englishName, boolean isForDelete) {

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


    public void saveSalePlan() {

        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on SalePlan
        clickMenu(BASIC_INFORMATION_PLAN);

        waitForPageToLoad();

        // Creating new SalePlan
        click(NEW_ITEM);

        // Filling the boxes
        type(NAME, FARSI_NAME_CREATE);
        type(ENGLISH_NAME, ENGLISH_NAME_CREATE);

        click(NEXT);
        click(NEXT);

        // Saving Product
        click(SAVE_AND_FINAL_SUBMIT);
    }


    public void editSalePlan() {

        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on SalePlan
        clickMenu(BASIC_INFORMATION_PLAN);
        waitForPageToLoad();

//        // Editing SalePlan
        click(EDIT_0);

        // Clearing the box
        clear(NAME);
        clear(ENGLISH_NAME);

        // Filling the boxes
        type(NAME, FARSI_NAME_EDIT);
        type(ENGLISH_NAME, ENGLISH_NAME_EDIT);

        // Saving edited SalePlan
        click(SUBMIT_SalePlan);

    }


    public void deleteSalePlan() {

        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on SalePlan
        clickMenu(BASIC_INFORMATION_PLAN);

        waitForPageToLoad();

        // Deleting SalePlan
        click(REMOVE_0);

        click(SWAL_BTN_CONFIRM);

        click(SWAL_BTN_CONFIRM);

    }

}
