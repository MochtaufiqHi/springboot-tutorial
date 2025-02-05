package com.belajar.rest_api.controller;

import javax.swing.text.html.parser.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.belajar.rest_api.entity.Hardware;
import com.belajar.rest_api.service.HardwareService;
import com.belajar.rest_api.util.Response;

@RestController
@RequestMapping(value = "hardware")
public class HardwareController {
    @Autowired
    HardwareService hardwareService;

    private String service = "Hardware";

    @PostMapping
    ResponseEntity<Response> create (@RequestBody @Validated Hardware hardware)
    {
        String nameofCurrMethod = new Throwable()
            .getStackTrace()[0]
            .getMethodName();

        Response response = new Response();
        response.setService(this.getClass().getName() + nameofCurrMethod);
        response.setMessage("Berhasil Membuat Data");

        response.setData(hardwareService.create(hardware));

        return ResponseEntity
            .status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(response);
    }


    @PutMapping
    ResponseEntity<Response> update(@PathVariable ("id")Long id, @RequestBody @Validated Hardware hardware)
    {
        String nameofCurrMethod = new Throwable()
            .getStackTrace()[0]
            .getMethodName();

        Response response = new Response();
        response.setService(this.getClass().getName() + nameofCurrMethod);
        response.setMessage("Berhasil Update Data");

        response.setData(hardwareService.update(id, hardware));

        return ResponseEntity
            .status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(response);
    }

    @GetMapping(value = "id")
    ResponseEntity<Response> getById(@PathVariable ("id") Long id)
    {
        String nameofCurrMethod = new Throwable()
            .getStackTrace()[0]
            .getMethodName();

        Response response = new Response();
        response.setService(this.getClass().getName() + nameofCurrMethod);
        response.setMessage("Berhasil Mengambil Data Berdasarkan Id");

        response.setData(hardwareService.findById(id));

        return ResponseEntity
            .status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(response);
        
    } 

    @GetMapping
    ResponseEntity<Response> findAll ()
    {
        String nameofCurrMethod = new Throwable()
            .getStackTrace()[0]
            .getMethodName();

            Response response = new Response();
            response.setService(this.getClass().getName() + nameofCurrMethod);
            response.setMessage("Berhasil Menampilkan Seluruh Data");
            response.setData(hardwareService.findAll());

            return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_PROBLEM_JSON)
                .body(response);
    }

    @DeleteMapping(value = "id")
    ResponseEntity<Response> deleteById(@PathVariable ("id")Long id)
    {
        String nameofCurrMethod = new Throwable()
            .getStackTrace()[0]
            .getMethodName();

        Response response = new Response();
        response.setService(this.getClass().getName() + nameofCurrMethod);
        response.setMessage("Data Berhasil dihapus");
        response.setData(hardwareService.findById(id));

        hardwareService.delete(id);


        return ResponseEntity
            .status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(response);
    }
}
