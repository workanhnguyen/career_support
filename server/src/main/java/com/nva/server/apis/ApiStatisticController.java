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

    @GetMapping("/month/users")
    public ResponseEntity<List<StatisticDTO>> statsUsersByMonthsOfYear(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(statisticService.statsUserByMonthsOfYear(params), HttpStatus.OK);
    }

    @GetMapping("/quater/users")
    public ResponseEntity<List<StatisticDTO>> statsUsersByQuatersOfYear(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(statisticService.statsUserByQuatersOfYear(params), HttpStatus.OK);
    }

    @GetMapping("/year/surveys/holland")
    public ResponseEntity<List<StatisticDTO>> statsHollandSurveysByYearPeriod(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(statisticService.statsHollandSurveyByYearPeriod(params), HttpStatus.OK);
    }

    @GetMapping("/month/surveys/holland")
    public ResponseEntity<List<StatisticDTO>> statsHollandSurveysByMonthsOfYear(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(statisticService.statsHollandSurveyByMonthsOfYear(params), HttpStatus.OK);
    }

    @GetMapping("/quater/surveys/holland")
    public ResponseEntity<List<StatisticDTO>> statsHollandSurveysByQuatersOfYear(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(statisticService.statsHollandSurveyByQuatersOfYear(params), HttpStatus.OK);
    }
}
