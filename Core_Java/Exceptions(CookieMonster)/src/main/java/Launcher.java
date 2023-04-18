import exceptions.NotACookieException;
import models.CookieEatingMonster;
import models.Food;

public class Launcher {

    public static void main(String[] args) {

        CookieEatingMonster cm = new CookieEatingMonster();

        Food apple = new Food("apple", false);
        Food cookie = new Food("cookie", true);

        cm.eatCookieWithTryCatch(cookie);
        cm.eatCookieWithTryCatch(apple);

        //how could we handle these? 2 ways...
        //cm.eatCookieWithThrows(cookie);
        //cm.eatCookieWithThrows(apple);


    }

}
