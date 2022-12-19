package com.jkb.ticketing.service;

import lombok.RequiredArgsConstructor;
import lombok.var;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TicketingService {
    //WebDriver
    private WebDriver driver;
    private Alert alert;
    private WebElement element;
    private String url;

    //Properties
    public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static String WEB_DRIVER_PATH = "/usr/bin/chromedriver";


    public void SeleniumTest() {
        //System Property SetUp
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        //Driver SetUp
        ChromeOptions options = new ChromeOptions();
        options.setCapability("ignoreProtectedModeSettings", true);
        driver = new ChromeDriver(options);

        url = "https://www.cgv.co.kr/";

        oper();
    }

    public void oper() {
        try {
            //get방식으로 url 요청
            driver.get(url);


            //로그인 버튼 클릭력
            XPathClick("//*[@id=\"cgvwrap\"]/div[2]/div[1]/div/ul/li[1]/a");

            //아이디 입력
            SetKey("txtUserId","ID입력");

            //패스워드 입력
            SetKey("txtPassword","pass 입");

            //로그인
            SubmitById("submit");

            //예매
            //XPathClick("*[@id=\"cgvwrap\"]/div[2]/div[2]/div/ul/li[3]/h2/a");
            LineText("예매");

            //프레임 변경
            Thread.sleep(1000);
            driver = driver.switchTo().frame(driver.findElement(By.id("ticket_iframe")));

            //영화 선택
            CssSelector("#movie_list > ul > li:nth-child(1)");

            //특별관 선택
            CssSelector("#sbmt_imax > a");

            //왕십리 선택
            CssSelector("#theater_area_list > ul > li.selected > div > ul > li:nth-child(2)");

            //날짜
            CssSelector("#date_list > ul > div > li:nth-child(14)");

            try {
                while (true){
                    alert = driver.switchTo().alert();
                    alert.dismiss();

                    //왕십리 선택
                    CssSelector("#theater_area_list > ul > li.selected > div > ul > li:nth-child(2)");

                    //날짜
                    CssSelector("#date_list > ul > div > li:nth-child(14)");
                    Thread.sleep(5000);
                }
            }catch (Exception e){
                //시간
                CssSelector("#ticket > div.steps > div.step.step1 > div.section.section-time > div.col-body > div.time-list.nano.has-scrollbar > div.content.scroll-y > div > ul > li:nth-child(4)");

                //좌석 선
                CssSelector("#tnb_step_btn_right");

                //확인
                CssSelector("body > div.ft_layer_popup.popup_alert.w450.ko > div.ft > a.btn.btn_ok > span");

                //관람등급 안
                CssSelector("body > div.ft_layer_popup.popup_alert.ko > div.ft > a.btn.btn_ok.btn_red");

                //일반 2명 선택
                CssSelector("#nop_group_adult > ul > li:nth-child(3)");

                //좌석 선택
                CssSelector("#seats_list > div:nth-child(1) > div:nth-child(7) > div.seat_group.left > div:nth-child(1) > div:nth-child(12)");
                //결재 선택
                CssSelector("#tnb_step_btn_right");

                //펼치
                CssSelector("#payCoupons > div.tpm_header > a");

                //기프트콘 선택
                CssSelector("#cgvMovieMoney > div.form_list > div.list_body.nano.has-scrollbar > ul > li:nth-child(1)");
                CssSelector("#cgvMovieMoney > div.form_list > div.list_body.nano.has-scrollbar > ul > li:nth-child(2)");

                //결제
                CssSelector("#tnb_step_btn_right");

                //약관동의
                CssSelector("#paymentAgreement > span:nth-child(1)");
                CssSelector("#paymentInfoConfirm > span:nth-child(3) > label");

                //최종 결제
                CssSelector("body > div.ft_layer_popup.popup_reservation_check > div.ft > a.reservation");

                //현금 영수증
                CssSelector("body > div.ft_layer_popup.popup_cash_receipts > div.btn_wrap.clfix > a.btn.btn_white.btn_cancel");

            }





            Thread.sleep(10000000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
        }
    }

    private void loof() throws InterruptedException {

    }

    private void XPathClick(String xPath) throws InterruptedException {
        Thread.sleep(1000);
        element = driver.findElement(By.xpath(xPath));
        element.click();
    }

    private void SetKey(String id, String Keys) throws InterruptedException {
        Thread.sleep(1000);
        element = driver.findElement(By.id(id));
        element.sendKeys(Keys);
    }

    private void SubmitById(String id) throws InterruptedException {
        Thread.sleep(1000);
        element = driver.findElement(By.id(id));
        element.submit();
    }

    private void LineText(String lineText) throws InterruptedException {

        Thread.sleep(1000);
        element = driver.findElement(By.linkText(lineText));
        element.click();

    }

    private void CssSelector(String css) throws InterruptedException {

        Thread.sleep(1000);
        element = driver.findElement(By.cssSelector(css));
        element.click();

    }

    private void GetAttributeByXPath() throws InterruptedException {

        Thread.sleep(1000);
        element = driver.findElement(By.linkText("26"));
        element.click();

    }
}
