package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ChartDataController {

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/chart-data")
    public List<ChartData> getChartData() {
        // Dummy data for illustration purposes
        List<ChartData> data = new ArrayList<>();
        data.add(new ChartData("2022-05-10", 467));
        data.add(new ChartData("2022-05-11", 576));
        data.add(new ChartData("2022-05-12", 572));
        data.add(new ChartData("2022-05-13", 79));
        data.add(new ChartData("2022-05-14", 92));
        data.add(new ChartData("2022-05-15", 574));
        data.add(new ChartData("2022-05-16", 573));
        data.add(new ChartData("2022-05-17", 576));
        return data;
    }

    public static class ChartData {
        private String date;
        private int value;

        public ChartData(String date, int value) {
            this.date = date;
            this.value = value;
        }

        public String getDate() {
            return date;
        }

        public int getValue() {
            return value;
        }
    }
}
