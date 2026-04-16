package test.BasicInformationTest;

import org.openqa.selenium.WebElement;
import test.BaseTest;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static test.Menu.BASIC_INFORMATION_INVENTORIES;

public class InventoryTest extends BaseTest {

    private static final String FARSI_NAME_CREATE = "انبار تستی";
    private static final String FARSI_NAME_EDIT = "انبار ویرایش شده";
    public static final String NAME = "name";
    public static final String NEW_ITEM = "newItem";
    public static final String ENGLISH_NAME = "englishName";
    public static final String SUBMIT_Inventory = "submitInventory";
    public static final String EDIT_0 = "edit-0";
    public static final String REMOVE_0 = "remove-0";
    public static final String SWAL_BTN_CONFIRM = "SwalBtnConfirm";
    public static final String VALUE = "02177720454";
    public static final String INVENTORY_TYPE = "inventoryType";
    public static final String INVENTORY_KEEPER = "inventoryKeeper";
    public static final String INVENTORY_KEEPER_OPTION_0 = "inventoryKeeper-option-0";
    public static final String INVENTORY_TYPE_OPTION_0 = "inventoryType-option-0";
    public static final String PHONE = "phone";
    public static final String OFFICE = "office";
    public static final String OFFICE_OPTION_3 = "office-option-3";
    public static final String PRODUCT_HIERARCHIES = "productHierarchies";
    public static final String PRODUCT_HIERARCHIES_OPTION_0 = "productHierarchies-option-0";
    public static final String CITY_REGION = "cityRegion";
    public static final String CITY_REGION_OPTION_3 = "cityRegion-option-3";
    public static final String POSTAL_CODE = "postalCode";
    public static final String VALUE1 = "1655857348";
    public static final String ADDRESS = "address";
    public static final String VALUE2 = "جردن";
    public static final String DESCRIPTION = "description";
    public static final String VALUE3 = "test";


    @Override
    public void internalTest() {
        login();
        saveInventory();
        searchInventory(FARSI_NAME_CREATE, false);
        editInventory();
        searchInventory(FARSI_NAME_EDIT, false);
        deleteInventory();
        searchInventory(FARSI_NAME_EDIT, true);
    }


    public void searchInventory(String farsiName, boolean isForDelete) {

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


    public void saveInventory() {

        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Inventory
        clickMenu(BASIC_INFORMATION_INVENTORIES);

        waitForPageToLoad();

        // Creating new Inventory
        click(NEW_ITEM);

        // Filling the boxes
        type(NAME, FARSI_NAME_CREATE);

        click(INVENTORY_TYPE);
        waitForPresenceOfElement(INVENTORY_TYPE);
        click(INVENTORY_TYPE_OPTION_0);

        click(INVENTORY_KEEPER);
        waitForPresenceOfElement(INVENTORY_KEEPER);
        click(INVENTORY_KEEPER_OPTION_0);

        type(PHONE, VALUE);

        click(OFFICE);
        click(OFFICE_OPTION_3);

        click(PRODUCT_HIERARCHIES);
        click(PRODUCT_HIERARCHIES_OPTION_0);

        click(CITY_REGION);
        waitForPresenceOfElement(CITY_REGION);
        click(CITY_REGION_OPTION_3);


        type(POSTAL_CODE, VALUE1);

        type(ADDRESS, VALUE2);

        type(DESCRIPTION, VALUE3);

        // Saving Inventory
        click(SUBMIT_Inventory);

    }


    public void editInventory() {

        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Inventory
        clickMenu(BASIC_INFORMATION_INVENTORIES);
        waitForPageToLoad();

//        // Editing Inventory
        click(EDIT_0);

        // Clearing the box
        clear(NAME);

        // Filling the boxes
        type(NAME, FARSI_NAME_EDIT);

        // Saving edited Inventory
        click(SUBMIT_Inventory);

    }


    public void deleteInventory() {

        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Inventory
        clickMenu(BASIC_INFORMATION_INVENTORIES);

        waitForPageToLoad();

        // Deleting Inventory
        click(REMOVE_0);

        click(SWAL_BTN_CONFIRM);

        click(SWAL_BTN_CONFIRM);

    }

}
