package org.ga4gh.drs.controller;

import org.ga4gh.drs.model.AccessURL;
import org.ga4gh.drs.model.DrsObject;
import org.ga4gh.drs.utils.requesthandler.AccessRequestHandler;
import org.ga4gh.drs.utils.requesthandler.ObjectRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;

@RestController
@RequestMapping("/objects")
public class Objects {

    @Resource(name = "objectRequestHandler")
    ObjectRequestHandler objectRequestHandler;

    @Resource(name = "accessRequestHandler")
    AccessRequestHandler accessRequestHandler;

    @GetMapping(path = "/{object_id:.+}")
    public DrsObject getObjectById(
        @PathVariable(name = "object_id") String id,
        @RequestParam(name = "expand", required = false) boolean expand
    ) {
        objectRequestHandler.setObjectId(id);
        objectRequestHandler.setExpand(expand);
        return objectRequestHandler.handleRequest();
    }

    @GetMapping(path = "/{object_id:.+}/access/{access_id:.+}")
    public AccessURL getAccessURLById(
        @PathVariable(name = "object_id") String objectId,
        @PathVariable(name = "access_id") String accessId
    ) {
        accessRequestHandler.setObjectId(objectId);
        accessRequestHandler.setAccessId(accessId);
        return accessRequestHandler.handleRequest();
    }
}
