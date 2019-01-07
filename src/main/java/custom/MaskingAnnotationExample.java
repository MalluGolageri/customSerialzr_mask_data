package custom;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.AnnotationIntrospectorPair;

public class MaskingAnnotationExample {

    public static void main(String... args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        AnnotationIntrospector sis = mapper.getSerializationConfig().getAnnotationIntrospector();
        AnnotationIntrospector dis = mapper.getDeserializationConfig().getAnnotationIntrospector();

        AnnotationIntrospector is1 = AnnotationIntrospectorPair.pair(sis, new MaskSensitiveDataAnnotationIntrospector());
        AnnotationIntrospector is2 = AnnotationIntrospectorPair.pair(dis, new MaskSensitiveDataAnnotationIntrospector());

        mapper.setAnnotationIntrospectors(is1, is2);

        MyBean myBean = new MyBean();
        myBean.setUserName("Saurabh Bhardwaj");
        myBean.setCardNumber("4455-7788-9999-7777");
        CreditCard creditCard=new CreditCard();
        creditCard.setCardType("VISA");
        creditCard.setCvv("345");
        myBean.setCreditCard(creditCard);

        mask(myBean,mapper);

        mask(creditCard,mapper);
    }

    private static  <T> void mask(T bean, ObjectMapper mapper) throws JsonProcessingException {
        String json = mapper.writeValueAsString(bean);
        System.out.println("json:"+json);
    }

}