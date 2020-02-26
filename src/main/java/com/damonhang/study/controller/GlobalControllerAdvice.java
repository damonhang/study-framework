package com.damonhang.study.controller;

import java.nio.file.FileSystemException;
import java.rmi.RemoteException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Component
public class GlobalControllerAdvice {

  @ExceptionHandler({FileSystemException.class, RemoteException.class})
  public ResponseEntity<String> handle(Exception ex) {
    return ResponseEntity.badRequest().build();
  }
}
