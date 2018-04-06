package com.gxf.spring.jiemi.chapter20;

import java.util.Date;

/**
 * Created by 58 on 2018/4/5.
 */
public interface IQuoteService {
    public Quote getQuate();

    public Quote getQuateByDateTime(Date date);

    public void saveQuate(Quote quote);

    public void updateQuate(Quote quote);

    public void deleteQuote(Quote quote);
}
