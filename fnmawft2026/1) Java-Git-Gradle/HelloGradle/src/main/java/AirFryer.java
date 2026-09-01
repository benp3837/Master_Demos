import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//This AirFryer will have some basic method with a couple different outcomes
//Check the test folder for our JUnit tests
public class AirFryer {

    //Instantiate a Logger object so we log this Class
    private static final Logger logger = LoggerFactory.getLogger(AirFryer.class);


    //Insert food - either prints that the food was inserted or tells the user it's empty
    public String insertFood(String food){

        //info log - basic informational log. low stakes stuff
        logger.info("Attempting to insert food");

        //TODO: should probably check for null and throw exception if not

        if(food.isBlank()){
            logger.warn("User inserted no food!!");
            return "HEY! There's no food in here...";
        } else {
            logger.info("User inserted: {}", food); //loggers don't like string concatenation (+)
            return "Inserted " + food;
        }

    }

    //Set temp - either sets a valid temp or throws an IllegalArgumentException
    public String setTemp(int temp){

        if(temp < 100 || temp > 400){
            throw new IllegalArgumentException("Must set valid temp!");
        } else {
            return "Temp has been set to: " + temp;
        }

    }


}
