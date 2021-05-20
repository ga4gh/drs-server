package org.ga4gh.starterkit.drs.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import org.ga4gh.starterkit.drs.utils.SerializeView;
import org.springframework.lang.NonNull;
import java.net.URI;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonView(SerializeView.Public.class)
public class AccessURL {
    @NonNull
    private URI url;

    private Map<String, String> headers;

    public AccessURL() {
        
    }

    public AccessURL(URI url) {
        this.url = url;
    }

    public AccessURL(URI url, Map<String, String> headers) {
        this.url = url;
        this.headers = headers;
    }

    public URI getUrl() {
        return url;
    }

    public void setUrl(URI url) {
        this.url = url;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }
}