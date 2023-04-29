package cn.spring.web;

import java.io.IOException;

public interface ObjectMapper {
    void setDateFormat(String dateFormat);
    void setDecimalFormat(String decimalFormat);
    String writeValuesAsString(Object obj) throws IOException, IllegalAccessException;
}
