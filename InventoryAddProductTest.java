package regression;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.uiFramework.KTCTC.Pages.InventoryAddProductsPage;
//import com.uiFramework.KTCTC.Pages.InventoryAddProductsPage;
import com.uiFramework.KTCTC.Pages.InventoryAddProductsPage;
import com.uiFramework.KTCTC.Pages.InventoryCategoryPage;
import com.uiFramework.KTCTC.testbase.TestBase;

public class InventoryAddProductTest extends TestBase {

	InventoryAddProductsPage inventoryAddProductsPage;

	int initialcountofrecords;

	String productName = cmObj.getcharacterString(6);
	String categoryName = cmObj.getcharacterString(6);
	String brandName = cmObj.getcharacterString(6);
	String unitName = cmObj.getcharacterString(6);
	String price = cmObj.getNumericString(2);
	String stock = cmObj.getNumericString(2);
	String description = cmObj.getcharacterString(5);

	String productName1 = cmObj.getcharacterString(6);
	String categoryName1 = cmObj.getcharacterString(6);
	String brandName1 = cmObj.getcharacterString(6);
	String unitName1 = cmObj.getcharacterString(6);
	String price1 = cmObj.getNumericString(2);
	String stock1 = cmObj.getNumericString(2);
	String description1 = cmObj.getcharacterString(5);

	@Test(priority = 1)
	public void verifyNewProductsCanBeAddedOnAddProductsPage()

	{

		SoftAssert sassert = new SoftAssert();
		inventoryAddProductsPage = new InventoryAddProductsPage(driver);
		cmObj.expandInventoryOption(driver);

		inventoryAddProductsPage.navigateToInventoryCategoryPage();
		inventoryAddProductsPage.addNewCategoryOnCategoryPage(categoryName);
		inventoryAddProductsPage.addNewCategoryOnCategoryPage(categoryName1);

		inventoryAddProductsPage.navigateToInventoryUnitPage();
		inventoryAddProductsPage.addNewUnitOnUnitPage(unitName);
		inventoryAddProductsPage.addNewUnitOnUnitPage(unitName1);
		inventoryAddProductsPage.navigateToInventoryBrandPage();
		inventoryAddProductsPage.addNewBrandOnBrandPage(brandName);
		inventoryAddProductsPage.addNewBrandOnBrandPage(brandName1);

		inventoryAddProductsPage.navigateToInventoryProductsPage();
		initialcountofrecords = inventoryAddProductsPage.getCountOfRecordsOnProductsPage();
		inventoryAddProductsPage.addNewProductsOnProductsPage(productName);

		// String Description=cmObj.getcharacterString(10);

		inventoryAddProductsPage.addProductPriceOnProductsPage(price);
		inventoryAddProductsPage.addProductPhotoOnProductsPage();

		inventoryAddProductsPage.addProductBrandOnProductsPage(brandName);
		inventoryAddProductsPage.addProductCategoryOnProductsPage(categoryName);
		inventoryAddProductsPage.addProductUnitOnProductsPage(unitName);
		inventoryAddProductsPage.addProductStatusOnProductsPage("Yes");
		inventoryAddProductsPage.addProductDiscriptionOnProductsPage(description);
		inventoryAddProductsPage.addProductStockOnProductsPage(stock);

		boolean flag = inventoryAddProductsPage.isProductsPresentOnProductsPage(productName);
		sassert.assertTrue(flag, "Products name is not displayed on categoory page");

		boolean flag1 = inventoryAddProductsPage.isProductsPriceOnProductsPage(price);
		sassert.assertFalse(flag1, "old AddProducts name is still displayed on categoory page");

		boolean flag2 = inventoryAddProductsPage.isProductsStatusOnProductsPage("Yes");
		sassert.assertTrue(flag2, "Products status is not displayed on categoory page");

		boolean flag3 = inventoryAddProductsPage.isProductsPriceOnProductsPage(price);
		sassert.assertFalse(flag3, "old AddProducts name is still displayed on categoory page");

	}

	@Test(priority = 2)
	public void verifySuccessBannerIsDisplayedForNewlyAddedProducts()

	{
		SoftAssert sassert = new SoftAssert();
		boolean flag = inventoryAddProductsPage.isSuccessBannerDisplayedForAddedProducts();
		sassert.assertTrue(flag, "AddProducts aadded banner is not displayed");

		sassert.assertAll();

	}

	@Test(priority = 3)
	public void verifyCountIsIncreasedByOneAfterAddingNewAProducts()

	{
		SoftAssert sassert = new SoftAssert();
		int count = inventoryAddProductsPage.getCountOfRecordsOnProductsPage();

		sassert.assertTrue(count == initialcountofrecords + 1,
				"Records count is not increased by 1 after adding new category");

		sassert.assertAll();

	}

	@Test(priority = 4) // check this
	public void verifyUserCanEditExsitingProducts()

	{
		SoftAssert sassert = new SoftAssert();

		initialcountofrecords = inventoryAddProductsPage.getCountOfRecordsOnProductsPage();

		inventoryAddProductsPage.editExistingProductNameOnProductsPage(productName, productName1);

		inventoryAddProductsPage.editExistingProductPriceOnProductsPage(price, price1);

		inventoryAddProductsPage.editProductStatusOnProductsPage("No");

		inventoryAddProductsPage.editProductStockOnProductsPage(stock, stock1);
		// inventoryAddProductsPage.editProductDiscriptionOnProductsPage(description,description1);

		inventoryAddProductsPage.editExistingProductCategoryOnProductsPage(categoryName, categoryName1);
		inventoryAddProductsPage.editExistingProductUnitOnProductsPage(unitName, unitName1);

		inventoryAddProductsPage.editExistingProductBrandOnProductsPage(brandName, brandName1);
		boolean flag13 = inventoryAddProductsPage.isProductsPresentOnProductsPage(productName1);
		sassert.assertTrue(flag13, "Edited Products is not displayed on categoory page");
		boolean flag15 = inventoryAddProductsPage.isProductsPriceOnProductsPage(price1);
		sassert.assertTrue(flag15, "Edited Products price is not displayed on categoory page");
		boolean flag8 = inventoryAddProductsPage.isProductsUnitOnProductsPage(unitName1);
		sassert.assertTrue(flag8, "Edited Products unit name is not displayed on categoory page");
		boolean flag10 = inventoryAddProductsPage.isProductsStatusOnProductsPage("No");
		sassert.assertTrue(flag10, "Edited Products status is not changed on categoory page");

		boolean flag14 = inventoryAddProductsPage.isProductsPresentOnProductsPage(productName);
		sassert.assertFalse(flag14, "old AddProducts name is still displayed on categoory page");

		boolean flag16 = inventoryAddProductsPage.isProductsPriceOnProductsPage(price);
		sassert.assertFalse(flag16, "old AddProducts name is still displayed on categoory page");

		boolean flag9 = inventoryAddProductsPage.isProductsUnitOnProductsPage(unitName);
		sassert.assertFalse(flag9, "old AddProducts name is still displayed on categoory page");

		boolean flag11 = inventoryAddProductsPage.isProductsStatusOnProductsPage("Yes");
		sassert.assertFalse(flag11, "old AddProducts name is still displayed on categoory page");

		sassert.assertAll();

	}

	@Test(priority = 5)
	public void successBannerIsDisplayedForEditedProducts()

	{
		SoftAssert sassert = new SoftAssert();

		boolean flag = inventoryAddProductsPage.isSuccessBannerDisplayedForEditedProducts();
		sassert.assertTrue(flag, "success banner is not displayed for edied Products");
		sassert.assertAll();

	}

	@Test(priority = 6) // started
	public void verifyCountIsnotChangedAfterEditingExistingProducts()

	{
		SoftAssert sassert = new SoftAssert();

		int count = inventoryAddProductsPage.getCountOfRecordsOnProductsPage();
		sassert.assertTrue(count == initialcountofrecords, "count is not same afterr editing product");
		sassert.assertAll();

	}

//
	@Test(priority = 7)
	public void verifyExistingProductsCanBeDeleted()

	{
		SoftAssert sassert = new SoftAssert();
		initialcountofrecords = inventoryAddProductsPage.getCountOfRecordsOnProductsPage();
		inventoryAddProductsPage.deleteExistingProductsOnProductsPage(productName1);

		boolean flag = inventoryAddProductsPage.isProductsPresentOnProductsPage(productName1);

		sassert.assertFalse(flag, "deleted category is still displayed");
		sassert.assertAll();

	}

	@Test(priority = 8)
	public void verifySuccessBannerIsDisplayedForDeletedProducts()

	{
		SoftAssert sassert = new SoftAssert();

		boolean flag = inventoryAddProductsPage.isSuccessBannerDisplayedForDeletedProducts();

		sassert.assertTrue(flag, "category deleted banner is not displayed");

		sassert.assertAll();

	}

	@Test(priority = 9)
	public void verifyCountIsDecreasedByOneAfterDeletingProducts()

	{
		SoftAssert sassert = new SoftAssert();

		int count = inventoryAddProductsPage.getCountOfRecordsOnProductsPage();

		sassert.assertTrue(count + 1 == initialcountofrecords, "Record count is not decreased after deleting category");
		sassert.assertAll();

	}

}