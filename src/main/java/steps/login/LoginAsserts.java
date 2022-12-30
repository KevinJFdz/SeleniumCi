package steps.login;

import io.cucumber.java.Scenario;
import org.testng.Assert;
import pages.inventory.InventoryPage;

public class LoginAsserts {

    private InventoryPage inventoryPage = new InventoryPage();
    public void assertSuccessfullyLogin(){
        Assert.assertTrue(inventoryPage.isInventorySectionDisplayed());
    }
}
