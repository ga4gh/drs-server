package org.ga4gh.starterkit.drs.model;

import org.ga4gh.starterkit.common.model.ServiceInfo;
import static org.ga4gh.starterkit.drs.constant.DrsServiceInfoDefaults.ID;
import static org.ga4gh.starterkit.drs.constant.DrsServiceInfoDefaults.NAME;
import static org.ga4gh.starterkit.drs.constant.DrsServiceInfoDefaults.DESCRIPTION;
import static org.ga4gh.starterkit.drs.constant.DrsServiceInfoDefaults.CONTACT_URL;
import static org.ga4gh.starterkit.drs.constant.DrsServiceInfoDefaults.DOCUMENTATION_URL;
import static org.ga4gh.starterkit.drs.constant.DrsServiceInfoDefaults.CREATED_AT;
import static org.ga4gh.starterkit.drs.constant.DrsServiceInfoDefaults.UPDATED_AT;
import static org.ga4gh.starterkit.drs.constant.DrsServiceInfoDefaults.ENVIRONMENT;
import static org.ga4gh.starterkit.drs.constant.DrsServiceInfoDefaults.VERSION;
import static org.ga4gh.starterkit.drs.constant.DrsServiceInfoDefaults.ORGANIZATION_NAME;
import static org.ga4gh.starterkit.drs.constant.DrsServiceInfoDefaults.ORGANIZATION_URL;
import static org.ga4gh.starterkit.drs.constant.DrsServiceInfoDefaults.SERVICE_TYPE_GROUP;
import static org.ga4gh.starterkit.drs.constant.DrsServiceInfoDefaults.SERVICE_TYPE_ARTIFACT;
import static org.ga4gh.starterkit.drs.constant.DrsServiceInfoDefaults.SERVICE_TYPE_VERSION;

public class DrsServiceInfo extends ServiceInfo {

    public DrsServiceInfo() {
        super();
        setAllDefaults();
    }

    private void setAllDefaults() {
        setId(ID);
        setName(NAME);
        setDescription(DESCRIPTION);
        setContactUrl(CONTACT_URL);
        setDocumentationUrl(DOCUMENTATION_URL);
        setCreatedAt(CREATED_AT);
        setUpdatedAt(UPDATED_AT);
        setEnvironment(ENVIRONMENT);
        setVersion(VERSION);
        getOrganization().setName(ORGANIZATION_NAME);
        getOrganization().setUrl(ORGANIZATION_URL);
        getType().setGroup(SERVICE_TYPE_GROUP);
        getType().setArtifact(SERVICE_TYPE_ARTIFACT);
        getType().setVersion(SERVICE_TYPE_VERSION);
    }
}