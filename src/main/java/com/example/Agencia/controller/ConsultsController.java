package com.example.Agencia.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("consults")
public class ConsultsController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @CrossOrigin(origins = "*", allowedHeaders = "*")


    @GetMapping("/bookings/count/{destination}")
    public Map<String, Object> getCountOfBookings(@PathVariable String destination) {
        String sql = "SELECT COUNT(*) AS count, p.title FROM booking b \n" +
                "JOIN package p ON b.id_package = p.id_package \n" +
                "WHERE p.title = ?\n" +
                "GROUP BY p.title;";
        return jdbcTemplate.queryForMap(sql, destination);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")

    @GetMapping("/packages/{description}")
    public Map<String, Object> getGuideOfPackage(@PathVariable String description) {
        String sql = "SELECT g.description FROM package p " +
                "JOIN guide g ON p.id_guide = g.id_guide " +
                "WHERE p.title = ?";
        return jdbcTemplate.queryForMap(sql, description);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")

    @GetMapping("/bookings/date/{date}")
    public Map<String, Object> getDateOfTicket(@PathVariable String date) {
        String sql = "select t.date " +
                "from booking b " +
                "join ticket t on b.id_ticket = t.id_ticket " +
                "join package p on b.id_package = p.id_package " +
                "where p.title = ? ";
        return jdbcTemplate.queryForMap(sql, date);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")

    @GetMapping("/package_accommodation/{title}")
    public List<Map<String, Object>> getAccommodationsOfPackage(@PathVariable String title) {
        String sql = "select a.name from package_accommodation pa join accommodation a on pa.id_accommodation = a.id_accommodation join package p on pa.id_package = p.id_package where p.title = ?";
        return jdbcTemplate.queryForList(sql, title);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")

    @GetMapping("/bookings/count_sells/{cpf}")
    public Map<String, Object> getCountSellsEmployee(@PathVariable String cpf) {
        String sql = "select Count(*) as count_sells, s.workload\n" +
                "from booking b\n" +
                "join seller s on b.id_seller = s.id_seller\n" +
                "join employee e on e.id_employee = s.id_seller \n" +
                "where e.cpf = ?\n" +
                "GROUP BY e.cpf, s.workload";

        return jdbcTemplate.queryForMap(sql, cpf);
    }






}