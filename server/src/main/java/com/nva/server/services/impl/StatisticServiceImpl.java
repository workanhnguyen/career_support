package com.nva.server.services.impl;

import com.nva.server.dtos.StatisticDTO;
import com.nva.server.pojos.Response;
import com.nva.server.pojos.User;
import com.nva.server.repositories.ResponseRepository;
import com.nva.server.repositories.UserRepository;
import com.nva.server.services.StatisticService;
import com.nva.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class StatisticServiceImpl implements StatisticService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ResponseRepository responseRepository;
    @Override
    public List<StatisticDTO> statsUserByYearPeriod(Map<String, String> params) {
        List<StatisticDTO> statisticDTOs = new ArrayList<>();

        int yearFrom = Integer.parseInt(params.get("from"));
        int yearTo = Integer.parseInt(params.get("to"));

        for (int i = yearFrom; i <= yearTo; i++) {
            List<User> users = userRepository.findByCreatedAtBetween(
                    java.sql.Date.valueOf(LocalDate.of(i, 1, 1)),
                    java.sql.Date.valueOf(LocalDate.of(i, 12, 31))
            );

            StatisticDTO stats = StatisticDTO.builder()
                    .title(String.valueOf(i))
                    .value(String.valueOf(users.size())).build();
            statisticDTOs.add(stats);
        }
        return statisticDTOs;
    }

    @Override
    public List<StatisticDTO> statsUserByMonthsOfYear(Map<String, String> params) {
        List<StatisticDTO> statisticDTOs = new ArrayList<>();

        for (Month month: Month.values()) {
            LocalDate firstDayOfMonth = LocalDate.of(Integer.parseInt(params.get("year")), month, 1);
            LocalDate lastDayOfMonth = firstDayOfMonth.withDayOfMonth(firstDayOfMonth.lengthOfMonth());

            Date startDate = Date.valueOf(firstDayOfMonth);
            Date endDate = Date.valueOf(lastDayOfMonth);

            List<User> users = userRepository.findByCreatedAtBetween(startDate, endDate);
            int userCount = users.size();

            StatisticDTO statisticDTO = StatisticDTO.builder()
                    .title(String.valueOf(month))
                    .value(String.valueOf(userCount))
                    .build();

            statisticDTOs.add(statisticDTO);
        }

        return statisticDTOs;
    }

    @Override
    public List<StatisticDTO> statsHollandSurveyByYearPeriod(Map<String, String> params) {
        List<StatisticDTO> statisticDTOs = new ArrayList<>();

        int yearFrom = Integer.parseInt(params.get("from"));
        int yearTo = Integer.parseInt(params.get("to"));

        for (int i = yearFrom; i <= yearTo; i++) {
            List<Response> responses = responseRepository.findByCreatedAtBetween(
                    java.sql.Date.valueOf(LocalDate.of(i, 1, 1)),
                    java.sql.Date.valueOf(LocalDate.of(i, 12, 31))
            );

            StatisticDTO stats = StatisticDTO.builder()
                    .title(String.valueOf(i))
                    .value(String.valueOf(responses.size())).build();
            statisticDTOs.add(stats);
        }
        return statisticDTOs;
    }

    @Override
    public List<StatisticDTO> statsHollandSurveyByMonthsOfYear(Map<String, String> params) {
        List<StatisticDTO> statisticDTOs = new ArrayList<>();

        for (Month month: Month.values()) {
            LocalDate firstDayOfMonth = LocalDate.of(Integer.parseInt(params.get("year")), month, 1);
            LocalDate lastDayOfMonth = firstDayOfMonth.withDayOfMonth(firstDayOfMonth.lengthOfMonth());

            Date startDate = Date.valueOf(firstDayOfMonth);
            Date endDate = Date.valueOf(lastDayOfMonth);

            List<Response> responses = responseRepository.findByCreatedAtBetween(startDate, endDate);
            int userCount = responses.size();

            StatisticDTO statisticDTO = StatisticDTO.builder()
                    .title(String.valueOf(month))
                    .value(String.valueOf(userCount))
                    .build();

            statisticDTOs.add(statisticDTO);
        }

        return statisticDTOs;
    }
}
