package test.BasicInformationTest;

import org.openqa.selenium.WebElement;
import test.BaseTest;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static test.Menu.BASIC_INFORMATION_PRODUCTS;

public class ProductTest extends BaseTest {

    public static final String VALUE1 = "0123456789";
    private static final String FARSI_NAME_CREATE = "محصول وارداتی ";
    private static final String ENGLISH_NAME_CREATE = "Test Product";
    private static final String FARSI_NAME_EDIT = "محصول ویرایش شده";
    private static final String ENGLISH_NAME_EDIT = "Edited Product";
    public static final String NAME = "name";
    public static final String NEW_ITEM = "newItem";
    public static final String ENGLISH_NAME = "englishName";
    public static final String SUBMIT_Product = "submitProduct";
    public static final String EDIT_0 = "edit-0";
    public static final String REMOVE_0 = "remove-0";
    public static final String SWAL_BTN_CONFIRM = "SwalBtnConfirm";
    public static final String BARCODE = "barcode";
    public static final String PRODUCT_HIERARCHY = "productHierarchy";
    public static final String PRODUCT_HIERARCHY_OPTION_0 = "productHierarchy-option-0";
    public static final String VALUE2 = "1";
    public static final String LENGTH = "length";
    public static final String WIDTH = "width";
    public static final String HEIGHT = "height";
    public static final String VOLUME = "volume";
    public static final String WEIGHT = "weight";
    public static final String NEXT = "next";
    public static final String SAVE_AND_FINAL_SUBMIT = "saveAndFinalSubmit";


    @Override
    public void internalTest() {
        login();
        saveProduct();
        searchProduct(FARSI_NAME_CREATE, ENGLISH_NAME_CREATE, false);
        editProduct();
        searchProduct(FARSI_NAME_EDIT, ENGLISH_NAME_EDIT, false);
        deleteProduct();
        searchProduct(FARSI_NAME_EDIT, ENGLISH_NAME_EDIT, true);
    }


    public void searchProduct(String farsiName, String englishName, boolean isForDelete) {

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


    public void saveProduct() {

        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Product
        clickMenu(BASIC_INFORMATION_PRODUCTS);

        waitForPageToLoad();

        // Creating new Product
        click(NEW_ITEM);

        // Filling the boxes
        type(NAME, FARSI_NAME_CREATE);
        type(ENGLISH_NAME, ENGLISH_NAME_CREATE);
        type(BARCODE, VALUE1);


        click(PRODUCT_HIERARCHY);
        waitForPresenceOfElement(PRODUCT_HIERARCHY);
        click(PRODUCT_HIERARCHY_OPTION_0);
        type(LENGTH, VALUE2);
        type(WIDTH,VALUE2);
        type(HEIGHT,VALUE2);
        type(VOLUME,VALUE2);
        type(WEIGHT,VALUE2);
        click(NEXT);
        click(NEXT);
        click(NEXT);

        // Saving Product
        click(SAVE_AND_FINAL_SUBMIT);

    }


    public void editProduct() {

        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Product
        clickMenu(BASIC_INFORMATION_PRODUCTS);
        waitForPageToLoad();

//        // Editing Product
        click(EDIT_0);

        // Clearing the box
        clear(NAME);
        clear(ENGLISH_NAME);

        // Filling the boxes
        type(NAME, FARSI_NAME_EDIT);
        type(ENGLISH_NAME, ENGLISH_NAME_EDIT);

        // Saving edited Product
        click(SUBMIT_Product);

    }


    public void deleteProduct() {

        // Applied wait time
        waitForFixedDuration(2000);

        // Clicking on Product
        clickMenu(BASIC_INFORMATION_PRODUCTS);

        waitForPageToLoad();

        // Deleting Product
        click(REMOVE_0);

        click(SWAL_BTN_CONFIRM);

        click(SWAL_BTN_CONFIRM);

    }

}
