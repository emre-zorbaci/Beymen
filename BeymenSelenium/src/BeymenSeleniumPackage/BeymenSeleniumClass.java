package BeymenSeleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;


public class BeymenSeleniumClass {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/mehme/Documents/Selenium Dependencies/Drivers/chromedriver.exe");

        WebDriver webdriver = new ChromeDriver();
        String beymenUrl = "https://www.beymen.com/customer/login";

        webdriver.get(beymenUrl);

        webdriver.findElement(By.id("email")).sendKeys("emrezorbaci0728@gmail.com");
        webdriver.findElement(By.id("password")).sendKeys("Emre123");
        webdriver.findElement(By.id("loginBtn")).click();

        webdriver.manage().deleteAllCookies();

        Thread.sleep(500);

        webdriver.findElement(By.xpath("//input[@class='default-input o-header__search--input']")).sendKeys("pantolon");

        webdriver.findElement(By.xpath("//button[@class='o-header__search--btn bmi-search']")).click();

        webdriver.findElement(By.xpath("//button[@id='moreContentButton']")).click();
        Thread.sleep(500);
        webdriver.navigate().to("https://www.beymen.com/search?q=pantolon&sayfa=2");
        webdriver.navigate().to("https://www.beymen.com/p_beymen-club-haki-kargo-cepli-pantolon_896160");


        Thread.sleep(500);
        String pagePrice = "";//webdriver.findElement(By.xpath("//label[@id='priceNew']")).getAttribute("value").replace(".", "").replace(",","").replace("TL", "");

        List<WebElement> list = webdriver.findElements(By.xpath("//*[@id='priceNew']"));

        for(int i=0;i<list.size();i++){

            pagePrice = list.get(i).getText().replace(".", "").replace(",","").replace("TL", "");

        }

        List<WebElement> beden = webdriver.findElements(By.xpath("//*[@id=sizes]/div/span[1]"));
        String   beden_vv = "";
        for(int k=0;k<beden.size();k++){

            beden_vv = beden.get(k).getText();

        }

        System.out.println(beden_vv);

        // Thread.sleep(500);
        // webdriver.findElement(By.xpath("//input//[@id='sizes']/div/span[1]")).click();
        Thread.sleep(500);
        webdriver.findElement(By.xpath("//button[@class='m-addBasketFavorite__basket btn']")).click();
        //  webdriver.findElement(By.id("AddBasket")).click();
        webdriver.navigate().to("https://www.beymen.com/cart");
        webdriver.navigate().to("https://www.beymen.com/cart");

        Thread.sleep(500);
        String prodPrice = "";//webdriver.findElement(By.xpath("//label[@class='m-productPrice__content']")).getAttribute("value").replace(".", "").replace(",","").replace("TL", "");


        List<WebElement> list1 = webdriver.findElements(By.xpath("//*[@class='m-productPrice__salePrice']"));

        for(int j=0;j<list.size();j++){

            prodPrice = list1.get(j).getText().replace(".", "").replace(",","").replace("TL", "");

        }


        System.out.println(pagePrice);
        System.out.println(prodPrice);

        if ( Double.parseDouble(pagePrice)  ==  Double.parseDouble(prodPrice) ){

            System.out.println("Urun fiyatı ile sepetteki urun fiyatı aynı.  ");

        }

        else {
            System.out.println("Urun fiyatı ile sepetteki urun fiyatı aynı degil.");
        }

        webdriver.findElement(By.className("m-basket__quantity")).click();

        String urunAdet = webdriver.findElement(By.id("quantitySelect0")).getAttribute("value");

        System.out.println("Sepette : "+urunAdet+" tane urun vardır.");


        webdriver.findElement(By.id("removeCartItemBtn0")).click();

        webdriver.navigate().to("https://www.beymen.com/cart");
        webdriver.navigate().to("https://www.beymen.com/cart");

        String prodDeleteControl = webdriver.findElement(By.xpath("//*[@class=m-empty__messageTitle")).getText();
        if (prodDeleteControl.contains("SEPETİNİZDE ÜRÜN BULUNMAMAKTADIR")){

            System.out.println("Sepet Boş");
        }
        else{
            System.out.println("Sepet dolu");

        }

    }


}
