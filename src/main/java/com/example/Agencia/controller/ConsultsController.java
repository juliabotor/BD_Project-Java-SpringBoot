package com.example.Agencia.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("consults")
public class ConsultsController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @CrossOrigin(origins = "*", allowedHeaders = "*")


    @GetMapping("/bookings/{destination}")
    public Map<String, Object> getCountOfBookings(@PathVariable String destination) {
        String sql = "SELECT COUNT(*) AS count, p.title FROM booking b " +
                "JOIN package p ON b.id_package = p.id_package " +
                "WHERE p.title = ? " +
                "GROUP BY p.title";
        return jdbcTemplate.queryForMap(sql, destination);
    }



}