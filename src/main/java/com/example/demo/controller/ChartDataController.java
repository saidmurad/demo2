package com.example.demo.controller;

import com.example.demo.entity.ChartData;
import com.example.demo.repository.ChartDataRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ChartDataController {

    private final ChartDataRepository chartDataRepository;

    public ChartDataController(ChartDataRepository chartDataRepository) {
        this.chartDataRepository = chartDataRepository;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/chart-data")
    public List<ChartData> getChartData() {
        return chartDataRepository.findAll();
    }
}
