package pages.inventory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class InventoryPage extends BasePage {
    @FindBy(id = "inventory_container")
    private WebElement inventoryContainerSection;

    public boolean isInventorySectionDisplayed(){
        return isDisplayed(inventoryContainerSection);
    }
}
