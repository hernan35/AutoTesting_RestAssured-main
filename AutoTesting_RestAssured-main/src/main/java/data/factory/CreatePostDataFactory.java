package data.factory;

import com.github.javafaker.Faker;
import model.Post.Request.PostRequest;
import static model.Post.Request.PostRequest.Builder;

import org.apache.commons.lang3.StringUtils;

public class CreatePostDataFactory {

    private static final Faker faker = new Faker();

    public static PostRequest missingAllinformation(){
        return new Builder().withName(StringUtils.EMPTY).withSalary("340000").withAge("38").build();
    }

    public static PostRequest news(){
        return new Builder()
                .withName(faker.book()
                .title()+faker.file().fileName())
                .withSalary(String.valueOf(faker.number().numberBetween(300,4000)))
                .withAge(String.valueOf(faker.number().numberBetween(1,400))).build();
    }

}
