package com.sboot.springlearn;

import com.sboot.springlearn.data.entity.Guest;
import com.sboot.springlearn.data.entity.Reservation;
import com.sboot.springlearn.data.entity.Room;
import com.sboot.springlearn.data.repository.GuestRepository;
import com.sboot.springlearn.data.repository.ReservationRepository;
import com.sboot.springlearn.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringLearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
	}



}