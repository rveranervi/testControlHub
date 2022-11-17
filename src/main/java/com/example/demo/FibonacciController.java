package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FibonacciController {
    @GetMapping(value = "/fibonacci/{value}")
    public ResponseEntity<Fibonacci> Fibonacci(@PathVariable(value = "value") int numbers){
        int num1 = 0, num2 = 1, sum = 1, acum = 0;
        List<Integer> values = new ArrayList<Integer>();
        values.add(0);
        for (int i = 1; i < numbers; i++) {
            acum += sum;
            values.add(sum);
            sum = num1 + num2;
            num1 = num2;
            num2 = sum;
        }
        Fibonacci f = new Fibonacci();
        f.setFibonacci(values);
        f.setSum(sum);
        return new ResponseEntity<>(f, HttpStatus.OK);
    }
}
