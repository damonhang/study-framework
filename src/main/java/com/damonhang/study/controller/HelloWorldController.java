package com.damonhang.study.controller;

import java.io.IOException;
import java.nio.file.FileSystemException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

  @GetMapping("/hello")
  @ResponseBody
  public String sayHello() {
    return "helloworld";
  }

  @GetMapping("/hello.html")
  public String helloPage() {
    return "index";
  }

  @GetMapping("/error")
  public String errorPage() throws RemoteException {
    throw new RemoteException();
  }

  @InitBinder
  public void initBinder(WebDataBinder binder) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    dateFormat.setLenient(false);
    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));

    binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
  }

  @ExceptionHandler
  public ResponseEntity<String> handle(IOException ex) {
    return ResponseEntity.status(200).build();
  }

}
