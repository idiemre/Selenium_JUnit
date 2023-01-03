package day06_assertions;

import org.junit.Assert;
import org.junit.Test;

public class C02_Assertion {

    /*
       JUnit framework'u calistirilan testlerin passed veya failed olmasini raporlar
       Ancak raporlamanin dogru sonuc vermes icin
       Test'lerin Assert class'indaki hazir method'larla yapilmasi gerekir

       Eger Assert class'i kullanilmazsa
       JUnit kodlarin sorunsuz olarak calisip bittigini raporlar
       C01'de test'leri if-else ile yaptigimiz icin
       Testler failed olsa da kodar sorunusuz calistigi icin
       testler yesil tik olarak isaretlendi
     */

    int p1=60;
    int p2=66;
    int p3=70;



    @Test
    public void test01(){
        // emekli yasi 65 olduguna gore
        // p2'nin emekli olabilecegini test edin

        Assert.assertTrue(p2>65);

    }

    @Test
    public void test02(){
        // emekli yasi 65 olduguna gore
        // p1'nin emekli olamayacagini test edin

        Assert.assertFalse(p1>65);

    }

    @Test
    public void test03(){
        // emekli yasi 65 olduguna gore
        // p2'nin emekli olamayacagini test edin

        Assert.assertFalse("Girilen yas 65'den kucuk olmadigindan emekli olabilir",p3>65);

    }
}
