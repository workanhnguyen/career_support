package com.nva.server.apis;

import com.nva.server.dtos.StatisticDTO;
import com.nva.server.services.StatisticService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/stats")
@Slf4j
public class ApiStatisticController {
    @Autowired
    private StatisticService statisticService;
    @GetMapping("/year/users")
    public ResponseEntity<List<StatisticDTO>> statsUsersByYearPeriod(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(statisticService.statsUserByYearPeriod(params), HttpStatus.OK);
    }

    @GetMapping("/year/surveys/holland")
    public ResponseEntity<List<StatisticDTO>> statsHollandSurveyByYearPeriod(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(statisticService.statsHollandSurveyByYearPeriod(params), HttpStatus.OK);
    }
}
