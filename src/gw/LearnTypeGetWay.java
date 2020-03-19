package gw;

import models.learnTime.LearnType;

public class LearnTypeGetWay extends SimpleGetWay<LearnType>{
    public LearnTypeGetWay(){
        insert(new LearnType("Обычное (3 месяца)"));
        insert(new LearnType("Обычное (1,5 месяца)"));
    }
}
