package support.testng;

public class TestNGManager {
    public static CustomSoftAssert softAssert;

    public void setSoftAssert() {
        softAssert = new CustomSoftAssert();
    }

    public CustomSoftAssert softAssert() {
        return softAssert;
    }
}
