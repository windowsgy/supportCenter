package utils.autoWeb;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import static org.apache.commons.net.telnet.TelnetCommand.EC;


/**
 *
 * Created by jlgaoyuan on 2018/5/19.
 *
 */
public class AutoWeb {

        public static void main(String[] args) {

            ChromeOptions options = new ChromeOptions();

            options.addArguments("--test-type", "--ignore-certificate-errors");

            System.setProperty("webdriver.chrome.driver","E:\\drivers\\chromedriver.exe");//chromedriver

            final String mainUrl = "https://webmail30.189.cn/w2/";

            WebDriver driver = new ChromeDriver(options);



            driver.get(mainUrl);

            System.out.println("currentURL:"+driver.getCurrentUrl());

            Set<String> a = driver.getWindowHandles();

            for(String set : a){

                System.out.println(set);

            }

            driver.switchTo().frame("iframeLogin");

            WebElement el = driver.findElement(By.id("userName"));

           /* System.out.print("inputUsername:");

            Scanner input = new Scanner(System.in);

            String inputData = input.nextLine().trim();*/

            el.sendKeys("18904420062");

            el = driver.findElement(By.id("password"));

         /*   System.out.print("inputPassWord:");

            inputData = input.nextLine().trim();*/

            el.sendKeys("780504");

            el = driver.findElement(By.id("j-login"));

            el.click();

            new WebDriverWait(driver,15).until(ExpectedConditions.presenceOfElementLocated(By.id("add-tag")));

            System.out.println("currentURL:"+driver.getCurrentUrl());

         // driver.switchTo().frame("mailListAdv");

         //   System.out.println(driver.getPageSource());

           List<WebElement> classList = driver.findElements(By.className( "ml-from"));

            for(int i = 0 ; i < classList.size();i++){

                if(i == 0 ){classList.get(0).click();}

             //   System.out.println(classList.get(i).getText());


            }



      /*  List<WebElement> emailName = driver.findElements(By.cssSelector("li.mail-list-bd-item ml-unread"));

            for(int i = 0 ; i < emailName.size();i++){

                System.out.println(emailName.get(i).getTagName());


            }*/



            /*List<WebElement> list = driver.findElements(By.cssSelector("*"));

                for(int i = 0 ; i < list.size();i++){

                    System.out.println(list.get(i).getTagName());


                }*/



  /*          Actions action = new Actions(driver);
            action.clickAndHold();// 鼠标悬停在当前位置，既点击并且不释放
            action.clickAndHold(onElement);// 鼠标悬停在 onElement 元素的位置*/



        }

    }
