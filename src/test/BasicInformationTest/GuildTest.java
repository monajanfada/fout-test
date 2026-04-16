package test.BasicInformationTest;

import org.openqa.selenium.WebElement;
import test.BaseTest;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static test.Menu.BASIC_INFORMATION_GUILDS;

public class GuildTest extends BaseTest {

    private static final String FARSI_NAME_CREATE = "صنف مراقبت از پوست و مو";
    private static final String ENGLISH_NAME_CREATE = "Jordan Guild";
    private static final String FARSI_NAME_EDIT = "صنف ویرایش شده";
    private static final String ENGLISH_NAME_EDIT = "Edited Guild";
    public static final String NAME = "name";
    public static final String NEW_ITEM = "newItem";
    public static final String ENGLISH_NAME = "englishName";
    public static final String SUBMIT_Guild = "submitGuild";
    public static final String EDIT_0 = "edit-0";
    public static final String REMOVE_0 = "remove-0";
    public static final String SWAL_BTN_CONFIRM = "SwalBtnConfirm";
    public static final String DESCRIPTION = "description";
    public static final String VALUE = "test";



    @Override
    public void internalTest() {
        login();
        saveGuild();
        searchGuild(FARSI_NAME_CREATE, false);
        editGuild();
        searchGuild(FARSI_NAME_EDIT, false);
        deleteGuild();
        searchGuild(FARSI_NAME_EDIT, true);
    }


    public void searchGuild(String farsiName, boolean isForDelete) {

        List<WebElement> childElementByClass = getSearchTableHeaderElements();
        if (childElementByClass != null && childElementByClass.size() > 0) {
            type(childElementByClass.get(1), farsiName);
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


    public void saveGuild() {

        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Guild
        clickMenu(BASIC_INFORMATION_GUILDS);

        waitForPageToLoad();

        // Creating new Guild
        click(NEW_ITEM);

        // Filling the boxes
        type(NAME, FARSI_NAME_CREATE);
        type(ENGLISH_NAME, ENGLISH_NAME_CREATE);

        type(DESCRIPTION, VALUE);


        // Saving Guild
        click(SUBMIT_Guild);

    }


    public void editGuild() {

        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Guild
        clickMenu(BASIC_INFORMATION_GUILDS);
        waitForPageToLoad();

//        // Editing Guild
        click(EDIT_0);

        // Clearing the box
        clear(NAME);
        clear(ENGLISH_NAME);

        // Filling the boxes
        type(NAME, FARSI_NAME_EDIT);
        type(ENGLISH_NAME, ENGLISH_NAME_EDIT);

        // Saving edited Guild
        click(SUBMIT_Guild);

    }


    public void deleteGuild() {

        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Guild
        clickMenu(BASIC_INFORMATION_GUILDS);

        waitForPageToLoad();

        // Deleting Guild
        click(REMOVE_0);

        click(SWAL_BTN_CONFIRM);

        click(SWAL_BTN_CONFIRM);

    }

}
