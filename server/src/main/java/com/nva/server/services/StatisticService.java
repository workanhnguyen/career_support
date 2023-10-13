package com.nva.server.services;

import com.nva.server.dtos.StatisticDTO;

import java.util.List;
import java.util.Map;

public interface StatisticService {
    List<StatisticDTO> statsUserByYearPeriod(Map<String, String> params);
    List<StatisticDTO> statsUserByMonthsOfYear(Map<String, String> params);
    List<StatisticDTO> statsUserByQuatersOfYear(Map<String, String> params);
    List<StatisticDTO> statsHollandSurveyByYearPeriod(Map<String, String> params);
    List<StatisticDTO> statsHollandSurveyByMonthsOfYear(Map<String, String> params);
    List<StatisticDTO> statsHollandSurveyByQuatersOfYear(Map<String, String> params);
}
