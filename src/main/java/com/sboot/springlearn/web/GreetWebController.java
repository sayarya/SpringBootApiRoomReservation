package com.sboot.springlearn.web;


import com.sboot.springlearn.business.domain.RoomReservation;
import com.sboot.springlearn.business.service.ReservationService;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.lang.Script;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;
import groovy.util.ScriptException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

//To get reservations on a particular date

@Controller
@RequestMapping("/greets")
public class GreetWebController {


    private final ReservationService reservationService;

    @Autowired
    public GreetWebController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public String getReservationName(@RequestParam(value="date", required=false)String dateString,Model model) throws Exception {

       // Always use return in groovy Script
        Binding binding = new Binding();
        GroovyShell shell = new GroovyShell(binding);
        Object value= shell.evaluate(new File("C:/Users/Arya/Desktop/test.groovy"));
        Date date=DateUtils.createDateFormatString(dateString);
        List<RoomReservation> roomReservationName = this.reservationService.getRoomReservationsForDate(date);
        model.addAttribute("roomReservationName",roomReservationName);
        model.addAttribute("key",value);

        return "greets";

    }

}
