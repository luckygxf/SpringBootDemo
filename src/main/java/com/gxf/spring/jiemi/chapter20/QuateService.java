package com.gxf.spring.jiemi.chapter20;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;

/**
 * Created by 58 on 2018/4/5.
 */
public class QuateService implements IQuoteService {
    private JdbcTemplate  jdbcTemplate;

    @Override
    public Quote getQuate() {
        return null;
    }

    @Override
    public Quote getQuateByDateTime(Date date) {
        return null;
    }

    @Override
    public void saveQuate(Quote quote) {

    }

    @Override
    public void updateQuate(Quote quote) {

    }

    @Override
    public void deleteQuote(Quote quote) {

    }
}
