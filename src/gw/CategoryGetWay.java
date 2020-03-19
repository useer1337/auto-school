package gw;

import models.simulatorProgram.Category;

public class CategoryGetWay extends SimpleGetWay<Category> {
    public CategoryGetWay(){
        insert(new Category("А – позволяет управлять обычными мотоциклами"));
        insert(new Category("В – на легковые машины, весом до 3,5 тонн"));
        insert(new Category("В1 – трициклы и квадрициклы"));
        insert(new Category("С – разрешение на грузовой транспорт"));
        insert(new Category("D – автомобили, приспособленные для перевозки более 8 человек, микроавтобусы"));
        insert(new Category("М – мопеды и легкие квадрициклы"));
        insert(new Category("Tm – трамваи"));
    }
}
