package org.ga4gh.drs.configuration;

import org.ga4gh.drs.model.ServiceInfo;

public class DrsConfig {

    private ServerProps serverProps;
    private ServiceInfo serviceInfo;
    private DataSourceRegistry dataSourceRegistry;

    public DrsConfig() {
        serverProps = new ServerProps();
        serviceInfo = new ServiceInfo();
        dataSourceRegistry = new DataSourceRegistry();
    }

    public void setServerProps(ServerProps serverProps) {
        this.serverProps = serverProps;
    }

    public ServerProps getServerProps() {
        return serverProps;
    }

    public void setServiceInfo(ServiceInfo serviceInfo) {
        this.serviceInfo = serviceInfo;
    }

    public ServiceInfo getServiceInfo() {
        return serviceInfo;
    }

    public void setDataSourceRegistry(DataSourceRegistry dataSourceRegistry) {
        this.dataSourceRegistry = dataSourceRegistry;
    }

    public DataSourceRegistry getDataSourceRegistry() {
        return dataSourceRegistry;
    }
}
