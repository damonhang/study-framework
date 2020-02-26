package com.damonhang.study.service;

import static org.junit.Assert.*;

import java.net.URI;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.DefaultUriBuilderFactory.EncodingMode;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class SpringWebServiceTest {

  @Test
  public void name() {
    UriComponents uriComponents = UriComponentsBuilder
        .fromUriString("https://example.com/hotels/{hotel}")
        .queryParam("q", "{q}")
        .encode()
        .build();

    URI uri = uriComponents.expand("Westin", "123").toUri();

    //
    String baseUrl = "https://example.org";
    DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(baseUrl);
    factory.setEncodingMode(EncodingMode.TEMPLATE_AND_VALUES);

    RestTemplate restTemplate = new RestTemplate();
    restTemplate.setUriTemplateHandler(factory);
  }
}