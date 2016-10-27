package carefinder.client

import grails.plugins.rest.client.RestBuilder
import groovy.util.slurpersupport.GPathResult
import org.springframework.beans.factory.annotation.Value

class ApiService {

    @Value('${carefinder.api.endpoint}')
    String endpoint

    @Value('${carefinder.api.key}')
    String apiKey

    RestBuilder client

    GPathResult getHospitals() {
        client.get("$endpoint/hospitals") { header "X-API-KEY", apiKey }.xml
    }

    GPathResult getHospitalsById(int id) {
        client.get("$endpoint/hospitals/id/$id") { header "X-API-KEY", apiKey }.xml
    }

    GPathResult getHospitalsByCity(String name) {
        client.get("$endpoint/hospitals/city/$name") { header "X-API-KEY", apiKey }.xml
    }

    GPathResult getHospitalsByState(String name) {
        client.get("$endpoint/hospitals/state/$name") { header "X-API-KEY", apiKey }.xml
    }

    GPathResult getHospitalByCounty(String name) {
        client.get("$endpoint/hospitals/county/$name") { header "X-API-KEY", apiKey }.xml
    }

    GPathResult getHospitalsByCityAndState(String city, String state) {
        client.get("$endpoint/hospitals/citystate/$city/$state") { header "X-API-KEY", apiKey }.xml
    }

    GPathResult getHospitalsByName(String name) {
        client.get("$endpoint/hospitals/citystate/$name") { header "X-API-KEY", apiKey }.xml
    }
}
