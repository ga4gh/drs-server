package org.ga4gh.starterkit.drs.controller;

import org.ga4gh.starterkit.drs.constant.DrsServerConstants;
import org.ga4gh.starterkit.drs.model.DrsServiceInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping(DrsServerConstants.DRS_API_PREFIX + "/service-info")
public class ServiceInfo {

    @Autowired
    DrsServiceInfo drsServiceInfo;

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<org.ga4gh.starterkit.common.model.ServiceInfo> getServiceInfo() {
        return new ResponseEntity<>(drsServiceInfo, HttpStatus.OK);
    }
}
