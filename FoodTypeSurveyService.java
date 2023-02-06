package examsurvey;

public class FoodTypeSurveyService implements SurveyService{
    private FoodTypeDao foodTypeDao;

    public  FoodTypeSurveyService(FoodTypeDao foodTypeDao){
        this.foodTypeDao = foodTypeDao;
    }
    @Override
    public void vote(int vote){

    }
}
